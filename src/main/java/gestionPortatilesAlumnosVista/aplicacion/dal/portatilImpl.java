package gestionPortatilesAlumnosVista.aplicacion.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class portatilImpl {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private portatilServicio portatilServicio;


	/*@Override
	public void insertarAltaPortatil(portatil alta) {
		// TODO Auto-generated method stub
		em.persist(alta);
	}

	@Override
	public List<portatil> buscaPortatil() {
		// TODO Auto-generated method stub
		try {
			//Seleccionamos todos los portatiles y los devolvemos en el return en forma de lista
		return em.createQuery("SELECT port FROM portatil port").getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}*/

}
