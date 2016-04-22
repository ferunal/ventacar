/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.TablaBaseFrm;
import com.uniminuto.edu.ventacar.modelo.Uusario;
import java.util.Objects;

/**
 *
 * @author fercris
 */
public class TablaUsuario extends TablaBaseFrm {

    private Uusario uusario = new Uusario();

    public TablaUsuario() {
    }

    public TablaUsuario(Uusario pUusario) {
        this.uusario = pUusario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.uusario);
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
        final TablaUsuario other = (TablaUsuario) obj;
        return Objects.equals(this.uusario, other.uusario);
    }

    /**
     * @return the uusario
     */
    public Uusario getUusario() {
        return uusario;
    }

    /**
     * @param uusario the uusario to set
     */
    public void setUusario(Uusario uusario) {
        this.uusario = uusario;
    }

}
