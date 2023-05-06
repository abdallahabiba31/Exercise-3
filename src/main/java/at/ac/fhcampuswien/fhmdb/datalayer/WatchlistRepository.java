package at.ac.fhcampuswien.fhmdb.datalayer;

import at.ac.fhcampuswien.fhmdb.database.MovieEntity;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

//testkomment
public class WatchlistRepository {

    Dao<WatchlistEntity, Long> dao;

    public WatchlistRepository() {

        this.dao = Database.getDatabase().getDao();

    }

    public void addToWatchlist(Movie movie) throws SQLException{

        dao.create(movieToWatchlist(movie));

    }
    public List<WatchlistEntity> getAll() throws SQLException {

        return dao.queryForAll();

    }

    private WatchlistEntity movieToWatchlist(Movie movie){
        return new WatchlistEntity(movie.getTitle(), movie.getDescription());
    }

    //public void addToWatchList (Movie, movie) throws SQLException {
        //String title = movie.getTitle().replace("'", "''");
        //if (dao.queryForEg ("title", title)).isEmpty()) {
            //dao.create(movieToEntity(movie));
            //System.out.println ("Added " +movie.getTitle() + "to Watchlist");
        }










