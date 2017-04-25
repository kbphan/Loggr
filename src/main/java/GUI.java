import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;


public class GUI extends Application {
    private static final int APPWIDTH = 1000;
    private static final int APPHEIGHT = 600;
    private static final int BUTTONWIDTH = 80;
    private static final int BUTTONHEIGHT = 15;

    Button addButton, removeButton, editButton, exportButton, importButton, helpButton;
    TableColumn nameCol, genreCol, ratingCol, typeCol, progressCol;
    ColumnConstraints col1, col2;
    HBox buttonBox;
    GridPane mainPane;
    Scene mainScene;
    Stage primaryStage;
    TableView movieList;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        setupScenes();
        stage.setTitle("Loggr"); //Title in the titlebar
        stage.setScene(mainScene);
        stage.show();
    }

    private void setupScenes() {
        setupMainScene();
    }

    private void setupMainScene() {
        setupMainPane();
        mainScene = new Scene(mainPane, APPWIDTH, APPHEIGHT);
    }

    private void setupMainPane() {
        mainPane = new GridPane();
        setupMainPaneColumnConstraints();
        setupMainButtons();
        // setupMainButtonSizes(BUTTONWIDTH, BUTTONHEIGHT);
        setupButtonBox();
        setupMovieList();
        mainPane.add(buttonBox, 0, 1);
        mainPane.add(movieList, 0, 0);
        mainPane.setVgrow(movieList, Priority.ALWAYS);
        mainPane.setHgrow(buttonBox, Priority.ALWAYS);
    }

    private void setupMainPaneColumnConstraints() {
        col1 = new ColumnConstraints();
        col2 = new ColumnConstraints();
        col1.setPercentWidth(75);
        col2.setPercentWidth(25);
        mainPane.getColumnConstraints().addAll(col1, col2);
    }

    private void setupMainButtons() {
        addButton = new Button("Add");
        removeButton = new Button("Remove");
        editButton = new Button("Edit");
        exportButton = new Button("Export");
        importButton = new Button("Import");
        helpButton = new Button("?");
        setupButtonSizes();
    }

    private void setupButtonSizes() {
        addButton.setMaxWidth(Double.MAX_VALUE);
        removeButton.setMaxWidth(Double.MAX_VALUE);
        editButton.setMaxWidth(Double.MAX_VALUE);
        exportButton.setMaxWidth(Double.MAX_VALUE);
        importButton.setMaxWidth(Double.MAX_VALUE);
        helpButton.setMaxWidth(Double.MAX_VALUE);
    }

    // private void setupMainButtonSizes(int width, int height) {

    // }

    private void setupButtonBox() {
        buttonBox = new HBox();
        buttonBox.getChildren().addAll(addButton,
                                       removeButton,
                                       editButton,
                                       exportButton,
                                       importButton,
                                       helpButton);
        buttonBox.setSpacing(0);
        setupButtonGrow();
        //buttonBox.setPadding(new Insets(0, 12, 15, 12));
    }

    private void setupButtonGrow() {
        HBox.setHgrow(addButton, Priority.ALWAYS);
        HBox.setHgrow(removeButton, Priority.ALWAYS);
        HBox.setHgrow(editButton, Priority.ALWAYS);
        HBox.setHgrow(exportButton, Priority.ALWAYS);
        HBox.setHgrow(importButton, Priority.ALWAYS);
        HBox.setHgrow(helpButton, Priority.ALWAYS);
    }

    private void setupMovieList() {
        setupMovieListColumns();
        movieList = new TableView();
        movieList.getColumns().addAll(nameCol,
                                      genreCol,
                                      ratingCol,
                                      typeCol,
                                      progressCol);
        setupMovieListColumnWidth();

    }

    private void setupMovieListColumns() {
        nameCol = new TableColumn("Name");
        genreCol = new TableColumn("Genre");
        ratingCol = new TableColumn("Rating");
        typeCol = new TableColumn("Type");
        progressCol = new TableColumn("Progress");
    }

    private void setupMovieListColumnWidth() {
        nameCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        genreCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        ratingCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        typeCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        progressCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
    }

    public ObservableList<Element> getElements() {
        ObservableList<Element> listOfElements = FXCollections.observableArrayList();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
