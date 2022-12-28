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
import model.PeliculaModel;
import utils.ConnectionBD;

/**
 *
 * @author RUYIS
 */
public class PeliculaDAO {

    private Connection conn = null;

    public ArrayList<PeliculaModel> getTodasPeliculas() {
        ArrayList<PeliculaModel> peliculas = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select p.peli_titulo, p.peli_resumen, p.peli_año, d.dir_nombre, d.dir_apellido from peliculas p join director d on p.peli_dir_id=d.dir_id order by peli_titulo asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                PeliculaModel pelicula = new PeliculaModel(result.getString(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return peliculas;
    }
    public ArrayList<PeliculaModel> getPeliculaPorAños(int año) {
        ArrayList<PeliculaModel> peliculas = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            Calendar fecha = Calendar.getInstance();
            fecha.set(Calendar.YEAR, año);
            String sql = "select p.peli_titulo, p.peli_resumen, p.peli_año, d.dir_nombre, d.dir_apellido from peliculas p join director d on p.peli_dir_id=d.dir_id where peli_año='"+fecha.get(Calendar.YEAR)+"'order by peli_titulo asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                PeliculaModel pelicula = new PeliculaModel(result.getString(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return peliculas;
    }
    public ArrayList<PeliculaModel> getPeliculaPorNombre(String titulo) {
         ArrayList<PeliculaModel> peliculas = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "select p.peli_titulo, p.peli_resumen, p.peli_año, d.dir_nombre, d.dir_apellido from peliculas p join director d on p.peli_dir_id=d.dir_id where peli_titulo='"+titulo+"'order by peli_titulo asc;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
               PeliculaModel pelicula = new PeliculaModel(result.getString(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return peliculas;
    }

    public int getNumeroPeliculas() {

        int numeroPeliculas = 0;
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }

            String sql = "select count(*) from peliculas;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                numeroPeliculas = result.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return numeroPeliculas;
    }

    public void insertPelicula(PeliculaModel newPeli) {
        try {

            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            DirectorDAO idDirct = new DirectorDAO();
            int id = idDirct.getIdDirector(newPeli.getNombreDirector(), newPeli.getApellidoDirector());
            System.out.println(id);
            Calendar fecha = Calendar.getInstance();
            fecha.set(Calendar.YEAR, newPeli.getAñoPelicula());
            String sql = "INSERT INTO peliculas(peli_titulo, peli_resumen, peli_año, peli_dir_id) VALUES(?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newPeli.getTituloPelicula());
            statement.setString(2, newPeli.getResumen());
            statement.setInt(3, fecha.get(Calendar.YEAR));
            statement.setInt(4, id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updatePelicula(PeliculaModel updatePeli) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            DirectorDAO idDirct = new DirectorDAO();
            int id = idDirct.getIdDirector(updatePeli.getNombreDirector(), updatePeli.getApellidoDirector());
            Calendar fecha = Calendar.getInstance();
            fecha.set(Calendar.YEAR, updatePeli.getAñoPelicula());
            String sql = "UPDATE peliculas SET peli_resumen =?,peli_año=?,peli_dir_id=? WHERE peli_titulo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, updatePeli.getResumen());
            statement.setInt(2, fecha.get(Calendar.YEAR));
            statement.setInt(3, id);
            statement.setString(4, updatePeli.getTituloPelicula());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
    public void deletePelicula(String tituloPelicula) {
        try {
            if(conn == null)
                conn = ConnectionBD.getConnection();
            String sql = "DELETE FROM peliculas WHERE peli_titulo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, tituloPelicula);
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
