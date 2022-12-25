// Project Euler.net Problem 20
// Factorial Digit Sum

// Find the sum of the digits in the number 100!

public class p020 implements Euler{

  public static void main(String[] args) {
    System.out.println(new p020().run());
  }

  public String run() {
    // Calculate the factorial of 100 using bigIntegers and convert it to a string
    String s = Library.fact(100).toString();

    // initialize a running sum variable
    int sum = 0;

    // for every character in the string of fact(100), add to sum
    for(int i = 0; i < s.length(); i++) {
      sum += Character.getNumericValue(s.charAt(i));
    }

    // return the sum of every integer in 100!
    return Integer.toString(sum);
  }
}
