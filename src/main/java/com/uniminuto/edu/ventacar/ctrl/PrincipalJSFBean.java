/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.BaseJSFBean;
import javax.annotation.PostConstruct;
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
    @Inject
    CaracteristicaJSFBean caracteristicaJSFBean;
    @Inject
    CaractXCarJSFBean caractXCarJSFBean;
    @Inject
    ComentariosJSFBean comentariosJSFBean;

    public void navAuto_AE() {
        autoJSFBean.init();

    }

    public void navCaract_AE() {
        caracteristicaJSFBean.init();
    }

    public void navCxc_AE() {
        caracteristicaJSFBean.init();
        autoJSFBean.init();
        caractXCarJSFBean.init();
        caracteristicaJSFBean.cargarCaracts();
        autoJSFBean.cargarCarros();
    }

    public void inicio_AE() {
        caracteristicaJSFBean.limpiarVariables();
        autoJSFBean.limpiarVariables();
        caractXCarJSFBean.limpiarVariables();
        comentariosJSFBean.limpiarVariables();
    }

    public void navomentarios_AE() {
        comentariosJSFBean.init();
        comentariosJSFBean.cargarUsuarios();

        caractXCarJSFBean.init();
    }

    @PostConstruct
    @Override
    public void init() {
        comentariosJSFBean.init();
        comentariosJSFBean.cargarUsuarios();
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
