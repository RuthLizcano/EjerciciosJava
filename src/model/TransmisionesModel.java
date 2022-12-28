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
public class TransmisionesModel {

    private int idTransmision;
    private String usuAlias;
    private String usuAliasNombre;
    private String usuAliasApellido;
    private String fechaHora;
    private String peliTitulo;
    private String serieTitulo;
    private String seriesPeliculasTitule;

    public TransmisionesModel() {
    }

    public TransmisionesModel(int id, String usuAlias, String peliTitulo, String serieTitulo, String fechaHora) {
        this.usuAlias = usuAlias;
        this.fechaHora = fechaHora;
        this.peliTitulo = peliTitulo;
        this.serieTitulo = serieTitulo;
    }

    public TransmisionesModel(String seriesPeliculasTitule, String alias, String fechaHora) {
        this.seriesPeliculasTitule = seriesPeliculasTitule;
        this.usuAlias = alias;
        this.fechaHora = fechaHora;
    }

    public TransmisionesModel(String seriesPeliculasTitule, String fechaHora) {
        this.seriesPeliculasTitule = seriesPeliculasTitule;
        this.fechaHora = fechaHora;
    }

    public TransmisionesModel(String alias, String nombreAlias, String apellidoAlias, String fechaHora) {
        this.usuAlias = alias;
        this.usuAliasNombre = nombreAlias;
        this.usuAliasApellido = apellidoAlias;
        this.fechaHora = fechaHora;
    }

    public String getUsuAliasNombre() {
        return usuAliasNombre;
    }

    public String getUsuAliasApellido() {
        return usuAliasApellido;
    }

    public String getSeriesPeliculasTitule() {
        return seriesPeliculasTitule;
    }

    /**
     * @return the idTransmision
     */
    public int getIdTransmision() {
        return idTransmision;
    }

    /**
     * @return the usuAlias
     */
    public String getUsuAlias() {
        return usuAlias;
    }

    /**
     * @return the fechaHora
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * @return the peliTitulo
     */
    public String getPeliTitulo() {
        return peliTitulo;
    }

    /**
     * @return the serieTitulo
     */
    public String getSerieTitulo() {
        return serieTitulo;
    }

    public Object[] toArrayPeliUsu() {
        Object[] data = {seriesPeliculasTitule, usuAlias, fechaHora};
        return data;
    }

    public Object[] toArrayPeliFecha() {
        Object[] data = {seriesPeliculasTitule, fechaHora};
        return data;
    }

    public Object[] toArrayUsuarioTrns() {
        Object[] data = {usuAlias, usuAliasNombre, usuAliasApellido, fechaHora};
        return data;
    }

    public Object[] toArrayPeliSerie() {
        Object[] data = {usuAlias, fechaHora, peliTitulo, serieTitulo};
        return data;
    }
}
