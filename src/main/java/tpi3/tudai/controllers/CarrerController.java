package tpi3.tudai.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpi3.tudai.dtos.CarrerDTO;
import tpi3.tudai.dtos.StudentCarrerDTO;
import tpi3.tudai.entities.Carrer;
import tpi3.tudai.entities.StudentCarrer;
import tpi3.tudai.services.CarrerService;
import tpi3.tudai.services.StudentCarrerService;

@RestController
@RequestMapping("/carrers")

public class CarrerController {
	
	@Autowired
	private CarrerService service;
	private StudentCarrerService serviceStudentCarrera;
	
	@GetMapping("")
	public ResponseEntity<?> getCarrers(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
		}
	}
	
	@GetMapping("/OrderByRegistered")
	public ResponseEntity<?> getCarrersOrderByRegistered(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findCarrersOrderByRegistered());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
		}
	}
	
	@PostMapping("")	
	public ResponseEntity<?> save(@RequestBody CarrerDTO c){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(c));
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, revise los campos e intente nuevamente.\"}");
		}
	}
	
	@PostMapping("/matricular")
	public ResponseEntity<?> matricular(@RequestBody StudentCarrerDTO sc){
		try {
			service.matricular(sc);
			return ResponseEntity.status(HttpStatus.OK).body("Se matriculo correctamente el estudiante con id: " + sc.getId_Estudiante() + " en la carrera: " + sc.getId_Carrera());
			
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, revise los campos e intente nuevamente.\"}");
		}

	}

}
