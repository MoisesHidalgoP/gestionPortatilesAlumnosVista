package gestionPortatilesAlumnosVista.aplicacion.consultas;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;
import gestionPortatilesAlumnosVista.aplicacion.dal.alumnoServicio;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatilServicio;



@Service
public class consultas {
	
	@Autowired
	private portatilServicio portatilServicio;
	@Autowired
	private alumnoServicio alumnoSer;
	
	@Transactional
	public void insertarUnPortatil(portatil portatil) {
		portatilServicio.save(portatil);
		
	}
	
	@Transactional 
	public void insertarUnAlumno(Alumno alumno,portatil portatil) {
		alumnoSer.save(alumno);
		
	}
	@Transactional
	public List<portatil>listPortatil(){
		return (List<portatil>) portatilServicio.findAll();
	}
	@Transactional
	public void borrarAlumno(int codAlumno){
		alumnoSer.deleteById(codAlumno);
	}
	@Transactional
	public List<Alumno>buscarTodos(){
		return (List<Alumno>) alumnoSer.findAll();
		 
	}
	
	@Transactional
	public List<portatil>portatilAsigAlumno(int codAlumno){
		return (List<portatil>) portatilServicio.findAll();
	}
	
	


	
}
