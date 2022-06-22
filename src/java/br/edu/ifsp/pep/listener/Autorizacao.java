/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.FuncionarioController;
import br.edu.ifsp.pep.model.Funcionario;
import br.edu.ifsp.pep.utils.Rotas;
import java.io.IOException;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author franca1
 */
public class Autorizacao implements PhaseListener {

    @Inject
    private FuncionarioController funcionarioController;

    @Override
    public void afterPhase(PhaseEvent pe) {

        HttpServletRequest request = (HttpServletRequest) pe.getFacesContext().getExternalContext().getRequest();

        Funcionario funcionarioAutenticado = funcionarioController.getfuncionarioAutenticado();

        if ((funcionarioAutenticado == null) && !Rotas.rotaValida('p', request.getServletPath())) {
            try {
                pe.getFacesContext().getExternalContext().redirect("/Banco_Fp2/index.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return;
        }

        if (funcionarioAutenticado != null && !Rotas.rotaValida('f', request.getServletPath())) {
            try {
                pe.getFacesContext().getExternalContext().redirect("/Banco_Fp2/funcionario/homeFuncionario.xhtml");
            } catch (IOException e) {
                e.printStackTrace();

            }
            return;
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {

    }

    @Override
    public PhaseId getPhaseId() {

        return PhaseId.ANY_PHASE;

    }

}
