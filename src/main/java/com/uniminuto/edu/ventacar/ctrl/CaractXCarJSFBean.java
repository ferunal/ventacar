/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.ConexionBD;
import com.uniminuto.edu.ventacar.modelo.VntCaracteristicas;
import com.uniminuto.edu.ventacar.modelo.VntCarcactxauto;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
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
public class CaractXCarJSFBean extends ConexionBD {

    @Inject
    AutoJSFBean autoJSFBean;
    @Inject
    CaracteristicaJSFBean caracteristicaJSFBean;

    List<TablaCaracteristica> lstCaracteristicas = new ArrayList<>();
    List<TablaCarro> lstTablaCarros = new ArrayList<>();

    public void guardarCaractXAuto_AE() {
        guardarCaracXAuto();
        autoJSFBean.cargarCarros();
    }

    private void guardarCaracXAuto() {
        lstCaracteristicas = caracteristicaJSFBean.getLstTablaCaract();
        lstTablaCarros = autoJSFBean.getLstTablaCarro();
        String strInsCaract = "{ ? = call fn_insertar_caracxauto(?,?) }";

        try {
            CallableStatement pst = conPg.prepareCall(strInsCaract);
            for (TablaCarro tablaCarro : lstTablaCarros) {
                if (tablaCarro.isSeleccionado()) {
                    for (TablaCaracteristica tablaCaracteristica : lstCaracteristicas) {
                        if (tablaCaracteristica.isSeleccionado()) {
                            pst.registerOutParameter(1, Types.BOOLEAN);
                            pst.setLong(2, tablaCarro.getCarro().getCarId());
                            pst.setLong(3, tablaCaracteristica.getCaracteristica().getCrtcId());
                            pst.execute();
                        }
                    }
                }

            }
            selTodoLst(caracteristicaJSFBean.getLstTablaCaract(), false);
            selTodoLst(autoJSFBean.getLstTablaCarro(), false);
        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  

    @Override
    public void init() {
        try {
            dsMyConexion();
            dsPgConexion();
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void limpiarVariables() {
        try {
            cerrarMyConexion();
            cerrarPgConexion();
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

}
