// ProjectEuler.net Problem 26
// Reciprocal Cycles

import java.lang.reflect.Array;
import java.util.ArrayList;

public class p026 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p026().run());
  }

  @Override
  public String run() {
    // largest cycle so far
    int maxCycle = 0;
    int maxCycleIndex = 0;
    ArrayList<Integer> primes = Library.getPrimes(1000);

    // the denominator must be co-prime to 10 therefore we must
    // remove any prime that is divisible by 2 or 5 or the recurrence will never terminate
    for (int i = 0; i < primes.size(); i++) {
      if (primes.get(i) % 5 == 0 || primes.get(i) % 2 == 0) {
        primes.remove(i);
      }
    }

    for (int i = 0; i < primes.size(); i++) {
      // if the cycle of the current number is larger than the max cycle so far
      if (findCycleLength(primes.get(i)) > maxCycle) {
        // store the current cycle as new max cycle
        maxCycle = findCycleLength(primes.get(i));
        // store the index
        maxCycleIndex = i;
      }
    }

    return Integer.toString(primes.get(maxCycleIndex));
  }

  private int findCycleLength(int denominator) {
    int res = 1;
    int times = 0;

    // while the recurrence has not ended with a 1
    do {
      res = res * 10 % denominator;
      times++;
    } while (res != 1);

    return times;
  }
}
