package br.com.rpgnext.card_critical_deck_server.Entity;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private Boolean status;

    @PrePersist
    void prePersist(){
        this.status = true;
    }

    public CategoriaEntity() {
    }

    public CategoriaEntity(String nome) {
        this.nome = nome;
    }

    public CategoriaEntity(String nome, Boolean status) {
        this.nome = nome;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
