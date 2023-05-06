package at.ac.fhcampuswien.fhmdb.controller;

import at.ac.fhcampuswien.fhmdb.FhmdbApplication;
import at.ac.fhcampuswien.fhmdb.datalayer.WatchlistEntity;
import at.ac.fhcampuswien.fhmdb.datalayer.WatchlistRepository;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WatchlistViewController {
    WatchlistRepository repo;
    @FXML
    public VBox mainVBoxWatchlist;
    @FXML
    public JFXButton homeViewBtn;
    @FXML
    public JFXListView movieWatchlistView;
    public void initialize(){
        repo = new WatchlistRepository();

        try {
            List<WatchlistEntity> watchlistEntities = repo.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadHomeView(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 890, 620);
            Stage stage = (Stage)mainVBoxWatchlist.getScene().getWindow();
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println("Error while loading main page.");
        }
    }

}
