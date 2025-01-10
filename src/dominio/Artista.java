package dominio;

import java.util.ArrayList;
import java.util.List;

public class Artista {
  // Nome do artista
  private String nome;
  // Lista de álbuns do artista
  private List<Album> albuns = new ArrayList<>();

  // Retorna o nome do artista
  public String getNome() {
    return nome;
  }

  // Define o nome do artista
  public void setNome(String nome) {
    this.nome = nome;
  }

  // Retorna a lista de álbuns do artista
  public List<Album> getAlbuns() {
    return albuns;
  }

  // Adiciona um álbum à lista de álbuns do artista
  public void addAlbum(Album album) {
    this.albuns.add(album);
  }

  // Adiciona uma lista de álbuns à lista de álbuns do artista
  public void addAlbuns(List<Album> albuns) {
    this.albuns.addAll(albuns);
  }

}
