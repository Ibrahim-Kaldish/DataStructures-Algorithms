package Lab1;

public class FlexibleArray <T> {
    private Object[] arr;
    private int idx = 0 ;

    public FlexibleArray (int n){
        arr = new Object[n];
    }

    public Object[] getArr() {
        return arr;
    }

    public int size(){
        return idx;
    }

    public int capacity(){
        return arr.length;
    }

    public boolean isEmpty(){
        return arr.length == 0 ;
    }

    public void resize(int sz){
        Object[] newArr = new Object[sz];
        for (int i = 0 ; i < Math.min(arr.length, sz) ; i++){
            newArr[i] = arr[i];
        }
        arr = newArr ;
        newArr = null;
    }

    public void insert(T obj){
        if (idx > arr.length - 1)
            resize(2 * idx);
        arr[idx++] = obj;
    }

    public void shrinkToSize(){
        resize(idx);
    }

    public T pop(){
        if (idx <= arr.length / 2) resize(idx);

        if (idx >= 0){
            T x = (T) arr[idx-1];
            arr[idx-1] = null;
            idx--;
            return x;
        }
        else{
            System.out.println("The Array is empty");
            return null;
        }
    }
}
