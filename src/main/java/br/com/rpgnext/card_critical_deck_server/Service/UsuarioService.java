package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioEntity> buscarTodos(){
        return (List) repository.findAll();
    }

    public UsuarioEntity salvar(UsuarioEntity usuario){
        return repository.save(usuario);
    }

    public List<UsuarioEntity> salvarTodos(List<UsuarioEntity> usuarios){
       return (List) repository.saveAll(usuarios);
    }




}
