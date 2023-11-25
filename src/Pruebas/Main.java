package Pruebas;

import java.util.Random;

public class Main {
    static double[] arr50 = new double[50];
    static double[] arr10 = new double[10];
    static double[] arr100 = new double[100];
    static double[] arr1000 = new double[1000];
    static double[] arr10000 = new double[10000];
    static ListaEnlazada list1 = new ListaEnlazada();
    static SortingAlgs sort = new SortingAlgs();
    static Random a = new Random();

    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            arr10[i] = a.nextInt(11);
        }
        for (int i = 0; i<100; i++){
            arr100[i] = a.nextInt(101);
        }
        for (int i = 0; i<1000; i++){
            arr1000[i] = a.nextInt(1001);
        }
        for (int i = 0; i<10000; i++){
            arr10000[i] = a.nextInt(10001);
        }

        long Start = System.currentTimeMillis();

        arr100 = sort.DumbSort(arr100);

        for (double v : arr100){
            list1.addFinal(v);
        }

        list1.print();

        long End = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución: " + (End - Start) + "ms");
    }
}