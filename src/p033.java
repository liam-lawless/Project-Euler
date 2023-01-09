// ProjectEuler.net Problem 33
// Digit Cancelling Fractions

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// not the prettiest solution but it works :/

public class p033 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p033().run());
  }

  @Override
  public String run() {
    // running product of valid fractions
    double result = 1;
    // check fractions with 2 digits in the numerator and denominator whose values are less thant 1
    for (int i = 10; i <= 99; i++) {
      for (int j = i + 1; j <= 99; j++) {
        // if the fraction is able to cancel, multiply it against the other valid fractions
        if(canCancel(i, j) && j % 10 != 0) {
          result *= (double) i / j;
        }
      }
    }

    return Library.convertDecimalToFraction(result);
  }

  private boolean canCancel(int numerator, int denominator) {
    // type cast integer division to float value to accurately compare values
    float fractionValue = (float) numerator / denominator;

    // split one number to compare digit by digit
    List<String> numeratorDigits = new LinkedList<String>(Arrays.asList(Integer.toString(numerator).split("")));
    List<String> denominatorDigits = new LinkedList<String>(Arrays.asList(Integer.toString(denominator).split("")));

    // check both digits in the numerator
    for (int i = 0; i < numeratorDigits.size(); i++) {
      // if either number in the numerator is contained in the denominator
      if(aContainsB(denominator, Integer.parseInt(numeratorDigits.get(i)))) {
        // eliminate the matching numbers from the fraction and check if it is a valid simplification
        denominatorDigits.remove(numeratorDigits.get(i));
        numeratorDigits.remove(numeratorDigits.get(i));

        // check if the new fraction is a valid simplification
        float newQuotient = (float) Integer.parseInt(numeratorDigits.get(0)) / Integer.parseInt(denominatorDigits.get(0));

        // if the new fraction is a valid simplification return true
        if (newQuotient == fractionValue) {
          return true;
        }
      }
    }

    return false;
  }

  // Check if one number is contained in another number
  // https://stackoverflow.com/questions/64651286/how-can-i-know-if-a-number-is-contained-in-another-in-java
  private static boolean aContainsB(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    int p = 1;
    while (p <= b) {
      p *= 10;
    }

    boolean contains = a == b;
    while (!contains && a >= b) {
      contains = a % p == b || a == b;
      a /= 10;
    }
    return contains;
  }
}
