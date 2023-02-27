package gestionPortatilesAlumnosVista.web.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gestionPortatilesAlumnosVista.aplicacion.consultas.consultas;
import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;
import gestionPortatilesAlumnosVista.aplicacion.dal.alumnoServicio;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatilServicio;

@Controller
public class ControladorTodosAlumnosPortatiles {
	
	@Autowired
	 consultas consulta=new consultas();
	@Autowired
	private alumnoServicio alumnoSer;
	@Autowired
	private portatilServicio portatilServicio;
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	    List<Alumno> listAlumnos = new ArrayList<Alumno>();
	    List<portatil> portatiles = new ArrayList<portatil>();
	    
	    Map<String, Object> miModelo = new HashMap<String, Object>();  
	
	
	 @RequestMapping(value="/todosAlumnosPortatiles")
	    public ModelAndView buscarTodos() {
	    	
	    	List<String>resultados = new ArrayList<>();
	        
	       List<Alumno>listAlumno=(List<Alumno>) alumnoSer.findAll();
	       for (Alumno alumno : listAlumno) {
			for (portatil portatil : portatilServicio.findAll()) {
				if(alumno.getPortatil().getIdPortatil()==portatil.getIdPortatil()) {
					resultados.add(alumno.toString()+portatil.toString());				
				}
				
			}
		}
	       	miModelo.put("resultados", resultados);
	        return new ModelAndView ("todosAlumnosPortatiles","miModelo", miModelo);
	    } 
	    
	    

}
