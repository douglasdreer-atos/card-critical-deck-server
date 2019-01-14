package br.com.rpgnext.card_critical_deck_server.Repository;

import br.com.rpgnext.card_critical_deck_server.Entity.TokenEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Long> {
    List<TokenEntity> findByStatusTrue();

    List<TokenEntity> findByStatusFalse();

    TokenEntity findByUsuario(UsuarioEntity usuario);

    List<TokenEntity> findByDataValidadeGreaterThan(Date data);
}
