package entitites.fruits;

import entitites.Element;

public class Apple extends Element {
  private static final String apple_path = "/elements/fruits/apple.png";
  private static final String apple_sliced_left_path = "/elements/fruits/apple_sliced.png";
  private static final String apple_sliced_right_path = "/elements/fruits/apple_sliced.png";

  public Apple() {
    super(apple_path, apple_sliced_left_path, apple_sliced_right_path);
  }
}
