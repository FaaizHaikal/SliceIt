package entitites;

public class Kiwi extends Element {
  private static final String KIWI = "/elements/fruits/kiwi.png";
  private static final String KIWI_SLICED_LEFT = "/elements/fruits/kiwi_sliced.png";
  private static final String KIWI_SLICED_RIGHT = "/elements/fruits/kiwi_sliced.png";
  private static final String KIWI_SPLASH = "/elements/fruits/splash3.png";

  public Kiwi() {
    super(KIWI, KIWI_SLICED_LEFT, KIWI_SLICED_RIGHT, KIWI_SPLASH);
  }
}
