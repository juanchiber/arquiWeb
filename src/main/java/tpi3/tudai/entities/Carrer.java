package tpi3.tudai.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Carrer {
   

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private Double duracionAnios;
    @OneToMany(mappedBy = "carrera")
    Set<StudentCarrer> estudiantes;
    
    public Carrer(String nombre, Double duracionAnios) {
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
        this.estudiantes = new HashSet<StudentCarrer>();
    }
    public Carrer(Integer id, String nombre, Double duracionAnios) {
        this.id = id;
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
        this.estudiantes = new HashSet<StudentCarrer>();
    }
    public Carrer() {
        super();
    } 
    public String getNombre() {
        return nombre;
    }
    public Double getDuracionAnios() {
        return duracionAnios;
    }
    public Integer getId() {
        return id;
    }
}