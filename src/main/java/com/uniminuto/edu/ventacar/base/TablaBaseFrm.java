package com.uniminuto.edu.ventacar.base;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author lchacon
 */
public abstract class TablaBaseFrm implements Serializable {

    protected boolean seleccionado = false;
    protected String claseSel = "";
    protected String claseError = "";
    protected boolean blnEditar = false;
    protected boolean blnNuevo = false;
    protected String strEstado = "";
    protected String claseEst = "";
    protected String estiloFila = "";

    /**
     * @return the seleccionado
     */
    public boolean isSeleccionado() {
        return seleccionado;
    }

    /**
     * @param seleccionado the seleccionado to set
     */
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    /**
     * @return the claseSel
     */
    public String getClaseSel() {
        return claseSel;
    }

    /**
     * @param claseSel the claseSel to set
     */
    public void setClaseSel(String claseSel) {
        this.claseSel = claseSel;
    }

    /**
     * @return the claseError
     */
    public String getClaseError() {
        return claseError;
    }

    /**
     * @param claseError the claseError to set
     */
    public void setClaseError(String claseError) {
        this.claseError = claseError;
    }

    /**
     * @return the blnEditar
     */
    public boolean isBlnEditar() {
        return blnEditar;
    }

    /**
     * @param blnEditar the blnEditar to set
     */
    public void setBlnEditar(boolean blnEditar) {
        this.blnEditar = blnEditar;
    }

    /**
     * @return the blnNuevo
     */
    public boolean isBlnNuevo() {
        return blnNuevo;
    }

    /**
     * @param blnNuevo the blnNuevo to set
     */
    public void setBlnNuevo(boolean blnNuevo) {
        this.blnNuevo = blnNuevo;
    }

    /**
     * @return the strEstado
     */
    public String getStrEstado() {
        return strEstado;
    }

    /**
     * @param strEstado the strEstado to set
     */
    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    /**
     * @return the claseEst
     */
    public String getClaseEst() {
        return claseEst;
    }

    /**
     * @param claseEst the claseEst to set
     */
    public void setClaseEst(String claseEst) {
        this.claseEst = claseEst;
    }

    /**
     * @return the estiloFila
     */
    public String getEstiloFila() {
        return estiloFila;
    }

    /**
     * @param estiloFila the estiloFila to set
     */
    public void setEstiloFila(String estiloFila) {
        this.estiloFila = estiloFila;
    }

}
