package com.citas.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpacientes")
    private int idpacientes;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El Apellido no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "apellido")
    private String apellido;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechanac")
    private Date fechanac;

    @NotBlank(message = "La direccion no puede estar en blanco")
    @Size(min = 2, max = 250, message = "La direccion debe tener entre 2 y 250 caracteres")
    @Column(name = "direccion")
    private String direccion;

    @NotBlank(message = "El telefono no puede estar en blanco")
    @Pattern(regexp = "^[0-9]*$", message = "El telefono solo debe contener numeros")
    @Size(min = 9, max = 15, message = "El telefono debe tener entre 9 y 15 numero")
    @Column(name = "telefono")
    private String telefono;
}
