package com.ibm.academia.apirest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona
{
    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "profesor_carrera", schema = "universidad",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id"))
    private Set<Carrera> carreras;

    public Profesor(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo)
    {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "sueldo=" + sueldo +
                '}';
    }
}