/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.TablaBaseFrm;
import com.uniminuto.edu.ventacar.modelo.CmtCalificacion;
import com.uniminuto.edu.ventacar.modelo.VntCarro;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lchacon
 */
public class TablaCarro extends TablaBaseFrm {

    private VntCarro carro = new VntCarro();
    private byte[] byteArrrayImagen;
    private List<TablaCaracteristica> tcXCarro = new ArrayList<>();
    private List<CmtCalificacion> lstCmtCalificacion = new ArrayList<>();

    public TablaCarro() {
    }

    public TablaCarro(VntCarro pCarro) {
        this.carro = pCarro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.carro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TablaCarro other = (TablaCarro) obj;
        if (!Objects.equals(this.carro, other.carro)) {
            return false;
        }
        return true;
    }

    /**
     * @return the carro
     */
    public VntCarro getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(VntCarro carro) {
        this.carro = carro;
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

    /**
     * @return the tcXCarro
     */
    public List<TablaCaracteristica> getTcXCarro() {
        return tcXCarro;
    }

    /**
     * @param tcXCarro the tcXCarro to set
     */
    public void setTcXCarro(List<TablaCaracteristica> tcXCarro) {
        this.tcXCarro = tcXCarro;
    }

    /**
     * @return the lstCmtCalificacion
     */
    public List<CmtCalificacion> getLstCmtCalificacion() {
        return lstCmtCalificacion;
    }

    /**
     * @param lstCmtCalificacion the lstCmtCalificacion to set
     */
    public void setLstCmtCalificacion(List<CmtCalificacion> lstCmtCalificacion) {
        this.lstCmtCalificacion = lstCmtCalificacion;
    }

   

}
