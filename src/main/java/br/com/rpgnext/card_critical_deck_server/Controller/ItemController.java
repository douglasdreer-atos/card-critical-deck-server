package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.TokenEntity;
import br.com.rpgnext.card_critical_deck_server.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itens")

public class ItemController {
    @Autowired
    private ItemService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> listar(){
        return new ResponseEntity<>((List) service.listar(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<ItemEntity> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "?titulo={titulo}}")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> buscarPorTitulo(@PathVariable String titulo){
        return new ResponseEntity<List<ItemEntity>>(service.buscarPorTitulo(titulo), HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}/tipo")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> buscarPorTipo(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorTipo(id), HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<ItemEntity> salvar(@RequestBody ItemEntity item, @RequestBody TokenEntity token) {
        TokenController controller = new TokenController();
        TokenEntity tkn = controller.buscarPorNumero(token.getNumero()).getBody();

        if(tkn.getId() != null){
            return new ResponseEntity<>(service.salvar(item), HttpStatus.OK);
        } else {
            return new ResponseEntity<> (new ItemEntity(), HttpStatus.UNAUTHORIZED);
        }

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar/todos")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> salvar(@RequestBody List<ItemEntity> itens) {
        return new ResponseEntity<>(service.salvarTodos(itens), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(value = "{id}/editar")
    @ResponseBody
    public ResponseEntity<Boolean> editar(@PathVariable Long id, @RequestBody ItemEntity item){
        item = service.editar(item);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "{id}/excluir")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }


}