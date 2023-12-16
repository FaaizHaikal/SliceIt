package state;

import audio.Audio;
import main.GamePanel;
import utilities.Background;
import utilities.Counter;
import utilities.Text;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class GameOverState extends State {
  private Background background;
  private Audio gameOverAudio;
  private Font font;
  private String score;

  public GameOverState(StateManager stateManager) {
    this.stateManager = stateManager;

    try {
      background = new Background("/background/background.jpg");
      gameOverAudio = new Audio("/music/gameOver.wav");
      Font Gomo = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Gomo.ttf"));

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Gomo);

      font = Gomo.deriveFont(Font.PLAIN, 120);
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
    Text.horizontalCenteredText(g, "Game Over", GamePanel.WIDTH, 300, font, java.awt.Color.RED);
    Text.horizontalCenteredText(g, score, GamePanel.WIDTH, 450, font, java.awt.Color.GREEN);
    if (Counter.isNewHighScore()) {
      Text.horizontalCenteredText(g, "New High Score!", GamePanel.WIDTH, 600, font, java.awt.Color.YELLOW);
    }
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {
    gameOverAudio.stop();
    stateManager.setState(StateManager.MENU_STATE);
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
  }

  @Override
  public void mouseDragged(java.awt.event.MouseEvent e) {
  }
}
