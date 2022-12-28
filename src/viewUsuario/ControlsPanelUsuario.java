/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewUsuario;

import ControllerUsuario.ClickEventUsuario;
import ControllerUsuario.InitialDataUsuario;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.UsuarioModel;

/**
 *
 * @author casierrav
 */
public class ControlsPanelUsuario extends JPanel {
 
    private JLabel                       lblAlias;
    private JTextField                   txtAlias;
    private JLabel                       lblNombre;
    private JTextField                   txtNombre;
    private JLabel                       lblApellido;
    private JTextField                   txtApellido;
    private JLabel                       lblEmail;
    private JTextField                   txtEmail;
    private JLabel                       lblCelular;
    private JTextField                   txtCelular;
    private JLabel                       lblContraseña;
    private JTextField                   txtContraseña;
    private JLabel                       lblFechaNacimiento;
    private JTextField                   txtFechaNacimiento;
    
    private JButton                      btnSearchAll;
    private JButton                      btnSearchAlias;
    private JButton                      btnSearchNumero;
    private JButton                      btnInsert;
    private JButton                      btnUpdate;
    private JTable                       tblResults;
    private JButton                      btnDelete;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanelUsuario(ResultsPanelUsuario resultsPanelusuario){
        this.tblResults = resultsPanelusuario.getTblResults();
        initComponents();
        
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(20,1));
        InitialDataUsuario initialDatausuario = new InitialDataUsuario();
        
        
        this.setTblResults(initialDatausuario.getUsuarioModel());
        
       
        this.lblAlias= new JLabel("Alias");
        add(this.getLblAlias());
        this.txtAlias = new JTextField();
        add(this.getTxtAlias());
        
        this.lblNombre = new JLabel("Nombre");
        add(this.getLblNombre());
        this.txtNombre = new JTextField();
        add(this.getTxtNombre());
        
        this.lblApellido = new JLabel("Apellido");
        add(this.getLblApellido());
        this.txtApellido = new JTextField();
        add(this.getTxtApellido());
        
        this.lblEmail = new JLabel("Email");
        add(this.getLblEmail());
        this.txtEmail = new JTextField();
        add(this.getTxtEmail());
        
        this.lblCelular = new JLabel("Numero de celular");
        add(this.getLblCelular());
        this.txtCelular = new JTextField();
        add(this.getTxtCelular());
        
        this.lblContraseña = new JLabel("Contraseña");
        add(this.getLblContraseña());
        this.txtContraseña= new JTextField();
        add(this.getTxtContraseña());
        
        this.lblFechaNacimiento = new JLabel("Fecha de Nacimiento");
        add(this.getLblFechaNacimiento());
        this.txtFechaNacimiento= new JTextField();
        add(this.getTxtFechaNacimiento());

        // Search button
        ClickEventUsuario clickEventusuario = new ClickEventUsuario(this);
        
        this.btnSearchAll = new JButton("Listar");
        add(this.btnSearchAll);
        this.getBtnSearchAll().addActionListener(clickEventusuario);
        
        this.btnSearchAlias = new JButton("Buscar por Alias");
        add(this.btnSearchAlias);
        this.getBtnSearchAlias().addActionListener(clickEventusuario);
        
        this.btnSearchNumero= new JButton("# registros");
        add(this.btnSearchNumero);
        this.getBtnSearchNumero().addActionListener(clickEventusuario);
          
        this.btnInsert= new JButton("Agregar Usuario BD");
        add(this.getBtnInsert());
        this.getBtnInsert().addActionListener(clickEventusuario);
        
        this.btnUpdate= new JButton("Actualizar usuario BD");
        add(this.getBtnUpdate());
        this.getBtnUpdate().addActionListener(clickEventusuario);
        
        this.btnDelete= new JButton("Borar Usuario");
        add(this.getBtnDelete());
        this.getBtnDelete().addActionListener(clickEventusuario);
    }

    /**
     * @return the lblAlias
     */
        public JLabel getLblAlias() {
        return lblAlias;
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
     * @return the lblEmail
     */  
        public JLabel getLblEmail() {
        return lblEmail;
         }
    /**
     * @return the lblCelular
     */  
        public JLabel getLblCelular() {
        return lblCelular;
         }
    /**
     * @return the lblContraseña
     */  
        public JLabel getLblContraseña() {
        return lblContraseña;
         }
    /**
     * @return the lblFechaNacimiento
     */  
        public JLabel getLblFechaNacimiento() {
        return lblFechaNacimiento;
         }
    
  
    /**
     * @return the txtAlias
     */
    public JTextField getTxtAlias() {
        return txtAlias;
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
     * @return the txtEmail
     */
    public JTextField getTxtEmail() {
        return txtEmail;
    }
    /**
     * @return the txtCelular
     */
    public JTextField getTxtCelular() {
        return txtCelular;
    }
    /**
     * @return the txtContraseña
     */
    public JTextField getTxtContraseña() {
        return txtContraseña;
    }
    /**
     * @return the txtFechaNacimiento
     */
    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
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
    public void setTblResults(ArrayList<UsuarioModel> usuario) {
        String[] headers = {"Alias", "Nombre", "Apellido", "Email","Numero Celular","contraseña","Fecha de Nacimiento" };
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<usuario.size(); i++){
            tableModel.addRow(usuario.get(i).toArray() );
        }
    }


   
}