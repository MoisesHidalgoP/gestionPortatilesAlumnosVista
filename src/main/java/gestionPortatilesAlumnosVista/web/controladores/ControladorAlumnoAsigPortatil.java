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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gestionPortatilesAlumnosVista.aplicacion.consultas.consultas;
import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;
import gestionPortatilesAlumnosVista.aplicacion.dal.alumnoServicio;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatilServicio;

@Controller
public class ControladorAlumnoAsigPortatil {
	@Autowired
	 consultas consulta=new consultas();
	
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	    List<Alumno> listAlumnos = new ArrayList<Alumno>();
	    List<portatil> portatiles = new ArrayList<portatil>();
	    
	    Map<String, Object> miModelo = new HashMap<String, Object>();  
	
	
	 @RequestMapping(value="/alumnoAsigPortatil")
	    public String portatilAsigAlumno(Model modelo) {
	        logger.info("Navegamos al formulario");
	        modelo.addAttribute("alumnosGM" , new Alumno());
	       
	        return "alumnoAsigPortatil";
	    } 
	    
	    @PostMapping(value="/portatilDelAlumno" )
	    public ModelAndView portatilDelAlumno(@RequestParam int codAlumno,Model model)
	    		{
	    	
	    	List<portatil> portatil = consulta.portatilAsigAlumno(codAlumno);
	        model.addAttribute("portatil", portatil);
	        miModelo.put("resultados", portatil);
	        
	        
	    	return new ModelAndView ("resultado","miModelo",miModelo);
	    }
	    

}
