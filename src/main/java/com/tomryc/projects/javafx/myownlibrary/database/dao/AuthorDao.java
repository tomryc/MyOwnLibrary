package com.tomryc.projects.javafx.myownlibrary.database.dao;

import com.j256.ormlite.support.ConnectionSource;


/**
 * Created by Tomasz Rycerz on 12/12/2018
 */
public class AuthorDao extends CommonDao {
    public AuthorDao(ConnectionSource connectionSource){
        super(connectionSource);
    }
}
