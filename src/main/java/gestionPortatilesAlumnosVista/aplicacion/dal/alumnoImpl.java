package gestionPortatilesAlumnosVista.aplicacion.dal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class alumnoImpl  {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private alumnoServicio alumnoServicio;


	/*@Override
	public void insertarMatriculaAlumno(Alumno matricula) {
		// TODO Auto-generated method stub
		em.persist(matricula);
		
	} */


	/*@Override
	public void borrarMatriculaAlumno(Alumno matricula) {
		// TODO Auto-generated method stub
		em.remove(matricula);
	}*/
	
	public void insertarAlumno(Alumno alumno) {
		alumnoServicio.save(alumno);
		
	}

}
