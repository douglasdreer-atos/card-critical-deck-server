package br.com.rpgnext.card_critical_deck_server.Utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    public String gerarSenha(String senha){
        MessageDigest algorithm = null;
        StringBuilder hexString = new StringBuilder();
        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));

            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

    public Boolean conferirSenhas(String senhaInterna, String senhaExterna){
        senhaExterna = gerarSenha(senhaExterna);
        return senhaInterna.equalsIgnoreCase(senhaExterna);
    }
}
