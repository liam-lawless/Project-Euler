// Project Euler.net Problem 4
// Largest palidrome product

public class p004 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p004().run());
  }
  @Override
  public String run() {
    int largestPalindrome = 0;

    // min value: 100 * 101 = 10100
    // max value: 998 * 999 = 997002
    for (int i = 101000 ; i < 997002; i++) {
      // if i is a palindrome and larger than previous largest palindrome
      if (Library.isPalindrome(i) && i > largestPalindrome) {
        largestPalindrome = i;
      }
    }
    return Integer.toString(largestPalindrome);
  }
}
