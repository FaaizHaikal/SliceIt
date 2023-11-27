package state;

public abstract class State {
  protected StateManager stateManager;

  public abstract void init();
  public abstract void update();
  public abstract void draw(java.awt.Graphics2D g);
  public abstract void mouseClicked(java.awt.event.MouseEvent e);
  public abstract void mousePressed(java.awt.event.MouseEvent e);
  public abstract void mouseReleased(java.awt.event.MouseEvent e);
  public abstract void mouseEntered(java.awt.event.MouseEvent e);
  public abstract void mouseExited(java.awt.event.MouseEvent e);
  public abstract void mouseMoved(java.awt.event.MouseEvent e);
  public abstract void mouseDragged(java.awt.event.MouseEvent e);
}
