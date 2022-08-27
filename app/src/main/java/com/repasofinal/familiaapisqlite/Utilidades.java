package com.repasofinal.familiaapisqlite;

public class Utilidades {
    //Tabla Usuario y campos
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_IDUSUARIO = "idUser";
    public static final String CAMPO_NOMBREUSUARIO = "nombreUsuario";
    public static final String CAMPO_NOMBREPADRE = "nombrePadre";
    public static final String CAMPO_NOMBREMADRE = "nombreMadre";
    public static final String CAMPO_FECHANACIMIENTO = "fechaNacimiento";
    public static final String CAMPO_LUGARNACIMIENTO = "lugarNacimiento";
    public static final String CAMPO_VIVE = "vive";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_IDUSUARIO+" INTEGER,"+CAMPO_NOMBREUSUARIO+" TEXT,"+CAMPO_NOMBREPADRE+" TEXT,"+CAMPO_NOMBREMADRE+" TEXT,"+CAMPO_FECHANACIMIENTO+" TEXT,"+CAMPO_LUGARNACIMIENTO+" TEXT,"+CAMPO_VIVE+" BOOLEAN)";


    //Tabla Hermano y campos
    public static final String TABLA_HERMANO = "hermano";
    public static final String CAMPO_IDHERMANO = "idHermano";
    public static final String CAMPO_NOMBREHERMANO = "nombreHermano";


    public static final String CREAR_TABLA_HERMANO = "CREATE TABLE "+TABLA_HERMANO+" ("+CAMPO_IDHERMANO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_NOMBREHERMANO+" TEXT,"+CAMPO_FECHANACIMIENTO+" TEXT,"+CAMPO_LUGARNACIMIENTO+" TEXT,"+CAMPO_VIVE+" BOOLEAN,"+CAMPO_IDUSUARIO+" INTEGER)";


}
