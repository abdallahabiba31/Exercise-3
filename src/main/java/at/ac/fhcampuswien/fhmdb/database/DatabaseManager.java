package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;


public class DatabaseManager {
    public static final String DB_URL = "jdbc:hc:file: ./db/dbmovies";
    public static final String user = "user";
    public static final String pw = "password";

    private static ConnectionSource connectionSource;
    Dao <MovieEntity, Long> dao;

    public static void createConnectionSource () throws SQLException {

        connectionSource = new JdbcConnectionSource(DB_URL, user, pw);

    }
}
