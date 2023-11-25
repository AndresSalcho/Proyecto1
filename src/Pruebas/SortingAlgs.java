package Pruebas;
import java.util.Arrays;
import java.util.Random;

public class SortingAlgs {

    private double[] res;
    double aux;

    private double max(double[]a){
        double max = 0;
        for(double v : a){
            if (max == 0){
                max = v;
            }else if(max < v){
                max = v;
            }
        }

        return max;
    }

    public double[] QuickSort(double[] a, int firstE, int lastE){
        int count = firstE - 1;
        if (firstE < lastE){
            for (int i = firstE; i <= lastE; i++){
                if (a[i] <= a[lastE]) {
                    count += 1;
                    aux = a[count];
                    a[count] = a[i];
                    a[i] = aux;
                }
            }

            QuickSort(a, firstE, count - 1);
            QuickSort(a, count + 1, lastE);

        }
        return a;
    }
    public double[] MergeSort(double[] a, int firstE, int lastE) {
        double[] sl;
        double[] sr;
        if (firstE == lastE) {
            double[] br = new double[1];
            br[0] = a[firstE];
            return br;
        } else {
            int middle = (firstE + lastE) / 2;

            sl = MergeSort(a, firstE, middle);
            sr = MergeSort(a, middle + 1, lastE);
        }


        return Merge(sl, sr);
    }

    private double[] Merge(double[] left, double[] right){
        double[] MergeEnd = new double[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while ( i < left.length && j < right.length){
            if (left[i] < right[j]){
                MergeEnd[k] = left[i];
                i++;
            }else {
                MergeEnd[k] = right[j];
                j++;
            }
            k++;
        }
        if(i == left.length){
            while(j < right.length){
                MergeEnd[k] = right[j];
                j++;
                k++;
            }
        }
        if(j == right.length){
            while(i < left.length){
                MergeEnd[k] = left[i];
                i++;
                k++;
            }
        }

        return MergeEnd;
    }
    public double[] RadixSort(double[] a){
        double chars = max(a);

        for (int exp = 1; chars / exp > 0; exp *= 10) {
            res = CountingSort(a, a.length, exp, chars);
        }
        return a;
    }
    private double[] CountingSort(double[] a, int s, int exp, double max) {
        double[] output = new double[s + 1];
        int[] count = new int[(int) (max + 1)];

        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }
        for (int i = 0; i < s; i++) {
            count[(int) ((a[i] / exp) % 10)]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = s - 1; i >= 0; i--) {
            output[count[(int) ((a[i] / exp) % 10)] - 1] = a[i];
            count[(int) ((a[i] / exp) % 10)]--;
        }

        if (s >= 0) System.arraycopy(output, 0, a, 0, s);

        return a;
    }

    public  double[] BubbleSort(double[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++){
                if (j != a.length - 1) {
                    if(a[j] > a[j+1]){
                        aux = a[j+1];
                        a[j+1] = a[j];
                        a[j] = aux;
                    }
                }

            }
        }
        return a;
    }

    public double[] DumbSort(double[] a){
        boolean ready = false;
        int buenas = 0;
        int avoid = 0;
        Random r = new Random();
        while(!ready){
            for (int i = 0; i < a.length; i++){
                if (avoid == a.length-1){
                    aux = a[a.length-1];
                    a[a.length-1] = a[a.length-2];
                    a[a.length-2] = aux;
                    avoid = 0;
                    break;
                }
                int c = r.nextInt(avoid,a.length-1);
                aux = a[i];
                a[i] = a[c];
                a[c] = aux;
                avoid++;
            }
            buenas = 0;
            for (int i = 0; i < a.length; i++){
                if (i != a.length - 1) {
                    if (a[i] <= a[i + 1]) {
                        buenas++;
                    }
                }
                if (buenas == a.length-1){
                    ready = true;
                }
            }

        }

        return a;
    }
}




