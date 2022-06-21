package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.FuncionarioDAO;
import br.edu.ifsp.pep.model.Funcionario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.message.Message;

/**
 *
 * @author franca1
 */
@Named
@SessionScoped
public class FuncionarioController implements Serializable {

    @EJB
    private Funcionario funcionario;
    private FuncionarioDAO funcionarioDAO;
    private Funcionario funcionarioAutenticado = null;

    public FuncionarioController() {

        this.funcionario = new Funcionario();
    }

    public void autenticar() {

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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public Funcionario getFuncionarioAutenticado() {
        return funcionarioAutenticado;
    }

    public void setFuncionarioAutenticado(Funcionario funcionarioAutenticado) {
        this.funcionarioAutenticado = funcionarioAutenticado;
    }

}
