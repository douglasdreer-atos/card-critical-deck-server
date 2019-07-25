package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.CategoriaEntity;
import br.com.rpgnext.card_critical_deck_server.Model.Categoria;
import br.com.rpgnext.card_critical_deck_server.Service.CategoriaService;
import br.com.rpgnext.card_critical_deck_server.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<CategoriaEntity>> listar() throws NullPointerException  {
        return new ResponseEntity<>( (List) service.listar(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<CategoriaEntity> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    /*
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<CategoriaEntity> salvar(@RequestBody CategoriaEntity categoria) {
        return new ResponseEntity<>(service.salvar(categoria), HttpStatus.OK);
    }
    */

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<CategoriaEntity> salvar(@RequestBody Categoria categoria) {
        Boolean status = check(categoria.getToken());
        CategoriaEntity categoriaSalva = new CategoriaEntity();
        HttpStatus httpStatus = HttpStatus.OK;

        if(status){
            categoriaSalva = service.salvar(new CategoriaEntity(categoria));
        } else {
            httpStatus = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<>(categoriaSalva, httpStatus);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/salvar/todos")
    @ResponseBody
    public ResponseEntity<List<CategoriaEntity>> salvarTodos(@RequestBody List<CategoriaEntity> categorias) {
        return new ResponseEntity<>(service.salvarTodos(categorias), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(value = "{id}/editar")
    @ResponseBody
    public ResponseEntity<Boolean> editar(@PathVariable Long id, @RequestBody CategoriaEntity item){
        item = service.editar(item);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping(value = "{id}/excluir")
    @ResponseBody
    public ResponseEntity<Boolean> excluir(@PathVariable Long id){
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }

    private Boolean check(String token){
        Boolean status = false;
        try{
            status = tokenService.buscarPorNumero(token).getId() != null;
        } catch(Exception e){
            String mensagem = String.format("Não foi encontrado nenhum item com o número: %s.", token);
            System.out.println(mensagem);
        }
        return status;
    }

    public Boolean isEmpty(){
        Boolean status = false;
        try{
            status = listar().getBody().size() >= 1;
        } catch (NullPointerException e){
            status = true;
        }
        return status;
    }

}
