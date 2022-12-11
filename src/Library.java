import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

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
      if (n % i == 0) {
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

  /**
   * Calculates factorial using BigIntegers instead of longs.
   *
   * @param n Integer to find the factorial of
   * @return Factorial value
   */
  public static BigInteger fact(long n) {
    BigInteger result = BigInteger.ONE;
    for (long i = 2; i <= n; i++)
      result = result.multiply(BigInteger.valueOf(i));
    return result;
  }

  /**
   * Return all divisors of a given integer including that integer.
   *
   * @param num Number to find the divisors of.
   * @param exclusive Include or exclude num (itself) from the list of divisors
   * @return ArrayList of integers where every integer is a divisor of num
   */
  public static ArrayList<Integer> divisors(int num, boolean exclusive) {

    // append all divisors of num to the array list
    ArrayList<Integer> result = new ArrayList<Integer>();

    // find the max possible divisor and type cast to integer
    int maxDivisor = (int) Math.sqrt(num);

    for (int i = 1; i <= maxDivisor; i++) {
      // if num is evenly divisible by i, add i to the ArrayList of divisors
      if (num % i == 0) {

        // if divisors are equal, only append once
        if (num / i == i) {
          result.add(i);
        } else {
          result.add(i);
          result.add(num / i);
        }
      }
    }

    // sort the list from least to greatest
    Collections.sort(result);

    // remove num from the list of divisors
    // Result will only contain numbers less than n which divide evenly into n
    if (exclusive) {
      result.remove(result.size() - 1);
    }

    return result;
  }

  /**
   * Returns the sum of all elements in an ArrayList of integers.
   *
   * @param list ArrayList of integers
   * @return Sum of the array list
   */
  public static int sum(ArrayList<Integer> list) {
    int result = 0;

    for(int i = 0; i < list.size(); i++) {
      result += list.get(i);
    }

    return result;
  }
}
