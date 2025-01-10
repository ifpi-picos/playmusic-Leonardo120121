
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import dominio.Album;
import dominio.Artista;
import dominio.Musica;

public class App {
    public static void main(String[] args) throws Exception {

        // Cria uma nova instância de Musica
        Musica musica1 = new Musica();

        // Define o nome da música
        musica1.setNome("Diga sim pra mim");
        // Define a duração da música em segundos
        musica1.setDuracao(215);
        // Define o caminho do arquivo de áudio
        musica1.setArquivoAudio("./src/assets/Digasimpramim.wav");
        // Define o gênero da música
        musica1.setGenero("Forro");

        // Cria uma nova instância de Musica
        Musica musica2 = new Musica();
        // Define o nome da música
        musica2.setNome("Beijos blues e poesia");
        // Define a duração da música em segundos
        musica2.setDuracao(198);
        // Define o caminho do arquivo de áudio
        musica2.setArquivoAudio("./src/assets/Beijosbluesepoesia.wav");
        // Define o gênero da música
        musica2.setGenero("Forro");

        // Cria uma nova instância de Album
        Album album1 = new Album();
        // Define o nome do álbum
        album1.setNome("Primeiro album");
        // Define o ano do álbum
        album1.setAno(2024);
        // Adiciona as músicas ao álbum
        album1.addMusica(musica1);
        album1.addMusica(musica2);

        // Cria uma nova instância de Artista
        Artista redHot = new Artista();
        // Define o nome do artista
        redHot.setNome("Seu Desejo");
        // Adiciona o álbum ao artista
        redHot.addAlbum(album1);

        // Exibe uma mensagem no console
        System.out.println("Abrindo o PlayMusic");
        // Obtém o caminho do arquivo de áudio da primeira música do primeiro álbum do artista
        redHot.getAlbuns().get(0).getMusicas().get(0).getArquivoAudio();

        // Cria uma nova instância de AudioPlayer
        AudioPlayer player = new AudioPlayer();
        // Carrega o áudio da primeira música ao iniciar
        player.loadAudio(redHot.getAlbuns().get(0).getMusicas().get(0).getArquivoAudio());

        // Cria os botões Play/Stop e Next e configura suas ações
        JButton playStopButton = new JButton("Play");
        JButton nextButton = new JButton("Next");

        // Lista de músicas e índice atual
        List<Musica> musicas = redHot.getAlbuns().get(0).getMusicas();
        int[] musicaAtual = {0};

        // Inicializa o player com a primeira música
        player.loadAudio(musicas.get(musicaAtual[0]).getArquivoAudio());

        // Configura ação do botão Play/Stop
        playStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!player.isPlaying) {
                    // Toca o áudio se não estiver tocando
                    player.playAudio();
                    playStopButton.setText("Stop");
                } else {
                    // Para o áudio se estiver tocando
                    player.stopAudio();
                    playStopButton.setText("Play");
                }
            }
        });

        // Configura ação do botão Next
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Para a música atual
                player.stopAudio();
                // Avança para a próxima música
                musicaAtual[0] = (musicaAtual[0] + 1) % musicas.size();
                // Carrega a nova música
                player.loadAudio(musicas.get(musicaAtual[0]).getArquivoAudio());
                // Exibe uma mensagem informando a música que está tocando
                JOptionPane.showMessageDialog(
                    null,
                    "Tocando: " + musicas.get(musicaAtual[0]).getNome(),
                    "PlayMusic",
                    JOptionPane.INFORMATION_MESSAGE
                );
                playStopButton.setText("Play");
            }
        });

        // Exibe um JOptionPane com os botões Play/Stop/Next
        ImageIcon icon = new ImageIcon("./src/assets/music.png");
        JOptionPane.showOptionDialog(
            null,
            "Escolha uma ação:",
            "PlayMusic",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            icon,
            new Object[] { playStopButton, nextButton },
            playStopButton
        );

        // Fecha o clip de áudio ao encerrar o programa
        if (player.audioClip != null) {
            player.audioClip.close();
        }

    }

}
