package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.AgenciaDAO;
import br.edu.ifsp.pep.model.Agencia;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author franca1
 */
@Named
@ViewScoped
public class AgenciaController implements Serializable {

    @EJB
    private AgenciaDAO agenciaDAO;

    private List<Agencia> agencias;

    public AgenciaController() {

    }

    public AgenciaDAO getAgenciaDAO() {
        return agenciaDAO;
    }

    public void setAgenciaDAO(AgenciaDAO agenciaDAO) {
        this.agenciaDAO = agenciaDAO;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

}
