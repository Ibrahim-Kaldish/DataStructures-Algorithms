import Lab8.Graph;
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


    System.out.println(bst.height());

//    System.out.println(bst.countNodes());
//    Integer x = bst.delete(2);
//    System.out.println(bst.countNodes());

//    System.out.println(bst.max());
//    System.out.println(bst.min());

//    System.out.println(x);
//
//    bst.preorder();
//    System.out.println(" ");
//
//    bst.inorder();
//    System.out.println(" ");
//
//    bst.postorder();

    Graph g = new Graph(6, false);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    g.addEdge(3, 5);

    System.out.println("Matrix:");
    g.printMatrix();
    System.out.println("List:");
    g.printList();

    System.out.println("DFS: " + g.dfs(0));
    System.out.println("BFS: " + g.bfs(0));
    System.out.println(g.hasEdge(1, 3));
    System.out.println(g.hasEdge(1, 4));

    Graph dg = new Graph(4, true);
    dg.addEdge(0, 1);
    dg.addEdge(1, 2);
    dg.addEdge(2, 0);
    dg.addEdge(2, 3);

    System.out.println("DFS directed: " + dg.dfs(0));
    System.out.println("BFS directed: " + dg.bfs(0));
    System.out.println("BFS from 3: " + dg.bfs(3));
}
