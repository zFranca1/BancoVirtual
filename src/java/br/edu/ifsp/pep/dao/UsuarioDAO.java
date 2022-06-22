/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author franca1
 */
@Stateless
public class UsuarioDAO {

    @PersistenceContext(unitName = "Banco_Fp2PU")
    private EntityManager em;

    public List<Usuario> buscar() {

        return em.createQuery("Select u FROM Usuario u",
                Usuario.class).getResultList();
    }
}
