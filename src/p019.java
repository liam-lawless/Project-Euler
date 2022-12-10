// Project Euler.net Problem 19
// Counting Sundays

// How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
// Choosing to do this without the use of any Date libraries.

public class p019 {

  public static void main(String[] args) {
    System.out.println(new p019().run());
  }

  private String run() {
    // Tuesday Jan 1, 1901
    int dayOfTheWeek = 2;
    int numSundays = 0;

    // loop for every year and month between 1901 and 2000 (inclusive)
    for(int year = 1901; year <= 2000; year++) {
      for(int month = 1; month <= 12; month++) {

        // end the code at dec. 2000 because we do not want to count Sunday Jan. 1st, 2001
        if (year == 2000 && month == 12) {
          break;
        }

        // day of the week on the first of every month
        dayOfTheWeek = daysPassed(dayOfTheWeek, getMonthLength(month, year));

        // check if the first day of the month is a sunday and count it
        if (dayOfTheWeek == 0) {
          numSundays++;
        }
      }
    }

    // return the number of sundays counted
    return Integer.toString(numSundays);
  }

  // return the number of days in a given month
  private int getMonthLength(int month, int year) {
    switch(month) {
      // months Jan, March, May, July, August, October, December
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        return 31;
      // Months April, June, September, November
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      // February
      case 2:
        // if the current year is a leap year Feb is 29 days long
        if ((year % 4 == 0) && !(year % 100 == 0)){
          return 29;
        }
        // if not a leap year return 28 days
        return 28;
      default:
        throw new IllegalArgumentException("Enter a valid month between 1 and 12");

    }
  }

  // calculates the day of the week
  // takes a current day of the week and the number of days ahead in the future
  private int daysPassed(int dayOfTheWeek, int daysPassed) {
    dayOfTheWeek += (daysPassed % 7);

    if (dayOfTheWeek >= 7 ) {
      dayOfTheWeek %= 7;
    }

    return dayOfTheWeek;
  }
}
