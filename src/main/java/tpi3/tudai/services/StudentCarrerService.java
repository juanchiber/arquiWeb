package tpi3.tudai.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import tpi3.tudai.entities.StudentCarrer;
import tpi3.tudai.repositories.StudentCarrerRepository;

@Service
public class StudentCarrerService implements BaseService<StudentCarrer>{

	@Autowired
	private StudentCarrerRepository repository;

	@Override
	@Transactional
	public List<StudentCarrer> findAll() throws Exception {
		return repository.findAll();
	}

	@Override
	@Transactional
	public StudentCarrer findById(Integer id) throws Exception{
		try {
			Optional<StudentCarrer> studentCarrer= repository.findById(id);
			return studentCarrer.get();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	@Override
	@Transactional
	public StudentCarrer save(StudentCarrer sc) throws Exception {
		try {
			return repository.save(sc);
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public StudentCarrer update(Long id, StudentCarrer entity) throws Exception {
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
