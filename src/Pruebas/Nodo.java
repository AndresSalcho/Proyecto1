package Pruebas;

public class Nodo {
    private double valor;
    private Nodo siguiente;

    Nodo(double valor){
        this.valor = valor;
        this.siguiente = null;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente(){
        return this.siguiente;
    }
}
