// ProjectEuler.net Problem 34
// Digit Factorials

import java.util.ArrayList;

public class p034 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p034().run());
  }


  @Override
  public String run() {
    ArrayList<Integer> validNumbers = new ArrayList<>();

    // As 1! = 1 and 2! = 2 are not sums they are not included
    // check for all numbers in an arbitrary range
    for (int i = 3; i < 100000; i++) {
      // running sum of the factorial of every digit
      long sum = 0;

      // break down the integer into individual digits
      String[] digits = Integer.toString(i).split("");

      // for every digit in the integer, compute its factorial and add to running sum
      for (int j = 0; j < digits.length; j++) {
        sum += Library.factorial(Integer.parseInt(digits[j]));
      }

      // if running sum is equal to the original integer add to the list of valid numbers
      if (sum == i) {
        validNumbers.add(i);
      }
    }

    return Integer.toString(Library.sum(validNumbers));
  }
}
