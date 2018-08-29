package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private static Integer itemPorPagina = 3;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioEntity> buscarTodos(){
        return (List) repository.findAll();
    }

    public UsuarioEntity buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public List<UsuarioEntity> buscarTodosComPaginacao(Integer pagina){
        PageRequest pageable = PageRequest.of(pagina, itemPorPagina);
        return repository.findAll(pageable).getContent();
    }

    public UsuarioEntity salvar(UsuarioEntity usuario){
        return repository.save(usuario);
    }

    public UsuarioEntity editar(UsuarioEntity usuario){
        return repository.save(usuario);
    }

    public List<UsuarioEntity> salvarTodos(List<UsuarioEntity> usuarios){
       return (List) repository.saveAll(usuarios);
    }

    public Boolean excluir(Long id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }




}
