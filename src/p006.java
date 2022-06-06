// Project Euler.net Problem 6
// Sum Square Difference

import java.util.function.Function;

public class p006 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p006().run());
  }

  @Override
  public String run() {
    int sumOfSquares = 0, squareOfSums = 0;
    for (int i = 1; i <= 100; i++) {
      sumOfSquares += i * i;
      squareOfSums += i;
    }

    return Integer.toString((int) (Math.pow(squareOfSums, 2) - sumOfSquares));
  }
}
