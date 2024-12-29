package com.EEspindola.ServicioGetAll.JPA.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Usuario")
public class UsuarioJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    public int idUsuario;

    @Column(name = "folio")
    public String folio;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "apellidopaterno")
    public String apellidoPaterno;

    @Column(name = "apellidomaterno")
    public String apellidoMaterno;

    @Column(name = "fechanacimiento")
    public Date fechaNacimiento;

    @Column(name = "username")
    public String username;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "status")
    public String status;

}
