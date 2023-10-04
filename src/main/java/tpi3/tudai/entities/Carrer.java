package tpi3.tudai.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "carrers")
@Getter
public class Carrer {
   

    @Id
    private Integer id;
    
    @Column
    private String nombre;
    
    @Column
    private Integer duracionAnios;
    
    @OneToMany(mappedBy = "carrera")
    Set<StudentCarrer> estudiantes;
    
    public Carrer(String nombre, Integer duracionAnios) {
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
        this.estudiantes = new HashSet<StudentCarrer>();
    }
    public Carrer(Integer id, String nombre, Integer duracionAnios) {
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
    
    public Integer getDuracionAnios() {
        return duracionAnios;
    }
    
    public Integer getId() {
        return id;
    }
    
    /*
    public Carrer getCarrerById(Set<Carrer> carreras, Integer id) {
        for (Carrer carrera : carreras) {
            if (carrera.getId().equals(id)) {
                return carrera;
            }
        }
        return null; 
    }
   */
    
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDuracionAnios(Integer duracionAnios) {
		this.duracionAnios = duracionAnios;
	}
}