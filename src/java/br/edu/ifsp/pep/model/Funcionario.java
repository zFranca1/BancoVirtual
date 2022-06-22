/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author franca1
 */
@Entity
@DiscriminatorValue(value = "F")
public class Funcionario extends Usuario {

    @Column(name = "senha", nullable = true, length = 255)
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String senha, int codigo, String nome, String cpf, String email, String tipo, Agencia agencia) {
        super(codigo, nome, cpf, email, tipo, agencia);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
