package entitites;

public class Pom extends Element {
  private static final String POM = "/elements/fruits/pom.png";
  private static final String POM_SLICED_LEFT = "/elements/fruits/pom_sliced.png";
  private static final String POM_SLICED_RIGHT = "/elements/fruits/pom_sliced.png";
  private static final String POM_SPLASH = "/elements/fruits/splash1.png";

  public Pom() {
    super(POM, POM_SLICED_LEFT, POM_SLICED_RIGHT, POM_SPLASH);
  }
}
