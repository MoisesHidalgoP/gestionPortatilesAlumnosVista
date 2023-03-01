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
	
	//Consulta que inserta un portatil a Base de Datos
	@Transactional
	public void insertarUnPortatil(portatil portatil) {
		portatilServicio.save(portatil);
		
	}
	
	//Consulta que inserta un alumno a Base de Datos
	@Transactional 
	public void insertarUnAlumno(Alumno alumno) {
		try {
			alumnoSer.save(alumno);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	//Conulta que devuelve una lista de portatiles
	@Transactional
	public List<portatil>listPortatil(){
		
		try {
			return (List<portatil>) portatilServicio.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	//Consulta que borra un alumno por su id(codAlumno en mi caso)
	@Transactional
	public void borrarAlumno(int codAlumno){
		try {
			alumnoSer.deleteById(codAlumno);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	//Consulta que devuelve una lista de alumnos
	@Transactional
	public List<Alumno>buscarTodos(){
		try {
			 List<Alumno>listAlumno = (List<Alumno>) alumnoSer.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
		 
	}
	
	@Transactional
	public portatil portatilAsigAlumno(int codAlumno){
		try {
			Alumno alumno = alumnoSer.findById(codAlumno).get();
			portatil portatil = alumno.getPortatil();
			
			return portatil;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	


	
}
