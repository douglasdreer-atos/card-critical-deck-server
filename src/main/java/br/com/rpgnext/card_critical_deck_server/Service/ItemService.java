package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<ItemEntity> listar(){
        return (List) repository.findAll();
    }

    public ItemEntity buscarPorId(Long id){
        ItemEntity item = repository.findById(id).get();
        return item;
    }

    public ItemEntity salvar(ItemEntity item){
        return repository.save(item);
    }
}
