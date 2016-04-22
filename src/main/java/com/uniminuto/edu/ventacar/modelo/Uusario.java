/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.modelo;

import java.util.Objects;

/**
 *
 * @author fercris
 */
public class Uusario {
    private String usrId;
    private String usrNombre;
    private String usrCorreo;

    public Uusario(String usrId, String usrNombre, String usrCorreo) {
        this.usrId = usrId;
        this.usrNombre = usrNombre;
        this.usrCorreo = usrCorreo;
    }

    public Uusario() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.usrId);
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
        final Uusario other = (Uusario) obj;
        if (!Objects.equals(this.usrId, other.usrId)) {
            return false;
        }
        return true;
    }

    /**
     * @return the usrId
     */
    public String getUsrId() {
        return usrId;
    }

    /**
     * @param usrId the usrId to set
     */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
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

    /**
     * @return the usrCorreo
     */
    public String getUsrCorreo() {
        return usrCorreo;
    }

    /**
     * @param usrCorreo the usrCorreo to set
     */
    public void setUsrCorreo(String usrCorreo) {
        this.usrCorreo = usrCorreo;
    }
}
