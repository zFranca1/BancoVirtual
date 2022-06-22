package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.ClienteDAO;
import br.edu.ifsp.pep.dao.ContaDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author franca1
 */

@Named
@SessionScoped
public class ContaController implements Serializable{
    
    @Inject
    private ClienteDAO clienteDAO;
    @Inject
    private ContaDAO contaDAO;
    
    public ContaController(){
//        this.conta
    
    
    }
    
    
    
    
}
