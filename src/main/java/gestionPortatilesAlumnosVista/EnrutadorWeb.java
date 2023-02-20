package gestionPortatilesAlumnosVista;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EnrutadorWeb extends AbstractAnnotationConfigDispatcherServletInitializer {


	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] { gestionPortatilesAlumnosVista.aplicacion.AplicacionConfiguracionContexto.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		 return new Class<?>[] { gestionPortatilesAlumnosVista.web.WebConfiguracionContexto.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	
	
	
}
