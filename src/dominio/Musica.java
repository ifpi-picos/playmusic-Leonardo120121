package dominio;

public class Musica {
  // Nome da música
  private String nome;
  // Gênero da música
  private String genero;
  // Caminho do arquivo de áudio
  private String arquivoAudio;
  // Duração da música em segundos
  private int duracao;

  // Retorna o nome da música
  public String getNome() {
    return nome;
  }

  // Define o nome da música
  public void setNome(String nome) {
    this.nome = nome;
  }

  // Retorna o gênero da música
  public String getGenero() {
    return genero;
  }

  // Define o gênero da música
  public void setGenero(String genero) {
    this.genero = genero;
  }

  // Retorna a duração da música
  public int getDuracao() {
    return duracao;
  }

  // Define a duração da música
  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  // Retorna o caminho do arquivo de áudio
  public String getArquivoAudio() {
    return arquivoAudio;
  }

  // Define o caminho do arquivo de áudio
  public void setArquivoAudio(String arquivoAudio) {
    this.arquivoAudio = arquivoAudio;
  }

}
