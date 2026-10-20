package Lab5;

public class HeapSort <T extends Comparable<T>>{
    T[] arr;

    public HeapSort(T[] arr){
        this.arr = arr;
    }

    public void sort(){
        heapSort(arr, arr.length);
    }

    public void swap(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void heapify(T[] arr, int n, int root){
        int l = 2 * root + 1 ;
        int r = 2 * root + 2 ;
        int mx = root ;

        if (l < n && arr[l].compareTo(arr[mx]) > 0) mx = l;
        if (r < n && arr[r].compareTo(arr[mx]) > 0) mx = r;

        if (root != mx){
            swap(root, mx);
            heapify(arr, n , mx);
        }
    }

    public void buildHeap(T[] arr, int n){
        for (int i = n / 2 - 1 ; i>=0 ; i--){
            heapify(arr, n, i);
        }
    }

    public void heapSort(T[] arr, int n){
        buildHeap(arr, n);

        for (int i = n - 1 ; i>=0 ; i--){
            swap(i,0);
            heapify(arr, i, 0);
        }
    }

}
