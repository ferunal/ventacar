/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.ConexionBD;
import com.uniminuto.edu.ventacar.modelo.VntCarro;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void cargarCarros() {
        lstTablaCarro.clear();
        try {
            String strSql = "SELECT car_id, car_nombre, car_foto, car_est  FROM public.vnt_carro ORDER BY car_nombre";
            Statement st = conPg.createStatement();
            ResultSet rs = st.executeQuery(strSql);
            while (rs.next()) {
                VntCarro vc = new VntCarro(rs.getLong("car_id"));
                vc.setCarNombre(rs.getString("car_nombre"));
                vc.setCarFoto(rs.getString("car_foto"));
                vc.setCarEst(rs.getBoolean("car_est"));
                TablaCarro tablaCarro = new TablaCarro(vc);
                lstTablaCarro.add(tablaCarro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
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
