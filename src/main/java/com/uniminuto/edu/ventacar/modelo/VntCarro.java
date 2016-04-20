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

public class VntCarro implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long carId;
    private String carNombre;
    private String carFoto;
    private Boolean carEst;
    private List<CmtCalificacion> cmtCalificacionList;
    private List<VntCarcactxauto> vntCarcactxautoList;

    public VntCarro() {
    }

    public VntCarro(Long carId) {
        this.carId = carId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarNombre() {
        return carNombre;
    }

    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }

    public String getCarFoto() {
        return carFoto;
    }

    public void setCarFoto(String carFoto) {
        this.carFoto = carFoto;
    }

    public Boolean getCarEst() {
        return carEst;
    }

    public void setCarEst(Boolean carEst) {
        this.carEst = carEst;
    }

    
    public List<CmtCalificacion> getCmtCalificacionList() {
        return cmtCalificacionList;
    }

    public void setCmtCalificacionList(List<CmtCalificacion> cmtCalificacionList) {
        this.cmtCalificacionList = cmtCalificacionList;
    }

    @XmlTransient
    public List<VntCarcactxauto> getVntCarcactxautoList() {
        return vntCarcactxautoList;
    }

    public void setVntCarcactxautoList(List<VntCarcactxauto> vntCarcactxautoList) {
        this.vntCarcactxautoList = vntCarcactxautoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntCarro)) {
            return false;
        }
        VntCarro other = (VntCarro) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.ventacar.modelo.VntCarro[ carId=" + carId + " ]";
    }
    
}
