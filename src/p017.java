// Project Euler.net Problem 17
// Number letter counts

public class p017 implements Euler {

  public static void main(String[] args) {
      System.out.println(new p017().run());
  }

  @Override
  public String run() {
    int count = 0;
    for (int i = 1; i <= 1000; i++) {
      count += toWords(i).length();
    }
    return Integer.toString(count);
  }

  // because we do not want to count spaces or hyphens we will not
  // include them regardless of spelling accuracy
  // works up to 999
  private String toWords(int val) {
    // ones place
    String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"};
    // tens place
    String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};
    //hundreds place
    String[] hundreds = {"", "onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred",
            "sixhundred", "sevenhundred", "eighthundred", "ninehundred"};
    // thousands place
    String[] thousands = {"", "onethousand", "twothousand"};

    String[] arr = String.valueOf(val).split("");

    if (arr.length == 1) {
      return ones[Integer.parseInt(arr[0])];
    }

    else if (arr.length == 2) {
      // if a teen
      if (arr[0].equals("1")) {
        return teens[Integer.parseInt(arr[1])];
      }
      // otherwise tens
      else {
        return tens[Integer.parseInt(arr[0])] + ones[Integer.parseInt(arr[1])];
      }
    }

    else if (arr.length == 3) {
      // if not a perfect hundredth
      if ( !(arr[1].equals("0") && arr[2].equals("0")) ) {
        // if a teen
        if (arr[1].equals("1")) {
          return hundreds[Integer.parseInt(arr[0])] + "and" + teens[Integer.parseInt(arr[2])];
        }
        // otherwise tens
        else {
          return hundreds[Integer.parseInt(arr[0])] + "and" + tens[Integer.parseInt(arr[1])] + ones[Integer.parseInt(arr[2])];
        }
      }
      // otherwise divisible by 100
      else {
        return hundreds[Integer.parseInt(arr[0])];
      }
    }

    else if (arr.length == 4) {
      return "onethousand";
    }

    return "Number not within 1 and 1000";
  }
}
