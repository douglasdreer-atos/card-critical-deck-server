package br.com.rpgnext.card_critical_deck_server.Model;

public class ItemModel {
    private Long id;
    private String titulo;
    private TipoModel tipo;
    private String descricao;

    public ItemModel() {
    }

    public ItemModel(Long id, String titulo, TipoModel tipo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoModel getTipo() {
        return tipo;
    }

    public void setTipo(TipoModel tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
