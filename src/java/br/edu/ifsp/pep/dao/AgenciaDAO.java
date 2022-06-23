/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Agencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author franca1
 */
@Stateless
public class AgenciaDAO {

    @PersistenceContext(unitName = "Banco_Fp2PU")
    private EntityManager em;

    public List<Agencia> buscar() {
        Query query = em.createNamedQuery("Agencia.buscar", Agencia.class);

        return query.getResultList();
    }

    public Agencia buscarNumero(String numero) {
        Query query = em.createNamedQuery("Agencia.buscarCodigoAgencia", Agencia.class);
        query.setParameter("numero", numero);

        try {
            return (Agencia) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }
}
