package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.TokenEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Service.TokenService;
import br.com.rpgnext.card_critical_deck_server.Utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("tokens")
public class TokenController {
    @Autowired
    private TokenService service;

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com/")
    @GetMapping(value = "/ativos")
    @ResponseBody
    public ResponseEntity<List<TokenEntity>> listarAtivos() {
        return new ResponseEntity<>((List) service.listarTodosAtivos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com/")
    @GetMapping(value = "/inativos")
    @ResponseBody
    public ResponseEntity<List<TokenEntity>> listarInativos() {
        return new ResponseEntity<>((List) service.listarTodosInativos(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com/")
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<TokenEntity> buscarPorId(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://rpgnext-card-critical.herokuapp.com/")
    @GetMapping(value = "/validar")
    @ResponseBody
    public void validarToken() {
        List<TokenEntity> tokens = buscarTokensVencidos();
        if (!tokens.isEmpty()) {
            service.desativarTokens(tokens);
        }
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
        StringBuilder builder = new StringBuilder();
        builder.append(usuario.getLogin());
        builder.append(new Date().toString());
        MD5 codificador = new MD5(builder.toString());

        return codificador.getValor();
    }
}
