// Project Euler.net Problem 15
// Lattice Paths
// Did not entirely solve by own work. Stuck on BigIntegers.

import java.math.BigInteger;

public class p015 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p015().run());
  }

  @Override
  public String run() {
    // we know that in a grid of size NxN, to get from the top left corner to the bottom right
    // corner we have to take N steps down and N steps right. In the example 2x2 grid that could
    // look like D D R R or R R D D or D R R D... essentially in 4 moves, we have to choose 2 ways
    // to move down, and we can assume that every other move will be to the right.

    // for a grid of size 20x20 ,we know we must make, in any order, 20 moves down and 20 moves
    // to the right. Therefore we know that we are choosing 20 from 40 moves, because again we can
    // assume if we aren't moving down, we are moving to the right.
    return choose(40,20).toString();
  }

  public static BigInteger factorial(int num) {

    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= num; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }

  public static BigInteger choose(int n, int k) {
    // factorial(n) / (factorial(k) * (factorial(n - k)))
    BigInteger result = BigInteger.ONE;

    for (int i = 0; i < k; i++) {
      result = result.multiply(BigInteger.valueOf(n - i));
    }

    return result.divide(factorial(k));
  }
}
