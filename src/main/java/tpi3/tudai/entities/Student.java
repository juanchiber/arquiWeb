package tpi3.tudai.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import tpi3.tudai.repositories.StudentCarrerRepository;

@Entity
@Data
public class Student {
    
//    @GeneratedValue(strategy = GenerationType.AUTO)
	@Id
    private Integer id;
	
    @Column
    private String nombre;
    
    @Column
    private String apellido;
    
    @Column
    private Integer edad;
    
    @Column
    private String genero;
    
    @Column
    private String ciudadResidencia;
    
    @Column
    private String documento;
    
    @Column
    private Integer numeroLibreta;
    
    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
    private Set<StudentCarrer> carreras;
    
    public Student(String nombre, String apellido, Integer edad, String genero, String ciudadResidencia, String documento, Integer numeroLibreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.documento = documento;
        this.numeroLibreta = numeroLibreta;
        this.carreras = new HashSet<StudentCarrer>();
    }
    public Student(Integer id, String nombre, String apellido, Integer edad, String genero, String ciudadResidencia, String documento, Integer numeroLibreta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.documento = documento;
        this.numeroLibreta = numeroLibreta;
        this.carreras = new HashSet<StudentCarrer>();
    }
    
    public Student() {
        this.carreras = new HashSet<StudentCarrer>();
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public Integer getEdad() {
        return edad;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public Integer getNumeroLibreta() {
        return numeroLibreta;
    }
    /*
    public ArrayList<StudentCarrer> getCarreras(){
        if(this.carreras.isEmpty()){
            StudentCarrerRepository ecr = new StudentCarrerRepository();
           List<StudentCarrer> aux = ecr.getEstudianteCarreraByIdEstudiante(this.getId());
            return new ArrayList<StudentCarrer>(aux);
        }
        return new ArrayList<StudentCarrer>(this.carreras);
    }
    */
    public String getNombre(){
        return this.nombre;
    }
    public Integer getId() {
        return id;
    }
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
}
