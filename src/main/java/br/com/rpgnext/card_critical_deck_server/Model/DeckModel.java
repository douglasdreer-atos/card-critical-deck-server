package br.com.rpgnext.card_critical_deck_server.Model;

import java.util.Date;
import java.util.List;

public class DeckModel {
    private UsuarioModel Usuario;
    private List<CardModel> cards;
    private Date data_criacao;

    public DeckModel() {
    }

    public DeckModel(UsuarioModel usuario, List<CardModel> cards, Date data_criacao) {
        Usuario = usuario;
        this.cards = cards;
        this.data_criacao = data_criacao;
    }

    public UsuarioModel getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        Usuario = usuario;
    }

    public List<CardModel> getCards() {
        return cards;
    }

    public void setCards(List<CardModel> cards) {
        this.cards = cards;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
}
