/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewTransmisiones;

import viewSerie.*;
import viewPelicula.*;
import ControllerPeli.ClickEvent;
import ControllerPeli.InitialData;
import ControllerSerie.ClickEventSerie;
import ControllerTransmisiones.ClickEventTransmisiones;
import ControllerTransmisiones.InitialDataTransmisiones;
import java.awt.Color;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.PeliculaModel;
import model.SerieModel;
import model.TransmisionesModel;

/**
 *
 * @author casierrav
 */
public class ControlsPanelTransmisiones extends JPanel {

    private JLabel lblAlias;
    private JTextField txtAlias;
    private JLabel lblTituloPeli;
    private JTextField txtTituloPeli;
    private JLabel lblTituloSerie;
    private JTextField txtTituloSerie;
    private JLabel lblFechaHora;
    private JTextField txtFechaHora;
    private JButton btnSearchAll;
    private JButton btnSearchAlias;
    private JButton btnSearchPelicula;
    private JButton btnSearchSerie;
    private JButton btnSearchNumero;
    private JButton btnInsertSerie;
    private JButton btnInsertPeli;
    private JTable tblResults;

    /**
     * Constructor of the ControlsPanel class.
     *
     * @param resultsPanel
     */
    public ControlsPanelTransmisiones(ResultsPanelTransmisiones resultsPaneltrasnmisiones) {
        this.tblResults = resultsPaneltrasnmisiones.getTblResults();
        initComponents();

    }

    /**
     *
     */
    private void initComponents() {
        setLayout(new GridLayout(17, 1));
        InitialDataTransmisiones initialDataTransmisiones = new InitialDataTransmisiones();

        this.setTblResults(initialDataTransmisiones.getTransmisionesModel());

        this.lblAlias= new JLabel("Alias");
        add(this.getLblAlias());
        this.txtAlias = new JTextField();
        add(this.getTxtAlias());

        this.lblTituloPeli = new JLabel("Titulo de la Pelicula");
        add(this.getLblTituloPeli());
        this.txtTituloPeli= new JTextField();
        add(this.getTxtTituloPeli());

        this.lblTituloSerie = new JLabel("Titulo de la Serie");
        add(this.getLblTituloSerie());
        this.txtTituloSerie= new JTextField();
        add(this.getTxtTituloSerie());
        
        this.lblFechaHora = new JLabel("Fecha y Hora");
        add(this.getLblFechaHora());
        this.txtFechaHora= new JTextField();
        add(this.getTxtFechaHora());

        // Search button
        ClickEventTransmisiones clickEventTransmisiones = new ClickEventTransmisiones(this);
        this.btnSearchAll = new JButton("Listar");
        add(this.btnSearchAll);
        this.getBtnSearchAll().addActionListener(clickEventTransmisiones);

        this.btnSearchAlias = new JButton("Buscar por Alias");
        add(this.btnSearchAlias);
        this.getBtnSearchAlias().addActionListener(clickEventTransmisiones);
        
        this.btnSearchPelicula= new JButton("Buscar por Pelicula");
        add(this.btnSearchPelicula);
        this.getBtnSearchPelicula().addActionListener(clickEventTransmisiones);
        
        this.btnSearchSerie = new JButton("Buscar por Serie");
        add(this.btnSearchSerie);
        this.getBtnSearchSerie().addActionListener(clickEventTransmisiones);

        this.btnSearchNumero = new JButton("# registros");
        add(this.btnSearchNumero);
        this.getBtnSearchNumero().addActionListener(clickEventTransmisiones);

        this.btnInsertPeli = new JButton("Agregar trasmision de Pelicula BD");
        add(this.getBtnInsertPeli());
        this.getBtnInsertPeli().addActionListener(clickEventTransmisiones);
        
        this.btnInsertSerie = new JButton("Agregar trasmision de Seria BD");
        add(this.getBtnInsertSerie());
        this.getBtnInsertSerie().addActionListener(clickEventTransmisiones);

        
    }

    /**
     * @return the lblAlias
     */
    public JLabel getLblAlias() {
        return lblAlias;
    }

    /**
     * @return the lblTituloPeli
     */
    public JLabel getLblTituloPeli() {
        return lblTituloPeli;
    }

    /**
     * @return the lblTituloSerie
     */
    public JLabel getLblTituloSerie() {
        return lblTituloSerie;
    }
    /**
     * @return the lblFechaHora
     */
    public JLabel getLblFechaHora() {
        return lblFechaHora;
    }

    /**
     * @return the txtTituloPeli
     */
    public JTextField getTxtTituloPeli() {
        return txtTituloPeli;
    }
    /**
     * @return the txtTituloSerie
     */
    public JTextField getTxtTituloSerie() {
        return txtTituloSerie;
    }

    /**
     * @return the txtFechaHora
     */
    public JTextField getTxtFechaHora() {
        return txtFechaHora;
    }

    /**
     * @return the txtAlias
     */
    public JTextField getTxtAlias() {
        return txtAlias;
    }

    /**
     * @return the btnSearchAll
     */
    public JButton getBtnSearchAll() {
        return btnSearchAll;
    }

    /**
     * @return the btnSearchAlias
     */
    public JButton getBtnSearchAlias() {
        return btnSearchAlias;
    }

    /**
     * @return the btnInsertPeli
     */

    public JButton getBtnInsertPeli() {
        return btnInsertPeli;
    }
    /**
     * @return the btnInsertSerie
     */
    public JButton getBtnInsertSerie() {
        return btnInsertSerie;
    }
    /**
     * @return the btnSearchNumero
     */
    public JButton getBtnSearchNumero() {
        return btnSearchNumero;
    }

    /**
     * @return the btnSearchPelicula
     */
    public JButton getBtnSearchPelicula() {
        return btnSearchPelicula;
    }

    /**
     * @return the btnSearchSerie
     */
    public JButton getBtnSearchSerie() {
        return btnSearchSerie;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param pelicula
     */
    public void setTblResults(ArrayList<TransmisionesModel> transmisiones) {
        String[] headers = {"Titulo", "Alias", "Fecha y Hora",};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < transmisiones.size(); i++) {
            tableModel.addRow(transmisiones.get(i).toArrayPeliUsu());
        }
    }

    public void setTblResults2(ArrayList<TransmisionesModel> transmisiones) {
        String[] headers = {"Alias", "Nombre", "Apellido", "Fecha y Hora"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < transmisiones.size(); i++) {
            tableModel.addRow(transmisiones.get(i).toArrayUsuarioTrns());
        }
    }

    public void setTblResults3(ArrayList<TransmisionesModel> transmisiones) {
        String[] headers = {"Titulo Serie y Peliculas", "Fecha y Hora"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < transmisiones.size(); i++) {
            tableModel.addRow(transmisiones.get(i).toArrayPeliFecha());
        }
    }

    public void setTblResults4(ArrayList<TransmisionesModel> transmisiones) {
        String[] headers = {"Titulo", "Alias", "Fecha y Hora",};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < transmisiones.size(); i++) {
            tableModel.addRow(transmisiones.get(i).toArrayPeliUsu());
        }
    }

}
