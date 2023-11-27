package Pruebas;

public class ListaEnlazada<T> {
    Nodo<T> cabeza;

    ListaEnlazada() {
        cabeza = null;
    }


    //Metodo borrar

    public void Borrar(T x){
        if (cabeza == null) {
            System.out.println("La lista está vacía!");
        }else if (cabeza.getValor() == x) {
            Nodo<T> temp = cabeza;
            cabeza = temp.getSiguiente();

        }else{
            Nodo<T> temp = cabeza;
            while (temp.getSiguiente().getValor() != x) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(temp.getSiguiente().getSiguiente());
        }
    }

    //Metodo agregar Final

    public void addFinal(T x) {
        Nodo<T> nuevo = new Nodo<>(x);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
    }

    //Metodo mostrar
    public void print() {
        if (cabeza == null) {
            System.out.print("La lista se encuentra vacia!");
        }Nodo<T> temp = cabeza;
            while (temp != null) {
                System.out.println(temp.getValor());
                temp = temp.getSiguiente();
            }
            System.out.println();
        }
    }

