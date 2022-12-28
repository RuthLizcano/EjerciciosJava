/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerUsuario;


import acces.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.UsuarioModel;
import viewUsuario.ControlsPanelUsuario;

/**
 *
 * @author RUYIS
 */
public class ClickEventUsuario implements ActionListener {

    private ControlsPanelUsuario controlsPanelusuario;

    /**
     * Constructor of the class
     *
     * @param controlsPanel
     */
    public ClickEventUsuario(ControlsPanelUsuario controlsPanelusuario) {
        this.controlsPanelusuario = controlsPanelusuario;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.controlsPanelusuario.getBtnSearchAll()) {

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ArrayList<UsuarioModel> usuarios = usuarioDAO.getTodosUsuarios();
            this.controlsPanelusuario.setTblResults(usuarios);

        }  else if (actionEvent.getSource() == this.controlsPanelusuario.getBtnSearchAlias()) {

            String alias = (String) this.controlsPanelusuario.getTxtAlias().getText();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ArrayList<UsuarioModel> usuarios = usuarioDAO.getUsuarioPorAlias(alias);
            this.controlsPanelusuario.setTblResults(usuarios);

        } else if (actionEvent.getSource() == this.controlsPanelusuario.getBtnInsert()) {
            
            JOptionPane.showMessageDialog(null, "Recuerde colocar la fecha asi: YYYY-MM-DD ");
            String alias=(String) this.controlsPanelusuario.getTxtAlias().getText();
            String nombre = (String) this.controlsPanelusuario.getTxtNombre().getText();
            String apellido = (String) this.controlsPanelusuario.getTxtApellido().getText();
            String email=(String) this.controlsPanelusuario.getTxtEmail().getText();
            Long celular = Long.parseLong(((String) this.controlsPanelusuario.getTxtCelular().getText()));
            String contraseña=(String) this.controlsPanelusuario.getTxtContraseña().getText();
            String fechaNacimiento=(String) this.controlsPanelusuario.getTxtFechaNacimiento().getText();
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            UsuarioModel updateUsuario = new UsuarioModel(alias,nombre,apellido,email,celular,contraseña,fechaNacimiento);
            try {
                usuarioDAO.insertUsuario(updateUsuario);
            } catch (ParseException ex) {
                Logger.getLogger(ClickEventUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (actionEvent.getSource() == this.controlsPanelusuario.getBtnUpdate()) {

            JOptionPane.showMessageDialog(null, "Recuerde no se puede modificar el alias");
            JOptionPane.showMessageDialog(null, "Recuerde colocar la fecha asi: YYYY-MM-DD ");
            String alias=(String) this.controlsPanelusuario.getTxtAlias().getText();
            String nombre = (String) this.controlsPanelusuario.getTxtNombre().getText();
            String apellido = (String) this.controlsPanelusuario.getTxtApellido().getText();
            String email=(String) this.controlsPanelusuario.getTxtEmail().getText();
            Long celular = Long.parseLong(((String) this.controlsPanelusuario.getTxtCelular().getText()));
            String contraseña=(String) this.controlsPanelusuario.getTxtContraseña().getText();
            String fechaNacimiento=(String) this.controlsPanelusuario.getTxtFechaNacimiento().getText();
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            UsuarioModel updateUsuario = new UsuarioModel(alias,nombre,apellido,email,celular,contraseña,fechaNacimiento);
            try {
                usuarioDAO.updateUsuario(updateUsuario);
            } catch (ParseException ex) {
                Logger.getLogger(ClickEventUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (actionEvent.getSource() == this.controlsPanelusuario.getBtnSearchNumero()) {

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            JOptionPane.showMessageDialog(null, "Hay " + usuarioDAO.getNumeroDeUsuarios()
                    + " de usuarios en total");

        } else if (actionEvent.getSource() == this.controlsPanelusuario.getBtnDelete()) {
            
            System.out.println("aqui");
            String alias = (String) this.controlsPanelusuario.getTxtAlias().getText();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.deleteUsuario(alias);
        }

    }

}
