package tpi3.tudai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tpi3.tudai.entities.Student;
import tpi3.tudai.repositories.StudentRepository;

@Service
public class StudentService implements BaseService<Student>{
	
	@Autowired
	private StudentRepository repository;

	@Override
	@Transactional
	public List<Student> findAll() throws Exception {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Student findById(Integer id) throws Exception{
		try {
			Optional<Student> student= repository.findById(id);
			return student.get();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	@Override
	@Transactional
	public Student save(Student s) throws Exception {
		try {
			return repository.save(s);
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Student update(Long id, Student entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

}
