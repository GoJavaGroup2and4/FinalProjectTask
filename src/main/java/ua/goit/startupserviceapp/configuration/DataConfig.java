package ua.goit.startupserviceapp.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.goit.startupserviceapp.controller.UserController;
import ua.goit.startupserviceapp.model.Test;
import ua.goit.startupserviceapp.model.User;
import ua.goit.startupserviceapp.service.UserService;
import ua.goit.startupserviceapp.service.UserServiceImpl;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Spring Data Jpa configuration
 *
 * @author Vadim Kozak
 */

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "ua.goit.startupserviceapp.dao")
@PropertySource("classpath:jdbc.properties")
public class DataConfig {

    @Value("${jdbc.driver.class}")
    private String jdbcDriveClass;

    @Value("${jdbc.user}")
    private String jdbcUser;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbcDriveClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUser);
        dataSource.setPassword(jdbcPassword);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("ua.goit.startupserviceapp.model");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties hibernateProperties = allHibernateProperties();
        factoryBean.setJpaProperties(hibernateProperties);

        return factoryBean;
    }

    private Properties allHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        return hibernateProperties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public Test test(UserController userController){
        Test test = new Test();
        test.setUserController(userController);
        return test;
    }

    @Bean
    public UserController userController(UserServiceImpl userServiceImpl){
        UserController userController = new UserController();
        userController.setUserService(userServiceImpl);
        return userController;
    }

    @Bean
    public UserServiceImpl userServiceImpl(){
        return new UserServiceImpl();
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addAnnotatedClasses(User.class);

        return sessionBuilder.buildSessionFactory();
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory) {

        HibernateTransactionManager txManager
                = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }
}
