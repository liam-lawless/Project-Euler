// ProjectEuler.net Problem 32
// Pandigital Products

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p032 implements Euler {
  public static void main(String[] args) {
    System.out.println(new p032().run());
  }

  @Override
  public String run() {
    // store all products that fit the criteria
    ArrayList<Integer> result = new ArrayList<Integer>();

    // check arbitrary span of multiplicands and multipliers
    for (int i = 1; i <= 1000; i++) {
      for (int j = 1; j <= 10000; j++) {
        int prod = i * j;

        // concatenate the multiplicand, multiplier, and product together
        // use stringbuilder for faster speed, string concatenation very slow
        StringBuilder str = new StringBuilder();
        str.append(i);
        str. append(j);
        str.append(prod);

        // if the number is pandigital and the product is not already listed in our arraylist, add it to result
        if (isPandigital(9, str.toString()) && !result.contains(prod)) {
          result.add(prod);
        }
      }
    }

    return Integer.toString(Library.sum(result));
  }

  // Checks if a number is pandigital. Number must be given as a string
  private boolean isPandigital(int upperBound, String numAsString) {
    List nums = Arrays.asList(numAsString.split(""));

    // check to see that the given number contain the numbers 1 through the upperbound
    for (int i = 1; i <= upperBound; i++) {
      if (!nums.contains(Integer.toString(i)) || numAsString.length() != upperBound) {
        return false;
      }
    }

    return true;
  }
}
