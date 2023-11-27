package state;

import main.GamePanel;
public class StateManager {
  private int currState;
  private State[] states;

  public static final int STATES = 3;
  public static final int MENU_STATE = 0;
  public static final int GAME_PLAY_STATE = 1;
  public static final int GAME_OVER_STATE = 2;

  public StateManager() {
    currState = GAME_OVER_STATE;
    states = new State[STATES];
    loadState(currState);
  }

  public void loadState(int state) {
    switch (state) {
      case MENU_STATE:
        states[MENU_STATE] = new MenuState(this);
        break;
      // case GAME_PLAY_STATE:
      //   states[GAME_PLAY_STATE] = new GamePlayState(this);
      //   break;
      case GAME_OVER_STATE:
        states[GAME_OVER_STATE] = new GameOverState(this);
        break;
      default:
        System.out.println("Invalid state");
        System.exit(1);
        break;
    }
  }

  public void unloadState(int state) {
    states[state] = null;
  }

  public void setState(int state) {
    GamePanel.setRepaint(true);
    unloadState(currState);
    currState = state;
    loadState(currState);
  }

  public void update() {
    try {
      states[currState].update();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void draw(java.awt.Graphics2D g) {
    try {
      if (states[currState] != null) states[currState].draw(g);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void mouseClicked(java.awt.event.MouseEvent e) {
    try {
      states[currState].mouseClicked(e);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void mousePressed(java.awt.event.MouseEvent e) {
    try {
      states[currState].mousePressed(e);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void mouseReleased(java.awt.event.MouseEvent e) {
    try {
      states[currState].mouseReleased(e);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void mouseEntered(java.awt.event.MouseEvent e) {
    try {
      states[currState].mouseEntered(e);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void mouseExited(java.awt.event.MouseEvent e) {
    try {
      states[currState].mouseExited(e);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void mouseMoved(java.awt.event.MouseEvent e) {
    try {
      states[currState].mouseMoved(e);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void mouseDragged(java.awt.event.MouseEvent e) {
    try {
      states[currState].mouseDragged(e);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
