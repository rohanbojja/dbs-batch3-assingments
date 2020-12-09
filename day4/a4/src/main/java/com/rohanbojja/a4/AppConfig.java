package com.rohanbojja.a4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.rohanbojja")
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/springdb");
        ds.setUsername("rohanbojja");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        LocalContainerEntityManagerFactoryBean lc = new LocalContainerEntityManagerFactoryBean();
        lc.setDataSource(ds);
        lc.setPackagesToScan("com.rohanbojja.a4.models");

        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        va.setDatabase(Database.MYSQL);
        va.setShowSql(true);
        lc.setJpaVendorAdapter(va);
        return lc;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txm = new JpaTransactionManager();
        txm.setEntityManagerFactory(emf);
        return txm;
    }
}
