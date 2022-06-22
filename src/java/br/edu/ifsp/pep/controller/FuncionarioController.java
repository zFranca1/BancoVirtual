package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.FuncionarioDAO;
import br.edu.ifsp.pep.model.Funcionario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author franca1
 */
@Named
@SessionScoped
public class FuncionarioController implements Serializable {

    @Inject
    private FuncionarioDAO funcionarioDAO;

    private Funcionario funcionario;

    private Funcionario funcionarioAutenticado = null;

    public FuncionarioController() {
        this.funcionario = new Funcionario();
    }

    public void autenticar() {
        Funcionario f = funcionarioDAO.autenticacao(funcionario.getEmail(), funcionario.getSenha());

        if (f == null) {
            addMessage(FacesMessage.SEVERITY_FATAL, "ERRO", "usuario ou senha invalidos");
            return;
        }

        funcionarioAutenticado = f;
        funcionario = new Funcionario();
        addMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "entrou");
    }

    public void sair() {
        funcionarioAutenticado = null;

    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getfuncionarioAutenticado() {
        return funcionarioAutenticado;
    }

    public void setfuncionarioAutenticado(Funcionario funcionarioAutenticado) {
        this.funcionarioAutenticado = funcionarioAutenticado;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
