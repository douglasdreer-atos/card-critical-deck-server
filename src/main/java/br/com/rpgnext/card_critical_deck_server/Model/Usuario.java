package br.com.rpgnext.card_critical_deck_server.Model;

import br.com.rpgnext.card_critical_deck_server.Entity.UsuarioEntity;

import java.util.Date;

public class Usuario {
    private Long id;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Date dataCriacao;
    private Date dataModificacao;
    private Boolean status;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String email, String senha, Date dataCriacao, Date dataModificacao, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.status = status;
    }

    public Usuario(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
        this.login = usuarioEntity.getLogin();
        this.email = usuarioEntity.getEmail();
        this.senha = usuarioEntity.getSenha();
        this.dataCriacao = usuarioEntity.getDataCriacao();
        this.status = usuarioEntity.getStatus();
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}