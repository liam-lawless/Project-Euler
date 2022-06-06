// Project Euler.net Problem 10
// Summation of Primes

public class p010 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p010().run());
  }

  @Override
  public String run() {
    long sum = 0;
    for (int i = 1; i < 2000000; i++) {
      if (Library.isPrime(i)) {
        System.out.println(i);
        sum += i;
      }
    }
    return Long.toString(sum);
  }
}
