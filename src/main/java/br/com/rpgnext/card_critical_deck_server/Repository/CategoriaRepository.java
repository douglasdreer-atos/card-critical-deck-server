package br.com.rpgnext.card_critical_deck_server.Repository;

import br.com.rpgnext.card_critical_deck_server.Entity.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {
}
