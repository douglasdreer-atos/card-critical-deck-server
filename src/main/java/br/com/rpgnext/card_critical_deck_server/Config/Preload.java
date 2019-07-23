package br.com.rpgnext.card_critical_deck_server.Config;

import br.com.rpgnext.card_critical_deck_server.Entity.CategoriaEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.TipoEntity;
import br.com.rpgnext.card_critical_deck_server.Model.Categoria;
import br.com.rpgnext.card_critical_deck_server.Model.Tipo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class Preload {
    private ObjectMapper mapper = new ObjectMapper();
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        /*
        CategoriaController categoriaCtrl = new CategoriaController();
        TipoController tipoController = new TipoController();

        if(categoriaCtrl.isEmpty()){
            List<CategoriaEntity> categorias = carregarCategorias();
            categoriaCtrl.salvarTodos(categorias);
        }

        if(tipoController.listar().getBody().size() >= 1){
            List<TipoEntity> tipos = carregarTipo();
            tipoController.salvarTodos(tipos);
        }

        System.out.println("FIM");
        */
    }

    private List<TipoEntity> carregarTipo() throws IOException {
        InputStream is = Tipo.class.getResourceAsStream("/tipos.json");
        List<Tipo> tipos = mapper.readValue(is, new TypeReference<List<Tipo>>(){});
        return (List<TipoEntity>) tipos.stream().map(tipo -> new TipoEntity(tipo));
    }

    private List<CategoriaEntity> carregarCategorias() throws IOException {
        InputStream is = Categoria.class.getResourceAsStream("/categorias.json");
        List<CategoriaEntity> categorias = mapper.readValue(is, new TypeReference<List<CategoriaEntity>>(){});
        return categorias;
    }
}
