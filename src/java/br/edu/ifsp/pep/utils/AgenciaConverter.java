/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.utils;

import br.edu.ifsp.pep.dao.AgenciaDAO;
import br.edu.ifsp.pep.model.Agencia;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import javax.faces.convert.FacesConverter;

/**
 *
 * @author franca1
 */
@FacesConverter(forClass = Agencia.class)
public class AgenciaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        AgenciaDAO dao = CDI.current().select(AgenciaDAO.class).get();
        Agencia agencia = dao.buscarPorCodigo(Integer.valueOf(string));
        return agencia;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Agencia a = (Agencia) t;
        return String.valueOf(a.getCodigo());
    }
}
