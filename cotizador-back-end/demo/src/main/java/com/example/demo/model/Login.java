package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String password;
    private String direccion;
    private String nombre_user;
    private Date fecha_creacion;
    private Long tipo;
    private String correo;

   public String getUsername() { 
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getNombre_user(){
        return nombre_user;
    }

    public void setNombre_user(String nombre_user){
        this.nombre_user = nombre_user;
    }

    public Date getFecha_creacion(){
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion){
        this.fecha_creacion = fecha_creacion;
    }

    public Long getTipo(){
        return tipo;
    }

    public void setTipo(Long tipo){
        this.tipo = tipo;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
}
