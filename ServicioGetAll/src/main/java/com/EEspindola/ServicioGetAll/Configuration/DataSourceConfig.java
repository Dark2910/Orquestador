package com.EEspindola.ServicioGetAll.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
public class DataSourceConfig {

    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;
    private final String DRIVER_CLASS_NAME ;

    public DataSourceConfig(
            @Value("${URL}") String url,
            @Value("${USER}") String username,
            @Value("${PASSWORD}") String password,
            @Value("${DRIVER_CLASS_NAME}") String driverClassName
    ){
        URL = url;
        USERNAME = username;
        PASSWORD = password;
        DRIVER_CLASS_NAME = driverClassName;

    }

    @Primary
    @Bean(name = "jdbcDataSource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);

        return dataSource;
    }

    @Primary
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate( @Qualifier("jdbcDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}


