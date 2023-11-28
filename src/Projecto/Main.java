package Projecto;
public class Main {

    static String l;
    static String r;
    static String e;
    static int m;
    public static void main(String[] args){

        for (int i = 0; i < args.length; i++){
            if (args[i].equals("-l")){
                l = args[i+1];
            }
            if (args[i].equals("-r")){
                r = args[i+1];
            }
            if (args[i].equals("-e")){
                e = args[i+1];
            }
            if (args[i].equals("-m")){
                m = Integer.parseInt(args[i+1]);
            }
        }

        if (l == null || r == null || e == null || m == 0){
            System.out.println(" ");
            System.out.println("Alguno de los archivos fué mal colocado o hace falta!!!");
            System.out.println("Es necesario que los parametros especifiquen la ruta de los archivos y la cantidad de meses a analizar");
            System.out.println("-l <ruta> -r <ruta> -e <ruta> -m <meses>");
            return;
        }
        Menu menu = new Menu(l,r,e,m);
        menu.run();

    }
}