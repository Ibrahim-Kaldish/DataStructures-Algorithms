package Lab4;

public class QuickSort <T extends Comparable<T>>{
    T[] arr ;

    public QuickSort(T[] arr){
        this.arr = arr;
    }

    public void sort(){
        quickSort(arr,0, arr.length - 1);
    }

    public void quickSort(T[] arr, int low, int high){
        if (low < high){
            int piv = pivot(arr,low,high);
            quickSort(arr, low, piv-1);
            quickSort(arr, piv+1, high);
        }
    }

    public int pivot(T[]arr, int l, int r){
        int i = l , j = r , pivotLoc = i ;

        while (true){
            while (pivotLoc != j && arr[pivotLoc].compareTo(arr[j]) < 0) j--;
            if (pivotLoc == j) break;
            if (arr[pivotLoc].compareTo(arr[j]) > 0){
                T temp = arr[j];
                arr[j] = arr[pivotLoc];
                arr[pivotLoc] = temp;
                pivotLoc = j ;
            }

            while (pivotLoc != i && arr[pivotLoc].compareTo(arr[i]) > 0) i++;
            if (pivotLoc == i) break;
            if (arr[pivotLoc].compareTo(arr[i]) < 0){
                T temp = arr[i];
                arr[i] = arr[pivotLoc];
                arr[pivotLoc] = temp;
                pivotLoc =i  ;
            }
        }
        return pivotLoc;
    }
}
