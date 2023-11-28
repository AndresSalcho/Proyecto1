package Projecto;

public class Abstract<T> {
    T aux;

    //Algoritmo de ordenamiento ganador
    public T[] QuickSort(T[] a, int firstE, int lastE){
        int count = firstE - 1;
        if (firstE < lastE){
            for (int i = firstE; i <= lastE; i++){
                if(a[i].getClass() == Long.class){
                    if ((long) a[i] <= (long) a[lastE]) {
                        count += 1;
                        aux = a[count];
                        a[count] = a[i];
                        a[i] = aux;
                    }
                }
                if(a[i].getClass() == Integer.class){
                    if ((int) a[i] <= (int) a[lastE]) {
                        count += 1;
                        aux = a[count];
                        a[count] = a[i];
                        a[i] = aux;
                    }
                }
            }

            QuickSort(a, firstE, count - 1);
            QuickSort(a, count + 1, lastE);

        }
        return a;
    }
}
