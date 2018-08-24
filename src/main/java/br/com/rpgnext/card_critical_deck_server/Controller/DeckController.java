package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.CardEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.DeckEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Service.DeckService;
import br.com.rpgnext.card_critical_deck_server.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("decks")
public class DeckController {
    @Autowired
    private DeckService service;

    @Autowired
    private UsuarioService usuarioService;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<DeckEntity>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<DeckEntity> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}/usuario")
    @ResponseBody
    public ResponseEntity<DeckEntity> buscarPorUsuario(@PathVariable Long id) {
        UsuarioEntity usuario = usuarioService.buscarPorId(id);
        return new ResponseEntity<>(service.buscarPorUsuario(usuario), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/{id}/cards/adicionar")
    @ResponseBody
    public ResponseEntity<DeckEntity> adicionarCards(@PathVariable Long id, @RequestBody List<CardEntity> cards) {
        DeckEntity deck = service.buscarPorId(id);
        cards.forEach(card -> deck.getCards().add(card));
        return new ResponseEntity<>(service.salvar(deck), HttpStatus.OK);
    }


}
