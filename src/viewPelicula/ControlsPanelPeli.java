/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewPelicula;
import ControllerPeli.ClickEvent;
import ControllerPeli.InitialData;
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

/**
 *
 * @author casierrav
 */
public class ControlsPanelPeli extends JPanel {
 
    private JLabel                       lbltitulo;
    private JTextField                   txtTitulo;
    private JLabel                       lblresumen;
    private JTextField                   txtResumen;
    private JLabel                       lblano;
    private JTextField                   txtAno;
    private JLabel                       lblnombreDirect;
    private JTextField                   txtNombreDirect;
    private JLabel                       lblapellidoDirect;
    private JTextField                   txtApellidoDirect;
    private JButton                      btnSearchAll;
    private JButton                      btnSearchTitulo;
    private JButton                      btnSearchAno;
    private JButton                      btnInsert;
    private JButton                      btnUpdate;
    private JButton                      btnSearchNumero;
    private JTable                       tblResults;
    private JButton                      btnDelete;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanelPeli(ResultsPanelPeli resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
        
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(17,1));
        InitialData initialData = new InitialData();
        
        // Complete ArtPieces info
        this.setTblResults(initialData.getPeliculaModel());
        
        // Pelicula selection
        
        this.lbltitulo = new JLabel("Titulo");
        add(this.getLbltitulo());
        this.txtTitulo = new JTextField();
        add(this.getTxtTitulo());
        
        this.lblresumen = new JLabel("Resumen");
        add(this.getLblresumen());
        this.txtResumen = new JTextField();
        add(this.getTxtResumen());
        
        this.lblano = new JLabel("Año");
        add(this.getLblano());
        this.txtAno = new JTextField();
        add(this.getTxtAno());
                
        this.lblnombreDirect = new JLabel("Nombre del director");
        add(this.getLblnombreDirect());
        this.txtNombreDirect = new JTextField();
        add(this.getTxtNombreDirect());
        
        
        this.lblapellidoDirect = new JLabel("Apellido del director");
        add(this.getLblapellidoDirect());
        this.txtApellidoDirect = new JTextField();
        add(this.getTxtApellidoDirect());
        
        
        
        // Search button
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearchAll = new JButton("Listar");
        add(this.btnSearchAll);
        this.getBtnSearchAll().addActionListener(clickEvent);
        
        this.btnSearchTitulo = new JButton("Buscar por titulo");
        add(this.btnSearchTitulo);
        this.getBtnSearchTitulo().addActionListener(clickEvent);
        
        this.btnSearchAno= new JButton("Buscar por año");
        add(this.btnSearchAno);
        this.getBtnSearchAno().addActionListener(clickEvent);
        this.btnSearchNumero= new JButton("# registros");
        add(this.btnSearchNumero);
        this.getBtnSearchNumero().addActionListener(clickEvent);
        
        
        // Insert  button
        this.btnInsert= new JButton("Agregar Pelicula BD");
        add(this.getBtnInsert());
        this.getBtnInsert().addActionListener(clickEvent);
        
        this.btnUpdate= new JButton("Actualizar Pelicula BD");
        add(this.getBtnUpdate());
        this.getBtnUpdate().addActionListener(clickEvent);
        
        this.btnDelete= new JButton("Borar Pelicula");
        add(this.getBtnDelete());
        this.getBtnDelete().addActionListener(clickEvent);
    }

    /**
     * @return the lbltitulo
     */
        public JLabel getLbltitulo() {
        return lbltitulo;
         }
    /**
     * @return the lblresumen
     */    
        public JLabel getLblresumen() {
        return lblresumen;
         }
    /**
     * @return the lblano
     */  
        public JLabel getLblano() {
        return lblano;
         }
    /**
     * @return the lblnombreDirector
     */
        public JLabel getLblnombreDirect() {
        return lblnombreDirect;
         }
    /**
     * @return the lblapellidoDirector
     */    
        public JLabel getLblapellidoDirect() {
        return lblapellidoDirect;
         }

  
    /**
     * @return the txtTitulo
     */
    public JTextField getTxtTitulo() {

        return txtTitulo;
    }
    /**
     * @return the txtResumen
     */
    public JTextField getTxtResumen() {
        return txtResumen;
    }
    /**
     * @return the txtano
     */
    public JTextField getTxtAno() {
        return txtAno;
    }
    /**
     * @return the txtNombreDirect
     */
    public JTextField getTxtNombreDirect() {
        return txtNombreDirect;
    }
    /**
     * @return the txtapellidirect
     */
    public JTextField getTxtApellidoDirect() {
        return txtApellidoDirect;
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
     * @return the btnSearchAno
     */
    public JButton getBtnSearchAno() {
        return btnSearchAno;
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
     * @param pelicula
     */    
    public void setTblResults(ArrayList<PeliculaModel> pelicula) {
        String[] headers = {"Titulo", "Resumen", "Año", "Nombre Director", "Apellido Director"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<pelicula.size(); i++){
            tableModel.addRow(pelicula.get(i).toArray() );
        }
    }


   
}