package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Counter {
  private static int countSliced;
  private static int highScore;
  private static boolean newHighScore;
  private static final String DATA = "data.txt";

  public Counter() {
    reset();
  }

  public static void reset() {
    countSliced = 0;
    highScore = loadHighScore();
    newHighScore = false;
  }

  public static void updateSliced() {
    countSliced++;
  }

  public static int getCountSliced() {
    return countSliced;
  }

  private static String encodeHighScore(int score) {
    return java.util.Base64.getEncoder().encodeToString(String.valueOf(score).getBytes());
  }

  private static int decodeHighScore(String encodedScore) {
    try {
      byte[] decodedBytes = java.util.Base64.getDecoder().decode(encodedScore);
      String decodedString = new String(decodedBytes);
      return Integer.parseInt(decodedString);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return 0;
    }
  }

  public static void saveHighScore() {
    try (PrintWriter writer = new PrintWriter(DATA)) {
      String encodedScore = encodeHighScore(highScore);
      writer.print(encodedScore);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int loadHighScore() {
    try (BufferedReader reader = new BufferedReader(new FileReader(DATA))) {
      String encodedScore = reader.readLine();
      if (encodedScore != null) {
        return decodeHighScore(encodedScore);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public static int getHighScore() {
    return highScore;
  }

  public static void setHighScore(int score) {
    newHighScore = true;
    highScore = score;
  }

  public static boolean isNewHighScore() {
    return newHighScore;
  }

}
