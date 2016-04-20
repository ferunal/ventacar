/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.uniminuto.edu.ventacar.base.TablaBaseFrm;
import com.uniminuto.edu.ventacar.modelo.VntCarro;
import java.util.Objects;

/**
 *
 * @author lchacon
 */
public class TablaCarro extends TablaBaseFrm{
    private VntCarro carro = new VntCarro();

    public TablaCarro() {
    }
    public TablaCarro(VntCarro pCarro) {
        this.carro=pCarro;
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
    
    
}