import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
  public Clip audioClip;
  public boolean isPlaying = false;

  public void loadAudio(String filePath) {
    // Exibe o caminho do arquivo de áudio no console
    System.out.println("loadAudio: " + filePath);
    try {
      // Carrega o arquivo de áudio
      File audioFile = new File(filePath);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

      // Configura o Clip
      AudioFormat format = audioStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      audioClip = (Clip) AudioSystem.getLine(info);

      // Abre o áudio
      audioClip.open(audioStream);
    } catch (UnsupportedAudioFileException e) {
      // Exibe mensagem de erro se o formato do arquivo não for suportado
      System.out.println("O formato do arquivo de áudio não é suportado.");
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      // Exibe mensagem de erro se a linha de áudio não estiver disponível
      System.out.println("A linha de áudio não está disponível.");
      e.printStackTrace();
    } catch (IOException e) {
      // Exibe mensagem de erro se houver problema ao ler o arquivo
      System.out.println("Erro ao ler o arquivo de áudio.");
      e.printStackTrace();
    }
  }

  public void playAudio() {
    // Exibe mensagem no console
    System.out.println("playAudio");
    // Verifica se o áudio não está tocando
    if (audioClip != null && !isPlaying) {
      // Reinicia o áudio do começo
      audioClip.setFramePosition(0);
      // Exibe mensagem no console
      System.out.println("playAudio start");
      // Inicia o áudio
      audioClip.start();
      // Atualiza o estado para tocando
      isPlaying = true;
    }
  }

  public void stopAudio() {
    // Exibe mensagem no console
    System.out.println("stopAudio");
    // Verifica se o áudio está tocando
    if (audioClip != null && isPlaying) {
      // Exibe mensagem no console
      System.out.println("stopAudio stop");
      // Para o áudio
      audioClip.stop();
      // Atualiza o estado para não tocando
      isPlaying = false;
    }
  }

public void nextAudio() {
    // Método não implementado
    throw new UnsupportedOperationException("Unimplemented method 'nextAudio'");
}
}
