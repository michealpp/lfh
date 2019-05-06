package basic.com;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * org.hibernate.Session是操作DB的主要接口，它可以通过 Hibernate SessionFactory创建，
 * 而spring提供了LocalSessionFactoryBean来创建SessionFactory
 */
@Configuration
@ComponentScan("basic.com")
public class AppConfig{
    //创建LocalSessionFactoryBean需要有javax.sql.DataSource
    private DataSource dataSource;

    //构造注入
    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        //指定扫描entity所在的包
        sessionFactoryBean.setPackagesToScan("basic.com");

        //Properties hibernateProperties = new Properties();
        //hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        //sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }
}