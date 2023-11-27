package Projecto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class uLogica {
    Utilidades u = new Utilidades();
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat fd = new SimpleDateFormat("dd");
    String dt = "01/01/2023";
    String dt1 = "01/02/2023";
    String dt2 = "01";
    Long d;
    Abstract<Long> al = new Abstract<>();
    String[] Fecha;

    public String[] OrdenarFecha(String[] a, int m) {

        Fecha = a;
        Long[] rawFecha = new Long[a.length];
        long today = 0;
        int nullcount = 0;
        try {
            long dia = fd.parse(dt2).getTime();
            d = f.parse(dt1).getTime() - f.parse(dt).getTime() - dia;
            today = Calendar.getInstance().getTime().getTime();

        }catch (ParseException e){}

        for (int i = 0; i < Fecha.length; i++) {
            try {
                if (f.parse(Fecha[i]).getTime() > today - d * m){
                    rawFecha[i] = f.parse(Fecha[i]).getTime();
                }
            } catch (ParseException e) {
            }
        }

        for(int i = 0; i < Fecha.length; i++){
            if (rawFecha[i] == null){
                nullcount += 1;
            }
        }
        Long[] derawF = new Long[rawFecha.length-nullcount];

        for(int i = 0; i < rawFecha.length; i++){
            if (rawFecha[i] != null){
                derawF[i] = rawFecha[i];
            }
        }
        derawF = al.QuickSort(derawF, 0, derawF.length - 1);

        String[] F = new String[derawF.length];

        for (int i = 0; i < derawF.length; i++) {
            F[i] = f.format(derawF[i]);

        }
        return F;
    }
    public String[] OrdenarColumnas(String[] a, String[] f) {
        String[] aux = new String[a.length - 1];
        for (int i = 0; i<f.length; i++){
            CharSequence cs = f[i];
            for (int j = 0; j<a.length; j++){
                if (a[j].contains(cs)){
                    aux[i] = a[j];
                }
            }
        }
        return aux;
    }

    public String[] getTotal(String[] a){
        return a;
    }
}

