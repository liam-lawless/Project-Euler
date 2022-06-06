// Project Euler.net Problem 9
// Special Pythagorean Triplet

public class p009 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p009().run());
  }

  @Override
  public String run() {
    double result = 0;
    Outerloop:
    for (double i = 3; i < 999; i++) {
      for (double j = 4; j < 999; j++) {
        double k = Library.pythagorean(i, j);

        if (i < j && j < k && i + j + k == 1000.0) {
          result = i * j * k;
          break Outerloop;
        }
      }
    }
    return Double.toString(result);
  }
}