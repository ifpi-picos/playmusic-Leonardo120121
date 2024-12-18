
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

        Musica musica1 = new Musica();

        musica1.setNome("Diga sim pra mim");
        musica1.setDuracao(215);
        musica1.setArquivoAudio("./src/assets/Digasimpramim.wav");
        musica1.setGenero("Forro");

        Musica musica2 = new Musica();
        musica2.setNome("Beijos blues e poesia");
        musica2.setDuracao(198);
        musica2.setArquivoAudio("./src/assets/Beijosbluesepoesia.wav");
        musica2.setGenero("Forro");

        Album album1 = new Album();
        album1.setNome("Primeiro album");
        album1.setAno(2024);
        album1.addMusica(musica1);
        album1.addMusica(musica2);

        Artista redHot = new Artista();
        redHot.setNome("Seu Desejo");
        redHot.addAlbum(album1);

        System.out.println("Abrindo o PlayMusic");
        redHot.getAlbuns().get(0).getMusicas().get(0).getArquivoAudio();

        AudioPlayer player = new AudioPlayer();
        player.loadAudio(redHot.getAlbuns().get(0).getMusicas().get(0).getArquivoAudio()); // Carregue o áudio ao
                                                                                           // iniciar

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
            player.playAudio();
            playStopButton.setText("Stop");
        } else {
            player.stopAudio();
            playStopButton.setText("Play");
        }
    }
});

// Configura ação do botão Next
nextButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        player.stopAudio(); // Para a música atual
        musicaAtual[0] = (musicaAtual[0] + 1) % musicas.size(); // Avança para a próxima música
        player.loadAudio(musicas.get(musicaAtual[0]).getArquivoAudio()); // Carrega a nova música
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
