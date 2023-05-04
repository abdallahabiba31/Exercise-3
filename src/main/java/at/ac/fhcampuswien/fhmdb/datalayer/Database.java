package at.ac.fhcampuswien.fhmdb.datalayer;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class Database {

    //imbedded Database
    public static final String DB_URL = "jdbc:h2:file: ./db/moviesdb";
    public static final String username = "user";
    public static final String password = "passwort";

    private static ConnectionSource connectionSource;

    private static void ConnectionSource() throws SQLException {
         connectionSource = new JdbcConnectionSource(DB_URL, username, password);
    }
}
