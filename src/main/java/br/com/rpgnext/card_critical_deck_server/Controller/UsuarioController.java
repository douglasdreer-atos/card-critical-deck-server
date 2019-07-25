package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Model.Usuario;
import br.com.rpgnext.card_critical_deck_server.Service.UsuarioService;
import br.com.rpgnext.card_critical_deck_server.Utils.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenController tokenController;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listar() {
        return new ResponseEntity<>(converterEntityParaModel(service.buscarTodos()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/pagina/{id}")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listarComPaginacao(@PathVariable Integer id){
        id = id > 0 ? id - 1 : id;
        return new ResponseEntity<>(converterEntityParaModel(service.buscarTodosComPaginacao(id)), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(converterEntityParaModel(service.buscarPorId(id)), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/login/{login}")
    @ResponseBody
    public ResponseEntity<Usuario> buscarPorLogin(@PathVariable String login) {
        return new ResponseEntity<>(converterEntityParaModel(service.buscarPorLogin(login)), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvar(@RequestBody UsuarioEntity usuario) {
        usuario.setSenha(codificarSenha(usuario.getSenha()));
        return new ResponseEntity<>(converterEntityParaModel(service.salvar(usuario)), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar/todos")
    @ResponseBody
    public ResponseEntity<List<Usuario>> salvarTodos(@RequestBody List<UsuarioEntity> usuarios) {
        return new ResponseEntity<>(converterEntityParaModel(service.salvarTodos(usuarios)), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/{id}/editar")
    @ResponseBody
    public ResponseEntity<Usuario> editar(@PathVariable Long id, @RequestBody UsuarioEntity usuario){
        usuario.setId(id);
        usuario.setSenha(codificarSenha(usuario.getSenha()));
        return new ResponseEntity<>(converterEntityParaModel(service.salvar(usuario)), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "/{id}/excluir")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }

    public List<UsuarioEntity> converterModelParaEntity(List<Usuario> models){
        List<UsuarioEntity> entities = new ArrayList<>();

        for(Usuario item : models){
            UsuarioEntity entity = new UsuarioEntity(item);
            entities.add(entity);
        }
        return entities;
    }

    public UsuarioEntity converterModelParaEntity(Usuario model){
        return new UsuarioEntity(model);
    }

    public List<Usuario> converterEntityParaModel(List<UsuarioEntity> entities){
        List<Usuario> models = new ArrayList<>();

        for(UsuarioEntity item : entities){
            Usuario model = new Usuario(item);
            models.add(model);
        }
        return models;
    }

    public Usuario converterEntityParaModel(UsuarioEntity entity){
        return new Usuario(entity);
    }

    public String codificarSenha(String senha){
        return new Password().gerarSenha(senha);
    }
}
