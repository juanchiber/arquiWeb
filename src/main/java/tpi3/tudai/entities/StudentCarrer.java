package tpi3.tudai.entities;


import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class StudentCarrer {

    @Column
    LocalDate inscripcion;
    
    @Column(nullable = true)
    LocalDate graduacion;
    
    @Column
    private boolean seGraduo;
    
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "estudiante")
    private Student estudiante;
    
    @Id
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

}
