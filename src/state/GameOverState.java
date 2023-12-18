package state;

import audio.Audio;
import main.GamePanel;
import utilities.Background;
import utilities.Counter;
import utilities.Text;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.Objects;

import javax.imageio.ImageIO;

public class GameOverState extends State {
  private Background background;
  private BufferedImage button;
  private Audio gameOverAudio;
  private Font gameOverFont;
  private Font scoreFont;
  private Font highScoreFont;
  private Font buttonFont;
  private String score;
  private int currentChoice = -1;

  private String[] options = { "Back", "Play Again" };

  private int[][] optionCoords = { { 530, 605 }, { 775, 605 } };

  private boolean[] optionHover = { false, false };

  public GameOverState(StateManager stateManager) {
    this.stateManager = stateManager;

    try {
      background = new Background("/background/background.jpg");
      button = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/elements/button.png")));
      gameOverAudio = new Audio("/music/gameOver.wav");
      Font Gomo = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Gomo.ttf"));

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Gomo);

      gameOverFont = Gomo.deriveFont(Font.PLAIN, 120);
      scoreFont = Gomo.deriveFont(Font.PLAIN, 90);
      highScoreFont = Gomo.deriveFont(Font.PLAIN, 60);
      buttonFont = Gomo.deriveFont(Font.PLAIN, 40);

      score = Counter.getCountSliced() + " fruit";
      gameOverAudio.play();
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
    Text.horizontalCenteredText(g, "Game Over", GamePanel.WIDTH, 250, gameOverFont, java.awt.Color.RED);
    Text.horizontalCenteredText(g, score, GamePanel.WIDTH, 400, scoreFont, java.awt.Color.GREEN);
    if (Counter.isNewHighScore()) {
      Text.horizontalCenteredText(g, "New High Score!", GamePanel.WIDTH, 500, highScoreFont, java.awt.Color.YELLOW);
    } else {
      Text.horizontalCenteredText(g, "High Score " + Counter.getHighScore(), GamePanel.WIDTH, 500, highScoreFont,
          java.awt.Color.YELLOW);
    }

    g.drawImage(button, 450, 550, null);
    g.drawImage(button, 750, 550, null);

    for (int i = 0; i < options.length; i++) {
      if (optionHover[i]) {
        g.setColor(java.awt.Color.RED);
      } else {
        g.setColor(java.awt.Color.WHITE);
      }

      Text.draw(g, options[i], optionCoords[i][0], optionCoords[i][1], buttonFont, g.getColor());
    }
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {
    gameOverAudio.stop();
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
      stateManager.setState(StateManager.MENU_STATE);
    } else if (currentChoice == 1) {
      stateManager.setState(StateManager.GAME_PLAY_STATE);
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
