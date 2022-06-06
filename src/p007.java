// Project Euler.net Problem 7
// 10001st Prime

public class p007 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p007().run());
  }

  @Override
  public String run() {
    int i = 1, count = 0;
    while (count != 10001) {
      i++;
      if (Library.isPrime(i)) {
        count += 1;
      }
    }
    return Integer.toString(i);
  }
}
