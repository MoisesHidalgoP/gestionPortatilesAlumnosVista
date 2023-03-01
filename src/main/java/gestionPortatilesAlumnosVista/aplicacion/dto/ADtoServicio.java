package gestionPortatilesAlumnosVista.aplicacion.dto;

import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;

public interface ADtoServicio {
	
	public alumnoDTO aAlumnoDTONormal(int codAlumno, String md_uuid , String nombre , String telefono , portatil portatil);
	public portatilDTO aPortatilDTONormal(String md_uuid, String marca,String modelo);
	public alumnoDTO aAlumnoDTONormal(Alumno alumno1);
	public alumnoDTO aAlumnoDTONormal(String md_uuid, String nombre, String telefono, int idPortatil, String marca,
			String modelo);
	
	
			
	

}
