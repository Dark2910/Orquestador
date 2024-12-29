package com.EEspindola.ServicioGetAll.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
public class HikariDataSourceConfig {

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    public static String DRIVER_CLASS_NAME;

    public HikariDataSourceConfig(
            @Value("${URL}") String url,
            @Value("${USER}") String user,
            @Value("${PASSWORD}") String password,
            @Value("${DRIVER_CLASS_NAME}") String driverClassName
    ){
        this.URL = url;
        this.USER = user;
        this.PASSWORD = password;

        HikariDataSourceConfig.DRIVER_CLASS_NAME = driverClassName;
    }

    @Bean(name = "hikariDataSource")
    public DataSource dataSource(){

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setUsername(USER);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setDriverClassName(DRIVER_CLASS_NAME);

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "hikariTemplate")
    public JdbcTemplate JdbcTemplate(@Qualifier("hikariDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
