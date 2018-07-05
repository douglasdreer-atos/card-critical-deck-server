package br.com.rpgnext.card_critical_deck_server.Model;


public class TipoModel {
    private Long id;
    private String nome;

    public TipoModel() {
    }

    public TipoModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
