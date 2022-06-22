/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Agencia;
import br.edu.ifsp.pep.model.Conta;
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
public class ContaDAO {

    @PersistenceContext(unitName = "Banco_Fp2PU")
    private EntityManager em;

    public void insert(Conta c) {
        em.persist(c);
    }

    public Conta buscar(String numero, Agencia agencia) {
        Query query = em.createNamedQuery("Conta.busca", Conta.class);
        query.setParameter("numero", numero);
        query.setParameter("agencia", agencia);

        try {
            return (Conta) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Conta autenticar(String numero, Agencia agencia, String senha) {
        Query query = em.createNamedQuery("Conta.autentica", Conta.class);
        query.setParameter("numero", numero);
        query.setParameter("agencia", agencia);
        query.setParameter("senha", senha);

        try {
            return (Conta) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
