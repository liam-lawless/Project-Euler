// Project Euler.net Problem 12
// Highly divisible triangular number

import java.math.BigInteger;

public class p012 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p012().run());
  }

  @Override
  public String run() {
    int index = 0;

    for (int i = 1; ;i++) {
      index += i;
      if (calculateDivisors(index) > 500) {
        return Integer.toString(index);
      }
    }

  }

  private int calculateDivisors(int num) {
    int counter = 0;

    for (int i = 1; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        if (num / i == i) {
          counter += 1;
        }

        else {
          counter += 2;
        }

      }
    }
    return counter;
  }
}
