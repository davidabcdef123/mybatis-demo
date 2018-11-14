package com.statement;

import com.config.Configuration;
import com.mapper.MapperData;
import com.result.ResultSetHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * Created by sc on 2018/11/12.
 */
public class StatementHandler {

    private Configuration configuration;

    private ResultSetHandler resultSetHandler;

    public StatementHandler(Configuration configuration) {
        this.configuration = configuration;
        this.resultSetHandler = new ResultSetHandler(configuration);
    }

    public <T>T query(MapperData mapperData,Object parameter) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //JDBC
        Connection conn = getConnection();
        //TODO ParameterHandler
        PreparedStatement pstmt = conn.prepareStatement(String.format(mapperData.getSql(), Integer.parseInt(String.valueOf(parameter))));
        //PreparedStatement pstmt = conn.prepareStatement("select * from test");

        //pstmt.execute();
        ResultSet resultSet=pstmt.executeQuery();
        //ResultSetHandler
        return (T)resultSetHandler.handle(resultSet,mapperData.getResultType());

    }

    public Connection getConnection() throws SQLException {
        String driver = configuration.getDirver();
        String url = configuration.getUrl();
        String username = configuration.getUsername();
        String password = configuration.getPassword();
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
