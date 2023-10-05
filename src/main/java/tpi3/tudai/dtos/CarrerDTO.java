package tpi3.tudai.dtos;

import lombok.Getter;

@Getter
public class CarrerDTO {
    private String nombre;
    private Double duracionAnios;
    private long cantidadInscriptos;
    private Integer id;
    
    public CarrerDTO(String nombre, Double duracionAnios) {
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
    }
    public CarrerDTO(Integer id,String nombre, Double duracionAnios,long cantidadInscriptos) {
    	this.id=id;
    	this.cantidadInscriptos=cantidadInscriptos;
        this.nombre = nombre;
        this.duracionAnios = duracionAnios;
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
