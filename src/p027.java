// ProjectEuler.net Problem 27
// Quadratic Primes

public class p027 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p027().run());
  }

  @Override
  public String run() {
    int maxConsecutivePrimes = 0;
    int coefficientProduct = 0;

    // test every value of coefficients a and b between -1000 and 1000
    for (int i = -1000; i < 1000; i++) {
      for (int j = -1000; j <= 1000; j++) {
        int n = 0;
        // starting at 0, check how many consecutive primes are generated given the current
        // coefficients, i and j
        while (Library.isPrime(quadraticFunc(i, j, n))) {
          n++;
        }

        // if the current number of consecutive primes is greater than our previous max
        if (n > maxConsecutivePrimes) {
          maxConsecutivePrimes = n;
          coefficientProduct = i * j;
        }

      }
    }

    return Integer.toString(coefficientProduct);
  }

  private int quadraticFunc(int a, int b, int n) {
    return (n * n) + (a * n) + b;
  }
}
