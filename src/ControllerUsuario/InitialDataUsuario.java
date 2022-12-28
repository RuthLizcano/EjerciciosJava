/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerUsuario;


import acces.UsuarioDAO;
import java.util.ArrayList;
import model.UsuarioModel;

/**
 *
 * @author RUYIS
 */
public class InitialDataUsuario {
    private ArrayList<UsuarioModel> usuario = null;
    
    public InitialDataUsuario(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.usuario= usuarioDAO.getTodosUsuarios();
    }
    public ArrayList<UsuarioModel> getUsuarioModel() {
        return usuario;
    }
}
