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
public class DirectorModel {
    private int idDirector;
    private String nombreDirector;
    private String apellidoDirector;
    private String nacionalidad;

    public DirectorModel() {
    }

    public DirectorModel(int idDirector, String nombreDirector, String apellidoDirector, String nacionalidad) {
        this.idDirector = idDirector;
        this.nombreDirector = nombreDirector;
        this.apellidoDirector = apellidoDirector;
        this.nacionalidad = nacionalidad;
    }
     public DirectorModel(String nombreDirector, String apellidoDirector, String nacionalidad) {
        this.nombreDirector = nombreDirector;
        this.apellidoDirector = apellidoDirector;
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the idDirector
     */
    public int getIdDirector() {
        return idDirector;
    }

    /**
     * @param idDirector the idDirector to set
     */
    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    /**
     * @return the nombreDirector
     */
    public String getNombreDirector() {
        return nombreDirector;
    }

    /**
     * @param nombreDirector the nombreDirector to set
     */
    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    /**
     * @return the apellidoDirector
     */
    public String getApellidoDirector() {
        return apellidoDirector;
    }

    /**
     * @param apellidoDirector the apellidoDirector to set
     */
    public void setApellidoDirector(String apellidoDirector) {
        this.apellidoDirector = apellidoDirector;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
     public Object[] toArray(){
        Object[] data = {nombreDirector, apellidoDirector, nacionalidad};
        return data;
    }
    
    
}
