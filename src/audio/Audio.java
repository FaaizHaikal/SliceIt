package audio;

import java.util.Objects;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
  private Clip clip;

  public Audio(String path) {
    try {
      AudioInputStream audioInputStream = AudioSystem
          .getAudioInputStream(Objects.requireNonNull(getClass().getResourceAsStream(path)));
      AudioFormat baseFormat = audioInputStream.getFormat();
      AudioFormat decodeFormat = new AudioFormat(
          AudioFormat.Encoding.PCM_SIGNED,
          baseFormat.getSampleRate(),
          16,
          baseFormat.getChannels(),
          baseFormat.getChannels() * 2,
          baseFormat.getSampleRate(),
          false);
      AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(decodeFormat, audioInputStream);
      clip = AudioSystem.getClip();
      clip.open(audioInputStream2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void play() {
    if (clip != null) {
      stop();
      clip.setFramePosition(0);
      clip.start();
    }
  }

  public void stop() {
    if (clip.isRunning())
      clip.stop();
  }

  public void close() {
    stop();
    clip.close();
  }
}
