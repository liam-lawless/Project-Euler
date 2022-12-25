// ProjectEuler.net Problem 23
// Non-Abundant Sums

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p023 implements Euler {

  public static void main(String[] args)  {
    System.out.println(new p023().run());
  }

  public String run() {
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> abundantNumbers = abundantNums(28123);

    // find all positive integers that cannot be expressed as the sum of two abundant numbers
    for (int i = 1; i <= 28123; i++) {
      // if i can not be represented as the sum of two numbers from abundantNumbers, append to result
      if (!hasTwoSum(abundantNumbers, i)) {
        result.add(i);
      }
    }

    // return the sum of result
    return Integer.toString(Library.sum(result));
  }

  // Determine if a target number can be represented as the sum of two numbers from a given ArrayList
  // Return true if the ArrayList contains two numbers that can sum to target int
  // Return false if the ArrayList does not contain two numbers than can sum to target int
  private boolean hasTwoSum(ArrayList<Integer> numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < numbers.size(); i++) {
      int difference = target - numbers.get(i);

      Integer num = map.get(difference);
      if (num != null) {
        return true;
      }

      map.put(numbers.get(i), i);
    }

    return false;
  }

  // Returns an ArrayList of Integers with all abundant numbers up to a given limit
  private ArrayList<Integer> abundantNums(int limit) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    for (int i = 1; i <= limit; i++) {
      // calculate the divisors of i
      ArrayList<Integer> divisors = Library.divisors(i, true);

      // check if i is abundant
      if (Library.sum(divisors) > i) {
        // add numbers twice so that a sum can be calculated with itself i.e. (12 + 12)
        result.add(i);
        result.add(i);
      }
    }

    // return all abundant numbers up to the limit
    return result;
  }
}
