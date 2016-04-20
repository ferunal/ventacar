/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.TablaBaseFrm;
import com.uniminuto.edu.ventacar.modelo.VntCaracteristicas;
import java.util.Objects;

/**
 *
 * @author lchacon
 */
public class TablaCaracteristica extends TablaBaseFrm {

    private VntCaracteristicas caracteristica = new VntCaracteristicas();

    public TablaCaracteristica() {
    }

    public TablaCaracteristica(VntCaracteristicas pCaracteristica) {
        this.caracteristica = pCaracteristica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.caracteristica);
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
        final TablaCaracteristica other = (TablaCaracteristica) obj;
        if (!Objects.equals(this.caracteristica, other.caracteristica)) {
            return false;
        }
        return true;
    }

    /**
     * @return the caracteristica
     */
    public VntCaracteristicas getCaracteristica() {
        return caracteristica;
    }

    /**
     * @param caracteristica the caracteristica to set
     */
    public void setCaracteristica(VntCaracteristicas caracteristica) {
        this.caracteristica = caracteristica;
    }

}
