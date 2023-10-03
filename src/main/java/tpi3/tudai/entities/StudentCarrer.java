package tpi3.tudai.entities;

import java.time.LocalDate;
import java.util.Optional;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentsCarrers")
public class StudentCarrer {

	@EmbeddedId
    private StudentCarrerID id;
	
    @Column
    LocalDate inscripcion;
    
    @Column(nullable = true)
    LocalDate graduacion;
    
    @Column
    private boolean seGraduo;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "estudiante")
    private Student estudiante;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "carrera")
    private Carrer carrera;
    
    public StudentCarrer() {
    }
    
    public StudentCarrer(LocalDate inscripcion, Student e, Carrer c) {
        this.inscripcion = inscripcion;
        this.seGraduo = false;
        this.graduacion = null;
        this.estudiante = e;
        this.carrera = c;
    }
    
    public StudentCarrer(Student e, Carrer c){
        this.carrera = c;
        this.estudiante = e;
        this.inscripcion = LocalDate.now();
        this.graduacion = null;
        this.seGraduo = false;
    }
    
    public StudentCarrer(LocalDate inscripcion, LocalDate graduacion, Student e, Carrer c) {
        this.inscripcion = inscripcion;
        if(graduacion.getYear()==0) {
        	this.seGraduo= false;
        }else {
        	this.seGraduo = true;
        }
        this.graduacion = graduacion;
        this.estudiante = e;
        this.carrera = c;
    }
    
    public LocalDate getInscripcion() {
        return inscripcion;
    }
    
    public LocalDate getGraduacion() {
        return graduacion;
    }
    
    public boolean isSeGraduo() {
        return seGraduo;
    }
    
    public Student getEstudiante() {
        return estudiante;
    }
    
    public Carrer getCarrera() {
        return carrera;
    }
    
    public Carrer getCarrer(Optional<Carrer> carrerOptional) {
        return carrerOptional.orElse(null);
    }
    
    public Student getStudent(Optional<Student> studentOptional) {
        return studentOptional.orElse(null);
    }

	public void setInscripcion(LocalDate inscripcion) {
		this.inscripcion = inscripcion;
	}

	public void setGraduacion(LocalDate graduacion) {
		this.graduacion = graduacion;
	}

	public void setEstudiante(Student estudiante) {
		this.estudiante = estudiante;
	}

	public void setCarrera(Carrer carrera) {
		this.carrera = carrera;
	}

}
