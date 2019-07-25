package br.com.rpgnext.card_critical_deck_server.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    public static String gerarSenha(String senha){
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

    public static Boolean conferirSenhas(String senhaInterna, String senhaExterna){
        senhaExterna = gerarSenha(senhaExterna);
        return senhaInterna.equalsIgnoreCase(senhaExterna);
    }
}
