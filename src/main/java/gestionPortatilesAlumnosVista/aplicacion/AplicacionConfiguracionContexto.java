package gestionPortatilesAlumnosVista.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import gestionPortatilesAlumnosVista.aplicacion.dal.Alumno;

@PropertySource("classpath:aplicacion.properties")
@EnableJpaRepositories("gestionPortatilesAlumnosVista.aplicacion.dal")
@Configuration
@ComponentScan
public class AplicacionConfiguracionContexto {
	
	@Autowired
    private Environment contextoPropiedades;
    
    //Tener un bean que llame a las variables del properties que tiene las constantes del datasource, emf y transacciones
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(contextoPropiedades.getProperty("db.driver"));
		dataSource.setUrl(contextoPropiedades.getProperty("db.url"));
		dataSource.setUsername(contextoPropiedades.getProperty("db.username"));
		dataSource.setPassword(contextoPropiedades.getProperty("db.password"));
		return dataSource;
	}

    
    //Crear el entity manager y transaction Manager
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(Alumno.class.getPackage().getName());

		HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
		hibernateJpa.setDatabase(Database.POSTGRESQL);
		hibernateJpa.setDatabasePlatform(contextoPropiedades.getProperty("hibernate.dialect"));
		hibernateJpa.setGenerateDdl(contextoPropiedades.getProperty("hibernate.generateDdl", Boolean.class));
		hibernateJpa.setShowSql(contextoPropiedades.getProperty("hibernate.show_sql", Boolean.class));
		emf.setJpaVendorAdapter(hibernateJpa);

		Properties jpaProperties = new Properties();
		//jpaProperties.put("hibernate.hbm2ddl.auto", contextoPropiedades.getProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.show_sql", contextoPropiedades.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", contextoPropiedades.getProperty("hibernate.format_sql"));
		// jpaProperties.put("hibernate.bytecode.provider",
		// contextoPropiedades.getProperty("hibernate.bytecode.provider"));
		emf.setJpaProperties(jpaProperties);

		return emf;
	}
        
        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            return transactionManager;
        }
        
        
	
	

}
