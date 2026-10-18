package Lab4;

import java.util.Arrays;

public class MergeSortSection<T extends Comparable<T>> {
    T[] arr ;

    public MergeSortSection(T[] arr){
        this.arr = arr ;
    }

    public void sort (){
        mergeSort(arr, 0, arr.length - 1) ;
    }

    public void merge(T[] arr, int l , int m , int r){
        int i = 0 , j = 0 , k = l;
        T[] L = Arrays.copyOfRange(arr, l , m+1);
        T[] R = Arrays.copyOfRange(arr, m + 1 , r+1);

        while (i < L.length && j < R.length){
            if (L[i].compareTo(R[j]) < 0) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < L.length)  arr[k++] = L[i++];
        while (j < R.length)  arr[k++] = R[j++];

    }
    public void mergeSort(T[]arr, int l, int r){
        if ( l < r) {
            int m = (l + r) / 2 ;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l , m , r);
        }
    }

}