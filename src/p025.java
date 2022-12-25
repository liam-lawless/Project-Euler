// ProjectEuler.net Problem 25
// 1000-Digit Fibonacci Number

import java.math.BigInteger;

public class p025 implements Euler{
  public static void main(String[] args) {
    System.out.println(new p025().run());
  }

  @Override
  public String run() {
    // longest fibonacci number so far
    int fibonacciLength = 0;
    int i = 0;

    // while the length of the ith fibonacci number is less than 1,000
    while (fibonacciLength < 1000) {
      // increment i by 1
      // increment first so the while loop will terminate with the current i value
      i++;

      // calculate the ith fibonacci number, convert it to a string,
      // and retrieve the length of the string
      fibonacciLength = Library.fibonacciBigInt(i).toString().length();
    }

    // return the value of i
    return Integer.toString(i);
  }
}
