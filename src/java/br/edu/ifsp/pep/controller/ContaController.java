package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ClienteDAO;
import br.edu.ifsp.pep.dao.ContaDAO;
import br.edu.ifsp.pep.model.Cliente;
import br.edu.ifsp.pep.model.Conta;
import br.edu.ifsp.pep.model.ContaEspecial;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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
public class ContaController implements Serializable {

    @Inject
    private ClienteDAO clienteDAO;
    @Inject
    private ContaDAO contaDAO;

    private ContaEspecial conta;

    private Conta contaAutenticada = null;

    private List<Conta> contas;

    public ContaController() {
        this.conta = new ContaEspecial();
        conta.setCliente(new Cliente());

    }

    public void abrirConta() {
        this.conta = new ContaEspecial();
    }

    public void adicionar() {

        Cliente c = clienteDAO.buscarCPF(conta.getCliente().getCpf());
        if (c == null) {

            return;

        }

        conta.setCliente(c);

        Conta cc = contaDAO.buscar(conta.getNumero(), conta.getAgencia());

        if (cc == null) {

            return;
        }

        if (conta.getLimite() <= 0) {
            contaDAO.insert(conta.toConvecional());
        } else {
            contaDAO.insert(conta);
        }

        conta = new ContaEspecial();
        conta.setCliente(new Cliente());

        return;
    }

    public void autenticar() throws IOException {

        Conta c = contaDAO.autenticar(conta.getNumero(), conta.getSenha());

        if (c == null) {
            addMessage(FacesMessage.SEVERITY_FATAL, "ERRO", "usuario ou senha invalidos");
            return;
        }

        contaAutenticada = c;
        conta = new ContaEspecial();
        addMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "entrou");
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Banco_Fp2/cliente/home.xhtml");
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public ContaDAO getContaDAO() {
        return contaDAO;
    }

    public void setContaDAO(ContaDAO contaDAO) {
        this.contaDAO = contaDAO;
    }

    public ContaEspecial getConta() {
        return conta;
    }

    public void setConta(ContaEspecial conta) {
        this.conta = conta;
    }

    public Conta getContaAutenticada() {
        return contaAutenticada;
    }

    public List<Conta> getContas() {
        if (contas == null) {

            this.contas = contaDAO.buscarTodos();
            return contas;
        }

        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void setContaAutenticada(Conta contaAutenticada) {
        this.contaAutenticada = contaAutenticada;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
