/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerSerie;

import ControllerPeli.*;
import acces.PeliculaDAO;
import acces.SerieDAO;
import java.util.ArrayList;
import model.PeliculaModel;
import model.SerieModel;

/**
 *
 * @author RUYIS
 */
public class InitialDataSerie {
    private ArrayList<SerieModel>     serie = null;
    
    public InitialDataSerie(){
        SerieDAO serieDAO = new SerieDAO();
        this.serie= serieDAO.getTodasSeries();
    }
    public ArrayList<SerieModel> getSerieModel() {
        return serie;
    }
}
