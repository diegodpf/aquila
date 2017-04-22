package com.motom.aquila.models;


import javax.persistence.*;

@Entity
@Table(name = "vigilante")
public class Vigilante extends Entidade {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnh;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private StatusVigilante statusVigilante;

    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

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

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusVigilante getStatusVigilante() {
        return statusVigilante;
    }

    public void setStatusVigilante(StatusVigilante statusVigilante) {
        this.statusVigilante = statusVigilante;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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
