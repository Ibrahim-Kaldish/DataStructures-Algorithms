import Lab4.MergeSortSection;
import Lab4.QuickSortSection;
import Lab4.Student;
import Lab5.HeapSort;
import Lab5.PriorityQueue;
import Lab6.BST;

void main() {

//    Student[] students = {
//            new Student("Ali", 3.2),
//            new Student("Sara", 3.2),
//            new Student("Omar", 2.8),
//            new Student("Lina", 3.5)
//    };
//
//    new QuickSortSection<>(students).sort();
//
//    System.out.println(Arrays.toString(students));
//
//    for (Student el: students) System.out.print(el.getGpa()+ " ");

    //       i
    // 2 4 6 ...
    //       j
    // 1 3 5 7 8 9

    // [1 2 3 4 5 6 7]

//    PriorityQueue<Integer> pq = new PriorityQueue<>();
//    pq.add(5);
//    pq.add(1);
//    pq.add(9);
//    pq.add(3);
//    pq.add(7);
//
//    System.out.println(pq.size());     // 5
//    System.out.println(pq.peek());     // 9
//    System.out.println(pq.remove());   // 9
//    System.out.println(pq.remove());   // 7
//    System.out.println(pq.remove());   // 5
//    System.out.println(pq.remove());   // 3
//    System.out.println(pq.remove());   // 1
//    System.out.println(pq.remove());   // null
//    System.out.println(pq.isEmpty());  // true
//
//
//    String[] arr = new String[] {"Ibrahim", "Ahmed", "Hossam"};
//    HeapSort<String> heapSort = new HeapSort<>(arr);
//    heapSort.sort();
//
//    for (String el: arr){
//        System.out.print(el + " ");
//    }

    Integer[] arr = new Integer[] {5,2,3,4,1} ;
    BST<Integer> bst = new BST<>();

    for (Integer el: arr)
        bst.insert(el);


    Integer x = bst.delete(2);
    System.out.println(x);

    bst.preorder();
    System.out.println(" ");

    bst.inorder();
    System.out.println(" ");

    bst.postorder();




}
