package br.com.rpgnext.card_critical_deck_server.Entity;

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

    private Boolean status;

    public TipoEntity() {
    }

    public TipoEntity(String nome) {
        this.nome = nome;
    }

    @PrePersist
    public void prePersist(){
        this.status = true;
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
