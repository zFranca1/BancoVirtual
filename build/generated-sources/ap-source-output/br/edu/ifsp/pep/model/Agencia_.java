package br.edu.ifsp.pep.model;

import br.edu.ifsp.pep.model.Conta;
import br.edu.ifsp.pep.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-06-24T02:57:01")
@StaticMetamodel(Agencia.class)
public class Agencia_ { 

    public static volatile SingularAttribute<Agencia, Integer> codigo;
    public static volatile SingularAttribute<Agencia, String> numero;
    public static volatile SingularAttribute<Agencia, String> nome;
    public static volatile ListAttribute<Agencia, Conta> contas;
    public static volatile ListAttribute<Agencia, Usuario> usuarios;

}