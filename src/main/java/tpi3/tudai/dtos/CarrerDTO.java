package tpi3.tudai.dtos;

import lombok.Getter;
import tpi3.tudai.entities.Carrer;

@Getter
public class CarrerDTO {
    private String nombre;
    private Integer duracionAnios;
    private long cantidadInscriptos;
    private Integer id;
    
    public CarrerDTO(String nombre, Integer duracionAnios) {
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
    }
    public CarrerDTO(Integer id,String nombre, Integer duracionAnios,long cantidadInscriptos) {
    	this.id=id;
    	this.cantidadInscriptos=cantidadInscriptos;
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
    }
    public CarrerDTO(Carrer c) {
        this.nombre = c.getNombre();
        this.duracionAnios = c.getDuracionAnios();
    }
    
//    public String getNombre() {
//        return nombre;
//    }
//    public Double getDuracionAnios() {
//        return duracionAnios;
//    }
	@Override
	public String toString() {
		return "CarreraDto [nombre=" + nombre + "]";
	}
//	public Integer getId() {
//		return id;
//	}
	
	
}
