/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lchacon
 */
public class VntTipocrt implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tpcrId;
    private String tpcrNombre;
    private List<VntCaracteristicas> vntCaracteristicasList;

    public VntTipocrt() {
    }

    public VntTipocrt(Integer tpcrId) {
        this.tpcrId = tpcrId;
    }

    public Integer getTpcrId() {
        return tpcrId;
    }

    public void setTpcrId(Integer tpcrId) {
        this.tpcrId = tpcrId;
    }

    public String getTpcrNombre() {
        return tpcrNombre;
    }

    public void setTpcrNombre(String tpcrNombre) {
        this.tpcrNombre = tpcrNombre;
    }

    
    public List<VntCaracteristicas> getVntCaracteristicasList() {
        return vntCaracteristicasList;
    }

    public void setVntCaracteristicasList(List<VntCaracteristicas> vntCaracteristicasList) {
        this.vntCaracteristicasList = vntCaracteristicasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpcrId != null ? tpcrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntTipocrt)) {
            return false;
        }
        VntTipocrt other = (VntTipocrt) object;
        if ((this.tpcrId == null && other.tpcrId != null) || (this.tpcrId != null && !this.tpcrId.equals(other.tpcrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.ventacar.modelo.VntTipocrt[ tpcrId=" + tpcrId + " ]";
    }

}
