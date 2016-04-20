/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.edu.ventacar.ctrl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

/**
 *
 * @author Luis Fernando
 */
public class ConexionBD {

    protected Connection conPg;
    protected Connection conMy;

    protected void dsPgConexion() throws SQLException {
        PGSimpleDataSource pgDs = new PGSimpleDataSource();
        pgDs.setServerName("localhost");
        pgDs.setDatabaseName("ventacar");
        pgDs.setUser("uniminuto");
        pgDs.setPassword("uniminuto");
        pgDs.setPortNumber(5432);
        conPg = pgDs.getConnection();
    }

    protected void dsMyConexion() throws SQLException {
        MysqlDataSource mds = new MysqlDataSource();
        mds.setURL("jdbc:mysql://localhost:3306/usuarios");
        mds.setUser("uniminuto");
        mds.setPassword("uniminuto");
        conMy = mds.getConnection();
    }

    protected void cerrarPgConexion() throws SQLException {
        conPg.close();
    }

    protected void cerrarMyConexion() throws SQLException {
        conMy.close();
    }
}
