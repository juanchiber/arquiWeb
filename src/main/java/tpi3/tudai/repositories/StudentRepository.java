package tpi3.tudai.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tpi3.tudai.entities.Student;

@Repository("StudentRepository")
public interface StudentRepository extends RepositoryBase<Student, Integer>  {
	
	@Query("SELECT s FROM Student s WHERE s.nombre = :nombre")
	public List<Student> findAllByName(String nombre);
	
	@Query("SELECT s FROM Student s WHERE s.apellido = :apellido")
	public List<Student> findAllBySurname(String apellido);

	@Override
	@Query("SELECT s FROM Student s WHERE s.id = :id")
	public Optional<Student> findById(Integer id);
	
	@Query("SELECT s FROM Student s WHERE s.genero= :genre")
	public List<Student> findByGenero(String genre);
	
	@Query("SELECT s FROM Student s WHERE s.numeroLibreta= :notebook")
	public Optional<Student> findByNotebook(Integer notebook);
	
	@Query("SELECT s FROM Student s ORDER BY s.nombre ASC")
	public List<Student> findAllOrderByName();

	@Query("SELECT s FROM Student s JOIN StudentCarrer sc ON (s.id = sc.estudiante.id) WHERE sc.carrera.id= :id AND s.ciudadResidencia= :city")
	public List<Student> findStudentsByCityAndCarrer(Integer id, String city);
}

/*
    @Override
    public List<EstudianteDto> getEstudiantesDto() {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        List<EstudianteDto> rta = em.createQuery("SELECT new dtos.EstudianteDto(e.nombre,e.apellido,e.edad,e.genero,e.ciudadResidencia,e.documento,e.numeroLibreta)  FROM Estudiante e").getResultList();
        em.getTransaction().commit();
        this.closeEM();
        return rta;
    }

    @Override
    public EstudianteDto getEstudianteDtoById(Integer id) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new dtos.EstudianteDto(e.nombre,e.apellido,e.edad,e.genero,e.ciudadResidencia,e.documento,e.numeroLibreta)  FROM Estudiante e WHERE e.id = ?1";
        TypedQuery<EstudianteDto> typedQuery = em.createQuery(jpql, EstudianteDto.class);
        typedQuery.setParameter(1, id);
        EstudianteDto rta = typedQuery.getSingleResult();
        em.getTransaction().commit();
        this.closeEM();
        return rta;
    }

    @Override
    public Estudiante getEstudianteById(Integer id) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new clases.Estudiante("+id+",e.nombre,e.apellido,e.edad,e.genero,e.ciudadResidencia,e.documento,e.numeroLibreta)  FROM Estudiante e WHERE e.id ="+id;
        TypedQuery<Estudiante> typedQuery = em.createQuery(jpql, Estudiante.class);
        Estudiante rta = typedQuery.getSingleResult();
        em.getTransaction().commit();
        this.closeEM();
        return rta;
    }

    @Override
    public boolean removeEstudiante(Integer id) {
        return true;
    }

    @Override
    public void insertEstudiante(Estudiante e) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        this.closeEM();
    }
    public List<EstudianteDto> getEstudiantesByCarreraAndCity(Integer idCarrera, String ciudad){
    	 EntityManager em = this.getEM();
         em.getTransaction().begin();
         String jpql = "SELECT new dtos.EstudianteDto(e.nombre,e.apellido, e.edad, e.genero, e.ciudadResidencia, e.documento, e.numeroLibreta, ec.carrera.nombre) FROM Estudiante e JOIN EstudianteCarrera ec  ON (e.id = ec.estudiante.id) WHERE ec.carrera.id =?1  AND e.ciudadResidencia=?2"  ;
         TypedQuery<EstudianteDto> typedQuery = em.createQuery(jpql, EstudianteDto.class);
         typedQuery.setParameter(1, idCarrera);
         typedQuery.setParameter(2, ciudad);
         List<EstudianteDto> resultado= typedQuery.getResultList();
         em.getTransaction().commit();
         return resultado;
    }
    public List<EstudianteDto> getEstudiantesDtoOrderedByName(){
    	EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new dtos.EstudianteDto(e.nombre,e.apellido,e.edad,e.genero,e.ciudadResidencia,e.documento,e.numeroLibreta) FROM Estudiante e ORDER BY e.nombre ASC";
        TypedQuery<EstudianteDto> query = em.createQuery(jpql, EstudianteDto.class);
        List<EstudianteDto> resultado = query.getResultList();
        em.getTransaction().commit();
        return resultado;
    }
    public EstudianteDto getEstudianteByNroLibreta(int numLibreta) {
    	EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new dtos.EstudianteDto(e.nombre,e.apellido,e.edad,e.genero,e.ciudadResidencia,e.documento,e.numeroLibreta) FROM Estudiante e WHERE e.numeroLibreta= ?1";
        TypedQuery<EstudianteDto> query = em.createQuery(jpql, EstudianteDto.class);
        query.setParameter(1, numLibreta);
        EstudianteDto resultado = query.getSingleResult();
        em.getTransaction().commit();
        return resultado;
	}
   
    public List<EstudianteDto> getEstudianteByGenero(String genero) {
    	EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new dtos.EstudianteDto(e.nombre,e.apellido,e.edad,e.genero,e.ciudadResidencia,e.documento,e.numeroLibreta) FROM Estudiante e WHERE e.genero= ?1";
        TypedQuery<EstudianteDto> query = em.createQuery(jpql, EstudianteDto.class);
        query.setParameter(1, genero);
        List<EstudianteDto> resultado = query.getResultList();
        em.getTransaction().commit();
        return resultado;
    }
   */

