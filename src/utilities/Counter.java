package utilities;

public class Counter {
  protected int countSliced;
  protected int countFallen;

  public Counter() {
    countSliced = 0;
    countFallen = 0;
  }

  public void reset() {
    countSliced = 0;
    countFallen = 0;
  }

  public void updateSliced() {
    countSliced++;
  }

  public int getCountSliced() {
    return countSliced;
  }

  public void updateFallen() {
    countFallen++;
  }

  public int getCountFallen() {
    return countFallen;
  }
}
