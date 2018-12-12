package com.tomryc.projects.javafx.myownlibrary.database.dao;

import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by Tomasz Rycerz on 12/12/2018
 */
public class BookDao extends CommonDao {

    public BookDao(ConnectionSource connectionSource){
        super(connectionSource);
    }
}
