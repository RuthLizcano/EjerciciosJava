/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.SerieModel;
import model.TransmisionesModel;
import utils.ConnectionBD;

/**
 *
 * @author RUYIS
 */
public class TransmisionesDAO {

    private Connection conn = null;

    public ArrayList<TransmisionesModel> getTodasTransmisiones() {
        ArrayList<TransmisionesModel> transs = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select p.peli_titulo, t.trans_usu_alias, trans_fecha_hora from peliculas p join transmisiones t on p.peli_titulo=t.trans_peli_titulo\n"
                    + "UNION\n"
                    + "select s.ser_titulo, t.trans_usu_alias, trans_fecha_hora from series s join transmisiones t on s.ser_titulo=t.trans_ser_titulo order by peli_titulo asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                TransmisionesModel trans = new TransmisionesModel(result.getString(1), result.getString(2), result.getString(3));
                transs.add(trans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return transs;
    }

    public ArrayList<TransmisionesModel> getTransmisionesAlias(String alias) {
        ArrayList<TransmisionesModel> transs = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "select p.peli_titulo, t.trans_fecha_hora from peliculas p join transmisiones t on p.peli_titulo=t.trans_peli_titulo where t.trans_usu_alias='" + alias + "'"
                    + "UNION\n"
                    + "select s.ser_titulo, t.trans_fecha_hora from series s join transmisiones t on s.ser_titulo=t.trans_ser_titulo where t.trans_usu_alias='" + alias + "' order by peli_titulo asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                TransmisionesModel trans = new TransmisionesModel(result.getString(1), result.getString(2));
                transs.add(trans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return transs;
    }

    public ArrayList<TransmisionesModel> getTransmisionPorPelicula(String titulo) {
        ArrayList<TransmisionesModel> transs = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "select u.usu_alias, u.usu_nombre, u.usu_apellido, t.trans_fecha_hora from usuarios u join transmisiones t on u.usu_alias=t.trans_usu_alias where t.trans_peli_titulo='" + titulo + "'order by u.usu_alias asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                TransmisionesModel trans = new TransmisionesModel(result.getString(1), result.getString(2),result.getString(3),result.getString(4));
                transs.add(trans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return transs;
    }

    public ArrayList<TransmisionesModel> getTransmisionPorSeries(String titulo) {
        ArrayList<TransmisionesModel> transs = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "select u.usu_alias, u.usu_nombre, u.usu_apellido, t.trans_fecha_hora from usuarios u join transmisiones t on u.usu_alias=t.trans_usu_alias where t.trans_ser_titulo='" + titulo + "'order by u.usu_alias asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                TransmisionesModel trans = new TransmisionesModel(result.getString(1), result.getString(2),result.getString(3),result.getString(4));
                transs.add(trans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return transs;
    }

    public int getNumeroTransmisiones() {

        int numeroTransmisiones = 0;
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select count(*) from transmisiones;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                numeroTransmisiones = result.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return numeroTransmisiones;
    }

    public void insertTransmisionPelicula(TransmisionesModel newTransPeli) {
        try {

            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String dateTime = newTransPeli.getFechaHora();
            Timestamp timestamp = Timestamp.valueOf(dateTime);
            String sql = "INSERT INTO transmisiones(trans_usu_alias, trans_peli_titulo, trans_fecha_hora) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newTransPeli.getUsuAlias());
            statement.setString(2, newTransPeli.getPeliTitulo());
            statement.setTimestamp(3, timestamp);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void insertTransmisionSerie(TransmisionesModel newTransSerie) {
        try {

            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String dateTime = newTransSerie.getFechaHora();
            Timestamp timestamp = Timestamp.valueOf(dateTime);
            String sql = "INSERT INTO transmisiones(trans_usu_alias, trans_ser_titulo, trans_fecha_hora) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newTransSerie.getUsuAlias());
            statement.setString(2, newTransSerie.getSerieTitulo());
            statement.setTimestamp(3, timestamp);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

}
