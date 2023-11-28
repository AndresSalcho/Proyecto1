package Projecto;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Pruebas.ListaEnlazada;

public class gEntradaSalida {
    String[] files, Local, Retiro, Entrega;
    String[] fechaL, fechaR, fechaE;
    String[] ValL, ValR, ValE;
    public double[] vL, vR, vE;
    int m;
    Utilidades u = new Utilidades();
    uLogica ul = new uLogica();
    public ListaEnlazada<String> L = new ListaEnlazada<>();
    public ListaEnlazada<String> R = new ListaEnlazada<>();
    public ListaEnlazada<String> E = new ListaEnlazada<>();

    gEntradaSalida(String ll, String rr, String ee, int mm){
        files = new String[]{ll, rr, ee};
        m = mm;
        mainE();
    }

    //Metodo principal
    private void mainE(){
        int index = 1;

        //Revisa el tipo de los archivos para ver si los convierte o no
        for (String f : files) {
            if (u.getFExt(f).equals("0")) {
                return;
            }else if (u.getFExt(f).equals("xlsx")) {
                u.Convert(f,u.getFName(f));
                f = u.getFName(f);
            }
        }

        //Carga los archivos en los arrays
        for (String f : files){
            readNLoad(f, index);
            index++;
        }

        //Extrae los valores individuales de cada array y los organiza
        Local = ul.IndividualSeparator(Local, "l");
        Retiro = ul.IndividualSeparator(Retiro, "r");
        Entrega = ul.IndividualSeparator(Entrega, "e");

        //Extrae los valores individuales de las fechas de cada array
        fechaL = u.getFechas(Local);
        fechaR = u.getFechas(Retiro);
        fechaE = u.getFechas(Entrega);

        //Utiliza los valores, los compara con la cantidad de meses especificada por el usuario
        // y utiliza el algoritmo de ordenamiento (Quicksort) para ordenarlos de menor a mayor

        fechaL = ul.OrdenarFecha(fechaL, m);
        fechaR = ul.OrdenarFecha(fechaR, m);
        fechaE = ul.OrdenarFecha(fechaE, m);

        //Llama a una funcion que compara las fechas ordenadas, con las fechas de los arrays que contienen los
        //datos de ventas y los acomoda segun ese orden
        Local = ul.OrdenarColumnas(Local, fechaL);
        Retiro = ul.OrdenarColumnas(Retiro, fechaR);
        Entrega = ul.OrdenarColumnas(Entrega, fechaE);

        //Debido a la funcion anterior quedaron muchas casillas null, que dan problemas luego
        //asi que se llama esta funcion para convertirlos a arrays sin nulls
        Local = u.convertNotNull(Local);
        Retiro = u.convertNotNull(Retiro);
        Entrega = u.convertNotNull(Entrega);

        //Añade los datos a una lista enlazada
        for (String s : Local){
            L.addFinal(s);
        }
        for (String s : Retiro){
            R.addFinal(s);
        }
        for (String s : Entrega){
            E.addFinal(s);
        }

        //Esta funcion extrae los valores de Ganancia, Perdida, y su diferencia
        ValL = ul.getTotal(Local);
        ValR = ul.getTotal(Retiro);
        ValE = ul.getTotal(Entrega);

        //Esta funcion obtiene el % de Ganancia
        vL = ul.getMargen(ValL);
        vR = ul.getMargen(ValR);
        vE = ul.getMargen(ValE);

    }

    //Este metodo lee los archivos ya sean csv o xlsx y los guarda en su respectivo array
    private void readNLoad(String n, int ord){
        try{
            int index = 0;
            File archivo = new File(n);
            Scanner scan = new Scanner(archivo);

            while (scan.hasNextLine()) {
                scan.nextLine();
                index++;
            }
            archivo = new File(n);
            scan = new Scanner(archivo);
            if(ord == 1) {
                Local = new String[index];
                index = 0;
                while (scan.hasNextLine()) {
                    Local[index] = scan.nextLine();
                    index++;
                }
            }
            if(ord == 2) {
                Retiro = new String[index];
                index = 0;
                while (scan.hasNextLine()) {
                    Retiro[index] = scan.nextLine();
                    index++;
                }
            }
            if(ord == 3) {
                Entrega = new String[index];
                index = 0;
                while (scan.hasNextLine()) {
                    Entrega[index] = scan.nextLine();
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo!!!");
        }
    }
}
