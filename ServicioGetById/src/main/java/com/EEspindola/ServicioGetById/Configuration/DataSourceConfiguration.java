package com.EEspindola.ServicioGetById.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    public static String DRIVER_CLASS_NAME;

    public DataSourceConfiguration(
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password,
        @Value("${spring.datasource.driver-class-name}") String driverClassName
    ){
        this.URL = url;
        this.USERNAME = username;
        this.PASSWORD = password;

        DataSourceConfiguration.DRIVER_CLASS_NAME = driverClassName;
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
