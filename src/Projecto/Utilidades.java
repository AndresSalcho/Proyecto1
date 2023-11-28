package Projecto;
import  com.aspose.cells.Workbook;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilidades {
    String aux;
    int Iaux, Iaux2;

    //Covierte los archivos .xlsx a .csv para su manejo
    public void Convert(String r, String n){
        try {
            Workbook xl = new Workbook(r);
            xl.save(n + ".csv");
        } catch(Exception ignored){
        }
    }

    //Averigua cual es la extension del archivo
    public String getFExt(String r){
        char[] c;
        c = r.toCharArray();
        for (int i = 0; i < c.length; i++){
            if (i == c.length - 1){
                if (c[i] == 'x' && c[i-1] == 's' && c[i-2] == 'l' && c[i-3] == 'x'){
                    aux = "xlsx";
                }
                if (c[i] == 'v' && c[i-1] == 's' && c[i-2] == 'c'){
                    aux = "csv";
                }
            }
        }
        if (aux == null){
            System.out.println("Error, alguno de los archivos no tiene un Formato compatible!!!");
            System.out.println("Unicamente se permite csv o xlsx");
            return "0";
        }else{
            return aux;
        }
    }

    //Si se convierte un archivo, se extrae el nombre del archivo para crearlo con el mismo nombre
    public String getFName(String r) {
        int a = 0;
        char[] c;
        c = r.toCharArray();
        for (int i = c.length - 5; i > 0; i--) {
            if (c[i] == '\\') {
                a = i;
                break;
            }
        }
        for (int i = a+1; i < c.length - 5; i++) {
            aux = aux + c[i];
        }
        return aux;
    }

    //Descompone el String de la fecha y extrae solo la parte numérica
    public String[] getFechas(String[] s) {
        char[] c;
        String[] date = new String[s.length-1];
        boolean ready = false;
        for (int j = 0; j < s.length-1; j++) {
            int pos = 0;
            c = s[j].toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == ':' && pos == 0) {
                    Iaux = i;
                    ready = true;
                }else if(c[i] == '/'){
                    if (pos == 2){
                        Iaux2 = i;
                    }
                    if(pos == 1){
                        ready = true;
                    }
                }else if (ready) {
                    ready = false;
                    pos++;
                }
            }
            for (int k = Iaux+2; k < Iaux2+5; k++) {
                if(k == Iaux+2){
                    date[j] = "";
                }
                date[j] += c[k];

            }
        }
        return date;
    }

    //Busca cual es el siguente espacio en blanco del array e intrduce ahi el valor
    public String[] nextBSpace(String[] a, String s){
        boolean ended = false;
        for (int i = 0; i < a.length; i++){
            if(a[i] == null){
                a[i] = s;
                ended = true;
            }
            if (ended){
                i = a.length;
            }
        }
        return a;
    }

    //Algunos arrays quedan con celdas null, y no me sirve asi que esta funcion registra
    //solo las celdas con datos en un array nuevo sin casillas nulls
    public String[] convertNotNull(String[] a){
        int count = 0;
        for (String s : a) {
            if (s == null) {
                count++;
            }
        }
        String[] notNull = new String[a.length - count];

        for (String s : a) {
            if (s != null) {
                notNull = nextBSpace(notNull, s);
            }
        }
     return notNull;
    }

    //Reduce la cantidad de decimales que muestra a 2
    public double DecimalF(double d){
        BigDecimal b = new BigDecimal(d);
        return b.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    //Metodo para limpiar la pantalla, SOLO SIRVE EN CMD!!
    public void cls(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch (IOException | InterruptedException e){
            return;
        }
    }
}
