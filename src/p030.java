// ProjectEuler.net Problem 30
// Digit fifth powers

import java.util.ArrayList;

public class p030 implements Euler {
  public static void main(String[] args) {
    System.out.println(new p030().run());
  }

  @Override
  public String run() {
    // Store all values where the sum of the power of their digits is equal to that value
    ArrayList<Integer> digits = new ArrayList<Integer>();

    // iterate through numbers in a broad, unspecific range
    for (int i = 2; i <= 1000000; i++) {
      // if i is equal to the sum of its digits raised to the 5th power
      if (i == sumOfPowerOfDigits(i, 5)) {
        // add i to the list
        digits.add(i);
      }
    }

    // return the sum of all numbers that have met the condition
    return Integer.toString(Library.sum(digits));
  }

  private int sumOfPowerOfDigits(int num, int pow) {
    // convert the number to a string
    String str = Integer.toString(num);

    // convert the string toCharArray
    char[] arr = str.toCharArray();

    // iterate through the array and convert each char to an int
    // for each int raise it to the nth power and add to runnning sum
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += Math.pow(Character.getNumericValue(arr[i]), pow);
    }

    return sum;
  }
}
