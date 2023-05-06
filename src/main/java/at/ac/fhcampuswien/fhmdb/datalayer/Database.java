package at.ac.fhcampuswien.fhmdb.datalayer;

import at.ac.fhcampuswien.fhmdb.exceptions.DatabaseException;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {
    //embedded Database
    //built into the Software - no need for an extra server
    public static final String DB_URL = "jdbc:h2:file: ./db/moviedb";
    public static final String username = "user";
    public static final String password = "password";

    private static ConnectionSource connectionSource;
     Dao<WatchlistEntity, Long> dao;
    private static Database instance;

    private Database(){
        try{
            createConnectionSource();
            dao = DaoManager.createDao(connectionSource, WatchlistEntity.class);
            createTables();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            MovieCell.showExceptionDialog(new DatabaseException("Database error"));
        }
    }
    public static Database getDatabase(){
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Dao<WatchlistEntity, Long> getDao()
    {
        return dao;
    }

    public  ConnectionSource getConnectionSource()
    {
        return connectionSource;
    }
    private static void createConnectionSource() throws SQLException {
        connectionSource = new JdbcConnectionSource(DB_URL, username, password);
    }
    private static void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, WatchlistEntity.class);
    }
    /*
    public void testDB() throws SQLException {
        WatchlistEntity watchlist = new WatchlistEntity("aId", "title", "description", "ACTION", 2003, "URL", 200, 9.8);
        dao.create(watchlist);
    }*/
}
