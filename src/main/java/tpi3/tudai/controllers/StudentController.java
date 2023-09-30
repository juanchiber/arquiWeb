package tpi3.tudai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpi3.tudai.entities.Student;
import tpi3.tudai.repositories.StudentRepository;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Qualifier("StudentRepository")
	@Autowired
	private final StudentRepository repository;
	
	public StudentController(@Qualifier("StudentRepository")StudentRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/")	//url a la que tiene que acceder (/students)
	public Iterable<Student> getStudents(){
		return repository.findAll();
	}
	
	@PostMapping("/")	//ALTA	@RequestBody indica que va a recibir una persona y luego ejectuta save() para guardarla
	public Student newStudent(@RequestBody Student s) {
		return repository.save(s);
	}
	

}
