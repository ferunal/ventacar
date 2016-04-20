/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.modelo;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lchacon
 */

public class VntCaracteristicas implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long crtcId;
    private String crtcDescripcion;
    private Boolean crtcEst;
    private VntTipocrt tpcrId;
    private List<VntCarcactxauto> vntCarcactxautoList;

    public VntCaracteristicas() {
    }

    public VntCaracteristicas(Long crtcId) {
        this.crtcId = crtcId;
    }

    public Long getCrtcId() {
        return crtcId;
    }

    public void setCrtcId(Long crtcId) {
        this.crtcId = crtcId;
    }

    public String getCrtcDescripcion() {
        return crtcDescripcion;
    }

    public void setCrtcDescripcion(String crtcDescripcion) {
        this.crtcDescripcion = crtcDescripcion;
    }

    public Boolean getCrtcEst() {
        return crtcEst;
    }

    public void setCrtcEst(Boolean crtcEst) {
        this.crtcEst = crtcEst;
    }

    public VntTipocrt getTpcrId() {
        return tpcrId;
    }

    public void setTpcrId(VntTipocrt tpcrId) {
        this.tpcrId = tpcrId;
    }

    public List<VntCarcactxauto> getVntCarcactxautoList() {
        return vntCarcactxautoList;
    }

    public void setVntCarcactxautoList(List<VntCarcactxauto> vntCarcactxautoList) {
        this.vntCarcactxautoList = vntCarcactxautoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crtcId != null ? crtcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntCaracteristicas)) {
            return false;
        }
        VntCaracteristicas other = (VntCaracteristicas) object;
        if ((this.crtcId == null && other.crtcId != null) || (this.crtcId != null && !this.crtcId.equals(other.crtcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.ventacar.modelo.VntCaracteristicas[ crtcId=" + crtcId + " ]";
    }
    
}
