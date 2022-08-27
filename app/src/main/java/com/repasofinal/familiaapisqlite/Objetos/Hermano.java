package com.repasofinal.familiaapisqlite.Objetos;

public class Hermano {
    private int idHermano;
    private String nombre;
    private String fechaNacimiento;
    private String lugarNacimiento;
    private Boolean vive;

    public Hermano(){

    }

    public Hermano(String nombre, String fechaNacimiento, String lugarNacimiento, Boolean vive) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.vive = vive;
    }

    public int getIdHermano() {
        return idHermano;
    }

    public void setIdHermano(int idHermano) {
        this.idHermano = idHermano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Boolean getVive() {
        return vive;
    }

    public void setVive(Boolean vive) {
        this.vive = vive;
    }

    public String toString(){
        String viveHermano = "Si";
        if(!getVive())
            viveHermano = "No";
        return "Nombre Hermano: " + nombre + "\n" +
                "Fecha Nacimiento: " + fechaNacimiento + "\n" +
                "Lugar Nacimiento: " + lugarNacimiento + "\n" +
                "Vive Hermano: " + viveHermano + "\n" ;
    }
}
