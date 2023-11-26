package Projecto;

public class Main {

    static String l;
    static String r;
    static String e;
    static int m;

    public static void main(String[] args) throws Exception {

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

        Menu menu = new Menu(l,r,e,m);

    }
}