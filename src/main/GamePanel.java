package main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import state.StateManager;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener, Runnable {
  public static final int WIDTH = 1440;
  public static final int HEIGHT = 800;

  private static boolean repaint;
  private boolean running;
  private int FPS = 60;
  private long targetTime = 1000 / FPS;
  private Thread thread;
  private BufferedImage image;
  private Graphics2D graphics2d;
  private StateManager stateManager;

  public GamePanel() {
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
  }

  public void addNotify() {
    super.addNotify();
    if (thread == null) {
      thread = new Thread(this);
      addMouseListener(this);
      addMouseMotionListener(this);
      thread.start();
    }
  }

  private void init() {
    running = true;
    image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    graphics2d = (Graphics2D) image.getGraphics();
    stateManager = new StateManager();
  }

  @Override
  public void run() {
    init();

    long start;
    long elapsed;
    long wait;

    while (running) {
      start = System.nanoTime();

      update();
      draw();
      drawToScreen();

      elapsed = System.nanoTime() - start;
      wait = targetTime - elapsed / 1000000;

      if (wait < 0) {
        wait = 5;
      }

      try {
        Thread.sleep(wait);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private void update() {
    stateManager.update();
  }

  private void draw() {
    stateManager.draw(graphics2d);
  }

  private void drawToScreen() {
    Graphics2D graphics2d = (Graphics2D) getGraphics();
    graphics2d.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
    graphics2d.dispose();
  }

  public static boolean getRepaint() {
    return repaint;
  }

  public static void setRepaint(boolean r) {
    repaint = r;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    stateManager.mouseClicked(e);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    stateManager.mousePressed(e);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    stateManager.mouseReleased(e);
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    stateManager.mouseEntered(e);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    stateManager.mouseExited(e);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    stateManager.mouseMoved(e);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    stateManager.mouseDragged(e);
  }
}
