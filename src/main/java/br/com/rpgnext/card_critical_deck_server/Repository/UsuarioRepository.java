package br.com.rpgnext.card_critical_deck_server.Repository;

import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>, PagingAndSortingRepository<UsuarioEntity, Long> {

}
