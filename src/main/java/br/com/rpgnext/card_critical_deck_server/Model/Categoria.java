package br.com.rpgnext.card_critical_deck_server.Model;

public class Categoria {
    private Long id;
    private String nome;
    private Boolean status;
    private String token;

    public Categoria(Long id, String nome, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Categoria(String nome, String token) {
        this.nome = nome;
        this.token = token;
    }

    public Categoria(Long id) {
        this.id = id;
    }

    public Categoria() {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
