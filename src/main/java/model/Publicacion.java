/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Publicacion {
    private String username;    
    private String descripcion;
    private String cilindrada;  
    private String modelo;     
    private String urlfoto;
    private Date signup_date;
    
    public Publicacion(String username){
        this.username = username;
        this.signup_date = new Date();
    }
    
    public Publicacion(String username, String descripcion, String cilindrada, String modelo, String urlfoto){
        this.username = username;
        this.descripcion = descripcion;
        this.cilindrada = cilindrada;
        this.modelo = modelo;        
        this.urlfoto = urlfoto;
        this.signup_date = new Date();
    }
  
    public String getUserName(){
        return this.username;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public Date getSignup_date() {
        return signup_date;
    }

}
