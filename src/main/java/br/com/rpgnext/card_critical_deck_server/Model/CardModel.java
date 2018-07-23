package br.com.rpgnext.card_critical_deck_server.Model;

import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;

import java.util.List;

public class CardModel {
    private Long id;
    private Long cardItem;
    private List<ItemEntity> itens;
    private Boolean status;

    public CardModel() {
    }

    public CardModel(Long id, List<ItemEntity> itens, Boolean status) {
        this.id = id;
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
