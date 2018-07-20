package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Controller.TipoController;
import br.com.rpgnext.card_critical_deck_server.Entity.CardEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.TipoEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.CardRepository;
import br.com.rpgnext.card_critical_deck_server.Repository.ItemRepository;
import br.com.rpgnext.card_critical_deck_server.Repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CardService {
    @Autowired
    private CardRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TipoRepository tipoRepository;

    public CardEntity salvar(CardEntity card) {
        List<ItemEntity> itens = new ArrayList<>();
        card.getItens().forEach(item -> {
            ItemEntity itemEntity = itemRepository.findById(item.getId()).get();
            itens.add(itemEntity);
        });
        card.setItens(itens);
        return repository.save(card);
    }

    public List<CardEntity> salvarTodos(List<CardEntity> cards) {
        List<CardEntity> cardsSaved = (List) repository.saveAll(cards);
        cards.clear();
        cardsSaved.forEach(card -> {
            cards.add(this.buscarPorId(card.getId()));
        });
        return cards;
    }

    public List<CardEntity> listar() {
        return (List) repository.findAll();
    }

    public CardEntity buscarPorId(Long id) {
        List<ItemEntity> itens = new ArrayList<>();
        CardEntity card = repository.findById(id).get();
        card.getItens().forEach(item -> {
            itens.add(itemRepository.findById(item.getId()).get());
        });
        card.setItens(itens);
        return card;
    }

    public List<CardEntity> buscarPorItem(Long itemId){
        List<CardEntity> cards = (List) repository.findAll();
        cards.stream().forEach(card -> {

            ItemEntity itemEntity = card.getItens().stream().filter(item -> {
                return itemId.equals(item.getId());
            }).findFirst().get();
        });
        return cards;
    }

    public CardEntity sortearPersonalizado() {
        Random random = new Random();
        CardEntity card = new CardEntity();
        Long id = 1L;
        List<ItemEntity> itens = new ArrayList<>();

        tipoRepository.findAll().forEach(tipo -> {
            List<ItemEntity> itensPorTipo = itemRepository.findByTipo(tipo);
            Integer index = random.nextInt(itensPorTipo.size());
            itens.add(itensPorTipo.get(index));
        });

        card.setItens(itens);
        return card;
    }

    public CardEntity editar(CardEntity card) {
        return this.salvar(card);
    }

    public Boolean excluir(Long id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
