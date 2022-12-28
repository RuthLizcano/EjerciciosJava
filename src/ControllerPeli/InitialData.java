/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerPeli;

import acces.PeliculaDAO;
import java.util.ArrayList;
import model.PeliculaModel;

/**
 *
 * @author RUYIS
 */
public class InitialData {
    private ArrayList<PeliculaModel>     pelicula = null;
    public InitialData(){
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        this.pelicula= peliculaDAO.getTodasPeliculas();
    }
    public ArrayList<PeliculaModel> getPeliculaModel() {
        return pelicula;
    }
}
