package gestionPortatilesAlumnosVista.aplicacion.dto;

import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;

public interface ADaoServicio {
	
	public portatil portatilDTOADAO(portatilDTO PortatilDTO);
	public Alumno alumnoDTOADAO (alumnoDTO AlumnoDTO);

}
