package Pruebas;

public class Nodo<T> {
    private T valor;
    private Nodo<T> siguiente;

    Nodo(T valor){
        this.valor = valor;
        this.siguiente = null;
    }

    public void setValor(T valor){
        this.valor = valor;
    }

    public T getValor(){
        return this.valor;
    }

    public void setSiguiente(Nodo<T> siguiente){
        this.siguiente = siguiente;
    }

    public Nodo<T> getSiguiente(){
        return this.siguiente;
    }
}
