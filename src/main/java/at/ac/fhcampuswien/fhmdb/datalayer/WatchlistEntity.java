package at.ac.fhcampuswien.fhmdb.datalayer;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DatabaseTable(tableName = "Movie")
public class WatchlistEntity {
    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField()
    private String apiId;

    @DatabaseField()
    private String title;

    @DatabaseField()
    private String description;

    @DatabaseField()
    private String genres;

    @DatabaseField()
    private int releaseYear;

    @DatabaseField()
    private String imgUrl;

    @DatabaseField()
    private int lengthInMinutes;

    @DatabaseField()
    private double rating;


    public WatchlistEntity()
    {

    }
    public WatchlistEntity(String apiId, String title, String description, String genres, int releaseYear, String imgUrl, int lengthInMinutes, double rating)
    {
        this.apiId = apiId;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public String getApiID() {
        return apiId;
    }

    public void setApiID(String apiID) {
        apiId = apiID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImgURL() {
        return imgUrl;
    }

    public void setImgURL(String imgURL) {
        this.imgUrl = imgURL;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static String genresToString(List<Genre> genres) {

        String result = "";
        for (var item: genres) {
            result += item.toString() + ",";
        }
        return result;
    }

    public Movie toMovie() {
        List<Genre> genres = Arrays.stream(this.genres.split(","))
                .map(Genre::valueOf)
                .collect(Collectors.toList());
        return new Movie(apiId, title, description, genres, releaseYear, imgUrl, lengthInMinutes, rating);
    }

}
