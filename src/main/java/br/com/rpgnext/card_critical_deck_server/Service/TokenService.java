package br.com.rpgnext.card_critical_deck_server.Service;

import br.com.rpgnext.card_critical_deck_server.Entity.TokenEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TokenService {
    private TokenRepository repository;

    @Autowired
    public TokenService(TokenRepository repository) {
        this.repository = repository;
    }

    public List<TokenEntity> listarTodosAtivos() {
        return (this.repository).findByStatusTrue();
    }

    public List<TokenEntity> listarTodosInativos() {
        return (this.repository).findByStatusFalse();
    }

    public TokenEntity buscarPorId(Long id) {
        return (this.repository).findById(id).get();
    }

    public List<TokenEntity> buscarTokenVencidos() {
        List<TokenEntity> lista = repository.findByDataValidadeGreaterThan(new Date());
        return lista;
    }

    public TokenEntity buscarPorUsuario(UsuarioEntity usuario) {
        return (this.repository).findByUsuario(usuario);
    }

    // TODO: Fazer um esquema de gravar apenas uma vez o usuário, reaproveitando o mesmo usuário.
    public TokenEntity salvar(TokenEntity token) {
        return (this.repository).save(token);
    }

    public TokenEntity editar(TokenEntity token) {
        return (this.repository).save(token);
    }

    public Boolean excluir(Long id) {
        (this.repository).deleteById(id);
        return (this.repository).existsById(id) ? false : true;
    }


    public void desativarTokens(List<TokenEntity> tokens) {
        tokens.forEach(token -> {
            token.setStatus(false);
            salvar(token);
        });
    }
}
