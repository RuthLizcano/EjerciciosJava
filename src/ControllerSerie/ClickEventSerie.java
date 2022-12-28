/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerSerie;

import ControllerPeli.*;
import acces.PeliculaDAO;
import acces.SerieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PeliculaModel;
import model.SerieModel;
import viewSerie.ControlsPanelSerie;

/**
 *
 * @author RUYIS
 */
public class ClickEventSerie implements ActionListener {

    private ControlsPanelSerie controlsPanelserie;

    /**
     * Constructor of the class
     *
     * @param controlsPanel
     */
    public ClickEventSerie(ControlsPanelSerie controlsPanelserie) {
        this.controlsPanelserie = controlsPanelserie;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.controlsPanelserie.getBtnSearchAll()) {
            
            SerieDAO serieDAO = new SerieDAO();
            ArrayList<SerieModel> series = serieDAO.getTodasSeries();
            this.controlsPanelserie.setTblResults(series);
            
        } else if (actionEvent.getSource() == this.controlsPanelserie.getBtnSearchTitulo()) {

            String titulo = (String) this.controlsPanelserie.getTxtTitulo().getText();
            SerieDAO serieDAO = new SerieDAO();
            ArrayList<SerieModel> peliculas = serieDAO.getSeriePorNombre(titulo);
            this.controlsPanelserie.setTblResults(peliculas);
            
        } else if (actionEvent.getSource() == this.controlsPanelserie.getBtnInsert()) {

            String titulo = (String) this.controlsPanelserie.getTxtTitulo().getText();
            int numTemp = Integer.parseInt((String) this.controlsPanelserie.getTxtnumTemp().getText());
            int numEps = Integer.parseInt((String) this.controlsPanelserie.getTxtnumEpis().getText());
            SerieDAO serieDAO = new SerieDAO();
            SerieModel newserie = new SerieModel(titulo, numTemp,numEps);
            serieDAO.insertSerie(newserie);

        } else if (actionEvent.getSource() == this.controlsPanelserie.getBtnUpdate()) {
            
            JOptionPane.showMessageDialog(null, "Recuerde el titulo de la serie no se puede modificar");
            String titulo = (String) this.controlsPanelserie.getTxtTitulo().getText();
            int numTemp = Integer.parseInt((String) this.controlsPanelserie.getTxtnumTemp().getText());
            int numEps = Integer.parseInt((String) this.controlsPanelserie.getTxtnumEpis().getText());

            SerieDAO serieDAO = new SerieDAO();
            SerieModel newserie = new SerieModel(titulo, numTemp,numEps);
            serieDAO.updateSerie(newserie);

        } else if (actionEvent.getSource() == this.controlsPanelserie.getBtnSearchNumero()) {
            
            SerieDAO serieDAO = new SerieDAO();
            JOptionPane.showMessageDialog(null, "Hay " + serieDAO.getNumeroSeries()
                    + " de series en total");
            
        } else if (actionEvent.getSource() == this.controlsPanelserie.getBtnDelete()) {
            
            String titulo = (String) this.controlsPanelserie.getTxtTitulo().getText();
            SerieDAO serieDAO = new SerieDAO();
            serieDAO.deleteSerie(titulo);
            
        }

    }

}
