/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerPeli;

import acces.PeliculaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PeliculaModel;
import viewPelicula.ControlsPanelPeli;

/**
 *
 * @author RUYIS
 */
public class ClickEvent implements ActionListener {

    private ControlsPanelPeli controlsPanelPeli;

    /**
     * Constructor of the class
     *
     * @param controlsPanel
     */
    public ClickEvent(ControlsPanelPeli controlsPanelPeli) {
        this.controlsPanelPeli = controlsPanelPeli;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.controlsPanelPeli.getBtnSearchAll()) {
            PeliculaDAO peliDAO = new PeliculaDAO();
            ArrayList<PeliculaModel> peliculas = peliDAO.getTodasPeliculas();

            this.controlsPanelPeli.setTblResults(peliculas);
        } else if (actionEvent.getSource() == this.controlsPanelPeli.getBtnSearchTitulo()) {

            String titulo = (String) this.controlsPanelPeli.getTxtTitulo().getText();
            PeliculaDAO peliDAO = new PeliculaDAO();
            ArrayList<PeliculaModel> peliculas = peliDAO.getPeliculaPorNombre(titulo);

            this.controlsPanelPeli.setTblResults(peliculas);
        } else if (actionEvent.getSource() == this.controlsPanelPeli.getBtnSearchAno()) {

            String titulo = (String) this.controlsPanelPeli.getTxtTitulo().getText();
            String resumen = (String) this.controlsPanelPeli.getTxtResumen().getText();
            String ano = (String) this.controlsPanelPeli.getTxtAno().getText();
            String nomDirect = (String) this.controlsPanelPeli.getTxtNombreDirect().getText();
            String aplDirect = (String) this.controlsPanelPeli.getTxtApellidoDirect().getText();

            PeliculaDAO peliDAO = new PeliculaDAO();
            ArrayList<PeliculaModel> peliculas = peliDAO.getPeliculaPorAños(Integer.parseInt(ano));

            this.controlsPanelPeli.setTblResults(peliculas);
        } else if (actionEvent.getSource() == this.controlsPanelPeli.getBtnInsert()) {

            String titulo = (String) this.controlsPanelPeli.getTxtTitulo().getText();
            String resumen = (String) this.controlsPanelPeli.getTxtResumen().getText();
            String ano = (String) this.controlsPanelPeli.getTxtAno().getText();
            String nomDirect = (String) this.controlsPanelPeli.getTxtNombreDirect().getText();
            String aplDirect = (String) this.controlsPanelPeli.getTxtApellidoDirect().getText();

            PeliculaDAO peliDAO = new PeliculaDAO();
            PeliculaModel pelinew = new PeliculaModel(titulo, resumen, Integer.parseInt(ano), nomDirect, aplDirect);
            peliDAO.insertPelicula(pelinew);

        } else if (actionEvent.getSource() == this.controlsPanelPeli.getBtnUpdate()) {
            JOptionPane.showMessageDialog(null, "Recuerde el titulo de la pelicula no se puede modificar");
            String titulo = (String) this.controlsPanelPeli.getTxtTitulo().getText();
            String resumen = (String) this.controlsPanelPeli.getTxtResumen().getText();
            String ano = (String) this.controlsPanelPeli.getTxtAno().getText();
            String nomDirect = (String) this.controlsPanelPeli.getTxtNombreDirect().getText();
            String aplDirect = (String) this.controlsPanelPeli.getTxtApellidoDirect().getText();

            PeliculaDAO peliDAO = new PeliculaDAO();
            PeliculaModel pelinew = new PeliculaModel(titulo, resumen, Integer.parseInt(ano), nomDirect, aplDirect);
            peliDAO.updatePelicula(pelinew);

        } else if (actionEvent.getSource() == this.controlsPanelPeli.getBtnSearchNumero()) {
            PeliculaDAO peliDAO = new PeliculaDAO();
            
            JOptionPane.showMessageDialog(null, "Hay " + peliDAO.getNumeroPeliculas()
                    + " de peliculas en total");
        }
        else if (actionEvent.getSource() == this.controlsPanelPeli.getBtnDelete()) {
            String titulo = (String) this.controlsPanelPeli.getTxtTitulo().getText();
            PeliculaDAO peliDAO = new PeliculaDAO();
            peliDAO.deletePelicula(titulo);
        }

    }

}
