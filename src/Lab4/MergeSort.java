package Lab4;

import java.util.Arrays;

public class MergeSort <T extends Comparable<T>>{
    T[] arr;

    public MergeSort(T[] arr){
        this.arr = arr;
    }

    public void sort(){
        mergeSort(0, arr.length-1);
    }

    private void merge(int l, int mid, int r){
        int n1 = mid-l+1, n2 = r-mid ;

        T[] L = Arrays.copyOfRange(arr,l,mid + 1);
        T[] R = Arrays.copyOfRange(arr,mid+1,r+1);

        int i = 0 , j = 0, k = l;

        while (i < n1 && j < n2){
            if ((L[i].compareTo(R[j])) < 0) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];

    }

    private void mergeSort( int l, int r){
        if (l < r){
            int m = (l + r) / 2 ;
            mergeSort(l , m);
            mergeSort(m+1 , r);
            merge(l, m, r);
        }

    }
}























//import java.util.Arrays;
//
//public class MergeSort < T extends Comparable<T> > {
//
//    T[] a ;
//
//    public MergeSort(T[] a){
//        this.a = a;
//    }
//
//    public void sort(){
//        mergeSort(0, a.length-1);
//    }
//
//    private void merge(T[] a, int l, int mid, int r){
//        int n1 = mid-l+1, n2 = r-mid ;
//
//        T[] L = Arrays.copyOfRange(a,l,mid + 1);
//        T[] R = Arrays.copyOfRange(a,mid+1,r+1);
//
//        int i = 0 , j = 0, k = l;
//
//        while (i < n1 && j < n2){
//            if ((L[i].compareTo(R[j])) < 0) a[k++] = L[i++];
//            else a[k++] = R[j++];
//        }
//        while (i < n1) a[k++] = L[i++];
//        while (j < n2) a[k++] = R[j++];
//
//    }
//
//    private void mergeSort(int l, int r){
//        if (l < r) {
//            int m = (l + r) / 2 ;
//            mergeSort (l, m);
//            mergeSort (m+1, r);
//            merge (a, l, m, r);
//        }
//    }
//
//}
