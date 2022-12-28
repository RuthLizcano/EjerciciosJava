/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RUYIS
 */
public class UsuarioModel {
    private String aliasUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String email;
    private long celular;
    private String contraseña;
    private String fechaNcimiento;
    

    public UsuarioModel() {
    }

    public UsuarioModel(String aliasUsuario, String nombreUsuario, String apellidoUsuario, String email, long celular, String contraseña, String fechaNcimiento) {
        this.aliasUsuario = aliasUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.email = email;
        this.celular = celular;
        this.fechaNcimiento = fechaNcimiento;
        this.contraseña = contraseña;
    }

    /**
     * @return the aliasUsuario
     */
    public String getAliasUsuario() {
        return aliasUsuario;
    }

    /**
     * @param aliasUsuario the aliasUsuario to set
     */
    public void setAliasUsuario(String aliasUsuario) {
        this.aliasUsuario = aliasUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the apellidoUsuario
     */
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    /**
     * @param apellidoUsuario the apellidoUsuario to set
     */
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the celular
     */
    public long getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(long celular) {
        this.celular = celular;
    }

    /**
     * @return the fechaNcimiento
     */
    public String getFechaNcimiento() {
        return fechaNcimiento;
    }

    /**
     * @param fechaNcimiento the fechaNcimiento to set
     */
    public void setFechaNcimiento(String fechaNcimiento) {
        this.fechaNcimiento = fechaNcimiento;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public Object[] toArray(){
        Object[] data = {aliasUsuario, nombreUsuario, apellidoUsuario, email, celular, contraseña, fechaNcimiento};
        return data;
    }
  
    
}
