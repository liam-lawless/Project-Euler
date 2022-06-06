// Project Euler.net Problem 1
// Multiples of 3 or 5

public final class p001 implements Euler {

    public static void main(String[] args) {
        System.out.println(new p001().run());
    }

    @Override
   public String run() {
       int sum = 0;
       for (int i = 0; i < 1000; i++) {
           if (i % 3 == 0 || i % 5 == 0) { sum += i; }
       }
    return Integer.toString(sum);
   }
}