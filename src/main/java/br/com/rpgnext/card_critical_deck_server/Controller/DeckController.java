package br.com.rpgnext.card_critical_deck_server.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("decks")
public class DeckController {
    /*
    @Autowired
    private DeckService service;

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<DeckEntity>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<DeckEntity> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @GetMapping(value = "/{id}/usuario")
    @ResponseBody
    public ResponseEntity<DeckEntity> buscarPorUsuario(@PathVariable Long id) {
       // Usuario usuario = usuarioService.buscarPorId(id);
       // return new ResponseEntity<>(service.buscarPorUsuario(usuario), HttpStatus.OK);
        return null;
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<DeckEntity> salvar(@RequestBody DeckEntity deck){
        return new ResponseEntity<>(service.salvar(deck), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @PostMapping(value = "/salvar/todos")
    @ResponseBody
    public ResponseEntity<List<DeckEntity>> salvarTodos(@RequestBody List<DeckEntity> decks){
        return new ResponseEntity<>(service.salvarTodos(decks), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @PostMapping(value = "{id}/editar")
    @ResponseBody
    public ResponseEntity<DeckEntity> editar(@PathVariable Long id, @RequestBody DeckEntity deck){
        return new ResponseEntity<>(service.salvar(deck), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @PostMapping(value = "/{id}/cards/adicionar")
    @ResponseBody
    public ResponseEntity<DeckEntity> adicionarCards(@PathVariable Long id, @RequestBody List<CardEntity> cards) {
        DeckEntity deck = service.buscarPorId(id);
        cards.forEach(card -> deck.getCards().add(card));
        return new ResponseEntity<>(service.salvar(deck), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com")
    @DeleteMapping(value = "/{id}/excluir")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id) {
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }

*/
}
