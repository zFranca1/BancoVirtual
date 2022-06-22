package br.edu.ifsp.pep.model;

import br.edu.ifsp.pep.model.Agencia;
import br.edu.ifsp.pep.model.Cliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-06-22T18:08:25")
@StaticMetamodel(Conta.class)
public class Conta_ { 

    public static volatile SingularAttribute<Conta, String> senha;
    public static volatile SingularAttribute<Conta, Cliente> cliente;
    public static volatile SingularAttribute<Conta, Integer> codigo;
    public static volatile SingularAttribute<Conta, String> numero;
    public static volatile SingularAttribute<Conta, Float> saldo;
    public static volatile SingularAttribute<Conta, Agencia> agencia;
    public static volatile SingularAttribute<Conta, String> senhaConfirmacao;

}