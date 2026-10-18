package Lab1;

public class Fibonacci {
    private int n ;

    public Fibonacci(int n){
        this.setN(n);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n >= 0)
            this.n = n;
        else
            System.out.println("We Cannot calualte fibonacci for a negative number");
    }

    public long iterative_fibonacci(){
        int a = 0 , b = 1 , c = a + b ;
        for (int i = 2 ; i < n ; i++){
            a = b ;
            b = c ;
            c = a + b ;
        }
        return c;
    }

    public long fib(int n){
        if (n<2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public long recursive_fibonacci(){
        return fib(n);
    }
}
