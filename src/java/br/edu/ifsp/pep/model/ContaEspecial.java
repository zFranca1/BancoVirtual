/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author franca1
 */
@Entity
@DiscriminatorValue("E")
public class ContaEspecial extends Conta {

    @Column(name = "limite", nullable = true, columnDefinition = "Decimal(10,2)")
    private float limite;

    public ContaEspecial() {
    }

    public ContaEspecial(float limite) {
        this.limite = limite;
    }

    public ContaEspecial(float limite, int codigo, String numero, Agencia agencia, float saldo, String senha, String senhaConfirmacao, Cliente cliente) {
        super(codigo, numero, agencia, saldo, senha, senhaConfirmacao, cliente);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public Conta toConvecional() {

        return new Conta(this.getCodigo(), this.getNumero(), this.getAgencia(), this.getSaldo(), this.getSenha(), this.getSenhaConfirmacao(), this.getCliente());

    }

}
