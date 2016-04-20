/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.modelo;

import java.io.Serializable;

/**
 *
 * @author lchacon
 */

public class VntCarcactxauto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long cxaId;
    private Boolean cxaEst;
    private VntCaracteristicas crtcId;
    private VntCarro carId;

    public VntCarcactxauto() {
    }

    public VntCarcactxauto(Long cxaId) {
        this.cxaId = cxaId;
    }

    public Long getCxaId() {
        return cxaId;
    }

    public void setCxaId(Long cxaId) {
        this.cxaId = cxaId;
    }

    public Boolean getCxaEst() {
        return cxaEst;
    }

    public void setCxaEst(Boolean cxaEst) {
        this.cxaEst = cxaEst;
    }

    public VntCaracteristicas getCrtcId() {
        return crtcId;
    }

    public void setCrtcId(VntCaracteristicas crtcId) {
        this.crtcId = crtcId;
    }

    public VntCarro getCarId() {
        return carId;
    }

    public void setCarId(VntCarro carId) {
        this.carId = carId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cxaId != null ? cxaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntCarcactxauto)) {
            return false;
        }
        VntCarcactxauto other = (VntCarcactxauto) object;
        if ((this.cxaId == null && other.cxaId != null) || (this.cxaId != null && !this.cxaId.equals(other.cxaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.ventacar.modelo.VntCarcactxauto[ cxaId=" + cxaId + " ]";
    }
    
}
