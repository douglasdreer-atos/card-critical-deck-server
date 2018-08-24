package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioEntity> listar(){
        return (List) repository.findAll();
    }

    public UsuarioEntity buscarPorId(Long id){
        return repository.findById(id).get();
    }

    public UsuarioEntity salvar(UsuarioEntity usuario){
        return repository.save(usuario);
    }
}
