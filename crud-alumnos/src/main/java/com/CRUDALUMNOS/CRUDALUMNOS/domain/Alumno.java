package com.CRUDALUMNOS.CRUDALUMNOS.domain;
//clase POJO unicamente para los datos
public class Alumno
{
    private int ID;
    private String nombre;
    private String email;
    private String edad;
    private String curso;

    public Alumno(int ID, String nombre, String email, String edad, String curso) {
        this.ID = ID;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.curso = curso;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


}
