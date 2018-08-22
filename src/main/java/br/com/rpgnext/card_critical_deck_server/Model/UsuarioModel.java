package br.com.rpgnext.card_critical_deck_server.Model;

import java.util.Date;

public class UsuarioModel {
    private Long id;
    private String nome;
    private String email;
    private String usuario;
    private String senha;
    private Boolean status;
    private Date data_criacao;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nome, String email, String usuario, String senha, Boolean status, Date data_criacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.status = status;
        this.data_criacao = data_criacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
}
