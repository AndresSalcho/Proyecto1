package Projecto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            for (String s : a) {
                if (s.contains(cs)) {
                    aux[i] = s;
                }
            }
        }
        return aux;
    }

    public String[] getTotal(String[] a){
        return a;
    }

    public String[] IndividualSeparator(String[] s, String id){
        char[] c;
        boolean ready = false;
        int aux = 0;
        int save = 0;
        for (int j = 1; j < s.length; j++) {
            int pos = 0;
            c = s[j].toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == ';' && pos == 0) {
                    aux = i;
                    if (id.equals("l")) {
                        s[j - 1] = "Fecha: ";
                    }
                    if (id.equals("r")) {
                        s[j - 1] = "Fecha: ";
                    }
                    if (id.equals("e")) {
                        s[j - 1] = "Fecha: ";
                    }
                    for (int k = 0; k < aux; k++){
                        if (id.equals("l")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            s[j - 1] += c[k];
                        }
                    }
                    ready = true;
                }else if (c[i] == ';' && pos == 1) {
                    if (id.equals("l")) {
                        s[j - 1] += " | Venta: ";
                    }
                    if (id.equals("r")) {
                        s[j - 1] += " | Venta: ";
                    }
                    if (id.equals("e")) {
                        s[j - 1] += " | Venta: ";
                    }
                    for (int k = aux + 1; k < i; k++){
                        if (id.equals("l")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            s[j - 1] += c[k];
                        }
                    }
                    aux = i;
                    ready = true;
                }else if (c[i] == ';' && pos == 2) {
                    if (id.equals("l")) {
                        s[j - 1] += " | Costo: ";
                    }
                    if (id.equals("r")) {
                        s[j - 1] += " | Costo: ";
                    }
                    if (id.equals("e")) {
                        s[j - 1] += " | Costo: ";
                    }
                    for (int k = aux + 1; k < i; k++){
                        if (id.equals("l")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            s[j - 1] += c[k];
                        }
                    }
                    aux = i;
                    ready = true;
                    if (!id.equals("e")) {
                        i -= 2;
                        save = c.length;
                    }
                }else if (c[i] == ';' && pos == 3) {
                    if (id.equals("l")) {
                        s[j - 1] += " | Impuesto: ";
                    }
                    if (id.equals("r")) {
                        s[j - 1] += " | Empaque: ";
                    }
                    if (id.equals("e")) {
                        s[j - 1] += " | Envio: ";
                    }
                    if (id.equals("e")) {
                        save = i;
                    }
                    for (int k = aux + 1; k < save; k++){
                        if (id.equals("l")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            s[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            s[j - 1] += c[k];
                        }
                    }
                    aux = i;
                    ready = true;
                    if (id.equals("e")) {
                        i -= 2;
                    }
                }else if (c[i] == ';' && pos == 4 && id.equals("e")) {
                    s[j - 1] += " | Entregado: ";
                    for (int k = i + 1; k < c.length; k++) {
                        s[j - 1] += c[k];
                    }
                    aux = i;
                    ready = true;
                }else if (ready){
                    ready = false;
                    pos++;
                }
            }

        }
        if (id.equals("l")) {
            s[s.length-1] = "--------------------------------------------------------------------";
        }
        if (id.equals("r")) {
            s[s.length-1] = "--------------------------------------------------------------------";
        }
        if (id.equals("e")) {
            s[s.length-1] = "--------------------------------------------------------------------";
        }

        return s;
    }
}

