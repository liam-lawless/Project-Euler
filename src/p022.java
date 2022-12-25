// Project Euler Problem 22
// Name Scores

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class p022 implements Euler {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(new p022().run());
  }

  public String run() {
    int score = 0;
    File file = new File("/Users/liamlawless/Desktop/Coding/ProjectEuler/aux/p022_names.txt");
    Scanner sc = null;
    try {
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    // remove commas
    String[] names = sc.nextLine().split(",", -2);

    // sort alphabetically
    Arrays.sort(names);

    // iterate through names for every name in the list
    for (int i = 0; i < names.length; i++) {
      // remove quotes at the beginning and end of each name
      String name = names[i].substring(1, names[i].length() - 1);
      // find the score of the name, multiply it by its position in the list and add it to the running sum
      score += nameScore(name) * (i + 1);
    }
    return Integer.toString(score);
  }

  /**
   * Convert a name into a score based on the letters used where A = 1, B = 2, ..., Z = 26
   *
   * @param name Any name as a string, not case sensitive
   * @return Sum of all letters used in the name
   */
  private int nameScore(String name) {
    int score = 0;

    // iterate through every character in the name
    for (int i = 0; i < name.length(); i++) {
      // Convert the character to ASCII, subtract 64 so A = 1, B = 2, ..., Z = 26
      score += (int)Character.toUpperCase(name.charAt(i)) - 64;
    }

    return score;
  }
}
