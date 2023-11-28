package Projecto;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu {
    String l;
    String r;
    String e;
    int m;
    static Utilidades u = new Utilidades();

    Menu(String ll, String rr, String ee, int mm) {
        l = ll;
        r = rr;
        e = ee;
        m = mm;
    }

    public void run() {
        try {
            u.cls();
            System.out.println("Procesando archivos por favor espere...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return;
        }

        u.cls();
        gEntradaSalida s = new gEntradaSalida(l, r, e, m);

        if (s.vL[2] > s.vR[2] && s.vL[2] > s.vE[2]) {
            System.out.println("Las ventas en el local tienen la mayor ganncia con " + s.vL[2] + " lo que significa un " + u.DecimalF(s.vL[2] / s.vL[1] * 100) + "% de Ganancia");
            if (s.vR[2] > s.vE[2]) {
                System.out.println("Las ventas por Retiro tienen una Ganancia de " + s.vR[2] + " lo que significa un " + u.DecimalF(s.vR[2] / s.vR[1] * 100) + "% de Ganancia");
                System.out.println("Las ventas mediente Entregas tienen la menor Ganancia con " + s.vE[2] + " lo que significa un " + u.DecimalF(s.vE[2] / s.vE[1] * 100) + "% de Ganancia");
            } else {
                System.out.println("Las ventas mediente Entregas una Ganancia de " + s.vE[2] + " lo que significa un " + u.DecimalF(s.vE[2] / s.vE[1] * 100) + "% de Ganancia");
                System.out.println("Las ventas por Retiro tienen la menor Ganancia con " + s.vR[2] + " lo que significa un " + u.DecimalF(s.vR[2] / s.vR[1] * 100) + "% de Ganancia");
            }
        } else if (s.vR[2] > s.vL[2] && s.vR[2] > s.vE[2]) {
            System.out.println("Las ventas por Retiro tienen la mayor ganncia con " + s.vR[2] + " lo que significa un " + u.DecimalF(s.vR[2] / s.vR[1] * 100) + "% de Ganancia");
            if (s.vL[2] > s.vE[2]) {
                System.out.println("Las ventas en el Local tienen una Ganancia de " + s.vL[2] + " lo que significa un " + u.DecimalF(s.vL[2] / s.vL[1] * 100) + "% de Ganancia");
                System.out.println("Las ventas mediente Entregas tienen la menor Ganancia con " + s.vE[2] + " lo que significa un " + u.DecimalF(s.vE[2] / s.vE[1] * 100) + "% de Ganancia");
            } else {
                System.out.println("Las ventas mediente Entregas una Ganancia de " + s.vE[2] + " lo que significa un " + u.DecimalF(s.vE[2] / s.vE[1] * 100) + "% de Ganancia");
                System.out.println("Las ventas en el Local tienen la menor Ganancia con " + s.vL[2] + " lo que significa un " + u.DecimalF(s.vL[2] / s.vL[1] * 100) + "% de Ganancia");
            }
        } else {
            System.out.println("Las ventas mediante Entregas tienen la mayor ganncia con " + s.vE[2] + " lo que significa un " + u.DecimalF(s.vE[2] / s.vE[1] * 100) + "% de Ganancia");
            if (s.vL[2] > s.vR[2]) {
                System.out.println("Las ventas en el Local tienen una Ganancia de " + s.vL[2] + " lo que significa un " + u.DecimalF(s.vL[2] / s.vL[1] * 100) + "% de Ganancia");
                System.out.println("Las ventas por Retiro tienen la menor Ganancia con " + s.vR[2] + " lo que significa un " + u.DecimalF(s.vR[2] / s.vR[1] * 100) + "% de Ganancia");
            } else {
                System.out.println("Las ventas por Retiro tienen una Ganancia de " + s.vR[2] + " lo que significa un " + u.DecimalF(s.vR[2] / s.vR[1] * 100) + "% de Ganancia");
                System.out.println("Las ventas en el Local tienen la menor Ganancia con " + s.vL[2] + " lo que significa un " + u.DecimalF(s.vL[2] / s.vL[1] * 100) + "% de Ganancia");
            }
        }

        System.out.println(" ");
        System.out.println("Desea ver los detalles de Ventas?");
        System.out.println("Presione una tecla...");
        System.out.println("( L ) Ver ventas del local");
        System.out.println("( R ) Ver ventas por Retiro");
        System.out.println("( E ) Ver ventas mediente Entrega");
        System.out.println("( S ) Salir");
        System.out.println(" ");

        JFrame f = getjFrame(s);
        f.setVisible(true);

    }

    private static JFrame getjFrame(gEntradaSalida s) {
        JFrame f = new JFrame();
        final boolean[] lpress = {false};
        final boolean[] rpress = {false};
        final boolean[] epress = {false};

        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                if(key == 76){
                    if (!lpress[0]){
                        u.cls();
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("Está viendo las ventas en el Local de los últimos " + s.m + " meses");
                        System.out.println("-------------------------------------------------------------------");
                        s.L.print();
                        lpress[0] = true;
                        rpress[0] = false;
                        epress[0] = false;
                        System.out.println(" ");
                        System.out.println("Desea ver otro detalle de Ventas?");
                        System.out.println("Presione una tecla...");
                        System.out.println("( R ) Ver ventas por Retiro");
                        System.out.println("( E ) Ver ventas mediente Entrega");
                        System.out.println("( S ) Salir");
                        System.out.println(" ");
                    }
                }
                if(key == 82){
                    if (!rpress[0]){
                        u.cls();
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("Está viendo las ventas por Retiro de los últimos " + s.m + " meses");
                        System.out.println("------------------------------------------------------------------");
                        s.R.print();
                        rpress[0] = true;
                        lpress[0] = false;
                        epress[0] = false;
                        System.out.println(" ");
                        System.out.println("Desea ver otro detalle de Ventas?");
                        System.out.println("Presione una tecla...");
                        System.out.println("( L ) Ver ventas del local");
                        System.out.println("( E ) Ver ventas mediente Entrega");
                        System.out.println("( S ) Salir");
                        System.out.println(" ");
                    }
                }
                if(key == 69){
                    if (!epress[0]){
                        u.cls();
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("Está viendo las mediante Entrega de los últimos " + s.m + " meses");
                        System.out.println("-----------------------------------------------------------------");
                        s.E.print();
                        epress[0] = true;
                        rpress[0] = false;
                        lpress[0] = false;
                        System.out.println(" ");
                        System.out.println("Desea ver otro detalle de Ventas?");
                        System.out.println("Presione una tecla...");
                        System.out.println("( L ) Ver ventas del local");
                        System.out.println("( R ) Ver ventas por Retiro");
                        System.out.println("( S ) Salir");
                        System.out.println(" ");
                    }
                }
                if(key == 83){
                    System.exit(0);
                }
            }
        });
        f.setUndecorated(true);
        f.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        return f;
    }
}