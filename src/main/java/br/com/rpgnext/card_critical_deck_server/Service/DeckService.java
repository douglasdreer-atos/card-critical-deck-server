package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.CardEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.DeckEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {
    private final DeckRepository repository;

    @Autowired
    public DeckService(DeckRepository repository) {
        this.repository = repository;
    }

    public List<DeckEntity> listar(){
        return (List<DeckEntity>) repository.findAll();
    }

    public DeckEntity buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public DeckEntity buscarPorUsuario(UsuarioEntity usuario){
        return repository.findByUsuario(usuario);
    }

    public DeckEntity salvar(DeckEntity deck){
        return repository.save(deck);
    }

    public DeckEntity adicionarNovasCards(Long deckId, List<CardEntity> cards){
        DeckEntity deck = repository.findById(deckId).get();
        cards.forEach(card -> deck.getCards().add(card));
        return this.salvar(deck);
    }

}
