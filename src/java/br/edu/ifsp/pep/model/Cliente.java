package br.edu.ifsp.pep.model;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author franca1
 */
@Entity
@DiscriminatorValue(value = "C")
@NamedQueries({
    @NamedQuery(name = "Cliente.buscar", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.buscarCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
})

public class Cliente extends Usuario {

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Conta> contas;

    public Cliente() {

    }

    public Cliente(int codigo, String nome, String cpf, String email, String tipo, Agencia agencia) {
        super(codigo, nome, cpf, email, tipo, agencia);

    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}
