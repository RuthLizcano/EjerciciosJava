/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDirector;

import ControllerPeli.*;
import acces.DirectorDAO;
import acces.PeliculaDAO;
import java.util.ArrayList;
import model.DirectorModel;
import model.PeliculaModel;

/**
 *
 * @author RUYIS
 */
public class InitialDataDirector {
    private ArrayList<DirectorModel>     director = null;
    public InitialDataDirector(){
        DirectorDAO directorDAO = new DirectorDAO();
        this.director= directorDAO.getTodosDirectores();
    }
    public ArrayList<DirectorModel> getDirectorModel() {
        return director;
    }
}
