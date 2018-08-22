package br.com.rpgnext.card_critical_deck_server.Entity;

import javax.persistence.*;

@Entity
@Table(name = "card_item")
public class CardItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long card_id;

    private Long item_id;

    public CardItemEntity() {
    }

    public CardItemEntity(Long card_id, Long item_id) {
        this.card_id = card_id;
        this.item_id = item_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }
}
