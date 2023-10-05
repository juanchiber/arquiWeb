package tpi3.tudai.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	@PostMapping("")	
	public ResponseEntity<?> save(@RequestBody Carrer c){
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
			return ResponseEntity.status(HttpStatus.OK).body(serviceStudentCarrera.save(sc));
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, revise los campos e intente nuevamente.\"}");
		}
	}
}
