/**
 * 
 */
package com.myhealth.service.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author hshaik
 *
 */
public interface EnrollSvcDBConnection {
	
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    String getUrl();
    int getPort();
    String getDatabaseName();
    String getUserName();
    String getPassWord();
    int getInitialPoolSize();

}
