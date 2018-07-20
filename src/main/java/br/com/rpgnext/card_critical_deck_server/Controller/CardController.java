package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.CardEntity;
import br.com.rpgnext.card_critical_deck_server.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {
    @Autowired
    private CardService service;

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<CardEntity>> listar() {
        return new ResponseEntity<>((List) service.listar(), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<CardEntity> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}/item")
    @ResponseBody
    public ResponseEntity<List<CardEntity>> buscarPorItem(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorItem(id), HttpStatus.OK);
    }

    //@CrossOrigin(origns = "https:deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/sortear")
    @ResponseBody
    public ResponseEntity<CardEntity> sortearCard(){
        return new ResponseEntity<>(service.sortearPersonalizado(), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<CardEntity> salvar(@RequestBody CardEntity card) {
        return new ResponseEntity<>(service.salvar(card), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar/todos")
    @ResponseBody
    public ResponseEntity<List<CardEntity>> salvar(@RequestBody List<CardEntity> cards) {
        return new ResponseEntity<>(service.salvarTodos(cards), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(value = "{id}/editar")
    @ResponseBody
    public ResponseEntity<Boolean> editar(@PathVariable Long id, @RequestBody CardEntity card) {
        CardEntity cardSalvo = service.editar(card);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "{id}/excluir")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id) {
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }

}
