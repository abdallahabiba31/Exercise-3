package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable (tableName = "movie")

    public class MovieEntity {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField()
    private String title;
    @DatabaseField()
    private String description;

    //@DatabaseField()
   // private final List<Genre> genres;

    @DatabaseField()
    private int releaseYear;
    @DatabaseField()
    private String imgUrl;
    @DatabaseField()
    private int lengthInMinutes; // in minutes
    @DatabaseField()
    private double rating; // 0-10


}
