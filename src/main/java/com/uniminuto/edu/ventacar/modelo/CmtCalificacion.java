/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.modelo;

import com.uniminuto.edu.ventacar.ctrl.TablaCarro;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lchacon
 */

public class CmtCalificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long cmtrId;
    private String cmtrComentario;
    private Date cmrtFecha;
    private String usrId;
    private String usrNombre;
 

    public CmtCalificacion() {
    }

    public CmtCalificacion(Long cmtrId) {
        this.cmtrId = cmtrId;
    }

    public Long getCmtrId() {
        return cmtrId;
    }

    public void setCmtrId(Long cmtrId) {
        this.cmtrId = cmtrId;
    }

    public String getCmtrComentario() {
        return cmtrComentario;
    }

    public void setCmtrComentario(String cmtrComentario) {
        this.cmtrComentario = cmtrComentario;
    }

    public Date getCmrtFecha() {
        return cmrtFecha;
    }

    public void setCmrtFecha(Date cmrtFecha) {
        this.cmrtFecha = cmrtFecha;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmtrId != null ? cmtrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmtCalificacion)) {
            return false;
        }
        CmtCalificacion other = (CmtCalificacion) object;
        if ((this.cmtrId == null && other.cmtrId != null) || (this.cmtrId != null && !this.cmtrId.equals(other.cmtrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.edu.ventacar.modelo.CmtCalificacion[ cmtrId=" + cmtrId + " ]";
    }

    /**
     * @return the usrNombre
     */
    public String getUsrNombre() {
        return usrNombre;
    }

    /**
     * @param usrNombre the usrNombre to set
     */
    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }
    
}
