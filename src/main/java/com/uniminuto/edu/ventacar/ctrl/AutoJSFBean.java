/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.ConexionBD;
import com.uniminuto.edu.ventacar.modelo.VntCarro;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;

@SessionScoped
@Named
public class AutoJSFBean extends ConexionBD implements Serializable {

    private byte[] byteArrrayImagen;

    public void listener(FileEntryEvent event) {
        fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        FileEntry fileEntry = (FileEntry) event.getSource();
        FileEntryResults results = fileEntry.getResults();
        for (FileEntryResults.FileInfo fileInfo : results.getFiles()) {
            if (fileInfo.isSaved()) {
                try {

                    //System.out.println("Archivo " + fileInfo.getFileName() + " nombre fiscio " + fileInfo.getFile().getAbsolutePath());
                    Files.copy(Paths.get(fileInfo.getFile().getAbsolutePath()), Paths.get(ec.getRealPath(rutaRecursos + "imagenes"), fileInfo.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                    Files.delete(Paths.get(fileInfo.getFile().getAbsolutePath()));
                    tablaCarroSel.getCarro().setCarFoto(fileInfo.getFileName());
                    byteArrrayImagen = Files.readAllBytes(Paths.get(ec.getRealPath(rutaRecursos + "imagenes"), fileInfo.getFileName()));
                } catch (IOException ex) {
                    Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private List<TablaCarro> lstTablaCarro = new ArrayList<>();
    private TablaCarro tablaCarroSel = new TablaCarro();

    public void guardarCarroAE() {
        guardarCarro();
        cargarCarros();
        tablaCarroSel=null;
        tablaCarroSel=new TablaCarro();
    }

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
        fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
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
                try {
                    tablaCarro.setByteArrrayImagen(Files.readAllBytes(Paths.get(ec.getRealPath(rutaRecursos + "imagenes"), vc.getCarFoto())));
                } catch (IOException ex) {
                    Logger.getLogger(AutoJSFBean.class.getName()).log(Level.SEVERE, null, ex);
                }
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

    /**
     * @return the byteArrrayImagen
     */
    public byte[] getByteArrrayImagen() {
        return byteArrrayImagen;
    }

    /**
     * @param byteArrrayImagen the byteArrrayImagen to set
     */
    public void setByteArrrayImagen(byte[] byteArrrayImagen) {
        this.byteArrrayImagen = byteArrrayImagen;
    }

}
