package org.parts.dao;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by fathergeorge on 05.05.18.
 */
public class ConnectionBuilder {
    public static Connection getH2Connection() {
        try {
            String url = "jdbc:h2:~/Downloads\\test_\\testDevCandidate1\\TestDB";
            String name = "";
            String pass = "";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
