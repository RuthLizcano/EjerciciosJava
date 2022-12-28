/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewSerie;
import viewPelicula.*;
import ControllerPeli.ClickEvent;
import ControllerPeli.InitialData;
import ControllerSerie.ClickEventSerie;
import ControllerSerie.InitialDataSerie;
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

/**
 *
 * @author casierrav
 */
public class ControlsPanelSerie extends JPanel {
 
    private JLabel                       lbltitulo;
    private JTextField                   txtTitulo;
    private JLabel                       lblnumTemp;
    private JTextField                   txtnumTemp;
    private JLabel                       lblnumEpis;
    private JTextField                   txtnumEpis;
    private JButton                      btnSearchAll;
    private JButton                      btnSearchTitulo;
    private JButton                      btnSearchNumero;
    private JButton                      btnInsert;
    private JButton                      btnUpdate;
    private JTable                       tblResults;
    private JButton                      btnDelete;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanelSerie(ResultsPanelSerie resultsPanelserie){
        this.tblResults = resultsPanelserie.getTblResults();
        initComponents();
        
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(17,1));
        InitialDataSerie initialDataserie = new InitialDataSerie();
        

        this.setTblResults(initialDataserie.getSerieModel());

        
        this.lbltitulo = new JLabel("Titulo");
        add(this.getLbltitulo());
        this.txtTitulo = new JTextField();
        add(this.getTxtTitulo());
        
        this.lblnumTemp = new JLabel("Numero de Temporadas");
        add(this.getLblnumTemp());
        this.txtnumTemp = new JTextField();
        add(this.getTxtnumTemp());
        
        this.lblnumEpis = new JLabel("Numero de Episodios");
        add(this.getLblnumEpis());
        this.txtnumEpis = new JTextField();
        add(this.getTxtnumEpis());
                
        
        
        
        // Search button
        ClickEventSerie clickEventserie = new ClickEventSerie(this);
        this.btnSearchAll = new JButton("Listar");
        add(this.btnSearchAll);
        this.getBtnSearchAll().addActionListener(clickEventserie);
        
        this.btnSearchTitulo = new JButton("Buscar por titulo");
        add(this.btnSearchTitulo);
        this.getBtnSearchTitulo().addActionListener(clickEventserie);
        
        this.btnSearchNumero= new JButton("# registros");
        add(this.btnSearchNumero);
        this.getBtnSearchNumero().addActionListener(clickEventserie);
        
        
        // Insert  button
        this.btnInsert= new JButton("Agregar Serie BD");
        add(this.getBtnInsert());
        this.getBtnInsert().addActionListener(clickEventserie);
        
        this.btnUpdate= new JButton("Actualizar Serie BD");
        add(this.getBtnUpdate());
        this.getBtnUpdate().addActionListener(clickEventserie);
        
        this.btnDelete= new JButton("Borar Serie");
        add(this.getBtnDelete());
        this.getBtnDelete().addActionListener(clickEventserie);
    }

    /**
     * @return the lbltitulo
     */
        public JLabel getLbltitulo() {
        return lbltitulo;
         }
    /**
     * @return the lblnumtemp
     */    
        public JLabel getLblnumTemp() {
        return lblnumTemp;
         }
    /**
     * @return the lblnumEpis
     */  
        public JLabel getLblnumEpis() {
        return lblnumEpis;
         }
    
  
    /**
     * @return the txtTitulo
     */
    public JTextField getTxtTitulo() {

        return txtTitulo;
    }
    /**
     * @return the txtnumTemp
     */
    public JTextField getTxtnumTemp() {
        return txtnumTemp;
    }
    /**
     * @return the txtnumEpis
     */
    public JTextField getTxtnumEpis() {
        return txtnumEpis;
    }
    
    
    /**
     * @return the btnSearchAll
     */
    public JButton getBtnSearchAll() {
        return btnSearchAll;
    }
    /**
     * @return the btnSearchTitulo
     */
    public JButton getBtnSearchTitulo() {
        return btnSearchTitulo;
    }
    /**
     * @return the btnInsert
     */
    
    public JButton getBtnInsert() {
        return btnInsert;
    }
    /**
     * @return the btnSearchNumero
     */
    public JButton getBtnSearchNumero() {
        return btnSearchNumero;
    }
    /**
     * @return the btnUpdate
     */
    public JButton getBtnUpdate() {        
        return btnUpdate;
    }
    /**
     * @return the btnDelete
     */
    public JButton getBtnDelete() {        
        return btnDelete;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }
    

 


    /**
     * @param 
     */    
    public void setTblResults(ArrayList<SerieModel> serie) {
        String[] headers = {"Titulo", "Numero de Temporadas", "Numero de Episodios", };
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<serie.size(); i++){
            tableModel.addRow(serie.get(i).toArray() );
        }
    }


   
}