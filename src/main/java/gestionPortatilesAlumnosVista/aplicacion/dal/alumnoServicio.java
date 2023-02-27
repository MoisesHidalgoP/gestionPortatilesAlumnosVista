package gestionPortatilesAlumnosVista.aplicacion.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface alumnoServicio extends CrudRepository<Alumno, Integer> {

		
            

}
