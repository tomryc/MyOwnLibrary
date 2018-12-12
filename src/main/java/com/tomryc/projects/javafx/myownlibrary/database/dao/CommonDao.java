package com.tomryc.projects.javafx.myownlibrary.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.tomryc.projects.javafx.myownlibrary.database.model.BaseModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tomasz Rycerz on 12/12/2018
 */
public class CommonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class);
    protected final ConnectionSource connectionSource;

    public CommonDao(ConnectionSource connectionSource){
        this.connectionSource = connectionSource;
    }

    public <T extends BaseModel, I> void creatOrUpdate(BaseModel baseModel) {
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.createOrUpdate((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }
    }

    public <T extends BaseModel, I> void refresh(BaseModel baseModel){
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.refresh((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }
    }

    public <T extends BaseModel, I> void delete(BaseModel baseModel){
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.delete((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        }
    }

    public <T extends BaseModel, I> void deleteById(Class<T> cls, Integer id){
        try {
            Dao<T, I> dao = getDao(cls);
            dao.deleteById((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> T findById(Class<T> cls, Integer id){
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForId((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        } finally {
            this.closeDbConnection();
        }
        return null;
    }

    public <T extends BaseModel, I> List<T> queryForAll(Class<T> cls){
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForAll();
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        } finally {
            this.closeDbConnection();
        }
        return null;
    }

    public <T extends BaseModel, I> Dao<T, I> getDao(Class<T> cls){
        try {
            return DaoManager.createDao(connectionSource, cls);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        } finally {
            this.closeDbConnection();
        }
        return null;
    }

    public <T extends BaseModel, I> QueryBuilder<T, I> getQueryBuilder(Class<T> cls){
        Dao<T, I> dao = getDao(cls);
        return dao.queryBuilder();
    }

    private void closeDbConnection(){
        try {
            this.connectionSource.close();
        } catch (IOException e) {
        }
    }

}
