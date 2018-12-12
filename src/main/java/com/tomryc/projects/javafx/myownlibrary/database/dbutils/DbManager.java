package com.tomryc.projects.javafx.myownlibrary.database.dbutils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tomryc.projects.javafx.myownlibrary.database.model.Author;
import com.tomryc.projects.javafx.myownlibrary.database.model.Book;
import com.tomryc.projects.javafx.myownlibrary.database.model.Category;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Tomasz Rycerz on 12/12/2018
 */
public class DbManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:./libraryDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;

    public static void initDatabase(){

        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource(){
        try{
            connectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD, USER, PASS);
        }catch (SQLException e){
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource != null){
            try{
                connectionSource.close();
            }catch (IOException e){
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable(){
        try{
            TableUtils.createTableIfNotExists(connectionSource, Author.class);
            TableUtils.createTableIfNotExists(connectionSource, Book.class);
            TableUtils.createTableIfNotExists(connectionSource, Category.class);
        }catch (SQLException e){
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable(){
        try{
            TableUtils.dropTable(connectionSource, Author.class, true);
            TableUtils.dropTable(connectionSource, Book.class, true);
            TableUtils.dropTable(connectionSource, Category.class, true);
        }catch(SQLException e){
            LOGGER.warn(e.getMessage());
        }
    }

}
