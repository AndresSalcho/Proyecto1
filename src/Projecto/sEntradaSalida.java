package Projecto;
import java.io.File;
import java.io.File.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sEntradaSalida {
    String[] files;
    String[] Local;
    String[] Retiro;
    String[] Entrega;
    int m;
    Utilidades u = new Utilidades();
    sEntradaSalida(String ll, String rr, String ee, int mm) throws Exception {
        files = new String[]{ll, rr, ee};
        m = mm;
        mainE();
    }

    private void mainE() throws Exception {
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

        for (String s : Local) {
            System.out.println(s);
        }
        for (String s : Retiro) {
            System.out.println(s);
        }
        for (String s : Entrega) {
            System.out.println(s);
        }
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
