package br.com.rpgnext.card_critical_deck_server.Entity;

import javax.persistence.*;

@Entity
@Table(name = "deck_card")
public class DeckCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private DeckEntity deck_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardEntity card_id;

    public DeckCardEntity() {
    }

    public DeckCardEntity(DeckEntity deck_id, CardEntity card_id) {
        this.deck_id = deck_id;
        this.card_id = card_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeckEntity getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(DeckEntity deck_id) {
        this.deck_id = deck_id;
    }

    public CardEntity getCard_id() {
        return card_id;
    }

    public void setCard_id(CardEntity card_id) {
        this.card_id = card_id;
    }
}
