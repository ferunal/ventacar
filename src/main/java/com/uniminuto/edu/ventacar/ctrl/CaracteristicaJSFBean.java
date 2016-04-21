/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.ConexionBD;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@SessionScoped
@Named
public class CaracteristicaJSFBean extends ConexionBD implements Serializable {

    private List<TablaCaracteristica> lstTablaCaract = new ArrayList<>();
    private TablaCaracteristica tablaCaractSel = new TablaCaracteristica();

    private void guardarCaracteristica() {
        try {
            String strInsCaract = "{ ? = call fn_insertar_caracterisitca(?,?) }";
            CallableStatement pst = conPg.prepareCall(strInsCaract);
            pst.registerOutParameter(1, Types.BOOLEAN);
            pst.setString(2, tablaCaractSel.getCaracteristica().getCrtcDescripcion());
            pst.setInt(3, tablaCaractSel.getCaracteristica().getTpcrId().getTpcrId());
            pst.execute();
            boolean ejec = pst.getBoolean(1);
        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void init() {
        try {
            dsPgConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limbiarVariables() {
        try {
            cerrarPgConexion();
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
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }
}
