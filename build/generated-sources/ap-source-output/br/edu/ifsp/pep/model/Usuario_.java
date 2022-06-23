package br.edu.ifsp.pep.model;

import br.edu.ifsp.pep.model.Agencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-06-23T03:00:47")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> codigo;
    public static volatile SingularAttribute<Usuario, String> tipo;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, Agencia> agencia;

}