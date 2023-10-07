package tpi3.tudai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.transaction.Transactional;
import tpi3.tudai.dtos.CarrerDTO;
import tpi3.tudai.dtos.StudentCarrerDTO;
import tpi3.tudai.dtos.StudentDTO;
import tpi3.tudai.entities.Carrer;
import tpi3.tudai.entities.Student;
import tpi3.tudai.entities.StudentCarrer;
import tpi3.tudai.repositories.CarrerRepository;
import tpi3.tudai.repositories.StudentCarrerRepository;
import tpi3.tudai.repositories.StudentRepository;

@Service
public class CarrerService implements BaseService<CarrerDTO>{
	
	@Autowired
	private CarrerRepository repositoryCarrer;
	private StudentRepository repositoryStudent;
	private StudentCarrerRepository repositoryStudentCarrer;
	private StudentService studentService;

	@Override
	@Transactional
	public List<CarrerDTO> findAll() throws Exception {
		List<Carrer> carrers= repositoryCarrer.findAll();
		List<CarrerDTO> all= new ArrayList<>();
		for(Carrer c: carrers){
           CarrerDTO aux= new CarrerDTO(c);
		   all.add(aux);
		}
		return all;
	}

	
	@Override
	@Transactional
	public CarrerDTO findById(Integer id) throws Exception{
		try {
			Optional<Carrer> carrer= repositoryCarrer.findById(id);
			Carrer c=  carrer.get();
			return new CarrerDTO(c);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}
	
	@Transactional
	public List<CarrerDTO> findCarrersOrderByRegistered() throws Exception{
		try {
			List<CarrerDTO> carrers= repositoryCarrer.findCarrersOrderByRegistered();
			return carrers;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}


	@Override
	@Transactional
	public CarrerDTO save(CarrerDTO cdto) throws Exception {
		System.out.println("|22");
		try {
			Carrer c= new Carrer(cdto);
			return new CarrerDTO(repositoryCarrer.save(c));
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	/* borrar si no anda */
	
	/*
	@Transactional
	public StudentCarrerDTO matricular(Integer id_student, Integer id_carrer) throws Exception{
		System.out.println("000");
		try {
			System.out.println(id_student);
			// Optional<Student> s_aux= this.repositoryStudent.findById(id_student);
			StudentDTO s_aux= this.studentService.findById(id_student);
			System.out.println(s_aux.getApellido());
			Student student= new Student(s_aux);
			System.out.println(student.getApellido());
			System.out.println(student.getApellido());
			Optional<Carrer> c_aux= this.repositoryCarrer.findById(id_carrer);
			Carrer carrer= c_aux.get();
			System.out.println(carrer.getNombre());
            StudentCarrer sce= new StudentCarrer(student, carrer);
			repositoryStudentCarrer.save(sce);
			return new StudentCarrerDTO(student.getId(), carrer.getId());
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	*/




	
}
