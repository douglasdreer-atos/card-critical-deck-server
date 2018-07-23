package br.com.rpgnext.card_critical_deck_server.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "card_item",
            joinColumns = {@JoinColumn(name = "card_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<ItemEntity> itens;

    private Boolean status;

    @PrePersist
    void prePersist() {
        this.status = true;
    }

    public CardEntity() {
    }

    public CardEntity(List<ItemEntity> itens) {
        this.itens = itens;
    }

    public CardEntity(List<ItemEntity> itens, Boolean status) {
        this.itens = itens;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemEntity> itens) {
        this.itens = itens;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

