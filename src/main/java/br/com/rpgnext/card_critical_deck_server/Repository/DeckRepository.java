package br.com.rpgnext.card_critical_deck_server.Repository;

import br.com.rpgnext.card_critical_deck_server.Entity.DeckEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends CrudRepository<DeckEntity, Long> {
    DeckEntity findByUsuario(UsuarioEntity usuario);
}
