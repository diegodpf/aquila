package com.motom.aquila.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cartao_de_credito")
public class CartaoDeCredito extends Entidade {

    @Column(nullable = false)
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
