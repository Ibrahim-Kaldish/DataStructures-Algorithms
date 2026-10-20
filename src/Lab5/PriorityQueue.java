package Lab5;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity){
        heap = (T[]) new Comparable[Math.max(1, capacity)];
    }

    public PriorityQueue(){
        this(10);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T peek(){
        return isEmpty() ? null : heap[0];
    }

    public void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void add(T x){
        if (size == heap.length)
            heap = Arrays.copyOf(heap, size * 2);

        heap[size] = x;
        int i = size++;

        while (i > 0 && heap[i].compareTo(heap[(i - 1) / 2]) > 0){
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public T remove(){
        if (isEmpty()) return null;

        T top = heap[0];
        heap[0] = heap[--size];
        heap[size] = null;
        heapify(heap, size, 0);
        return top;
    }

    public void heapify(T[] arr, int n, int root){
        int l = 2 * root + 1;
        int r = 2 * root + 2;
        int mx = root;

        if (l < n && arr[l].compareTo(arr[mx]) > 0) mx = l;
        if (r < n && arr[r].compareTo(arr[mx]) > 0) mx = r;

        if (root != mx){
            swap(arr, root, mx);
            heapify(arr, n, mx);
        }
    }
}