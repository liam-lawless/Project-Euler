// ProjectEuler.net Problem 31
// Coin Sums

public class p031 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p031().run());
  }

  @Override
  public String run() {
    return Integer.toString(findTotalCoins(200));
  }

  private int findTotalCoins(int goal) {
    int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    int[] arr = new int[goal + 1];
    arr[0] = 1;

    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= goal; j++) {
        arr[j] += arr[j - coins[i]];
      }
    }

    return arr[goal];
  }
}
