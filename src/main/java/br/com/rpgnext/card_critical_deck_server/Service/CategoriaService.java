package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.CategoriaEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<CategoriaEntity> listar(){
        return (List<CategoriaEntity>) repository.findAll();
    }

    public CategoriaEntity buscarPorId(Long id){
        id = id == null ? 0 : id;
        return repository.findById(id).get();
    }

    public CategoriaEntity salvar(CategoriaEntity categoria){
        return repository.save(categoria);
    }

    public List<CategoriaEntity> salvarTodos(List<CategoriaEntity> categorias){
        return (List) repository.saveAll(categorias);
    }

    public CategoriaEntity editar(CategoriaEntity item){
        return repository.save(item);
    }

    public Boolean excluir(Long id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
