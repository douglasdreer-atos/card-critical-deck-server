package br.com.rpgnext.card_critical_deck_server.Repository;

import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.TipoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
    List<ItemEntity> findByTipo(TipoEntity tipo);

    List<ItemEntity> findAllByTituloContains(String titulo);
}
