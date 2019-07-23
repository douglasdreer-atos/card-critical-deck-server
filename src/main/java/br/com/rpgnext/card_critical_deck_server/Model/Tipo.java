package br.com.rpgnext.card_critical_deck_server.Model;

public class Tipo {
    private Long id;
    private String nome;
    private Categoria categoria;
    private Boolean status;

    public Tipo() {
    }

    public Tipo(Long id) {
        this.id = id;
    }

    public Tipo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Tipo(Long id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Tipo(Long id, String nome, Categoria categoria, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.status = status;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
