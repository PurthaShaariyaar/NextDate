package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import src.NextDate;

public class NextDateTest {
  
  @Test 
  public void inputCaseOne() {
    assertEquals("02/01/1812", NextDate.getNextDate(1, 1, 1812)); 
  }

  @Test 
  public void inputCaseTwo() {
    String invalidDay = "abc";

    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
      NextDate.getNextDate(Integer.parseInt(invalidDay), 5, 2000);
    });
    assertEquals("For input string: \"abc\"", e.getMessage());
  }

  @Test 
  public void inputCaseThree() {
    assertEquals("29/02/2000", NextDate.getNextDate(28, 2, 2000));
  }

  @Test 
  public void inputCaseFour() {
    assertEquals("02/03/2023", NextDate.getNextDate(1, 3,2023));
  }

  @Test
  void testCaseFive() {
      IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
          NextDate.getNextDate(15, Integer.parseInt("13"), 2003);
      });
      assertEquals("Invalid month: 13. Month must be between 1 and 12.", e.getMessage());
  }

  @Test 
  public void inputCaseSix() {
    assertEquals("11/06/2008", NextDate.getNextDate(10, 6, 2008));
  }

  @Test
  void testCaseSeven() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
        NextDate.getNextDate(15, 3, 2213);
    });
    assertEquals("Invalid year: 2213. Year must be between 1812 and 2212.", e.getMessage());
  }

  @Test 
  void testCaseEight() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
        NextDate.getNextDate(Integer.parseInt("0"), 2, 2000);
    });
    assertEquals("Invalid day: 0. Day must be between 1 and 31.", e.getMessage());
  }  

  @Test
  void testCaseNine() {
    assertEquals("29/02/2000", NextDate.getNextDate(28, 2, 2000));
  }
}