package Lab4;

public class QuickSortSection <T extends Comparable<T>>{

    T[] arr ;

    public QuickSortSection(T[] arr){
        this.arr = arr;
    }

    public void sort(){
        quickSort(arr, 0 ,  arr.length-1);
    }

    int pivot(T[]arr, int l , int r){
        int i = l , j = r , pivLoc = i;

        while (true){
            while (pivLoc != j && arr[pivLoc].compareTo(arr[j]) < 0) j--;
            if (pivLoc == j) break;
            if (arr[pivLoc].compareTo(arr[j]) > 0){
                T temp = arr[j] ;
                arr[j] = arr[pivLoc];
                arr[pivLoc] = temp ;
                pivLoc = j ;
            }
            while (pivLoc != i && arr[pivLoc].compareTo(arr[i]) > 0) i++;
            if (pivLoc == i) break;
            if (arr[pivLoc].compareTo(arr[i]) < 0){
                T temp = arr[i] ;
                arr[i] = arr[pivLoc];
                arr[pivLoc] = temp ;
                pivLoc = i ;
            }
        }
       return pivLoc;
    }

    public void quickSort(T[]arr, int l , int r){
        if (l < r){
            int piv = pivot(arr, l , r);
            quickSort(arr,l, piv - 1);
            quickSort(arr,piv+1, r);
        }
    }
}