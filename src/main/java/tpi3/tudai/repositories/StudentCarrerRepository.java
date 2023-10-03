package tpi3.tudai.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import tpi3.tudai.entities.StudentCarrer;

public interface StudentCarrerRepository extends RepositoryBase<StudentCarrer, Integer> {
	
	@Query("SELECT sc FROM StudentCarrer sc WHERE c.carrera = :carrera")
	public List<StudentCarrer> findAllByName(String carrera);
	
	
}
	/*
    @Override
    public void insertEstudianteCarrera(EstudianteCarrera c) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        this.closeEM();
    }
    @Override
    public List<EstudianteCarrera> getEstudianteCarreraByIdEstudiante(Integer idEstudiante) {
        EntityManager em = this.getEM();
        em.getTransaction().begin();
        String jpql = "SELECT new EstudianteCarrera(ec.inscripcion, ec.graduacion, ec.estudiante, ec.carrera) FROM EstudianteCarrera ec WHERE ec.estudiante.id = ?1";
        TypedQuery<EstudianteCarrera> typedQuery = em.createQuery(jpql, EstudianteCarrera.class);
        typedQuery.setParameter(1, idEstudiante);
        List<EstudianteCarrera> rta = typedQuery.getResultList();
        em.getTransaction().commit();
        this.closeEM();
        return rta;
    }

}
*/
