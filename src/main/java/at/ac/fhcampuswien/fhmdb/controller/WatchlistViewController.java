package at.ac.fhcampuswien.fhmdb.controller;

import at.ac.fhcampuswien.fhmdb.FhmdbApplication;
import at.ac.fhcampuswien.fhmdb.datalayer.WatchlistEntity;
import at.ac.fhcampuswien.fhmdb.datalayer.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.exceptions.DatabaseException;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WatchlistViewController {
    WatchlistRepository repo;
    @FXML
    public VBox mainVBox;
    @FXML
    public JFXButton homeViewBtn;
    @FXML
    public JFXListView movieWatchlistView;
    public void initialize(){
        /*
        repo = new WatchlistRepository();

        try {
            List<WatchlistEntity> watchlistEntities = repo.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("WatchlistViewController initialized");

        repo = new WatchlistRepository();
        List<WatchlistEntity> watchlist = new ArrayList<>();

        try {
            watchlist = repo.getAll();
        } catch (SQLException e) {
            MovieCell.showExceptionDialog(new DatabaseException("Database problem"));
        }

        ObservableList<Movie> movies = FXCollections.observableArrayList(
                watchlist.stream()
                        .map(WatchlistEntity::toMovie)
                        .collect(Collectors.toList())
        );

        movieWatchlistView.setItems(movies);
        movieWatchlistView.setCellFactory(movieListView -> new MovieCell(true));
    }
    public void loadHomeView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 890, 620);
            Stage stage = (Stage)mainVBox.getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println("Error while loading main page.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error has occurred.");
            alert.setContentText("Error while loading.");
        }
    }

}
