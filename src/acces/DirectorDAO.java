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
import javax.swing.JOptionPane;
import model.DirectorModel;
import model.SerieModel;
import utils.ConnectionBD;

/**
 *
 * @author RUYIS
 */
public class DirectorDAO {

    public DirectorDAO() {
    }

    private Connection conn = null;

    public int getIdDirector(String nombre, String apellido) {
        int idDirector = 0;
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select d.dir_id from director d where d.dir_nombre='" + nombre + "' and d.dir_apellido='" + apellido + "';";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                idDirector = result.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return idDirector;
    }

    public ArrayList<DirectorModel> getTodosDirectores() {
        ArrayList<DirectorModel> directores = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select d.dir_nombre, d.dir_apellido, d.dir_nacionalidad from director d;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                DirectorModel director = new DirectorModel(result.getString(1), result.getString(2), result.getString(3));
                directores.add(director);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return directores;
    }

    public ArrayList<DirectorModel> getDirectorPorNombreApellido(String nombre, String apellido) {
        ArrayList<DirectorModel> directores = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "select d.dir_nombre, d.dir_apellido, d.dir_nacionalidad from director d where dir_nombre='" + nombre + "' and dir_apellido='" + apellido + "' order by dir_apellido asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                DirectorModel director = new DirectorModel(result.getString(1), result.getString(2), result.getString(3));
                directores.add(director);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return directores;
    }

    public int getNumeroDirectores() {

        int numeroDirectores = 0;
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select count(*) from director;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                numeroDirectores = result.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return numeroDirectores;
    }

    public ArrayList<DirectorModel> getDirectorNacionalidad(String nacionalidad) {

        ArrayList<DirectorModel> directores = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select d.dir_nombre, d.dir_apellido, d.dir_nacionalidad from director d where dir_nacionalidad='" + nacionalidad + "' order by dir_apellido asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                DirectorModel director = new DirectorModel(result.getString(1), result.getString(2), result.getString(3));
                directores.add(director);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return directores;
    }

    public void insertDirector(DirectorModel newDirector) {
        try {

            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "INSERT INTO director(dir_nombre, dir_apellido, dir_nacionalidad) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newDirector.getNombreDirector());
            statement.setString(2, newDirector.getApellidoDirector());
            statement.setString(3, newDirector.getNacionalidad());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateDirector(DirectorModel updateDirector) {

        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            System.out.println("entro2");
            String sql = "UPDATE director SET dir_nacionalidad=? WHERE dir_nombre=? and dir_apellido=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, updateDirector.getNacionalidad());
            statement.setString(2, updateDirector.getNombreDirector());
            statement.setString(3, updateDirector.getApellidoDirector());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteDirector(String nombre, String apellido) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "DELETE FROM director WHERE dir_nombre=? and dir_apellido=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
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
