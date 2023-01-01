// ProjectEuler.net Problem 29
// Distinct Powers

import java.math.BigInteger;
import java.util.ArrayList;

public class p029 implements Euler {
  public static void main(String[] args) {
    System.out.println(new p029().run());
  }

  @Override
  public String run() {
    // ArrayList to contain all distinct values
    ArrayList<BigInteger> terms = new ArrayList<BigInteger>();

    // iterate over every a^b value between 2 <= a <= 100 and 2 <= b <= 100
    for (int i = 2; i <= 100; i++) {
      for (int j = 2; j <= 100; j++) {
        // store the result as a big integer
        BigInteger result = new BigInteger(String.valueOf(i)).pow(j);

        // if the answer does not already exist in our distinct powers, add to the list
        if (!terms.contains(result)) {
          terms.add(result);
        }
      }
    }

    // return the number of distinct powers
    return Integer.toString(terms.size());
  }
}
