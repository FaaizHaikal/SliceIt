package utilities;

public class Counter {
  protected static int countSliced;

  public Counter() {
    reset();
  }

  public static void reset() {
    countSliced = 0;
  }

  public static void updateSliced() {
    countSliced++;
  }

  public static int getCountSliced() {
    return countSliced;
  }
}
