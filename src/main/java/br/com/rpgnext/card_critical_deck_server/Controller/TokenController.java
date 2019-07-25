package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.TokenEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Service.TokenService;
import br.com.rpgnext.card_critical_deck_server.Utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tokens")
public class TokenController {
    @Autowired
    private TokenService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/numero/{numero}")
    @ResponseBody
    public ResponseEntity<TokenEntity> buscarPorNumero(@PathVariable String numero) {
        return new ResponseEntity<>(service.buscarPorNumero(numero), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/ativos")
    @ResponseBody
    public ResponseEntity<List<TokenEntity>> listarAtivos() {
        return new ResponseEntity<>((List) service.listarTodosAtivos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/inativos")
    @ResponseBody
    public ResponseEntity<List<TokenEntity>> listarInativos() {
        return new ResponseEntity<>((List) service.listarTodosInativos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<TokenEntity> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/validar")
    @ResponseBody
    public ResponseEntity<String> validar() {
        List<TokenEntity> tokens = buscarTokensVencidos();
        if (!tokens.isEmpty()) {
            service.desativarTokens(tokens);
        }

        String mensagem = String.format("Foram desativados %s token(s)", tokens.size());
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    public ResponseEntity<TokenEntity> salvar(UsuarioEntity usuario) {
        String numero = gerarToken(usuario);
        TokenEntity token = new TokenEntity(numero, usuario);
        return new ResponseEntity<>(service.salvar(token), HttpStatus.OK);
    }

    private List<TokenEntity> buscarTokensVencidos() {
        return service.buscarTokenVencidos();
    }

    private String gerarToken(UsuarioEntity usuario) {
       return Token.gerar(usuario);
    }
}
