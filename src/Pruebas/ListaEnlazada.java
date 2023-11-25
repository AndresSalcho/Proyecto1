package Pruebas;

public class ListaEnlazada {
    Nodo cabeza;

    ListaEnlazada() {
        cabeza = null;
    }

    //Metodo agregar al inicio

    public void addInicio(double x) {
        Nodo nuevo = new Nodo(x);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        }
    }

    //Metodo añadir ordenado, el entero de menor a mayor, el string de A-Z y la cancion por nombre de A-Z

    public void addOrdenado(double a) {
        double i1;
        double i2;
        String s1;
        String s2;

            i2 = a;
            Nodo nuevo = new Nodo(a);
            if (cabeza == null) {
                cabeza = nuevo;
                return;
            }
            i1 = cabeza.getValor();
            if (i1 > i2) {
                addInicio(a);
            } else {
                Nodo temp = cabeza;
                while (temp.getSiguiente() != null) {
                    i1 = temp.getSiguiente().getValor();
                    if (i1 > i2) {
                        nuevo.setSiguiente(temp.getSiguiente());
                        temp.setSiguiente(nuevo);
                        return;
                    }
                    temp = temp.getSiguiente();
                }
                temp.setSiguiente(nuevo);
            }
    }

    //Metodo borrar

    public void Borrar(double x) {
        if (cabeza == null) {
            System.out.println("La lista está vacía!");
        } else if (cabeza.getValor() == x) {
            Nodo temp = cabeza;
            cabeza = temp.getSiguiente();

        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente().getValor() != x) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(temp.getSiguiente().getSiguiente());
        }
    }

    //Metodo agregar Final

    public void addFinal(double x) {
        Nodo nuevo = new Nodo(x);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
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
        } else {
            Nodo temp = cabeza;
            while (temp != null) {
                System.out.print(temp.getValor() + "->");
                temp = temp.getSiguiente();
            }
            System.out.println();
        }
    }

    //Metodo ver ultimo elemento
    public double lastElement() {
        double aux;
        if (cabeza == null) {
            System.out.print("La lista se encuentra vacia!");
        } else {
            Nodo temp = cabeza;
            while (temp != null) {
                if (temp.getSiguiente() == null) {
                    return temp.getValor();
                }
                temp = temp.getSiguiente();
            }
        }
        return 0;
    }
}

