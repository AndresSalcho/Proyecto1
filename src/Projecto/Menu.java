package Projecto;

public class Menu {
    String l;
    String r;
    String e;
    int m;

    Menu(String ll, String rr, String ee, int mm) throws Exception {
        l = ll;
        r = rr;
        e = ee;
        m = mm;
        run();
    }
    private void run() throws Exception {
        sEntradaSalida s = new sEntradaSalida(l,r,e,m);
    }
}
