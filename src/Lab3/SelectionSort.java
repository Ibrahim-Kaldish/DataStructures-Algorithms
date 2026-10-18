package Lab3;

import java.util.Comparator;

public class SelectionSort{

    public static void sort(Comparable[] arr){
        for (int i = 0 ; i < arr.length - 1 ; i++){
            int mn = i ;
            for (int j = i + 1; j < arr.length ; j++){
                if (less(arr[j], arr[mn]))
                    mn = j ;
            }
            exchange(arr, i,mn);
        }
    }

    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    private static void exchange(Comparable[] arr, int i, int j){
        Comparable temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
}
