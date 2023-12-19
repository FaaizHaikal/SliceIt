package utilities;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;

public class Text {
  public static void centeredText(Graphics2D g, String text, int width, int height, Font font, Color color) {
    g.setFont(font);
    g.setColor(color);

    int textWidth = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
    int textHeight = (int) g.getFontMetrics().getStringBounds(text, g).getHeight();

    int horizontalCenter = width / 2 - textWidth / 2;
    int verticalCenter = height / 2 - textHeight / 2;

    g.drawString(text, horizontalCenter, verticalCenter);
  }

  public static void horizontalCenteredText(Graphics2D g, String text, int width, int y, Font font, Color color) {
    g.setFont(font);
    g.setColor(color);

    int textWidht = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
    int horizontalCenter = width / 2 - textWidht / 2;

    g.drawString(text, horizontalCenter, y);
  }

  public static void verticalCenteredText(Graphics2D g, String text, int x, int height, Font font, Color color) {
    g.setFont(font);
    g.setColor(color);

    int textHeight = (int) g.getFontMetrics().getStringBounds(text, g).getHeight();
    int verticalCenter = height / 2 - textHeight / 2;

    g.drawString(text, x, verticalCenter);
  }

  public static void draw(Graphics2D g, String text, int x, int y, Font font, Color color) {
    g.setFont(font);
    g.setColor(color);

    g.drawString(text, x, y);
  }
}
