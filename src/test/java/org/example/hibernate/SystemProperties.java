package org.example.hibernate;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {
    private static final Properties SYSTEM_PROPS = loadSystemProperties();
    private static final Logger logger = Logger.getLogger(SystemProperties.class.getName());

    private static Properties loadSystemProperties() {
        Properties systemProps = new Properties();
        try {
            InputStream appConfig = SystemProperties.class.getClassLoader().getResourceAsStream("hibernate.properties");
            if (appConfig == null) {
                throw new IllegalArgumentException("hibernate.properties not found");
            }
            systemProps.load(appConfig);
        } catch (IOException e) {
            logger.error(e);
            throw new IllegalArgumentException(e);
        }
        return systemProps;
    }

    public static Properties getHibernateConfiguration() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", SYSTEM_PROPS.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", SYSTEM_PROPS.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
        hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", SYSTEM_PROPS.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
        hibernateProperties.setProperty("hibernate.connection.driver_class", SYSTEM_PROPS.getProperty("hibernate.connection.driver_class"));
        hibernateProperties.setProperty("hibernate.connection.url", SYSTEM_PROPS.getProperty("hibernate.connection.url"));
        hibernateProperties.setProperty("hibernate.connection.username", SYSTEM_PROPS.getProperty("hibernate.connection.username"));
        hibernateProperties.setProperty("hibernate.connection.password", SYSTEM_PROPS.getProperty("hibernate.connection.password"));
        hibernateProperties.setProperty("hibernate.connection.pool_size", SYSTEM_PROPS.getProperty("hibernate.connection.pool_size"));
        hibernateProperties.setProperty("format_sql", SYSTEM_PROPS.getProperty("format_sql"));
        hibernateProperties.setProperty("show_sql", SYSTEM_PROPS.getProperty("show_sql"));
        hibernateProperties.setProperty("hbm2ddl", SYSTEM_PROPS.getProperty("hbm2ddl"));
        return hibernateProperties;
    }
}
