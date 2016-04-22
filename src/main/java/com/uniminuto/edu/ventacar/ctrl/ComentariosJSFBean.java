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
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
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
    @Inject
    CaracteristicaJSFBean caracteristicaJSFBean;
    private String idUsrSel;
    private List<SelectItem> lstItemsUsr = new ArrayList<>();
    private String comentario;
    private List<TablaUsuario> lstTablaUsuarios = new ArrayList<>();
    private TablaUsuario tablaUsuarioSel = new TablaUsuario();

    public void grabarComentario_AE() {
        grabarComentarioXAuto();
        autoJSFBean.cargarCarros();
    }

    public void cargarUsuarios() {
        lstTablaUsuarios.clear();
        lstItemsUsr.clear();
        try {
            String strSql = "SELECT usr_id,    usr_nombre,    usr_correo FROM usuario ORDER BY usr_nombre;";
            Statement st = conMy.createStatement();
            try (ResultSet rs = st.executeQuery(strSql)) {
                while (rs.next()) {
                    Uusario u = new Uusario(rs.getString("usr_id"), rs.getString("usr_nombre"), rs.getString("usr_correo"));

                    lstTablaUsuarios.add(new TablaUsuario(u));
                    lstItemsUsr.add(new SelectItem(u.getUsrId(), u.getUsrNombre()));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void grabarComentarioXAuto() {
        try {
            //fn_insertar_calificacion(p_cmtr_comentario character varying, p_cmrt_fecha timestamp with time zone, p_usr_id character varying, p_car_id bigint)
            String strInsCaract = "{ ? = call fn_insertar_calificacion(?,?,?,?) }";
            CallableStatement pst = conPg.prepareCall(strInsCaract);
            for (TablaCarro tc : autoJSFBean.getLstTablaCarro()) {
                if (tc.isSeleccionado()) {
                    pst.registerOutParameter(1, Types.BOOLEAN);
                    pst.setString(2, comentario);

                    pst.setDate(3, new java.sql.Date(new Date().getTime()));
                    pst.setString(4, idUsrSel);
                    pst.setLong(5, tc.getCarro().getCarId());
                    pst.execute();
                }
            }
            comentario = "";
            selTodoLst(autoJSFBean.getLstTablaCarro(), false);
        } catch (SQLException ex) {
            Logger.getLogger(ComentariosJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            comentario = "";
        }
    }

    @Override
    public void init() {
        try {
            dsPgConexion();
            dsMyConexion();
            autoJSFBean.init();
            caracteristicaJSFBean.init();
            autoJSFBean.cargarCarros();
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

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the idUsrSel
     */
    public String getIdUsrSel() {
        return idUsrSel;
    }

    /**
     * @param idUsrSel the idUsrSel to set
     */
    public void setIdUsrSel(String idUsrSel) {
        this.idUsrSel = idUsrSel;
    }

    /**
     * @return the lstItemsUsr
     */
    public List<SelectItem> getLstItemsUsr() {
        return lstItemsUsr;
    }

    /**
     * @param lstItemsUsr the lstItemsUsr to set
     */
    public void setLstItemsUsr(List<SelectItem> lstItemsUsr) {
        this.lstItemsUsr = lstItemsUsr;
    }

}
