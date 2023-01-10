// ProjectEuler.net Problem 35
// Circular Primes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p035 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p035().run());
  }

  @Override
  public String run() {
    // define the upper limit to search for circular primes
    int lim = 1000000;

    // Iterate through all primes below the limit
    ArrayList<Integer> primes = Library.getPrimes(lim);

    // store all valid circular primes
    ArrayList<Integer> circularPrimes = new ArrayList<Integer>();

    // iterate through all prime numbers stored in our list
    for (int i = 0; i < primes.size(); i++) {
      // if the prime number is circular, add it to our list
      if (isCircularPrime(primes.get(i))) {
        circularPrimes.add(i);
      }
    }

    // return the number of circular primes below the limit
    return Integer.toString(circularPrimes.size());
  }

  private boolean isCircularPrime(int number) {
    // convert int to mutable array of digits represented as strings
    List<String> digits = new LinkedList<String>(Arrays.asList(Integer.toString(number).split("")));

    for (int i = 0; i < digits.size(); i++) {
      // check if the current rotation of the number is prime, if not return false, otherwise continue the for loop
      if (!Library.isPrime(convertListToInteger(digits))) {
        return false;
      }

      // move the last element to the front of the list
      digits.add(0, digits.get(digits.size() - 1));

      // remove the last element of the list
      digits.remove(digits.size() - 1);
    }

    return true;
  }

  // Convert a list of strings to an integer
  private Integer convertListToInteger(List<String> listOfStrings) {
    StringBuilder result = new StringBuilder();

    // append each string to the stringbuilder
    for (String listOfString : listOfStrings) {
      result.append(listOfString);
    }

    // convert the string builder to and integer
    return Integer.parseInt(String.valueOf(result));
  }
}
