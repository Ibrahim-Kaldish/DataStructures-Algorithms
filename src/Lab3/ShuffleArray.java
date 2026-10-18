package Lab3;

public class ShuffleArray {

    public static void shuffle(Comparable[] arr){
        for (int i = arr.length - 1 ; i > 0  ; i--){
            int idx = (int) (Math.random()*(i+1)) ;
            exchange(arr, i, idx);
        }
    }

    public static void exchange(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
