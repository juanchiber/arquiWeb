package tpi3.tudai.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpi3.tudai.dtos.StudentDTO;
import tpi3.tudai.entities.Student;
import tpi3.tudai.repositories.StudentRepository;
import tpi3.tudai.services.StudentService;



@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("")	//url a la que tiene que acceder (/students)
	public ResponseEntity<?> getStudents(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
		}
	}
	
	@PostMapping("")	
	public ResponseEntity<?> save(@RequestBody StudentDTO s){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(s));
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, revise los campos e intente nuevamente.\"}");
		}
	}
}
