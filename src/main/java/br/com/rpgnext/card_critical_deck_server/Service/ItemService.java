package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.TipoEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.ItemRepository;
import br.com.rpgnext.card_critical_deck_server.Repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository repository;
    private final TipoRepository tipoRepository;

    @Autowired
    public ItemService(ItemRepository repository, TipoRepository tipoRepository) {
        this.repository = repository;
        this.tipoRepository = tipoRepository;
    }

    public List<ItemEntity> listar(){
        List<ItemEntity> lista = (List) repository.findAll();
        Collections.sort(lista, Comparator.comparing(ItemEntity::getId).thenComparing(ItemEntity::getId));
        return lista;
    }

    public ItemEntity buscarPorId(Long id){
        ItemEntity item = repository.findById(id).get();
        return item;
    }

    public List<ItemEntity> buscarPorTitulo(String titulo){
        List<ItemEntity> itens = repository.findAllByTituloContains(titulo);
        return itens;
    }

    public List<ItemEntity> buscarPorTipo(Long id) {
        TipoEntity tipo = tipoRepository.findById(id).get();
        return repository.findByTipo(tipo);
    }

    public ItemEntity salvar(ItemEntity item){
        TipoEntity tipo = tipoRepository.findById(item.getTipo().getId()).get();
        item.setTipo(tipo);
        return repository.save(item);
    }

    public List<ItemEntity> salvarTodos(List<ItemEntity> itens) {
        itens.forEach(item -> {
            TipoEntity tipo = tipoRepository.findById(item.getTipo().getId()).get();
            item.setTipo(tipo);
        });
        return (List) repository.saveAll(itens);
    }

    public ItemEntity editar(ItemEntity item){
        return repository.save(item);
    }

    public Boolean excluir(Long id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }

}
