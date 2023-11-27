package Projecto;
import  com.aspose.cells.Workbook;

public class Utilidades {
    String aux;
    public void Convert(String r, String n){
        try {
            Workbook xl = new Workbook(r);
            xl.save(n + ".csv");
        } catch(Exception ignored){
        }
    }
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
}
