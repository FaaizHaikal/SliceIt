package entitites;

public class Lemon extends Element {
  private static final String LEMON = "/elements/fruits/lemon.png";
  private static final String LEMON_SLICED_LEFT = "/elements/fruits/lemon_sliced.png";
  private static final String LEMON_SLICED_RIGHT = "/elements/fruits/lemon_sliced.png";
  private static final String LEMON_SPLASH = "/elements/fruits/splash2.png";

  public Lemon() {
    super(LEMON, LEMON_SLICED_LEFT, LEMON_SLICED_RIGHT, LEMON_SPLASH);
  }
}
