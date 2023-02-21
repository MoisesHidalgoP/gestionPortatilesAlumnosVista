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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gestionPortatilesAlumnosVista.aplicacion.consultas.consultas;
import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;




@Controller
public class ControladorSegunda {
	
	@Autowired
	 consultas consulta=new consultas();
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	    List<Alumno> alumnos = new ArrayList<Alumno>();
	    Map<String, Object> miModelo = new HashMap<String, Object>();  
	    
	    @RequestMapping(value="/segunda")
	    public ModelAndView gestionSolicitud() {
	        logger.info("Navegamos a la vista segunda");     
	       
	        
	        miModelo.put("listaAlumnos", alumnos);
	        return new ModelAndView("segunda", "miModelo", miModelo);
	    }
	    
	   
	        
	    } 