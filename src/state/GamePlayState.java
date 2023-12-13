package state;

import entitites.*;
import utilities.Background;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlayState extends State {
  private Background background;
  private static List<Element> elements;
  private static Random random = new Random();
  private static final int APPLE = 0;
  private static final int KIWI = 1;
  private static final int LEMON = 2;
  private static final int ORANGE = 3;
  private static final int POM = 4;
  private static final int MAX_ELEMENT = 4;

  public GamePlayState(StateManager stateManager) {
    this.stateManager = stateManager;

    try {
      background = new Background("/background/background.jpg");
      elements = new ArrayList<Element>();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void generateElement() {
    int maxElement = random.nextInt(3) + 1;

    for (int i=0; i<maxElement; i++) {
      if (elements.size() >= MAX_ELEMENT) break;
      int element = random.nextInt(6);

      switch (element) {
        case APPLE:
          elements.add(new Apple());
          break;
        case KIWI:
          elements.add(new Kiwi());
          break;
        case LEMON:
          elements.add(new Lemon());
          break;
        case ORANGE:
          elements.add(new Orange());
          break;
        case POM:
          elements.add(new Pom());
          break;
        default:
          elements.add(new Bomb());
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
    generateElement();
    for (int i=0; i<elements.size();i++) {
      if (elements.get(i).isFall()) {
        elements.remove(i);
      } else {
        elements.get(i).draw(g);
      }
    }
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {}
  public void mousePressed(java.awt.event.MouseEvent e) {}
  public void mouseReleased(java.awt.event.MouseEvent e) {}
  public void mouseEntered(java.awt.event.MouseEvent e) {}
  public void mouseExited(java.awt.event.MouseEvent e) {}
  public void mouseMoved(java.awt.event.MouseEvent e) {}
  public void mouseDragged(java.awt.event.MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    for (int i=0; i<elements.size(); i++){
      Element element = elements.get(i);
      if (element.getX() - 50 < x  && x < element.getX() + 50 && element.getY() - 50 < y && y < element.getY() + 50) {
        if (element.isBomb()) {
          stateManager.setState(StateManager.GAME_OVER_STATE);
        } else if (!element.isSliced()) {
          element.slice();
        }
      }
    }
  }
}
