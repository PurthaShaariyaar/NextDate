package src;

public class NextDate {
  
  public static String getNextDate(int day, int month, int year) throws IllegalArgumentException {
    
    // Check user input correct boundary domains
    if (year < 1812 || year > 2212) {
      throw new IllegalArgumentException("Invalid year: " + year + ". Year must be between 1812 and 2212.");
    }

    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("Invalid month: " + month + ". Month must be between 1 and 12.");
    }

    if (day < 1 || day > 31) {
      throw new IllegalArgumentException("Invalid day: " + day + ". Day must be between 1 and 31.");
    }

    // Assign total days initially to equal 31 
    int totalDays = 31; 

    if (month == 2) {
      // For February first check if year is a leap year, if so set total days to 29, otherwise 28.
      if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        totalDays = 29; 
      }
      else {
        totalDays = 28; 
      }
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      totalDays = 30;
    }

    // Increment day to next day
    day++; 

    // If the incremented day is greater than the total days, set day to equal 1 and increment month by 1. 
    if (day > totalDays) {
      day = 1; 
      month++; 
      // If the incremented is greater than 12, set it to 1 and increment year by 1.
      if (month > 12) {
        month = 1; 
        year++; 
      }
    }
    return String.format("%02d/%02d/%04d", day, month, year); 
  }
}
