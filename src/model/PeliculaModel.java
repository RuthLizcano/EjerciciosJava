/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

/**
 *
 * @author RUYIS
 */
public class PeliculaModel {
    private String nombreDirector;
    private String apellidoDirector;
    private String tituloPelicula;
    private String resumen;
    private int añoPelicula;

    public PeliculaModel() {
    }

    public PeliculaModel(String tituloPelicula, String resumen, int añoPelicula, String nombreDirector,String apellidoDirector) {
        this.tituloPelicula = tituloPelicula;
        this.resumen = resumen;
        this.añoPelicula = añoPelicula;
        this.nombreDirector = nombreDirector;
        this.apellidoDirector= apellidoDirector;
    }

    /**
     * @return the idDirector
     */
    public String getApellidoDirector() {    
        return apellidoDirector;
    }

    public void setApellidoDirector(String apellidoDirector) {
        this.apellidoDirector = apellidoDirector;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }
    

    /**
     * @return the tituloPelicula
     */
    public String getTituloPelicula() {
        return tituloPelicula;
    }

    /**
     * @param tituloPelicula the tituloPelicula to set
     */
    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    /**
     * @return the resumen
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * @param resumen the resumen to set
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /**
     * @return the añoPelicula
     */
    public int getAñoPelicula() {
        return añoPelicula;
    }

    /**
     * @param añoPelicula the añoPelicula to set
     */
    public void setAñoPelicula(int añoPelicula) {
        this.añoPelicula = añoPelicula;
    }

    public Object[] toArray(){
        Object[] data = {tituloPelicula, resumen, añoPelicula, nombreDirector, apellidoDirector};
        return data;
    }

    
    
    
}
