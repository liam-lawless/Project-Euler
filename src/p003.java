// Project Euler.net Problem 3
// Largest Prime Factor

import java.util.LinkedList;
import java.util.List;

public class p003 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p003().run());
  }

  @Override
  public String run() {
    return String.valueOf(findLargestPrimeFactor(600851475143L));
  }

  private long findLargestPrimeFactor(long n) {
    List<Integer> primeNumbers = new LinkedList<>();
    for (long i = 2; i <= 10000; i++) {
      if (Library.isPrime(i) && n % i == 0) {
        primeNumbers.add((int) i);
      }
    }
    return primeNumbers.get(primeNumbers.size() - 1);
  }
}