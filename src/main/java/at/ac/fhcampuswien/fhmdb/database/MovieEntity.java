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
    @DatabaseField(columnName = "title")
    private String title;
    @DatabaseField(columnName = "description")
    private String description;

    //@DatabaseField()
   // private final List<Genre> genres;

    @DatabaseField(columnName = "")
    private int releaseYear;
    @DatabaseField(columnName = "")
    private String imgUrl;
    @DatabaseField(columnName = "")
    private int lengthInMinutes; // in minutes
    @DatabaseField(columnName = "")
    private double rating; // 0-10


}
