/**
 * Library of commonly used methods across problem solutions.
  */
public class Library {

  /**
   * Determines whether ant integer is a palindrome. i.e. 9009, 174471
   *
   * @param n Integer to check if palindrome
   * @return true if palindrome, false if not
   */
  public static boolean isPalindrome(int n) {
    String toStr = Integer.toString(n);
    int i = 0, j = toStr.length() - 1;

    // compare each character starting from the front and back of n
    while (i < j) {
      if (toStr.charAt(i) != toStr.charAt(j))
        return false;

      i++;
      j--;
    }
    return true;
  }

  /**
   * Determines if a number is prime. Compatible with long values.
   *
   * @param n number to check prime status
   * @return boolean true if prime, false if not prime
   */
  public static boolean isPrime(long n) {
    if (n <= 1) {
      return false;
    }
    // check every value up to √n
    for (long i = 2; i <= Math.sqrt(n); i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * computes Pythagorean's Theorem.
   *
   * @param a first value
   * @param b second value
   * @return the sum of a^2 + b^2
   */
  public static double pythagorean(double a, double b) {
    return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
  }

  /**
   * Multiplies the number by every natural number below it.
   *
   * @param num Number to find the factorial of
   * @return Factorial of num
   */
  public static long factorial(int num) {
    // base case
    if (num == 0) {
      return 1;
    }
    // recursive case
    return num * factorial(num - 1);
  }

  /**
   * a selection of items from a set that has distinct members where order doesn't matter.
   *
   * @param n total number of objects in the set
   * @param k number of choosing objects from the set
   * @return number of combinations
   */
  public static long choose(int n, int k) {
    return factorial(n) / (factorial(k) * (factorial(n - k)));
  }
}
