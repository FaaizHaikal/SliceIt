package state;

import main.GamePanel;
import utilities.Text;
import utilities.Background;
import audio.Audio;

import java.awt.Font;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.Objects;

public class MenuState extends State {
  private Background background;
  private Audio menuAudio;
  private Font titleFont;
  private Font titleShadowFont;
  private Font menuFont;
  private int currentChoice = -1;
  private String[] options = { "Play", "Quit" };

  private int[][] optionCoords = { { 1024, 558 }, { 1024, 658 } };

  private boolean[] optionHover = { false, false };

  public MenuState(StateManager stateManager) {
    this.stateManager = stateManager;

    try {
      background = new Background("/background/menu_background.png");
      menuAudio = new Audio("/music/mainTheme.wav");

      Font Gomo = Font.createFont(Font.TRUETYPE_FONT,
          new File(Objects.requireNonNull(getClass().getResource("/fonts/Gomo.ttf")).getPath()));
      Font ChangChang = Font.createFont(Font.TRUETYPE_FONT,
          new File(Objects.requireNonNull(getClass().getResource("/fonts/ChangChang.ttf")).getPath()));

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Gomo);
      ge.registerFont(ChangChang);

      menuFont = Gomo.deriveFont(Font.PLAIN, 60);
      titleFont = ChangChang.deriveFont(Font.PLAIN, 96);
      titleShadowFont = ChangChang.deriveFont(Font.PLAIN, 100);

      menuAudio.play();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void init() {
  }

  @Override
  public void update() {
  }

  @Override
  public void draw(java.awt.Graphics2D g) {
    reDraw(g);

    background.draw(g);
    Text.horizontalCenteredText(g, "Slice It!", GamePanel.WIDTH, GamePanel.HEIGHT / 2 - 100, titleShadowFont,
        Color.BLACK);
    Text.horizontalCenteredText(g, "Slice It!", GamePanel.WIDTH, GamePanel.HEIGHT / 2 - 96, titleFont, Color.WHITE);

    g.setFont(menuFont);

    for (int i = 0; i < options.length; i++) {
      if (optionHover[i]) {
        g.setColor(Color.RED);
      } else {
        g.setColor(Color.WHITE);
      }

      Text.draw(g, options[i], optionCoords[i][0], optionCoords[i][1], menuFont, g.getColor());
    }
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    if (x >= optionCoords[0][0] && x <= optionCoords[0][0] + 96 && y >= optionCoords[0][1] - 48
        && y <= optionCoords[0][1]) {
      currentChoice = 0;
    } else if (x >= optionCoords[1][0] && x <= optionCoords[1][0] + 96 && y >= optionCoords[1][1] - 48
        && y <= optionCoords[1][1]) {
      currentChoice = 1;
    }

    if (currentChoice == 0) {
      menuAudio.stop();
      stateManager.setState(StateManager.GAME_PLAY_STATE);
    } else if (currentChoice == 1) {
      System.exit(0);
    }
  }

  @Override
  public void mousePressed(java.awt.event.MouseEvent e) {
  }

  @Override
  public void mouseReleased(java.awt.event.MouseEvent e) {
  }

  @Override
  public void mouseEntered(java.awt.event.MouseEvent e) {
  }

  @Override
  public void mouseExited(java.awt.event.MouseEvent e) {
  }

  @Override
  public void mouseMoved(java.awt.event.MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    for (int i = 0; i < options.length; i++) {
      if (x >= optionCoords[i][0] && x <= optionCoords[i][0] + 120 && y >= optionCoords[i][1] - 48
          && y <= optionCoords[i][1]) {
        currentChoice = i;
        optionHover[i] = true;
      } else {
        optionHover[i] = false;
      }
    }
  }

  @Override
  public void mouseDragged(java.awt.event.MouseEvent e) {
  }
}
