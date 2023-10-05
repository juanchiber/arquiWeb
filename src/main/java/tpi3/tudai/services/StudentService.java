package tpi3.tudai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import tpi3.tudai.dtos.StudentDTO;
import tpi3.tudai.entities.Student;
import tpi3.tudai.repositories.StudentRepository;

@Service
public class StudentService implements BaseService<StudentDTO>{
	
	@Autowired
	private StudentRepository repository;

	@Override
	@Transactional
	public List<StudentDTO> findAll() throws Exception {
		List<Student> students=repository.findAll();
		List<StudentDTO> all= new ArrayList<>();
		for(Student s:students){
           StudentDTO aux= new StudentDTO(s);
		   all.add(aux);
		}
		return all;
	}

	@Override
	@Transactional
	public StudentDTO findById(Integer id) throws Exception{
		try {
//			Optional<Student> student=
			Optional<Student> resultado = repository.findById(id);
			Student s=resultado.get();
			return new StudentDTO(s);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	@Transactional
	public StudentDTO save(StudentDTO s) throws Exception {
		try {
			Student st= new Student(s);
			return  new StudentDTO(repository.save(st));
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}


}
