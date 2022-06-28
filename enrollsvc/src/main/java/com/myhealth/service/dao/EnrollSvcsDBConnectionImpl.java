/**
 * 
 */
package com.myhealth.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hshaik
 *
 */
public class EnrollSvcsDBConnectionImpl implements EnrollSvcDBConnection {

	private Properties jdbcConfigParams;
	/**
	 * 
	 * @param jdbcConfigParams
	 */
    public EnrollSvcsDBConnectionImpl(Properties jdbcConfigParams){
        this.jdbcConfigParams = jdbcConfigParams;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return getConnection(getUrl(), getUserName(),getPassWord());
    }

    private Connection getConnection(String url,String uName, String password) throws SQLException {
        return DriverManager.getConnection(url, uName, password);
    }
    @Override
    public boolean releaseConnection(Connection connection) {
        return false;
    }

    @Override
    public String getUrl() {
        return new StringBuilder ("jdbc:mysql://").append(jdbcConfigParams.getProperty ("hostname"))
                    .append(":").append(getPort()).append("/").append (getDatabaseName ()).toString ();
    }

    @Override
    public int getPort() {
        return Integer.parseInt (jdbcConfigParams.getProperty("port"));
    }

    @Override
    public String getDatabaseName() {
        return jdbcConfigParams.getProperty("dbname");
    }

    @Override
    public String getUserName() { return jdbcConfigParams.getProperty("uname"); }

    @Override
    public String getPassWord() {
        return jdbcConfigParams.getProperty("password");
    }

    @Override
    public int getInitialPoolSize() {
        return 1;
    }
}
