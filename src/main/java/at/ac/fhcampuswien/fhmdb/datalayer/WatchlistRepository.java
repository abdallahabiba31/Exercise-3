package at.ac.fhcampuswien.fhmdb.datalayer;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class WatchlistRepository {
    Dao<WatchlistEntity, Long> dao;

    public WatchlistRepository(){
        this.dao = Database.getDatabase().getDao();
    }
    public void removeFromWatchlist(Movie movie) throws SQLException {
        String title = movie.getTitle().replace("'", "''");
        List<WatchlistEntity> movies = dao.queryForEq("title", title);
        if (!movies.isEmpty()) {
            dao.delete(movies);
            System.out.println("Deleted " + movie.getTitle() + " from Watchlist");
        }
    }
     public List<WatchlistEntity> getAll() throws SQLException {
        return dao.queryForAll();
    }
    public void addToWatchlist(Movie movie) throws SQLException {
        dao.create(movieToWatchlist(movie));
    }

    private WatchlistEntity movieToWatchlist(Movie movie){
        return new WatchlistEntity(movie.getId(), movie.getTitle(), movie.getDescription(),WatchlistEntity.genresToString(movie.getGenres()) , movie.getReleaseYear(),
                movie.getImgUrl(), movie.getLengthInMinutes(), movie.getRating());
    }
}
