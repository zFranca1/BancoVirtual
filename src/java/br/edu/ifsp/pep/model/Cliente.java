package br.edu.ifsp.pep.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author franca1
 */
@Entity
@DiscriminatorValue(value = "C")
public class Cliente extends Usuario {

//    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
//    private List<Conta> contas;
    
    
    
    
}
