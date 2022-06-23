package br.edu.ifsp.pep.listener;

import br.edu.ifsp.pep.controller.ContaController;
import br.edu.ifsp.pep.controller.FuncionarioController;
import br.edu.ifsp.pep.model.Conta;
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

    @Inject
    private ContaController contaController;

    @Override
    public void afterPhase(PhaseEvent pe) {

        HttpServletRequest request = (HttpServletRequest) pe.getFacesContext().getExternalContext().getRequest();

        Funcionario funcionarioAutenticado = funcionarioController.getfuncionarioAutenticado();

        Conta contaAutenticada = contaController.getContaAutenticada();

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

        if (contaAutenticada != null && !Rotas.rotaValida('c', request.getServletPath())) {
            try {
                pe.getFacesContext().getExternalContext().redirect("/Banco_Fp2/cliente/homeCliente.xhtml");

            } catch (Exception e) {
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
