package entitites;

public class Pom extends Element {
  private static final String pom_path = "/elements/fruits/pom.png";
  private static final String pom_sliced_left_path = "/elements/fruits/pom_sliced.png";
  private static final String pom_sliced_right_path = "/elements/fruits/pom_sliced.png";

  public Pom() {
    super(pom_path, pom_sliced_left_path, pom_sliced_right_path);
  }
}
