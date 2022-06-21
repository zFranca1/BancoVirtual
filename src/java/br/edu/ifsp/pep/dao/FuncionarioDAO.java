package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Funcionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author franca1
 */
@Stateless
public class FuncionarioDAO {

    @PersistenceContext(unitName = "Banco_Fp2PU")
    private EntityManager em;

    public void inserir(Funcionario f) {
        em.persist(f);
    }

    public void remover(Funcionario f) {
        em.remove(f);
    }

    public Funcionario autenticacao(String email, String senha) {

        Query query = em.createNamedQuery("Funcionario.autenticacao", Funcionario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        try {
            return (Funcionario) query.getSingleResult();

        } catch (NoResultException ex) {
            return null;
        }
    }

}
