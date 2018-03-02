package com.example.conf;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * Data Source Configuration for 'dev' Profile.
 * This configuration sets MySql as the default DataSource
 * when the profile is set as 'dev'.
 */
@Profile("dev")
@Configuration
public class DevDataSourceConfiguration {

    //Retrieves the mysql-schema from the resource folder.
    @Value("classpath:mysql-schema.sql")
    private Resource schemaScript;

    //Initialize a DataSource and populates the database.
    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    //Populates the database using the MySql Schema.
    private DatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        return populator;
    }

    //Sets the DataSource using a MySql database.
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUsername("root");
        dataSource.setPassword("010203040506070809");
        dataSource.setUrl("jdbc:mysql://localhost:3306/token_database");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return dataSource;
    }
}
