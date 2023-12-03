package com.example.proyectoprototipo;

public class Libro {
    private String idd;
    private String autor;
    private String nombre;
    //private String estado;

    public Libro()
    {
        this.idd="";
        this.autor="";
        this.nombre="";
        //this.estado="";
    }

    public Libro( String idd, String autor, String nombre /*, String estado*/ )
    {
        this.idd=idd;
        this.autor=autor;
        this.nombre=nombre;
        //this.estado=estado;
    }

    public String getID() {
        return idd;
    }

    public void setID(String idd) {
        this.idd = idd;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;

    }*/

    @Override
    public String toString() {
        return "ID{" +
                "autor='" + autor + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
