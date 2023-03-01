package gestionPortatilesAlumnosVista.aplicacion.dto;

import org.springframework.stereotype.Service;

import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;
import gestionPortatilesAlumnosVista.aplicacion.dal.portatil;



@Service
public class ADtoServicioImpl implements ADtoServicio {

	@Override
	public alumnoDTO aAlumnoDTONormal(int codAlumno, String md_uuid, String nombre, String telefono, portatil portatil) {
		alumnoDTO alumnoDTO = new alumnoDTO ( codAlumno,  md_uuid,  nombre,  telefono,  portatil);
		return alumnoDTO;
	}

	@Override
	public portatilDTO aPortatilDTONormal(String md_uuid, String marca, String modelo) {
		portatilDTO portatilDTO = new portatilDTO (0, md_uuid, marca, modelo );
		return portatilDTO;
	}

	@Override
	public alumnoDTO aAlumnoDTONormal(Alumno alumno1) {
		// TODO Auto-generated method stub
		alumnoDTO alumnoDTO = new alumnoDTO ( alumno1);
		return alumnoDTO;
		
		
	}

	@Override
	public alumnoDTO aAlumnoDTONormal(String md_uuid, String nombre, String telefono, int idPortatil, String marca,
			String modelo) {
		alumnoDTO alumnoDTO = new alumnoDTO ();
		return alumnoDTO;
	}

	


	
	

	

	

	

	

	
	

}
