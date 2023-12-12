package state;

import entitites.Element;
import entitites.fruits.Apple;
import utilities.Background;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlayState extends State {
  private Background background;
  private List<Element> elements = new ArrayList<Element>();
  private Element element;
  private static Random random = new Random();
  private static final int BOMB = 0;
  private static final int APPLE = 1;
  private static final int KIWI = 2;
  private static final int LEMON = 3;
  private static final int ORANGE = 4;
  private static final int POM = 5;

  public GamePlayState(StateManager stateManager) {
    this.stateManager = stateManager;

    try {
      background = new Background("/background/background.jpg");
      element = new Apple();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void generateElement() {
    int maxElement = random.nextInt(6) + 1;

    for (int i=0; i<maxElement; i++) {
      int element = random.nextInt(6);

      switch (element) {
        case BOMB:
        case APPLE:
        case KIWI:
        case LEMON:
        case ORANGE:
        case POM:
          break;
      }
    }
  }

  @Override
  public void init() {}

  @Override
  public void update() {}

  @Override
  public void draw(java.awt.Graphics2D g) {
    reDraw(g);

    background.draw(g);
    element.draw(g);
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {}
  public void mousePressed(java.awt.event.MouseEvent e) {
    // element.slice();
  }
  public void mouseReleased(java.awt.event.MouseEvent e) {}
  public void mouseEntered(java.awt.event.MouseEvent e) {}
  public void mouseExited(java.awt.event.MouseEvent e) {}
  public void mouseMoved(java.awt.event.MouseEvent e) {}
  public void mouseDragged(java.awt.event.MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    
    // for (Element element : elements) {
      if (element.getX() - 50 < x && x < element.getX() + 50 && element.getY() - 50 < y && y < element.getY() + 50) {
        if (!element.getSliced()) element.slice();  
      }
    // }
  }
}
