package entitites;

import main.GamePanel;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.util.Objects;
import java.util.Random;

import javax.imageio.ImageIO;

public class Element {
  private static final double GRAVITY = 0.1;
  private static final double INITIAL_VELOCITY = 10.0;
  private BufferedImage element;
  private BufferedImage slicedElementLeft;
  private BufferedImage slicedElementRight;
  private double x;
  private double y;
  private double slicedElementLeftX;
  private double slicedElementRightX;
  private double slicedElementFallSpeed;
  private double xSpeed;
  private double ySpeed;
  private double angle;
  private boolean isSliced;
  private boolean isBomb;
  private boolean isFall;

  public Element(String elementPath, String slicedElementLeftPath, String slicedElementRightPath) {
    try {
      element = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(elementPath)));
      slicedElementLeft = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(slicedElementLeftPath)));
      slicedElementRight = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(slicedElementRightPath)));
      isSliced = false;
      isBomb = false;
      init();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Element(String elementPath) {
    try {
      element = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(elementPath)));
      isBomb = true;
      init();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void throwElement() {
    if (ySpeed == 0) {
      ySpeed += GRAVITY;
      y += ySpeed;
    } else {
      ySpeed -= GRAVITY;
      y -= ySpeed;
    }

    x += xSpeed;
    if (x >= GamePanel.WIDTH || y >= GamePanel.HEIGHT || x <= 0 || y <= 0) init();
  }

  public void fallElement() {
    if (y > GamePanel.HEIGHT) {
      isFall = true;
      return;
    }
    slicedElementFallSpeed += GRAVITY;
    y += slicedElementFallSpeed;
  }

  public boolean trajectoryIsValid(boolean isLeft) {
    double xMax = INITIAL_VELOCITY * INITIAL_VELOCITY * Math.sin(angle * 2) / GRAVITY;
    if (isLeft) xMax *= -1;

    return x + xMax <= GamePanel.WIDTH - 200 && x + xMax >= 200;
  }

  private void init() {
    Random random = new Random();
    x = random.nextInt((1200 - 200) + 1) + 200;
    y = GamePanel.HEIGHT;
    angle = Math.toRadians(random.nextDouble() * 30 + 60);
    xSpeed = INITIAL_VELOCITY * Math.cos(angle);
    if (x > GamePanel.WIDTH / 2) xSpeed *= -1;
    ySpeed = INITIAL_VELOCITY * Math.sin(angle);

    if (!trajectoryIsValid(xSpeed < 0))
      init();
  }

  private void initSlicedElement() {
    slicedElementLeftX = x - 50;
    slicedElementRightX = x + 50;
    y -= 50;
    slicedElementFallSpeed = 0;
  }

  public void slice() {
    isSliced = true;
    initSlicedElement();
  }

  public void draw(Graphics2D g) {
    if (isSliced) {
      fallElement();
      g.drawImage(slicedElementLeft, (int) slicedElementLeftX, (int) y, null);
      g.drawImage(slicedElementRight, (int) slicedElementRightX, (int) y, null);
      return;
    }

    throwElement();
    if (y >= GamePanel.HEIGHT) {
      isFall = true;
    }
    g.drawImage(element, (int) x, (int) y, null);
  }

  public int getX() {
    return (int) x;
  }

  public int getY() {
    return (int) y;
  }

  public boolean isSliced() {
    return isSliced;
  }

  public boolean isBomb() {
    return isBomb;
  }

  public boolean isFall() {
    return isFall;
  }
}
