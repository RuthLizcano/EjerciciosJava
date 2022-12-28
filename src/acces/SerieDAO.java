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
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.SerieModel;
import utils.ConnectionBD;

/**
 *
 * @author RUYIS
 */
public class SerieDAO {

    private Connection conn = null;

    public ArrayList<SerieModel> getTodasSeries() {
        ArrayList<SerieModel> series = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select * from series;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                SerieModel serie = new SerieModel(result.getString(1), result.getInt(2), result.getInt(3));
                series.add(serie);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return series;
    }

    public ArrayList<SerieModel> getSeriePorNombre(String titulo) {
        ArrayList<SerieModel> series = new ArrayList<SerieModel>();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "select * from series where ser_titulo='" + titulo + "';";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                SerieModel serie = new SerieModel(result.getString(1), result.getInt(2), result.getInt(3));
                series.add(serie);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return series;
    }

    public int getNumeroSeries() {

        int numeroSeries = 0;
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select count(*) from series;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                numeroSeries = result.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return numeroSeries;
    }

    public void insertSerie(SerieModel newSerie) {
        try {

            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "INSERT INTO series(ser_titulo, ser_numero_episodio, ser_numero_temporada) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newSerie.getTituloSerie());
            statement.setInt(2, newSerie.getNumEpisodio());
            statement.setInt(3, newSerie.getNumTemporada());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateSerie(SerieModel updateSerie) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "UPDATE series SET ser_numero_episodio =?, ser_numero_temporada=? WHERE ser_titulo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, updateSerie.getNumEpisodio());
            statement.setInt(2, updateSerie.getNumTemporada());
            statement.setString(3, updateSerie.getTituloSerie());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteSerie(String tituloserie) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "DELETE FROM series WHERE ser_titulo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, tituloserie);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
