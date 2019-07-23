package br.com.rpgnext.card_critical_deck_server.Entity;

import br.com.rpgnext.card_critical_deck_server.Model.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = true)
    private String nome;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", columnDefinition = "bigInt default 1")
    private CategoriaEntity categoria;

    @Column(columnDefinition = "Boolean default 'true'")
    private Boolean status;

    public TipoEntity() {
    }

    public TipoEntity(String nome) {
        this.nome = nome;
    }

    public TipoEntity(String nome, CategoriaEntity categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public TipoEntity(String nome, CategoriaEntity categoria, Boolean status) {
        this.nome = nome;
        this.categoria = categoria;
        this.status = status;
    }

    public TipoEntity(Tipo tipo){
        CategoriaEntity categoria = new CategoriaEntity(tipo.getCategoria());
        this.id = tipo.getId();
        this.nome = tipo.getNome();
        this.categoria = categoria;
        this.status = tipo.getStatus();
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

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}