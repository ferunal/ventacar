/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.ConexionBD;
import com.uniminuto.edu.ventacar.modelo.Uusario;
import com.uniminuto.edu.ventacar.modelo.VntCaracteristicas;
import com.uniminuto.edu.ventacar.modelo.VntTipocrt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ComentariosJSFBean extends ConexionBD {

    @Inject
    AutoJSFBean autoJSFBean;

    private List<TablaUsuario> lstTablaUsuarios = new ArrayList<>();
    private TablaUsuario tablaUsuarioSel = new TablaUsuario();

    public void cargarUsuarios() {
        lstTablaUsuarios.clear();
        try {
            String strSql = "SELECT usr_id,    usr_nombre,    usr_correo FROM usuario ORDER BY usr_nombre;";
            Statement st = conMy.createStatement();
            try (ResultSet rs = st.executeQuery(strSql)) {
                while (rs.next()) {
                    Uusario u = new Uusario(rs.getString("usr_id"), rs.getString("usr_nombre"), rs.getString("usr_correo"));
                    
                    lstTablaUsuarios.add(new TablaUsuario(u));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void grabarComentarioXAuto() {

    }

    @Override
    public void init() {
        try {
            dsPgConexion();
            dsMyConexion();

        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    /**
     * @return the lstTablaUsuarios
     */
    public List<TablaUsuario> getLstTablaUsuarios() {
        return lstTablaUsuarios;
    }

    /**
     * @param lstTablaUsuarios the lstTablaUsuarios to set
     */
    public void setLstTablaUsuarios(List<TablaUsuario> lstTablaUsuarios) {
        this.lstTablaUsuarios = lstTablaUsuarios;
    }

    /**
     * @return the tablaUsuarioSel
     */
    public TablaUsuario getTablaUsuarioSel() {
        return tablaUsuarioSel;
    }

    /**
     * @param tablaUsuarioSel the tablaUsuarioSel to set
     */
    public void setTablaUsuarioSel(TablaUsuario tablaUsuarioSel) {
        this.tablaUsuarioSel = tablaUsuarioSel;
    }

}
