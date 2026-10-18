package Lab2;

public class LinkedList <T>{

    static class Node <T> {
        T value ;
        Node<T> next;

        public Node(T value){
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int sz = 0;

    public int size() {
        return sz;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void insertFirst(T item){
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        sz++;
        if (sz == 1) tail = head;
    }
    public void insertLast(T item){
        Node <T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = newNode;
            tail = head;
            sz++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        sz++;
    }
    public void insert(int pos, T item){

        Node<T> newNode = new Node<>(item);

        if (pos == 0) insertFirst(item);
        else if (pos == sz) insertLast(item);

        else{
            int idx = 0;
            Node <T> node = head;
            while (idx < sz){
                if (idx + 1 == pos){
                    newNode.next = node.next;
                    node.next = newNode;
                    sz++;
                    return;
                }
                node = node.next;
                idx++;
            }
            System.out.println("Index out of range");
        }
    }
    public T removeFirst(){
        if (isEmpty()){
            System.out.println("List is empty !!");
            return null;
        }

        T val = head.value;
        if (head.next == null) {
            head = tail = null ;
        }
        else{
            head = head.next;
        }
        sz--;
        return val;
    }
    public T removeLast(){
        if (isEmpty()){
            System.out.println("List is empty");
            return null;
        }
        T val = tail.value;
        if (sz == 1){
            head = tail = null;
        }
        else{
            Node<T> node = head;
            while (node.next.next != null){
                node = node.next;
            }
            node.next = null;
            tail = node;
        }
        sz--;
        return val;
    }
    public T removeKey(T key){
        if (isEmpty()){
            System.out.println("List is empty");
            return null;
        }

        if (key == head.value) return removeFirst();
        else if (key == tail.value) return removeLast();

        else{
            Node<T> node = head;
            while (node.next != null){
                if (node.next.value == key){
                    T val = node.next.value ;
                    node.next = node.next.next;
                    sz--;
                    return val;
                }
                node = node.next ;
            }
            System.out.println("Doesn't exist");
            return null;
        }
    }
    public void display(){
        Node<T> node = head ;
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public void reverse(){
//        for (int i = 0 ; i < sz ; i++){
//            insert(i, removeLast());
//        }
        Node<T> prev, cur, next ;
        prev = null;
        cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public boolean search(T key){
        Node<T> node = head;
        while (node != null) {
            if (node.value == key)
                return true;
            node = node.next;
        }
        return false;
    }
}
