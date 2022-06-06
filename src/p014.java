// Project Euler.net Problem 14
// Longest Collatz sequence

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class p014 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p014().run());
  }

  @Override
  public String run() {
    long largestCollatzIndex = 0, largestCollatzSize = 0;

    for(int i = 1; i <= 1000000; i++) {
      int tempSize = calculateCollatz(i).size();

      if (tempSize > largestCollatzSize) {
        largestCollatzIndex = i;
        largestCollatzSize = tempSize;
      }
    }

    return Long.toString(largestCollatzIndex);
  }

  private LinkedList<Long> calculateCollatz(long start) {
    LinkedList<Long> seq = new LinkedList<Long>(Arrays.asList(start));

    // until the end of the collatz sequence
    while (start != 1) {
      // check if current link is even
      if (start % 2 == 0) {
        start /= 2;
      }
      // otherwise odd
      else {
        start = 3 * start + 1;
      }
      // and the current link to the chain
      seq.add(start);
    }
    // return the collatz sequence
    return seq;
  }
}
