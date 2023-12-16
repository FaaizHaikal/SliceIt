package state;

import audio.Audio;
import entitites.*;
import utilities.Background;
import utilities.Counter;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class GamePlayState extends State {
  private Font gameFont;
  private Background background;
  private Audio[] sliceFruitAudio = new Audio[3];
  private Counter score;
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
    this.score = new Counter();

    try {
      background = new Background("/background/background.jpg");
      elements = new ArrayList<Element>();
      sliceFruitAudio[0] = new Audio("/music/fruit1.wav");
      sliceFruitAudio[1] = new Audio("/music/fruit2.wav");
      sliceFruitAudio[2] = new Audio("/music/fruit3.wav");

      Font Gomo = Font.createFont(Font.TRUETYPE_FONT,
          new File(Objects.requireNonNull(getClass().getResource("/fonts/Gomo.ttf")).getPath()));

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Gomo);

      gameFont = Gomo.deriveFont(Font.PLAIN, 120);
      init();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void generateElement() {
    int maxElement = random.nextInt(3) + 1;

    for (int i = 0; i < maxElement; i++) {
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

  private void drawScore(java.awt.Graphics2D g) {
    g.setColor(java.awt.Color.ORANGE);
    g.setFont(gameFont);
    g.drawString(""+score.getCountSliced(), 20, 100);
  }
  @Override
  public void init() {
    score.reset();
    elements.clear();
  }

  @Override
  public void update() {
    for (int i=0; i<elements.size(); i++) {
      if (elements.get(i).isFall()) {
        if (!elements.get(i).isSliced() && !elements.get(i).isBomb()) {
          score.updateFallen();
          if (score.getCountFallen() >= 3) {
            for (int j=0; j<3; j++) sliceFruitAudio[j].stop();
            System.out.println("Sliced: " + score.getCountSliced());
            System.out.println("Fallen: " + score.getCountFallen());
            stateManager.setState(StateManager.GAME_OVER_STATE);
          }
        }
        elements.remove(i);
      }
    }
  }

  @Override
  public void draw(java.awt.Graphics2D g) {
    reDraw(g);

    background.draw(g);
    drawScore(g);
    generateElement();
    for (int i = 0; i < elements.size(); i++) {
      elements.get(i).draw(g);
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

    for (int i = 0; i < elements.size(); i++) {
      Element element = elements.get(i);
      if (element.getX() - 50 < x && x < element.getX() + 50 && element.getY() - 50 < y && y < element.getY() + 50) {
        if (element.isBomb()) {
          for (int j=0; j<3; j++) sliceFruitAudio[j].stop();
          System.out.println("Sliced: " + score.getCountSliced());
          System.out.println("Fallen: " + score.getCountFallen());
          stateManager.setState(StateManager.GAME_OVER_STATE);
        } else if (!element.isSliced()) {
          int randomAudio = random.nextInt(3);
          sliceFruitAudio[randomAudio].play();
          element.slice();
          score.updateSliced();
        }
      }
    }
  }
}
