package br.com.rpgnext.card_critical_deck_server.Controller;

import br.com.rpgnext.card_critical_deck_server.Entity.TokenEntity;
import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;
import br.com.rpgnext.card_critical_deck_server.Service.TokenService;
import br.com.rpgnext.card_critical_deck_server.Service.UsuarioService;
import br.com.rpgnext.card_critical_deck_server.Utils.Password;
import br.com.rpgnext.card_critical_deck_server.Utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<Boolean> login(@RequestBody UsuarioEntity usuario){
        UsuarioEntity usuarioSalvo = usuarioService.buscarPorLogin(usuario.getLogin());
        Boolean status = comparar(usuarioSalvo, usuario);

        if(status){
            tokenService.salvar(gerarToken(usuarioSalvo));
        }

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    private TokenEntity gerarToken(UsuarioEntity usuario) {
        String numero = Token.gerar(usuario);
        return new TokenEntity(numero, usuario);
    }

    private Boolean comparar(UsuarioEntity usuarioSalvo, UsuarioEntity usuarioFornecido){
        Password util = new Password();
        return util.conferirSenhas(usuarioSalvo.getSenha(), usuarioFornecido.getSenha());
    }
}
