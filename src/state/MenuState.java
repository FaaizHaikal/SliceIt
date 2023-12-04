package state;

import main.GamePanel;
import utilities.Text;

import java.awt.Font;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.Objects;

public class MenuState extends State {
  private Font titleFont;
  private Font menuFont;
  private int currentChoice = -1;
  private String[] options = {
    "Play",
    "Quit"
  };

  //TODO: Change optionCoords to be dynamic
  private int[][] optionCoords = {
    {
      GamePanel.WIDTH / 2 - 48,
      GamePanel.HEIGHT / 2 - 24
    },
    {
      GamePanel.WIDTH / 2 - 48,
      GamePanel.HEIGHT / 2 + 48
    }
  };
  private boolean[] optionHover = {
    false,
    false
  };

  public MenuState(StateManager stateManager) {
    this.stateManager = stateManager;

    try {
      Font Gomo = Font.createFont(Font.TRUETYPE_FONT, new File(Objects.requireNonNull(getClass().getResource("/fonts/Gomo.ttf")).getPath()));
      Font ChangChang = Font.createFont(Font.TRUETYPE_FONT, new File(Objects.requireNonNull(getClass().getResource("/fonts/ChangChang.ttf")).getPath()));

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Gomo);
      ge.registerFont(ChangChang);

      menuFont = Gomo.deriveFont(Font.PLAIN, 48);
      titleFont = ChangChang.deriveFont(Font.PLAIN, 96);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void init() {}

  @Override
  public void update() {}

  @Override
  public void draw(java.awt.Graphics2D g) {
    reDraw(g);

    Text.horizontalCenteredText(g, "Slice It!", GamePanel.WIDTH, GamePanel.HEIGHT / 2 - 96, titleFont, Color.WHITE);

    g.setFont(menuFont);

    for (int i = 0; i < options.length; i++) {
      if (optionHover[i]) {
        g.setColor(Color.RED);
      } else {
        g.setColor(Color.WHITE);
      }

      Text.horizontalCenteredText(g, options[i], GamePanel.WIDTH, optionCoords[i][1], menuFont, g.getColor());
    }
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    if (x >= optionCoords[0][0] && x <= optionCoords[0][0] + 96 &&
        y >= optionCoords[0][1] - 48 && y <= optionCoords[0][1]) {
      currentChoice = 0;
    } else if (x >= optionCoords[1][0] && x <= optionCoords[1][0] + 96 &&
               y >= optionCoords[1][1] - 48 && y <= optionCoords[1][1]) {
      currentChoice = 1;
    }

    if (currentChoice == 0) {
      // stateManager.loadState(StateManager.GAME_PLAY_STATE);
      System.out.println("Play");
    } else if (currentChoice == 1) {
      System.out.println("Quit");
    }
  }

  @Override
  public void mousePressed(java.awt.event.MouseEvent e) {}

  @Override
  public void mouseReleased(java.awt.event.MouseEvent e) {}

  @Override
  public void mouseEntered(java.awt.event.MouseEvent e) {}

  @Override
  public void mouseExited(java.awt.event.MouseEvent e) {}

  @Override
  public void mouseMoved(java.awt.event.MouseEvent e) {
    int x = e.getX();
    int y = e.getY();

    for (int i = 0; i < options.length; i++) {
        if (x >= optionCoords[i][0] && x <= optionCoords[i][0] + 96 &&
                y >= optionCoords[i][1] - 48 && y <= optionCoords[i][1]) {
            currentChoice = i;
            optionHover[i] = true;
        } else {
            optionHover[i] = false;
        }
    }
  }

  @Override
  public void mouseDragged(java.awt.event.MouseEvent e) {}
}
