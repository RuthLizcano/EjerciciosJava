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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.UsuarioModel;
import utils.ConnectionBD;

/**
 *
 * @author RUYIS
 */
public class UsuarioDAO {

    private Connection conn = null;

    public ArrayList<UsuarioModel> getTodosUsuarios() {
        ArrayList<UsuarioModel> usuarios = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select * from usuarios;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                UsuarioModel usuario = new UsuarioModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6), result.getString(7));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }

    public ArrayList<UsuarioModel> getUsuarioPorAlias(String alias) {
        ArrayList<UsuarioModel> usuarios = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "select * from usuarios where usu_alias='" + alias + "';";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                UsuarioModel usuario = new UsuarioModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6), result.getString(7));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }

    public int getNumeroDeUsuarios() {

        int numeroUsuarios = 0;
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select count(*) from usuarios;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                numeroUsuarios = result.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return numeroUsuarios;
    }

    public void insertUsuario(UsuarioModel newUsuario) throws ParseException {
        try {

            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateInString = newUsuario.getFechaNcimiento();
            Date date = formatter.parse(dateInString);
            long timeInMilliSeconds = date.getTime();
            java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
            String sql = "INSERT INTO usuarios(usu_alias, usu_nombre, usu_apellido, usu_email, usu_celular, usu_contraseña,usu_fecha_nacimiento) VALUES(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newUsuario.getAliasUsuario());
            statement.setString(2, newUsuario.getNombreUsuario());
            statement.setString(3, newUsuario.getApellidoUsuario());
            statement.setString(4, newUsuario.getEmail());
            statement.setLong(5, newUsuario.getCelular());
            statement.setString(6, newUsuario.getContraseña());
            statement.setDate(7, date1);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateUsuario(UsuarioModel updateUsuario) throws ParseException {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateInString = updateUsuario.getFechaNcimiento();
            Date date = formatter.parse(dateInString);
            long timeInMilliSeconds = date.getTime();
            java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);

            String sql = "UPDATE usuarios SET usu_nombre =?, usu_apellido=?, usu_email=?, usu_celular=?, usu_contraseña=?, usu_fecha_nacimiento=? WHERE usu_alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, updateUsuario.getNombreUsuario());
            statement.setString(2, updateUsuario.getApellidoUsuario());
            statement.setString(3, updateUsuario.getEmail());
            statement.setLong(4, updateUsuario.getCelular());
            statement.setString(5, updateUsuario.getContraseña());
            statement.setDate(6, date1);
            statement.setString(7, updateUsuario.getAliasUsuario());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteUsuario(String alias) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "DELETE FROM usuarios WHERE usu_alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, alias);
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
