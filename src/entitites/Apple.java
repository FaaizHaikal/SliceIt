package entitites;

public class Apple extends Element {
  private static final String APPLE = "/elements/fruits/apple.png";
  private static final String APPLE_SLICED_LEFT = "/elements/fruits/apple_sliced.png";
  private static final String APPLE_SLICED_RIGHT = "/elements/fruits/apple_sliced.png";
  private static final String APPLE_SPLASH = "/elements/fruits/splash4.png";

  public Apple() {
    super(APPLE, APPLE_SLICED_LEFT, APPLE_SLICED_RIGHT, APPLE_SPLASH);
  }
}
