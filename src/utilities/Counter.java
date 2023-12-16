package utilities;

public class Counter {
  protected static int countSliced;
  protected static int countFallen;

  public Counter() {
    reset();
  }

  public static void reset() {
    countSliced = 0;
    countFallen = 0;
  }

  public static void updateSliced() {
    countSliced++;
  }

  public static int getCountSliced() {
    return countSliced;
  }

  public static void updateFallen() {
    countFallen++;
  }

  public static int getCountFallen() {
    return countFallen;
  }
}
