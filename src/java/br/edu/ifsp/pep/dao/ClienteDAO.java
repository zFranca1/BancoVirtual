/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Cliente;
import java.util.List;
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
public class ClienteDAO {

    @PersistenceContext(unitName = "Banco_Fp2PU")
    private EntityManager em;

    public void inserir(Cliente c) {
        em.persist(c);
    }

    public List<Cliente> buscar() {
        Query query = em.createNamedQuery("Cliente.buscar", Cliente.class);

        return query.getResultList();
    }

    public Cliente buscarCPF(String cpf) {
        Query query = em.createNamedQuery("Cliente.buscarCpf", Cliente.class);
        query.setParameter("cpf", cpf);

        try {
            return (Cliente) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
