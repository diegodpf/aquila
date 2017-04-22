package com.motom.aquila.models;


import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario extends Entidade {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String senha;

    @OneToOne
    @JoinColumn(name = "conta_bancaria_id")
    private ContaBancaria contaBancaria;

    @Embedded
    private Localizacao localizacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
