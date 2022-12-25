// ProjectEuler.net Problem 28
// Number Spiral Diagonals

public class p028 implements Euler{

  public static void main(String[] args) {
    System.out.println(new p028().run());
  }

  @Override
  public String run() {
    return Integer.toString((int)func(1001));
  }

  private double func(int n) {
    // n represents the number of rings to the spiral
    // to convert this to a length by height value -> (n + 1) / 2
    n = (n + 1) / 2;

    // running sum of the spiral
    // center tile is excluded
    double sum = 1;

    for (int i = 1; i < n; i++) {
      //diagonal up-right = 4n^2 - 4n + 1
      double upRight = (4 * Math.pow(i, 2)) + (4 * i) + 1;
      //diagonal up-left = 4n^2 - 6n + 3
      double upLeft = (4 * Math.pow(i, 2)) + (2 * i) + 1;
      //diagonal down-left = 4n^2 - 8n + 5
      double downLeft = (4 * Math.pow(i, 2)) + 1;
      //diagonal down-right = 4n^2 - 10n + 7
      double downRight = (4 * Math.pow(i, 2)) - (2 * i) + 1;

      sum += upRight + upLeft + downRight + downLeft;
    }

    return sum;
  }
}
