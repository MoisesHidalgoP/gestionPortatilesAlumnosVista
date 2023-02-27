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
public class ControladorMatriculaAlumno {
	
	@Autowired
	 consultas consulta=new consultas();
	@Autowired
	private portatilServicio portatilServicio;
	
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	    List<Alumno> listAlumnos = new ArrayList<Alumno>();
	    List<portatil> portatiles = new ArrayList<portatil>();
	    
	    Map<String, Object> miModelo = new HashMap<String, Object>();  
	     
	
	 @RequestMapping(name="/matriculaAlumno")
	    public String matriculaAlumno(Model modelo) {
	        logger.info("Navegamos al formulario");
	        modelo.addAttribute("alumnosGM" , new Alumno());
	       
	        return "matriculaAlumno";
	    } 
	    
	    
	    @PostMapping(value="/guardarAlumno" )
	    public ModelAndView guardarAlumno(@RequestParam String md_uuid, @RequestParam String nombre, @RequestParam String telefono,@RequestParam int idPortatil,@RequestParam String marca,
	   		 @RequestParam String modelo)
	    		{
	    	
	    	
	    	portatil portatil1 = new portatil(idPortatil,marca,modelo);
	    	
	        Alumno alumno1 = new Alumno(md_uuid,nombre,telefono,portatil1);
	       
	       
	        consulta.insertarUnAlumno(alumno1,portatil1);
	        
	    	return new ModelAndView("menu", "miModelo", miModelo);
	    }
	    
	    @RequestMapping(value="/matriculaAlumno")
	    public ModelAndView listaDePortatil() {
	    	
	    	List<String>resultados = new ArrayList<>();
	        
	       
	    
			for (portatil portatil : portatilServicio.findAll()) {
				resultados.add(portatil.toString());		
		}
	       	miModelo.put("resultados", resultados);
	        return new ModelAndView ("matriculaAlumno","miModelo", miModelo);
	    } 
	   
	    
	    
	
	

}
