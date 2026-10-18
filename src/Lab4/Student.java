package Lab4;

public class Student implements Comparable<Student>{
   String name;

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double gpa ;

   public Student(String name, double gpa){
       this.name = name ;
       this.gpa = gpa;
   }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    @Override
   public int compareTo(Student std){
       int gpaCompare = Double.compare(this.gpa, std.gpa);
       if (gpaCompare == 0){
           return this.name.compareTo(std.name);
       }
       return gpaCompare;
   }
}