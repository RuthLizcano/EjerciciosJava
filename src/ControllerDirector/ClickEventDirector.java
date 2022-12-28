/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDirector;

import ControllerSerie.*;
import ControllerPeli.*;
import acces.DirectorDAO;
import acces.PeliculaDAO;
import acces.SerieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DirectorModel;
import model.PeliculaModel;
import model.SerieModel;
import viewDirector.ControlsPanelDirector;
import viewSerie.ControlsPanelSerie;

/**
 *
 * @author RUYIS
 */
public class ClickEventDirector implements ActionListener {

    private ControlsPanelDirector controlsPaneldirector;

    /**
     * Constructor of the class
     *
     * @param controlsPanel
     */
    public ClickEventDirector(ControlsPanelDirector controlsPaneldirector) {
        this.controlsPaneldirector = controlsPaneldirector;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.controlsPaneldirector.getBtnSearchAll()) {

            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> directores = directorDAO.getTodosDirectores();
            this.controlsPaneldirector.setTblResults(directores);

        } else if (actionEvent.getSource() == this.controlsPaneldirector.getBtnSearchNombreApellido()) {

            String nombre = (String) this.controlsPaneldirector.getTxtNombre().getText();
            String apellido = (String) this.controlsPaneldirector.getTxtApellido().getText();
            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> peliculas = directorDAO.getDirectorPorNombreApellido(nombre, apellido);
            this.controlsPaneldirector.setTblResults(peliculas);

        } else if (actionEvent.getSource() == this.controlsPaneldirector.getBtnSearchNacionalidad()) {

            String nacionalidad = (String) this.controlsPaneldirector.getTxtNacionalidad().getText();
            DirectorDAO directorDAO = new DirectorDAO();
            ArrayList<DirectorModel> peliculas = directorDAO.getDirectorNacionalidad(nacionalidad);
            this.controlsPaneldirector.setTblResults(peliculas);

        } else if (actionEvent.getSource() == this.controlsPaneldirector.getBtnInsert()) {

            String nombre = (String) this.controlsPaneldirector.getTxtNombre().getText();
            String apellido = (String) this.controlsPaneldirector.getTxtApellido().getText();
            String nacionalidad = (String) this.controlsPaneldirector.getTxtNacionalidad().getText();
            DirectorDAO directorDAO = new DirectorDAO();
            DirectorModel newdirector = new DirectorModel(nombre, apellido, nacionalidad);
            directorDAO.insertDirector(newdirector);

        } else if (actionEvent.getSource() == this.controlsPaneldirector.getBtnUpdate()) {

            JOptionPane.showMessageDialog(null, "Recuerde solo puede modificar la nacionalidad");
            String nombre = (String) this.controlsPaneldirector.getTxtNombre().getText();
            String apellido = (String) this.controlsPaneldirector.getTxtApellido().getText();
            String nacionalidad = (String) this.controlsPaneldirector.getTxtNacionalidad().getText();
            DirectorDAO directorDAO = new DirectorDAO();
            DirectorModel newdirector = new DirectorModel(nombre, apellido, nacionalidad);
            System.out.println("sale");
            directorDAO.updateDirector(newdirector);

        } else if (actionEvent.getSource() == this.controlsPaneldirector.getBtnSearchNumero()) {

            DirectorDAO directorDAO = new DirectorDAO();
            JOptionPane.showMessageDialog(null, "Hay " + directorDAO.getNumeroDirectores()
                    + " de directores en total");

        } else if (actionEvent.getSource() == this.controlsPaneldirector.getBtnDelete()) {
            
            System.out.println("aqui");
            String nombre = (String) this.controlsPaneldirector.getTxtNombre().getText();
            String apellido = (String) this.controlsPaneldirector.getTxtApellido().getText();
            DirectorDAO directorDAO = new DirectorDAO();
            directorDAO.deleteDirector(nombre, apellido);
        }

    }

}
