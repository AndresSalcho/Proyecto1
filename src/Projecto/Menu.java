package Projecto;

public class Menu {
    String l;
    String r;
    String e;
    int m;

    Menu(String ll, String rr, String ee, int mm){
        l = ll;
        r = rr;
        e = ee;
        m = mm;
    }
    public void run(){
        sEntradaSalida s = new sEntradaSalida(l,r,e,m);
    }
}
