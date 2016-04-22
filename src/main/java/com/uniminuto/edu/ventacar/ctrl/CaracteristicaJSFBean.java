/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.ConexionBD;
import com.uniminuto.edu.ventacar.modelo.VntCaracteristicas;
import com.uniminuto.edu.ventacar.modelo.VntTipocrt;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@SessionScoped
@Named
public class CaracteristicaJSFBean extends ConexionBD implements Serializable {

    private Integer tipoCarSel;
    private List<SelectItem> lstItemsTipoCaract = new ArrayList<>();
    private List<TablaCaracteristica> lstTablaCaract = new ArrayList<>();

    private TablaCaracteristica tablaCaractSel = new TablaCaracteristica();

    public void guardarCaractAE() {
        guardarCaracteristica();
        cargarCaracts();
    }

    private void guardarCaracteristica() {
        try {
            String strInsCaract = "{ ? = call fn_insertar_caracterisitca(?,?) }";
            CallableStatement pst = conPg.prepareCall(strInsCaract);
            pst.registerOutParameter(1, Types.BOOLEAN);
            pst.setString(2, tablaCaractSel.getCaracteristica().getCrtcDescripcion());
            pst.setInt(3, tipoCarSel);
            pst.execute();
            boolean ejec = pst.getBoolean(1);
        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarCaracts() {

        lstTablaCaract.clear();
        try {
            String strSql = "SELECT c.crtc_id, c.crtc_descripcion, c.crtc_est, t.tpcr_id , t.tpcr_nombre  FROM vnt_caracteristicas c INNER JOIN vnt_tipocrt t ON c.tpcr_id = t.tpcr_id ORDER BY crtc_descripcion";
            Statement st = conPg.createStatement();
            ResultSet rs = st.executeQuery(strSql);
            while (rs.next()) {
                VntCaracteristicas vc = new VntCaracteristicas(rs.getLong("crtc_id"));
                vc.setCrtcDescripcion(rs.getString("crtc_descripcion"));
                VntTipocrt vt = new VntTipocrt(rs.getInt("tpcr_id"));
                vt.setTpcrNombre(rs.getString("tpcr_nombre"));
                vc.setTpcrId(vt);
                vc.setCrtcEst(rs.getBoolean("crtc_est"));

                lstTablaCaract.add(new TablaCaracteristica(vc));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TablaCaracteristica> cargarCaractsXAuto(Long pCarId) {
        List<TablaCaracteristica> lstTablaCaractXAuto = new ArrayList<>();

        try {
            String strSql = "SELECT c.crtc_id, c.crtc_descripcion, c.crtc_est, t.tpcr_id , t.tpcr_nombre "
                    + " FROM vnt_caracteristicas c INNER JOIN vnt_tipocrt t ON c.tpcr_id = t.tpcr_id "
                    + "INNER JOIN vnt_carcactxauto cxa ON c.crtc_id = cxa.crtc_id "
                    + "WHERE cxa.car_id = ? ORDER BY crtc_descripcion";
            PreparedStatement st = conPg.prepareStatement(strSql);
            st.setLong(1, pCarId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                VntCaracteristicas vc = new VntCaracteristicas(rs.getLong("crtc_id"));
                vc.setCrtcDescripcion(rs.getString("crtc_descripcion"));
                VntTipocrt vt = new VntTipocrt(rs.getInt("tpcr_id"));
                vt.setTpcrNombre(rs.getString("tpcr_nombre"));
                vc.setTpcrId(vt);
                vc.setCrtcEst(rs.getBoolean("crtc_est"));

                lstTablaCaractXAuto.add(new TablaCaracteristica(vc));
            }
            return lstTablaCaractXAuto;
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    private void cargarTipoCaract() {

        lstItemsTipoCaract.clear();
        lstItemsTipoCaract.add(itemSeleccioneInt);
        try {
            String strSql = "SELECT tpcr_id, tpcr_nombre  FROM vnt_tipocrt ORDER BY  tpcr_nombre;";
            Statement st = conPg.createStatement();
            ResultSet rs = st.executeQuery(strSql);
            while (rs.next()) {
                lstItemsTipoCaract.add(new SelectItem(rs.getInt("tpcr_id"), rs.getString("tpcr_nombre")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void init() {
        try {
            dsPgConexion();
            cargarTipoCaract();
            cargarCaracts();
        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the lstTablaCaract
     */
    public List<TablaCaracteristica> getLstTablaCaract() {
        return lstTablaCaract;
    }

    /**
     * @param lstTablaCaract the lstTablaCaract to set
     */
    public void setLstTablaCaract(List<TablaCaracteristica> lstTablaCaract) {
        this.lstTablaCaract = lstTablaCaract;
    }

    /**
     * @return the tablaCaractSel
     */
    public TablaCaracteristica getTablaCaractSel() {
        return tablaCaractSel;
    }

    /**
     * @param tablaCaractSel the tablaCaractSel to set
     */
    public void setTablaCaractSel(TablaCaracteristica tablaCaractSel) {
        this.tablaCaractSel = tablaCaractSel;
    }

    @Override
    public void limpiarVariables() {
        try {
            cerrarPgConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    /**
     * @return the tipoCarSel
     */
    public Integer getTipoCarSel() {
        return tipoCarSel;
    }

    /**
     * @param tipoCarSel the tipoCarSel to set
     */
    public void setTipoCarSel(Integer tipoCarSel) {
        this.tipoCarSel = tipoCarSel;
    }

    /**
     * @return the lstItemsTipoCaract
     */
    public List<SelectItem> getLstItemsTipoCaract() {
        return lstItemsTipoCaract;
    }

    /**
     * @param lstItemsTipoCaract the lstItemsTipoCaract to set
     */
    public void setLstItemsTipoCaract(List<SelectItem> lstItemsTipoCaract) {
        this.lstItemsTipoCaract = lstItemsTipoCaract;
    }

}
