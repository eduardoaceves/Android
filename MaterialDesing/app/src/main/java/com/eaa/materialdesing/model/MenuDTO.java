package com.eaa.materialdesing.model;

public class MenuDTO {

    private String Imagen;
    private String Titulo;

    public MenuDTO(String imagen, String titulo) {
        Imagen = imagen;
        Titulo = titulo;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

}
