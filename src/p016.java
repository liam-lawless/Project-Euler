// Project Euler.net Problem 16
// Power digit sum

import java.math.BigInteger;

public class p016 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p016().run());
  }

  @Override
  public String run() {
    String[] arrNum = new BigInteger("2").pow(1000).toString().split("");

    int sum = 0;
    for (int i = 0; i < arrNum.length; i++) {
      sum += Integer.parseInt(arrNum[i]);
    }
    return Integer.toString(sum);
  }
}
