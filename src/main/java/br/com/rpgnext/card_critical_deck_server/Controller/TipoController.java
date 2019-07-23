package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.CategoriaEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.TipoEntity;
import br.com.rpgnext.card_critical_deck_server.Service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tipos")

public class TipoController {
    @Autowired
    private TipoService service;

    @Autowired
    private CategoriaController catagoriaCtrl;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<TipoEntity>> listar(){
        return new ResponseEntity<>((List) service.listar(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<TipoEntity> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<TipoEntity> salvar(@RequestBody TipoEntity tipo){
        CategoriaEntity categoria = buscarCategoriaPorId(tipo.getCategoria().getId());
        tipo.setCategoria(categoria);
        return new ResponseEntity<>(service.salvar(tipo), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar/todos")
    @ResponseBody
    public ResponseEntity<List<TipoEntity>> salvarTodos(@RequestBody List<TipoEntity> tipos) {
        tipos = buscarCategoriaPorTipo(tipos);
        return new ResponseEntity<>(service.salvarTodos(tipos), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(value = "/{id}/editar")
    @ResponseBody
    public ResponseEntity<Boolean> editar(@PathVariable Long id, @RequestBody TipoEntity tipo){
        TipoEntity tipoSalvo = service.editar(tipo);
        Boolean status = tipo.equals(tipoSalvo);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "/{id}/excluir")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }


    private CategoriaEntity buscarCategoriaPorId(Long id){
        return catagoriaCtrl.buscarPorId(id).getBody();
    }

    private List<TipoEntity> buscarCategoriaPorTipo(List<TipoEntity> itens){
        List<TipoEntity> lista = itens.stream().map(item -> {
            CategoriaEntity categoria = buscarCategoriaPorId(item.getCategoria().getId());
            item.setCategoria(categoria);
            return item;
        }).collect(Collectors.toList());
        return lista;
    }


}
