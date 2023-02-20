package gestionPortatilesAlumnosVista.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;


import org.hibernate.dialect.Database;
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
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource("classpath:aplicacion.properties")
@EnableJpaRepositories("gestionPortatilesAlumnosVista.aplicacion.dal")
@EnableTransactionManagement
@Configuration
@ComponentScan
public class AplicacionConfiguracionContexto {
	
	@Autowired
    private Environment contextoPropiedades;
    
    //Tener un bean que llame a las variables del properties que tiene las constantes del datasource, emf y transacciones
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(contextoPropiedades.getProperty("spring.dataSource.database"));
        dataSource.setUrl(contextoPropiedades.getProperty("spring.dataSource.database"));
        dataSource.setUsername(contextoPropiedades.getProperty("spring.dataSource.username"));
        dataSource.setPassword(contextoPropiedades.getProperty("spring.dataSource.password" ));
        return dataSource;
    }

    
    //Crear el entity manager y transaction Manager
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(dataSource());
            em.setPackagesToScan(GestionAlumnos.class.getPackage().getName());
            
            HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
            jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
            jpaVendorAdapter.setDatabasePlatform(contextoPropiedades.getProperty("org.hibernate.dialect.PostgreSQLDialect"));
            jpaVendorAdapter.setGenerateDdl(contextoPropiedades.getProperty("hibernate.generateDdl", Boolean.class));
            jpaVendorAdapter.setShowSql(contextoPropiedades.getProperty("hibernate.show_sql",Boolean.class));
            em.setJpaVendorAdapter(jpaVendorAdapter);
            
            Properties jpaProperties = new Properties();
            jpaProperties.put("hibernate.hbm2ddl.auto", contextoPropiedades.getProperty("hibernate.hbm2ddl.auto"));
            jpaProperties.put("hibernate.show_sql", contextoPropiedades.getProperty("hibernate.show_sql"));
            jpaProperties.put("hibernate.format_sql", contextoPropiedades.getProperty("hibernate.format_sql"));
            em.setJpaProperties(jpaProperties);
            
        return em;
    }
        
        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            return transactionManager;
        }
	
	

}
