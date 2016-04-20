/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.ConexionBD;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class AutoJSFBean extends ConexionBD implements Serializable {

    private List<TablaCarro> lstTablaCarro = new ArrayList<>();
    private TablaCarro tablaCarroSel = new TablaCarro();

    private void guardarCarro() {
        try {
            String strInsCaract = "{ ? = call fn_insertar_auto(?,?) }";
            CallableStatement pst = conPg.prepareCall(strInsCaract);
            pst.registerOutParameter(1, Types.BOOLEAN);
            pst.setString(2, tablaCarroSel.getCarro().getCarNombre());
            pst.setString(3, tablaCarroSel.getCarro().getCarFoto());
            pst.execute();
            boolean ejec = pst.getBoolean(1);
        } catch (SQLException ex) {
            Logger.getLogger(CaracteristicaJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the lstTablaCarro
     */
    public List<TablaCarro> getLstTablaCarro() {
        return lstTablaCarro;
    }

    /**
     * @param lstTablaCarro the lstTablaCarro to set
     */
    public void setLstTablaCarro(List<TablaCarro> lstTablaCarro) {
        this.lstTablaCarro = lstTablaCarro;
    }

    /**
     * @return the tablaCarroSel
     */
    public TablaCarro getTablaCarroSel() {
        return tablaCarroSel;
    }

    /**
     * @param tablaCarroSel the tablaCarroSel to set
     */
    public void setTablaCarroSel(TablaCarro tablaCarroSel) {
        this.tablaCarroSel = tablaCarroSel;
    }

}
