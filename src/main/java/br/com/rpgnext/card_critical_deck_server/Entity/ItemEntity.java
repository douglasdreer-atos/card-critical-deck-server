package br.com.rpgnext.card_critical_deck_server.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = true)
    private String titulo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    private TipoEntity tipo;
    
    private String descricao;

    private String formatacao;

    private Boolean status;

    @PrePersist
    void prePersist(){
        this.status = true;
    }

    public ItemEntity() {
    }

    public ItemEntity(String titulo, TipoEntity tipo, String descricao, String formatacao, Boolean status) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.formatacao = formatacao;
        this.status = status;
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

    public TipoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntity tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFormatacao() {
        return formatacao;
    }

    public void setFormatacao(String formatacao) {
        this.formatacao = formatacao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
