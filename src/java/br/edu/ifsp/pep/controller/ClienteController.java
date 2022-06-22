/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ClienteDAO;
import br.edu.ifsp.pep.dao.UsuarioDAO;
import br.edu.ifsp.pep.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author franca1
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

    @Inject
    private ClienteDAO clienteDAO;
    @Inject
    private UsuarioDAO usuarioDAO;

    private Cliente cliente;
    private Cliente clienteSelecionado;
    private List<Cliente> clientes;

    public ClienteController() {
        this.cliente = new Cliente();
    }

    public void cadastroCliente() {

        this.clienteDAO.inserir(cliente);
        this.cliente = new Cliente();
        this.clientes = null;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public List<Cliente> getClientes() {
        if (clientes == null) {

            this.clientes = clienteDAO.buscar();
            return clientes;
        }

        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
