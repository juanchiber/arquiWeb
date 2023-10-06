package tpi3.tudai.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import tpi3.tudai.dtos.CarrerDTO;
import tpi3.tudai.dtos.StudentDTO;
import tpi3.tudai.entities.Carrer;
import tpi3.tudai.entities.Student;
import tpi3.tudai.repositories.CarrerRepository;

@Service
public class CarrerService implements BaseService<CarrerDTO>{
	
	@Autowired
	private CarrerRepository repository;

	@Override
	@Transactional
	public List<CarrerDTO> findAll() throws Exception {
//		return repository.findAll();
		return null;
	}

	@Override
	@Transactional
	public CarrerDTO findById(Integer id) throws Exception{
		try {
			Optional<Carrer> carrer= repository.findById(id);
			Carrer c=  carrer.get();
			return new CarrerDTO(c);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
	}


	@Override
	@Transactional
	public CarrerDTO save(CarrerDTO cdto) throws Exception {
		try {
			Carrer c= new Carrer(cdto);
			return new CarrerDTO(repository.save(c));
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}




	
}
