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

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<ItemEntity>> listar(){
        return new ResponseEntity<>((List) service.listar(), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<ItemEntity> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<ItemEntity> salvar(@RequestBody ItemEntity tipo){
        return new ResponseEntity<>(service.salvar(tipo), HttpStatus.OK);
    }

    //@CrossOrigin(origins = "https://deck-critical-hit-client.herokuapp.com")
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "/excluir/{id}")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){
        return null;
        //return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }


}