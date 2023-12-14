package state;

import main.GamePanel;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class GameOverState extends State {
  private Font font;

  public GameOverState(StateManager stateManager) {
    this.stateManager = stateManager;

    try {
      Font Gomo = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Gomo.ttf"));

      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Gomo);

      font = Gomo.deriveFont(Font.PLAIN, 48);
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
    g.setFont(font);
    g.setColor(java.awt.Color.WHITE);
    g.drawString("Game Over", GamePanel.WIDTH / 2 - 96, GamePanel.HEIGHT / 2 - 24);
  }

  @Override
  public void mouseClicked(java.awt.event.MouseEvent e) {
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
