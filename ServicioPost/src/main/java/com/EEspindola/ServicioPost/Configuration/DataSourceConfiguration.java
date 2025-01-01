package com.EEspindola.ServicioPost.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
public class DataSourceConfiguration {

    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    public static String DRIVER_CLASS_NAME;

    public DataSourceConfiguration(
        @Value("${URL}") String url,
        @Value("${USERNAME}") String username,
        @Value("${PASSWORD}") String password,
        @Value("${DRIVER_CLASS_NAME}") String driverClassName
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
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }



}
