package state;

import main.GamePanel;

import java.awt.Font;

public class MenuState extends State {
  private Font font;
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
      font = new Font("Arial", Font.PLAIN, 48); // TODO: Change font
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
    g.setFont(font);
    
    for (int i = 0; i < options.length; i++) {
      if (optionHover[i]) {
        g.setColor(java.awt.Color.RED);
      } else {
        g.setColor(java.awt.Color.WHITE);
      }

      g.drawString(
        options[i],
        optionCoords[i][0],
        optionCoords[i][1]
      );
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
