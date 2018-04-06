
import java.util.Arrays;

public class Taller8 {

    public static void mergeSort(int[] a) {
      mergeSort(a,0,a.length-1);
}
    private static void mergeSort(int a[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            mergeSort(a, l, m);
            mergeSort(a , m+1, r);
            merge(a, l, m, r);
        }
    }
    private static void merge(int a[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    
    private static void quicksort(int[] a, int left, int right) {
        int i = left, j = right;
        int pivot = a[left + (right - left) / 2];
        
        while(i <= j){
            while(a[i] < pivot) i++;
            while(a[j] > pivot) j--;
            if (i <= j) {                    
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++; j--;
            }
        }
        
        if (left < j)
            quicksort(a, left, j);
        if (i < right)
            quicksort(a, i, right);
    }

    public static void main(String[] args) {
       int[] w = {2, 10, 46, 1, 8};
       mergeSort(w);
       System.out.println(Arrays.toString(w));

       int[] s = {2, 10, 46, 1, 8};
       quicksort(s);
       System.out.println(Arrays.toString(s));
    }
    
}
