package br.edu.ifsp.pep.utils;

import br.edu.ifsp.pep.model.Conta;

/**
 *
 * @author franca1
 */
public class Rotas {

    public static final String[] publica_rota = new String[]{"/funcionario/index.xhtml", "/index.xhtml"};
    public static final String[] funcionario_rota = new String[]{"/funcionario/homeFuncionario.xhtml", "/funcionario/cliente.xhtml", "/funcionario/agencia.xhtml", "/funcionario/novoCliente.xhtml"};
    public static final String[] cliente_rota = new String[]{"/homeCliente.xhtml"};

    public static boolean rotaValida(String destino) {

        for (String rota : publica_rota) {
            if (rota.equals(destino)) {
                return true;
            }

        }

        return false;

    }

    public static boolean rotaValida(char tipo, String destino) {

        String[] rotas = null;

        switch (tipo) {

            case 'p':
                rotas = publica_rota;
                break;

            case 'f':
                rotas = funcionario_rota;
                break;

            case 'c':
                rotas = cliente_rota;
                break;
        }

        for (String rota : rotas) {
            System.out.println(rota + "=" + destino);
            if (rota.equals(destino)) {
                return true;
            }

        }
        return false;
    }

    public static boolean valida_rota(Conta c, String destino) {
        if (c != null) {
            return false;
        };

        for (String rota : cliente_rota) {
            if (rota.equals(destino)) {
                return true;
            }
        }

        return false;
    }

}
