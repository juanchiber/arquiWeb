package tpi3.tudai.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import tpi3.tudai.entities.Carrer;


public interface CarrerRepository extends RepositoryBase<Carrer, Integer> {
	
	@Query("SELECT c FROM Carrer c WHERE c.nombre = :nombre")
	public List<Carrer> findAllByName(String nombre);
	@Override
	@Query("SELECT c FROM Carrer c WHERE c.id = :id")
	public Optional<Carrer> findById(Integer id);
	
}




	/*
    public List<CarrerDTO> getCarrerasDto() {
    	return null;
    }
    
    public CarrerDTO getCarreraDtoById(Integer id) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new dtos.CarreraDto(c.nombre, c.duracionAnios)  FROM Carrera c WHERE c.id = ?1";
        TypedQuery<CarrerDTO> typedQuery = em.createQuery(jpql, CarrerDTO.class);
        typedQuery.setParameter(1, id);
        CarrerDTO rta = typedQuery.getSingleResult();
        em.getTransaction().commit();
        this.closeEM();
        return rta;
    }
    
    public Carrer getCarreraById(Integer id) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new clases.Carrer("+id+",c.nombre, c.duracionAnios)  FROM Carrer c WHERE c.id ="+id;
        TypedQuery<Carrer> typedQuery = em.createQuery(jpql, Carrer.class);
        Carrer rta = typedQuery.getSingleResult();
        em.getTransaction().commit();
        this.closeEM();
        return rta;
    }
    
    public boolean removeCarrera(Integer id) {
        return true;
    }
    
    public void insertCarrera(Carrer c) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        this.closeEM();
    }
    
    public List<CarrerDTO> getCarrerasOrderByInscriptos(){
        EntityManager em = this.getEM();
        String jpql = "SELECT new dtos.CarreraDto(c.id, c.nombre, c.duracionAnios, COUNT(ec.estudiante.id)) FROM Carrera c JOIN EstudianteCarrera ec  ON (c.id= ec.carrera.id) GROUP BY ec.carrera.id, c.nombre, c.duracionAnios ORDER BY COUNT(ec.estudiante.id) DESC";
        em.getTransaction().begin();
        TypedQuery<CarrerDTO> query = em.createQuery(jpql, CarrerDTO.class);
        List<CarrerDTO> resultado= query.getResultList();
        em.getTransaction().commit();
        return resultado;
    }
    
    public List<CarreraReporteDTO> getCarrerasReport(){
    	EntityManager em = this.getEM();
	    em.getTransaction().begin();
	    Query query =em.createNativeQuery(
	           "SELECT carrera, SUM(cant_inscriptos) AS cant_inscriptos, \r\n"
	    		+ "                        SUM(cant_graduados) cant_graduados, anio FROM (\r\n"
	    		+ "                        SELECT c.nombre AS carrera, COUNT(ec.estudiante) AS cant_inscriptos, 0 AS cant_graduados,\r\n"
	    		+ "                        YEAR(ec.inscripcion) AS anio\r\n"
	    		+ "                        FROM estudiantecarrera ec\r\n"
	    		+ "                        JOIN carrera c ON ec.carrera = c.id\r\n"
	    		+ "                        GROUP BY c.nombre, ec.carrera, anio\r\n"
	    		+ "                        UNION ALL\r\n"
	    		+ "                        SELECT c.nombre AS carrera, 0 AS cant_inscriptos, COUNT(ec.estudiante) AS cant_graduados,\r\n"
	    		+ "                        YEAR(ec.graduacion) AS anio\r\n"
	    		+ "                        FROM estudiantecarrera ec\r\n"
	    		+ "                        JOIN carrera c ON ec.carrera = c.id\r\n"
	    		+ "                        GROUP BY c.nombre, ec.carrera, anio) AS subQuery\r\n"
	    		+ "                        WHERE anio not like 1\r\n"
	    		+ "                        GROUP BY carrera, anio\r\n"
	    		+ "                        ORDER BY carrera ASC,anio ASC;");
	    
	    List<Object> rta= query.getResultList();
	    List<ReportCarrerDTO> resultado= new ArrayList<ReportCarrerDTO>();
	    for(Object o:rta) {
	    	Object[] row = (Object[]) o;
	    	 String carrera = (String) row[0]; // Primer elemento es la carrera (columna 0)
	    	 BigDecimal cantInscriptos = (BigDecimal) row[1];
	    	 BigDecimal cantGraduados = (BigDecimal) row[2];
	    	 Integer anio = (Integer) row[3];
	    	 
	    	 
	    	 ReportCarrerDTO carreraDTO=new ReportCarrerDTO(carrera,anio,cantGraduados.intValue(),cantInscriptos.intValue());
	    	 resultado.add(carreraDTO);
	    	 
	    }
        em.getTransaction().commit();
        return resultado;
	}

}
*/
