/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.FuncionarioDAO;
import br.edu.ifsp.pep.model.Funcionario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author franca1
 */
@Named
@SessionScoped
public class FuncionarioController implements Serializable {

    @EJB
    private FuncionarioDAO funcionarioDAO;

    private Funcionario funcionario;
    private Funcionario funcionarioAutenticado = null;

    public void Autenticar() {

        String senha = funcionario.getSenha();

        Funcionario func = funcionarioDAO.autenticacao(funcionario.getEmail(), senha);

        if (func == null) {
            addMessage(FacesMessage.SEVERITY_FATAL, "ERRO", "usuario ou senha invalidos");
            return;
        }

        funcionarioAutenticado = func;
        funcionario = new Funcionario();
        addMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "entrou");

    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionarioAutenticado() {
        return funcionarioAutenticado;
    }

    public void setFuncionarioAutenticado(Funcionario funcionarioAutenticado) {
        this.funcionarioAutenticado = funcionarioAutenticado;
    }

}
