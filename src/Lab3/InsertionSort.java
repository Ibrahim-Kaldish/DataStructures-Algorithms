package Lab3;

public class InsertionSort {

    public static void sort(Comparable [] arr){
        for (int i = 1; i < arr.length; i++){
            for (int j = i ; j > 0 ; j--){
                if (less(arr[j],arr[j-1])){
                    exchange(arr, j,j-1);
                }
                else
                    break;
            }
        }
    }

    public static boolean less(Comparable c1, Comparable c2){
        return c1.compareTo(c2) < 0;
    }

    public static void exchange(Comparable [] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
    }
}
