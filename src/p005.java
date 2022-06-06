// Project Euler.net Problem 5
// Smallest Multiple

public class p005 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p005().run());
  }

  @Override
  public String run() {
    int i = 20;
    boolean found = false;

    while(!found) {
      // increment i by positive 1
      i++;

      // check i against all 20 numbers
      for (int j = 1; j <= 20; j++) {
        if ( !(i % j == 0)) {
          break;
        }
        // if for loop is completed, the integer is found
        if (j == 20) {
          found = true;
        }
      }
    }

    return Integer.toString(i);
  }
}
