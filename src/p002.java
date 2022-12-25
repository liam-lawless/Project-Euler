// Project Euler.net Problem 2
// Even Fibonacci numbers

public class p002 implements Euler {

    public static void main(String[] args) {
        System.out.println(new p002().run());
    }

    @Override
    public String run() {
        int sum = 0;
        int a = 1;
        int b = 2;

        while ( !(a >= 4000000) || !(b >= 4000000)) {
            if (a % 2 == 0) {
                sum += a;
            }
            int c = a + b;
            a = b;
            b = c;
        }
        return Integer.toString(sum);
    }
    
}
