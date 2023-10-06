package tpi3.tudai.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		try {
			Carrer c= new Carrer(cdto);
			return new CarrerDTO(repositoryCarrer.save(c));
		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	/* borrar si no anda */
	
	@Transactional
	public void matricular(StudentCarrerDTO sc) throws Exception {
		Objects.requireNonNull(sc.getId_Estudiante());
		Objects.requireNonNull(sc.getId_Carrera());
		try {
			Optional<Student> resultado= this.repositoryStudent.findById(sc.getId_Estudiante());
			Student student= resultado.get();
			Optional<Carrer> resultadocarrera= this.repositoryCarrer.findById(sc.getId_Carrera());
			Carrer carrer= resultadocarrera.get();
            StudentCarrer sce= new StudentCarrer(student,carrer);
			repositoryStudentCarrer.save(sce);

		}
		catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}




	
}
