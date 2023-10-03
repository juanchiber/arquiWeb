/*
package tpi3.tudai.helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import jakarta.persistence.EntityManager;
import tpi3.tudai.entities.Carrer;
import tpi3.tudai.entities.Student;
import tpi3.tudai.entities.StudentCarrer;
import tpi3.tudai.repositories.StudentCarrerRepository;
import tpi3.tudai.repositories.StudentRepository;
@Component
public class DBHelper {
	
    private final StudentRepository estudianteRepository;
	private final StudentCarrerRepository estudianteCarreraRepository;
	private final CarrerRepository carreraRepository;

    
    public DBHelper(StudentRepository estudianteRepository, StudentCarrerRepository estudianteCarreraRepository,
    		CarrerRepository carreraRepository) {
        this.estudianteCarreraRepository = estudianteCarreraRepository;
		this.carreraRepository = carreraRepository;
		this.estudianteRepository = estudianteRepository;
    }
	
	private Iterable<CSVRecord> getData(String archivo) throws IOException {
		String path = "integrador3\\src\\main\\resources\\" + archivo;
		Reader in = new FileReader(path);
		String[] header = {};
		CSVParser csvParser = CSVFormat.EXCEL.builder().setNullString("").setHeader(header).build().parse(in);		
		Iterable<CSVRecord> record = csvParser;
		return record;
	}
	
	@Autowired
	public void populateCarrerasDB() throws IOException {	
		for(CSVRecord row : getData("carreras.csv")) {
			Carrer carrera = new Carrer((String) row.get(0));
			carreraRepository.save(carrera);
		}		
	}
	
	@Autowired
	public void populateEstudiantesDB() throws IOException {
		for(CSVRecord row : getData("estudiantes.csv")) {
			Student estudiante = new Student((String) row.get(0), (String) row.get(1), 
							Integer.parseInt(row.get(2)), (String) row.get(3), (String) row.get(4),
							Integer.parseInt(row.get(5)), Integer.parseInt(row.get(6)));
			estudianteRepository.save(estudiante);
		}
	}
	
	@Autowired
	public void populateEstudiantesCarrerasDB() throws IOException {
		for(CSVRecord row : getData("estudiantes_carreras_acotado.csv")) {
			Timestamp ts = row.get(3) == null ? null : Timestamp.valueOf(row.get(3));
			StudentCarrer estudianteCarrera = new StudentCarrer((Student) estudianteRepository.findEstudianteById(Integer.valueOf(row.get(0))),		
						(Carrera) carreraRepository.findCarreraById(Integer.valueOf(row.get(1))), 
						(Timestamp) Timestamp.valueOf(row.get(2)), ts);
			estudianteCarreraRepository.save(estudianteCarrera);
		}
	}        
}
*/
