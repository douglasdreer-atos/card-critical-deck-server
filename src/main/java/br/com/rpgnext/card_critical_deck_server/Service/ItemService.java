package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.TipoEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.ItemRepository;
import br.com.rpgnext.card_critical_deck_server.Repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    @Autowired
    private TipoRepository tipoRepository;

    public List<ItemEntity> listar(){
        List<ItemEntity> lista = (List) repository.findAll();
        return lista;
    }

    public ItemEntity buscarPorId(Long id){
        ItemEntity item = repository.findById(id).get();
        return item;
    }

    public ItemEntity salvar(ItemEntity item){
        TipoEntity tipo = tipoRepository.findById(item.getTipo().getId()).get();
        item.setTipo(tipo);
        return repository.save(item);
    }

    public ItemEntity editar(ItemEntity item){
        return repository.save(item);
    }

    public Boolean excluir(Long id){
        repository.deleteById(id);
        return repository.existsById(id);
    }
}
