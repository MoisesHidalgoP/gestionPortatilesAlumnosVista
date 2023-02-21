package gestionPortatilesAlumnosVista.aplicacion.dal;

public interface alumnoServicio {
	
            //Signatura del metodo que inserta la matricula del alumno
			public void insertarMatriculaAlumno(Alumno matricula);
			//Signtura del metodo que borra la matricula del alumno
			public void borrarMatriculaAlumno(Alumno matricula);

}
