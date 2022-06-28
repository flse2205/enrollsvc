/**
 * 
 */
package com.myhealth.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.myhealth.exception.ConfigLoadFailureException;

/**
 * @author hshaik
 *
 */
public abstract class BaseDao {
	
    private Connection connection;
    private EnrollSvcDBConnection daoConnection;
    private String query;
    protected Map<String,String> requestMap;

    public BaseDao() throws ConfigLoadFailureException {
        daoConnection = new EnrollSvcsDBConnectionImpl(null);
        requestMap = new HashMap<> ();
    }

    public Object[] executeSimpleQuery(String query){
        Statement stmt;
        Object[] response = null;
        try{
            connection = daoConnection.getConnection ();
            stmt = connection.createStatement();
            ResultSet rs =  stmt.executeQuery (query);
            response = populateResponse (rs);
        }catch (SQLException excep){
            excep.printStackTrace ();
        }
        return response;
    }

    public Map<String, String> getRequestMap() {
        return requestMap;
    }

    protected String getQuery(String queryName){
        return null; // QueryUnmarshaller.getInstance ().getSqls ().get (queryName);
    }

    protected abstract Object[] populateResponse(ResultSet resultSet) throws SQLException;

    protected abstract String prepareQueryString(Map<String, String> request);


}
