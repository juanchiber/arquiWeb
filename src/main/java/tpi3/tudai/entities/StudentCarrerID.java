package tpi3.tudai.entities;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentCarrerID implements Serializable {
    private Student estudiante;
    private Carrer carrera;
    
	public StudentCarrerID() {
		super();
	}

	public StudentCarrerID(Student estudiante, Carrer carrera) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
	}

	public Student getEstudiante() {
		return estudiante;
	}
	
	public void setEstudiante(Student estudiante) {
		this.estudiante = estudiante;
	}
	
	public Carrer getCarrera() {
		return carrera;
	}
	
	public void setCarrera(Carrer carrera) {
		this.carrera = carrera;
	}
	
	
    
}
