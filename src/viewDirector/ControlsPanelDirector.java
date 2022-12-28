/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewDirector;
import ControllerDirector.ClickEventDirector;
import ControllerDirector.InitialDataDirector;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.DirectorModel;

/**
 *
 * @author casierrav
 */
public class ControlsPanelDirector extends JPanel {
 
    private JLabel                       lblNombre;
    private JTextField                   txtNombre;
    private JLabel                       lblApellido;
    private JTextField                   txtApellido;
    private JLabel                       lblNacionalidad;
    private JTextField                   txtNacionalidad;
    
    private JButton                      btnSearchAll;
    private JButton                      btnSearchNacionalidad;
    private JButton                      btnSearchNombreApellido;
    private JButton                      btnSearchNumero;
    private JButton                      btnInsert;
    private JButton                      btnUpdate;
    private JTable                       tblResults;
    private JButton                      btnDelete;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanelDirector(ResultsPanelDirector resultsPaneldirector){
        this.tblResults = resultsPaneldirector.getTblResults();
        initComponents();
        
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(17,1));
        InitialDataDirector initialDataDirector = new InitialDataDirector();
        
        // Complete ArtPieces info
        this.setTblResults(initialDataDirector.getDirectorModel());
        
        // Pelicula selection
        
        this.lblNombre = new JLabel("Nombre");
        add(this.getLblNombre());
        this.txtNombre= new JTextField();
        add(this.getTxtNombre());
        
        this.lblApellido= new JLabel("Apellido");
        add(this.getLblApellido());
        this.txtApellido= new JTextField();
        add(this.getTxtApellido());
        
        this.lblNacionalidad = new JLabel("Nacionalidad");
        add(this.getLblNacionalidad());
        this.txtNacionalidad = new JTextField();
        add(this.getTxtNacionalidad());
                
        
        
        
        // Search button
        ClickEventDirector clickEventdirector= new ClickEventDirector(this);
        this.btnSearchAll = new JButton("Listar");
        add(this.btnSearchAll);
        this.getBtnSearchAll().addActionListener(clickEventdirector);
        
        this.btnSearchNombreApellido = new JButton("Buscar por Nombre y Apellido");
        add(this.btnSearchNombreApellido);
        this.getBtnSearchNombreApellido().addActionListener(clickEventdirector);
        
        this.btnSearchNacionalidad = new JButton("Buscar por Nacionalidad");
        add(this.btnSearchNacionalidad);
        this.getBtnSearchNacionalidad().addActionListener(clickEventdirector);
        
        this.btnSearchNumero= new JButton("# registros");
        add(this.btnSearchNumero);
        this.getBtnSearchNumero().addActionListener(clickEventdirector);
        
        
        // Insert  button
        this.btnInsert= new JButton("Agregar Director BD");
        add(this.getBtnInsert());
        this.getBtnInsert().addActionListener(clickEventdirector);
        
        this.btnUpdate= new JButton("Actualizar Director BD");
        add(this.getBtnUpdate());
        this.getBtnUpdate().addActionListener(clickEventdirector);
        
        this.btnDelete= new JButton("Borar Director");
        add(this.getBtnDelete());
        this.getBtnDelete().addActionListener(clickEventdirector);
    }

    /**
     * @return the lblNombre
     */
        public JLabel getLblNombre() {
        return lblNombre;
         }
    /**
     * @return the lblApellido
     */    
        public JLabel getLblApellido() {
        return lblApellido;
         }
    /**
     * @return the lblNacionalidad
     */  
        public JLabel getLblNacionalidad() {
        return lblNacionalidad;
         }
    
  
    /**
     * @return the txtNombre
     */
    public JTextField getTxtNombre() {

        return txtNombre;
    }
    /**
     * @return the txtApellido
     */
    public JTextField getTxtApellido() {
        return txtApellido;
    }
    /**
     * @return the txtNacionalidad
     */
    public JTextField getTxtNacionalidad() {
        return txtNacionalidad;
    }
    
    
    /**
     * @return the btnSearchAll
     */
    public JButton getBtnSearchAll() {
        return btnSearchAll;
    }
    /**
     * @return the btnSearchNombreApellido
     */
    public JButton getBtnSearchNombreApellido() {
        return btnSearchNombreApellido;
    }
    /**
     * @return the btnSearchNacionalidad
     */
    public JButton getBtnSearchNacionalidad() {
        return btnSearchNacionalidad;
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
    public void setTblResults(ArrayList<DirectorModel> director) {
        String[] headers = {"Nombre", "Apellido", "Nacionalidad", };
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<director.size(); i++){
            tableModel.addRow(director.get(i).toArray() );
        }
    }


   
}