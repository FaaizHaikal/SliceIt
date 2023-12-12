package entitites;

public class Lemon extends Element {
  private static final String lemon_path = "/elements/fruits/lemon.png";
  private static final String lemon_sliced_left_path = "/elements/fruits/lemon_sliced.png";
  private static final String lemon_sliced_right_path = "/elements/fruits/lemon_sliced.png";

  public Lemon() {
    super(lemon_path, lemon_sliced_left_path, lemon_sliced_right_path);
  }
}
