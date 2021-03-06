package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.TipoEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {
    @Autowired
    private TipoRepository repository;

    public List<TipoEntity> listar(){
        return (List) repository.findAll();
    }

    public TipoEntity buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public TipoEntity salvar(TipoEntity tipo){
        return repository.save(tipo);
    }

    public List<TipoEntity> salvarTodos(List<TipoEntity> tipos) {
        return (List) repository.saveAll(tipos);
    }

    public TipoEntity editar(TipoEntity tipo){
        return repository.save(tipo);
    }

    public Boolean excluir(Long id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }


}