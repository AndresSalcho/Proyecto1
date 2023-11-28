package Projecto;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gEntradaSalida {
    String[] files, Local, Retiro, Entrega;
    String[] fechaL, fechaR, fechaE;
    String[] ValL, ValR, ValE;
    int m;
    int aux;
    int save;
    Utilidades u = new Utilidades();
    uLogica ul = new uLogica();
    gEntradaSalida(String ll, String rr, String ee, int mm){
        files = new String[]{ll, rr, ee};
        m = mm;
        mainE();
    }

    private void mainE(){
        int index = 1;
        for (String f : files) {
            if (u.getFExt(f).equals("0")) {
                return;
            }else if (u.getFExt(f).equals("xlsx")) {
                u.Convert(f,u.getFName(f));
                f = u.getFName(f);
            }
        }
        for (String f : files){
            readNLoad(f, index);
            index++;
        }

        Local = ul.IndividualSeparator(Local, "l");
        Retiro = ul.IndividualSeparator(Retiro, "r");
        Entrega = ul.IndividualSeparator(Entrega, "e");

        fechaL = u.getFechas(Local);
        fechaR = u.getFechas(Retiro);
        fechaE = u.getFechas(Entrega);

        fechaL = ul.OrdenarFecha(fechaL, m);
        fechaR = ul.OrdenarFecha(fechaR, m);
        fechaE = ul.OrdenarFecha(fechaE, m);

        Local = ul.OrdenarColumnas(Local, fechaL);
        Retiro = ul.OrdenarColumnas(Retiro, fechaR);
        Entrega = ul.OrdenarColumnas(Entrega, fechaE);

        Local = u.convertNotNull(Local);
        Retiro = u.convertNotNull(Retiro);
        Entrega = u.convertNotNull(Entrega);

        ValL = ul.getTotal(Local);
        ValR = ul.getTotal(Retiro);
        ValE = ul.getTotal(Entrega);

        for (String f : ValL){
            if (f != null) {
                System.out.println(f);
            }
        }
        /*
        System.out.println(" ");
        for (String f : Retiro){
            if (f != null) {
                System.out.println(f);
            }
        }
        System.out.println(" ");
        for (String f : Entrega){
            if (f != null) {
                System.out.println(f);
            }
        }
         */


    }

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
            return;
        }
    }
}
