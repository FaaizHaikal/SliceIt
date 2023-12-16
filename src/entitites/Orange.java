package entitites;

public class Orange extends Element {
  private static final String ORANGE = "/elements/fruits/orange.png";
  private static final String ORANGE_SLICED_LEFT = "/elements/fruits/orange_sliced.png";
  private static final String ORANGE_SLICED_RIGHT = "/elements/fruits/orange_sliced.png";
  private static final String ORANGE_SPLASH = "/elements/fruits/splash2.png";

  public Orange() {
    super(ORANGE, ORANGE_SLICED_LEFT, ORANGE_SLICED_RIGHT, ORANGE_SPLASH);
  }
}
