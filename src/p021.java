// Project Euler.net Problem 21
// Amicable Numbers

// Brute Force approach

public class p021 {

  public static void main(String[] args) {
    System.out.println(new p021().run());
  }

  public String runBrute() {
    int ceil = 10000;
    int result = 0;

    // iterate through every number < 10000 where i != j
    for (int i = 1; i < ceil; i++) {
      for (int j = i + 1; j < ceil; j++) {
        // if i and j are amicable numbers, add them to the running sum of amicable numbers
        if (isAmicable(i, j)){
          result += i;
          result += j;
        }
      }
    }

    // Return the sum of all amicable numbers
    //return amicableNums.toString();
    return Integer.toString(result);
  }

  // because an amicable pair is a loop, we do not need to iterate using a nested for loop
  // x -> sum of divisors(x) = y -> sum of divisors(y) = x ...
  public String run() {
    int ceil = 10000;
    int result = 0;

    // Iterate through every integer less than the ceiling
    for (int i = 2; i < ceil; i++) {
      // find the sum of all divisors of i
      int sumDivi = Library.sum(Library.divisors(i, true));

      // if the sum of all divisors is larger than i, we can possibly have a j with sumDiv = i
      if (sumDivi <= ceil && sumDivi > i) {
        // find the sum of all divisors of j
        int sumDivj = Library.sum(Library.divisors(sumDivi, true));
        // if the sum of all divisors of j = i, loop is complete, add the amicable pair
        if (sumDivj == i) {
          // add the amicable pair (i and the sum of divisors of i (aka j))
          result += i + sumDivi;
        }
      }
    }

    // return the sum of all amicable numbers less than the ceiling
    return Integer.toString(result);
  }



  /**
   * Determine if two numbers are an amicable pair.
   *
   * @param x First Integer
   * @param y Second Integer
   * @return True if the integers are an amicable pair, false if they are not
   */
  private boolean isAmicable(int x, int y) {
    int sumDivX = Library.sum(Library.divisors(x, true));
    int sumDivY = Library.sum(Library.divisors(y, true));

    if (x == sumDivY && y == sumDivX) {
      return true;
    }

    return false;
  }
}
