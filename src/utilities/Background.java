package utilities;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Background {
  private BufferedImage image;
  private double x;
  private double y;

  public Background(String str) {
      try {
          image = ImageIO.read(
              Objects.requireNonNull(getClass().getResourceAsStream(str))
          );
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  public void setPosition(double x, double y) {
      this.x = x % GamePanel.WIDTH;
      this.y = y % GamePanel.HEIGHT;
  }

  public void draw(Graphics2D g) {
      g.drawImage(image, (int)x, (int)y, null);

      if (x < 0) g.drawImage(image, (int)x + GamePanel.WIDTH, (int)y, null);
      if (x > 0) g.drawImage(image, (int)x - GamePanel.WIDTH, (int)y, null);
  }
}
