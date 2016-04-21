/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.base;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

/**
 *
 * @author Luis Fernando
 */
public abstract class ConexionBD implements Serializable {

    protected SelectItem itemSeleccioneStr = new SelectItem("-1", "Seleccione>>");
    protected SelectItem itemSeleccioneInt = new SelectItem(-1, "Seleccione>>");
    protected SelectItem itemSeleccioneLng = new SelectItem(-1l, "Seleccione>>");
    protected FacesContext fc = FacesContext.getCurrentInstance();
    protected ELContext elc;
    protected Integer numPanel = 1;
    protected String strPagId = "";
    protected boolean blnImgError = false;
    protected String strDetalleIncons = "";
    protected Connection conPg;
    protected Connection conMy;

    public Integer getNumPanel() {
        return numPanel;
    }

    public void setNumPanel(Integer numPanel) {
        this.numPanel = numPanel;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones Comunes">
    protected void dsPgConexion() throws SQLException {
        PGSimpleDataSource pgDs = new PGSimpleDataSource();
        pgDs.setServerName("localhost");
        pgDs.setDatabaseName("ventacar");
        pgDs.setUser("uniminuto");
        pgDs.setPassword("uniminuto");
        pgDs.setPortNumber(5432);
        conPg = pgDs.getConnection();
    }

    protected void dsMyConexion() throws SQLException {
        MysqlDataSource mds = new MysqlDataSource();
        mds.setURL("jdbc:mysql://localhost:3306/usuarios");
        mds.setUser("uniminuto");
        mds.setPassword("uniminuto");
        conMy = mds.getConnection();
    }

    protected void cerrarPgConexion() throws SQLException {
        conPg.close();
    }

    protected void cerrarMyConexion() throws SQLException {
        conMy.close();
    }

    protected boolean esNumero(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() > 1) {
                i++;
            } else {
                return false;
            }
        }
        for (; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones Abstractas">
    public abstract void init();

    public abstract void limpiarVariables();

    public abstract void navegacionLateral_ActionEvent(ActionEvent ae);

    public abstract boolean validarFormulario();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="manejo fecha">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="manejo listas">
    public Long cantElemSelLista(List<? extends TablaBaseFrm> lst) {

        return lst.stream().filter(p -> p.isSeleccionado()).count();

    }

    /**
     * Eliminar los elementos seleccionados de una tabla
     *
     * @param lst
     * @return Lista de elementos eliminados para hacer las operaciones
     * correspondientes
     */
    protected List retirarElemTabla(List<? extends TablaBaseFrm> lst) {
        List lstRerirar = new ArrayList();
        lst.stream().filter(p -> p.isSeleccionado()).forEach(p -> lstRerirar.add(p));
        lst.removeAll(lstRerirar);

        return lstRerirar;
    }

    /**
     * Resaltar la fila seleccionada de una tabla, la lista debe ser de objetos
     * que hereden de la clase TablaBaseGrid
     *
     * @param lst
     * @param objSel
     */
    public void resaltarFilaTabla(List<? extends TablaBaseFrm> lst, TablaBaseFrm objSel) {
        lst.stream().forEach(p -> {
            if (p.equals(objSel)) {
                p.setSeleccionado(true);
                p.setClaseSel("seleccione");
            } else {
                p.setSeleccionado(false);
                p.setClaseSel("");
            }
        });

    }

    /**
     * Cambiar el estado del campo seleccionado de una lista tipo tabla
     *
     * @param lst Lista
     * @param sel estado del campo
     */
    protected void selTodoLst(List<? extends TablaBaseFrm> lst, boolean sel) {
        lst.stream().forEach(p -> p.setSeleccionado(sel));

    }
    //</editor-fold>

}
