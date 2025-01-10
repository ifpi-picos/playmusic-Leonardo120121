package dominio;

import java.util.ArrayList;
import java.util.List;

public class Album {
  // Nome do álbum
  private String nome;
  // Ano de lançamento do álbum
  private int ano;
  // Lista de músicas do álbum
  private List<Musica> musicas = new ArrayList<>();

  // Retorna o nome do álbum
  public String getNome() {
    return nome;
  }

  // Define o nome do álbum
  public void setNome(String nome) {
    this.nome = nome;
  }

  // Retorna o ano de lançamento do álbum
  public int getAno() {
    return ano;
  }

  // Define o ano de lançamento do álbum
  public void setAno(int ano) {
    this.ano = ano;
  }

  // Retorna a lista de músicas do álbum
  public List<Musica> getMusicas() {
    return musicas;
  }

  // Adiciona uma música à lista de músicas do álbum
  public void addMusica(Musica musica) {
    musicas.add(musica);
  }

  // Adiciona uma lista de músicas à lista de músicas do álbum
  public void addMusicas(List<Musica> musicas) {
    this.musicas.addAll(musicas);
  }

}
