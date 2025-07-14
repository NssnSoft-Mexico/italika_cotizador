package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long id_nombre_usuario;
    private Date fecha_pedido;
    private String resumen_pedido;
    private Boolean estatus_pedido;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id ; }

    public Long getid_nombre_usuario() { return id_nombre_usuario; }
    public void setid_nombre_usuario(Long id_nombre_usuario) { this.id_nombre_usuario = id_nombre_usuario; }
  
    public Date getfecha_pedido() { return fecha_pedido; }
    public void setfecha_pedido(Date fecha_pedido) { this.fecha_pedido = fecha_pedido; }
    
    public String getresumen_pedido() { return resumen_pedido; }
    public void setresumen_pedido(String resumen_pedido) { this.resumen_pedido = resumen_pedido; }
  
    public Boolean getestatus_pedido() { return estatus_pedido; }
    public void setestatus_pedido(Boolean estatus_pedido) { this.estatus_pedido = estatus_pedido; }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "id=" + id +
                ", id_nombre_usuario=" + id_nombre_usuario +
                ", fecha_pedido='" + fecha_pedido + '\'' +
                ", resumen_pedido=" + resumen_pedido +
                ", estatus_pedido=" + estatus_pedido +
                '}';
    }
}
