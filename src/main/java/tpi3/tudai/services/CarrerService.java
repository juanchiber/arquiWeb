package tpi3.tudai.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import tpi3.tudai.entities.Carrer;
import tpi3.tudai.repositories.CarrerRepository;

@Service
public class CarrerService implements BaseService<Carrer>{
	
	@Autowired
	private CarrerRepository repository;

	@Override
	@Transactional
	public List<Carrer> findAll() throws Exception {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Carrer findById(Integer id) throws Exception{
		try {
			Optional<Carrer> carrer= repository.findById(id);
			return carrer.get();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	@Override
	@Transactional
	public Carrer save(Carrer c) throws Exception {
		try {
			return repository.save(c);
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Carrer update(Long id, Carrer entity) throws Exception {
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
