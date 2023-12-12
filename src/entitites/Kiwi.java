package entitites;

public class Kiwi extends Element {
  private static final String kiwi_path = "/elements/fruits/kiwi.png";
  private static final String kiwi_sliced_left_path = "/elements/fruits/kiwi_sliced.png";
  private static final String kiwi_sliced_right_path = "/elements/fruits/kiwi_sliced.png";

  public Kiwi() {
    super(kiwi_path, kiwi_sliced_left_path, kiwi_sliced_right_path);
  }
}
