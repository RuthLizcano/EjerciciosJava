/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerTransmisiones;

import ControllerSerie.*;
import ControllerPeli.*;
import acces.PeliculaDAO;
import acces.SerieDAO;
import acces.TransmisionesDAO;
import java.util.ArrayList;
import model.PeliculaModel;
import model.SerieModel;
import model.TransmisionesModel;

/**
 *
 * @author RUYIS
 */
public class InitialDataTransmisiones {
    private ArrayList<TransmisionesModel>     trans = null;
    
    public InitialDataTransmisiones(){
        TransmisionesDAO transmisionesDAO = new TransmisionesDAO();
        this.trans= transmisionesDAO.getTodasTransmisiones();
    }
    public ArrayList<TransmisionesModel> getTransmisionesModel() {
        return trans;
    }
}
