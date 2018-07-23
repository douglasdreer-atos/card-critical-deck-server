package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.ItemEntity;
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

    @CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> listar(){
        return new ResponseEntity<>((List) service.listar(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<ItemEntity> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }


    @CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @GetMapping(value = "/{id}/tipo")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> buscarPorTipo(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorTipo(id), HttpStatus.OK);
    }


    @CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<ItemEntity> salvar(@RequestBody ItemEntity item) {
        return new ResponseEntity<>(service.salvar(item), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @PostMapping(value = "/salvar/todos")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> salvar(@RequestBody List<ItemEntity> itens) {
        return new ResponseEntity<>(service.salvarTodos(itens), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @PutMapping(value = "{id}/editar")
    @ResponseBody
    public ResponseEntity<Boolean> editar(@PathVariable Long id, @RequestBody ItemEntity item){
        ItemEntity itemSalvo = service.editar(item);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @DeleteMapping(value = "{id}/excluir")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }


}