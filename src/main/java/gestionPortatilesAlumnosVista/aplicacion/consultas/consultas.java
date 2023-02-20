package gestionPortatilesAlumnosVista.aplicacion.consultas;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gestionPortatilesAlumnosVista.aplicacion.dal.alumno;
import gestionPortatilesAlumnosVista.aplicacion.dal.alumnoImpl;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatilImpl;



@Repository
public class consultas {
	
	@Autowired
	private alumnoImpl al;
	@Autowired
	private portatilImpl por;
	
	@Transactional
	public void insertarUnAlumno(alumno matricula) {
		al.insertarMatriculaAlumno(matricula);
	}
	
	@Transactional
	public void borrarUnaMatriculaAlumno(alumno matricula) {
		al.borrarMatriculaAlumno(matricula);
	}
	
	@Transactional
	public void insertarUnPortatil(portatil alta) {
		por.insertarAltaPortatil(alta);
	}
	
	@Transactional
	public List<portatil>listPortatil(){
		return por.buscaPortatil();
	}
	
	


	
}
