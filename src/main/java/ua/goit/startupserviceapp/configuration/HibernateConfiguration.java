package ua.goit.startupserviceapp.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:jdbc.properties")
public class HibernateConfiguration {

    @Value("${jdbc.driver.class")
    private String jdbcDriveClass;

    @Value("${jdbc.user}")
    private String jdbcUser;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbcDriveClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (BasicDataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("ua.goit.startupserviceapp.model");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        factoryBean.setJpaProperties(hibernateProperties);
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
