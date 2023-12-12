package entitites;

public class Orange extends Element {
  private static final String orange_path = "/elements/fruits/orange.png";
  private static final String orange_sliced_left_path = "/elements/fruits/orange_sliced.png";
  private static final String orange_sliced_right_path = "/elements/fruits/orange_sliced.png";

  public Orange() {
    super(orange_path, orange_sliced_left_path, orange_sliced_right_path);
  }
}
