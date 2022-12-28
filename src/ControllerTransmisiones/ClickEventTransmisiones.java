/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerTransmisiones;

import acces.SerieDAO;
import acces.TransmisionesDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.SerieModel;
import model.TransmisionesModel;
import viewSerie.ControlsPanelSerie;
import viewTransmisiones.ControlsPanelTransmisiones;

/**
 *
 * @author RUYIS
 */
public class ClickEventTransmisiones implements ActionListener {

    private ControlsPanelTransmisiones controlsPaneltransmisiones;

    /**
     * Constructor of the class
     *
     * @param controlsPanel
     */
    public ClickEventTransmisiones(ControlsPanelTransmisiones controlsPaneltransmisiones) {
        this.controlsPaneltransmisiones = controlsPaneltransmisiones;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.controlsPaneltransmisiones.getBtnSearchAll()) {
            
            TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
            ArrayList<TransmisionesModel> trans = transmisionesDAO.getTodasTransmisiones();
            this.controlsPaneltransmisiones.setTblResults4(trans);
            
        } else if (actionEvent.getSource() == this.controlsPaneltransmisiones.getBtnSearchAlias()) {

            String alias = (String) this.controlsPaneltransmisiones.getTxtAlias().getText();
            TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
            ArrayList<TransmisionesModel> trans = transmisionesDAO.getTransmisionesAlias(alias);
            this.controlsPaneltransmisiones.setTblResults3(trans);
            
        }else if (actionEvent.getSource() == this.controlsPaneltransmisiones.getBtnSearchPelicula()) {

            String pelicula = (String) this.controlsPaneltransmisiones.getTxtTituloPeli().getText();
            TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
            ArrayList<TransmisionesModel> trans = transmisionesDAO.getTransmisionPorPelicula(pelicula);
            this.controlsPaneltransmisiones.setTblResults2(trans);
            
        }else if (actionEvent.getSource() == this.controlsPaneltransmisiones.getBtnSearchSerie()) {

            String serie = (String) this.controlsPaneltransmisiones.getTxtTituloSerie().getText();
            TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
            ArrayList<TransmisionesModel> trans = transmisionesDAO.getTransmisionPorSeries(serie);
            this.controlsPaneltransmisiones.setTblResults2(trans);
            
        } else if (actionEvent.getSource() == this.controlsPaneltransmisiones.getBtnInsertPeli()) {

            String titulo = (String) this.controlsPaneltransmisiones.getTxtTituloPeli().getText();
            String alias = (String) this.controlsPaneltransmisiones.getTxtAlias().getText();
            String fechaHora = (String) this.controlsPaneltransmisiones.getTxtFechaHora().getText();
            TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
            TransmisionesModel newTransmision = new TransmisionesModel(0,alias,titulo,"",fechaHora);
            transmisionesDAO.insertTransmisionPelicula(newTransmision);

        } else if (actionEvent.getSource() == this.controlsPaneltransmisiones.getBtnInsertSerie()) {

            String titulo = (String) this.controlsPaneltransmisiones.getTxtTituloSerie().getText();
            String alias = (String) this.controlsPaneltransmisiones.getTxtAlias().getText();
            String fechaHora = (String) this.controlsPaneltransmisiones.getTxtFechaHora().getText();
            
            TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
            TransmisionesModel newTransmision = new TransmisionesModel(0,alias,"",titulo,fechaHora);
            transmisionesDAO.insertTransmisionSerie(newTransmision);

        }  else if (actionEvent.getSource() == this.controlsPaneltransmisiones.getBtnSearchNumero()) {
            
            TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
            JOptionPane.showMessageDialog(null, "Hay " + transmisionesDAO.getNumeroTransmisiones()
                    + " de series en total");
            
        } 

    }

}
