package com.motom.aquila.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria extends Entidade {

    @Column(nullable = false)
    private String agencia;

    @Column(nullable = false)
    private String conta;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
