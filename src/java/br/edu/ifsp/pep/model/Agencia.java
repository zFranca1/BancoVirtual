package br.edu.ifsp.pep.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author franca1
 */
@Entity
@Table(name = "agencia")
@NamedQueries({
    @NamedQuery(name = "Agencia.buscar", query = "SELECT a FROM Agencia a"),
    @NamedQuery(name = "Agencia.buscarCodigoAgencia", query = "SELECT a FROM Agencia a WHERE a.numero = :numero")

})
public class Agencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome", nullable = false, length = 20, unique = true)
    private String nome;

    @Column(name = "numero", nullable = false, length = 5, unique = true)
    private String numero;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "agencia", fetch = FetchType.EAGER)
    private List<Conta> contas;

    public Agencia() {
    }

    public Agencia(int codigo, String nome, String numero, List<Usuario> usuarios, List<Conta> contas) {
        this.codigo = codigo;
        this.nome = nome;
        this.numero = numero;
        this.usuarios = usuarios;
        this.contas = contas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agencia other = (Agencia) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
