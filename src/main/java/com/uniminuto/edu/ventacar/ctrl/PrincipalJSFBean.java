/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.BaseJSFBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fercris
 */
@SessionScoped
@Named
public class PrincipalJSFBean extends BaseJSFBean {

    @Inject
    AutoJSFBean autoJSFBean;

    public void navAuto_AE() {
        autoJSFBean.init();
    }

    @Override
    public void init() {

    }

    @Override
    public void limpiarVariables() {
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

}
