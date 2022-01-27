package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL_BD = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME_BD = "root";
    public static final String PASSWORD_BD = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getConnectionHiber() {
        Configuration configuration = getConfiguration();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration getConfiguration() {
        return new Configuration()
                .setProperty("hibernate.connection.url", URL_BD)
                .setProperty("hibernate.connection.username", USERNAME_BD)
                .setProperty("hibernate.connection.password", PASSWORD_BD)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .addAnnotatedClass(User.class);
    }
}
