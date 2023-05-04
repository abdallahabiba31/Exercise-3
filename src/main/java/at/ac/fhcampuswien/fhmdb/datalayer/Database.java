package at.ac.fhcampuswien.fhmdb.datalayer;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {
    //imbedded Database
    public static final String DB_URL = "jdbc:h2:file: ./db/moviesdb";
    public static final String username = "user";
    public static final String password = "passwort";

    private static ConnectionSource connectionSource;
    private Dao<WatchlistEntity, Long> dao;
    private static Database instance;

    private Database(){
        try{
            createConnectionSource();
            dao = DaoManager.createDao(connectionSource, WatchlistEntity.class);
            createTables();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public Database getDatabase(){
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
    public void testDB() throws SQLException {
        WatchlistEntity watchlist = new WatchlistEntity("aId", "title", "description", "ACTION", 2003, "URL", 200, 9.8);
        dao.create(watchlist);
    }
}
