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
public class SerieModel {
    private String tituloSerie;
    private int numTemporada;
    private int numEpisodio;

    public SerieModel() {
    }

    public SerieModel(String tituloSerie, int numTemporada, int numEpisodio) {
        this.tituloSerie = tituloSerie;
        this.numTemporada = numTemporada;
        this.numEpisodio = numEpisodio;
    }

    /**
     * @return the tituloSerie
     */
    public String getTituloSerie() {
        return tituloSerie;
    }

    /**
     * @param tituloSerie the tituloSerie to set
     */
    public void setTituloSerie(String tituloSerie) {
        this.tituloSerie = tituloSerie;
    }

    /**
     * @return the numTemporada
     */
    public int getNumTemporada() {
        return numTemporada;
    }

    /**
     * @param numTemporada the numTemporada to set
     */
    public void setNumTemporada(int numTemporada) {
        this.numTemporada = numTemporada;
    }

    /**
     * @return the numEpisodio
     */
    public int getNumEpisodio() {
        return numEpisodio;
    }

    /**
     * @param numEpisodio the numEpisodio to set
     */
    public void setNumEpisodio(int numEpisodio) {
        this.numEpisodio = numEpisodio;
    }
    
    public Object[] toArray(){
        Object[] data = {tituloSerie, numTemporada, numEpisodio};
        return data;
    }
    
    
}
