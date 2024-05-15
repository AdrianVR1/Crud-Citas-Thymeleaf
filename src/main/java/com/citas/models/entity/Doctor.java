package com.citas.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctores")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctores")
    private int iddoctores;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El Apellido no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "apellido")
    private String apellido;

    @NotBlank(message = "El telefono no puede estar en blanco")
    @Pattern(regexp = "^[0-9]*$", message = "El telefono solo debe contener numeros")
    @Size(min = 9, max = 15, message = "El telefono debe tener entre 9 y 15 numero")
    @Column(name = "telefono")
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idespecialidad")
    private Especialidad especialidad;

}
