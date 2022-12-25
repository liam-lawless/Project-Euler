// ProjectEuler.net Problem 24
// Lexicographic Permutations

import java.util.Collections;
import java.util.List;

public class p024 implements Euler {

  public static void main(String[] args) {
    System.out.println(new p024().run());
  }

  @Override
  public String run() {
    // find all permutations of the given string
    List<String> permuations = Library.findPermutations("0123456789");
    // sort into lexicographic order
    Collections.sort(permuations);
    // return the one-millionth permutation
    return permuations.get(999999);
  }

}
