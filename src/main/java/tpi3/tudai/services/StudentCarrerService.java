package tpi3.tudai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import tpi3.tudai.entities.Carrer;
import tpi3.tudai.entities.Student;
import tpi3.tudai.entities.StudentCarrer;
import tpi3.tudai.repositories.CarrerRepository;
import tpi3.tudai.repositories.StudentCarrerRepository;
import tpi3.tudai.dtos.StudentCarrerDTO;
import tpi3.tudai.repositories.StudentRepository;

@Service
public class StudentCarrerService implements BaseService<StudentCarrerDTO>{

	@Autowired
	private StudentCarrerRepository repository;
	private StudentRepository repositoryStudent;
	private CarrerRepository repositoryCarrer;

	@Override
	@Transactional
	public List<StudentCarrerDTO> findAll() throws Exception {
//		return repository.findAll();
		return new ArrayList<StudentCarrerDTO>();
	}

	@Override
	@Transactional
	public StudentCarrerDTO findById(Integer id) throws Exception{
		try {
			Optional<StudentCarrer> studentCarrer= repository.findById(id);
//			return studentCarrer.get();
			return new StudentCarrerDTO();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	@Override
	public StudentCarrerDTO save(StudentCarrerDTO entity) throws Exception {
		return null;
	}

	/*
	@Transactional
	public StudentCarrerDTO matricular(Integer id_student, Integer id_carrer) throws Exception {
		System.out.println("1 service");
		Objects.requireNonNull(id_student);
		Objects.requireNonNull(id_carrer);
		try {
			Optional<Student> resultado= this.repositoryStudent.findById(id_student);
			Student student= resultado.get();
			Optional<Carrer> resultadocarrera= this.repositoryCarrer.findById(id_carrer);
			Carrer carrer= resultadocarrera.get();
            StudentCarrer sce= new StudentCarrer(student, carrer);
			repository.save(sce);
			return new StudentCarrerDTO(sce);

		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	*/


	
}

