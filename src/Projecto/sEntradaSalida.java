package Projecto;
import java.io.File;
import java.io.File.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sEntradaSalida {
    String[] files, Local, Retiro, Entrega;
    String[] fecha;
    int m;
    int aux;
    Utilidades u = new Utilidades();
    sEntradaSalida(String ll, String rr, String ee, int mm){
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

        IndividualSeparator(Local, "l");
        IndividualSeparator(Retiro, "r");
        IndividualSeparator(Entrega, "e");

        fecha = u.getFechas(Local);

        for (String f : fecha){
            System.out.println(f);
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

    private void IndividualSeparator(String[] s, String id){
        char[] c;
        boolean ready = false;
        for (int j = 1; j < s.length; j++) {
            int pos = 0;
            c = s[j].toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == ';' && pos == 0) {
                    aux = i;
                    if (id.equals("l")) {
                        Local[j - 1] = "Fecha: ";
                    }
                    if (id.equals("r")) {
                        Retiro[j - 1] = "Fecha: ";
                    }
                    if (id.equals("e")) {
                        Entrega[j - 1] = "Fecha: ";
                    }
                    for (int k = 0; k < aux; k++){
                        if (id.equals("l")) {
                            Local[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            Retiro[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            Entrega[j - 1] += c[k];
                        }
                    }
                    ready = true;
                }else if (c[i] == ';' && pos == 1) {
                    if (id.equals("l")) {
                        Local[j - 1] += " | Venta: ";
                    }
                    if (id.equals("r")) {
                        Retiro[j - 1] += " | Venta: ";
                    }
                    if (id.equals("e")) {
                        Entrega[j - 1] += " | Venta: ";
                    }
                    for (int k = aux + 1; k < i; k++){
                        if (id.equals("l")) {
                            Local[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            Retiro[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            Entrega[j - 1] += c[k];
                        }
                    }
                    aux = i;
                    ready = true;
                }else if (c[i] == ';' && pos == 2) {
                    if (id.equals("l")) {
                        Local[j - 1] += " | Costo: ";
                    }
                    if (id.equals("r")) {
                        Retiro[j - 1] += " | Costo: ";
                    }
                    if (id.equals("e")) {
                        Entrega[j - 1] += " | Costo: ";
                    }
                    for (int k = aux + 1; k < i; k++){
                        if (id.equals("l")) {
                            Local[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            Retiro[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            Entrega[j - 1] += c[k];
                        }
                    }
                    aux = i;
                    ready = true;
                }else if (c[i] == ';' && pos == 3) {
                    if (id.equals("l")) {
                        Local[j - 1] += " | Impuesto: ";
                    }
                    if (id.equals("r")) {
                        Retiro[j - 1] += " | Empaque: ";
                    }
                    if (id.equals("e")) {
                        Entrega[j - 1] += " | Envio: ";
                    }
                    for (int k = aux + 1; k < i; k++){
                        if (id.equals("l")) {
                            Local[j - 1] += c[k];
                        }
                        if (id.equals("r")) {
                            Retiro[j - 1] += c[k];
                        }
                        if (id.equals("e")) {
                            Entrega[j - 1] += c[k];
                        }
                    }
                    aux = i;
                    ready = true;
                    i -= 2;
                }else if (c[i] == ';' && pos == 4 && id.equals("e")) {
                    Entrega[j - 1] += " | Entregado: ";
                    for (int k = i + 1; k < c.length; k++) {
                        Entrega[j - 1] += c[k];
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
            Local[Local.length-1] = "--------------------------------------------------------------------";
        }
        if (id.equals("r")) {
            Retiro[Local.length-1] = "--------------------------------------------------------------------";
        }
        if (id.equals("e")) {
            Entrega[Local.length-1] = "--------------------------------------------------------------------";
        }
    }
}
