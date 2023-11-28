package Projecto;

import java.io.IOException;

public class Menu {
    String l;
    String r;
    String e;
    int m;

    Menu(String ll, String rr, String ee, int mm) throws IOException, InterruptedException {
        l = ll;
        r = rr;
        e = ee;
        m = mm;
    }
    public void run() throws IOException, InterruptedException {

        /*
        while(flag){
            System.out.println("Procesando archivos por favor espere");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("Procesando archivos por favor espere.");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("Procesando archivos por favor espere..");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("Procesando archivos por favor espere...");
            Thread.sleep(1000);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
         */

        gEntradaSalida s = new gEntradaSalida(l,r,e,m);


    }
}
