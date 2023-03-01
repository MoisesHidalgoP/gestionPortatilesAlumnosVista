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
import gestionPortatilesAlumnosVista.aplicacion.dal.alumnoServicio;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatilServicio;
import gestionPortatilesAlumnosVista.aplicacion.dto.ADaoServicio;
import gestionPortatilesAlumnosVista.aplicacion.dto.ADaoServicioImpl;
import gestionPortatilesAlumnosVista.aplicacion.dto.ADtoServicio;
import gestionPortatilesAlumnosVista.aplicacion.dto.ADtoServicioImpl;
import gestionPortatilesAlumnosVista.aplicacion.dto.portatilDTO;

@Controller
public class ControladorAltaPortatil {
	
	
	@Autowired
	 consultas consulta=new consultas();
	 ADtoServicio aDto = new ADtoServicioImpl();
	 ADaoServicio aDao = new ADaoServicioImpl();
	 
	 //DTO para portatil
	  portatilDTO dtoPortatil;
	  portatil Portatil;
	
	
	
	 protected final Log logger = LogFactory.getLog(getClass());
	    
	    List<Alumno> listAlumnos = new ArrayList<Alumno>();
	    List<portatil> portatiles = new ArrayList<portatil>();
	    
	    Map<String, Object> miModelo = new HashMap<String, Object>();  
	
    
    @RequestMapping(value="/altaPortatil")
    public String altaPortatil(Model modelo) {
        modelo.addAttribute("portatil", new portatil());
        return "altaPortatil";
    } 
    
    
    @RequestMapping(value= "/guardarPortatil", method = RequestMethod.POST)
    public ModelAndView guardarPortatil(@ModelAttribute("portatil") portatil portatil){
    	portatiles.add(portatil);
        //miModelo.put("listaPortatiles", portatilVista);
    	
    	  dtoPortatil = aDto.aPortatilDTONormal(portatil.getMd_uuid(),portatil.getMarca(),portatil.getModelo());
		  Portatil = aDao.portatilDTOADAO(dtoPortatil);
		  consulta.insertarUnPortatil(Portatil);
        
      
    	
        
    	return new ModelAndView("menu", "miModelo", miModelo);
    }
    
    

}
