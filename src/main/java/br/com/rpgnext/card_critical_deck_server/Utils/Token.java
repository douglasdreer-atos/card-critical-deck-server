package br.com.rpgnext.card_critical_deck_server.Utils;

import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;

import java.util.Date;

public class Token {
    public static String gerar(UsuarioEntity usuario) {
        StringBuilder builder = new StringBuilder();
        builder.append(usuario.getLogin());
        builder.append(new Date().toString());
        MD5 codificador = new MD5(builder.toString());
        return codificador.getValor();
    }
}
