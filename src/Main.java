import Lab4.MergeSortSection;
import Lab4.QuickSortSection;
import Lab4.Student;


void main() {

    Student[] students = {
            new Student("Ali", 3.2),
            new Student("Sara", 3.2),
            new Student("Omar", 2.8),
            new Student("Lina", 3.5)
    };

    new QuickSortSection<>(students).sort();

    System.out.println(Arrays.toString(students));

    for (Student el: students) System.out.print(el.getGpa()+ " ");

    //       i
    // 2 4 6 ...
    //       j
    // 1 3 5 7 8 9

    // [1 2 3 4 5 6 7]



}
