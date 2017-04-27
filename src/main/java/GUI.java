import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.control.cell.*;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.awt.image.BufferedImage;

public class GUI extends Application {
    private static final int APPWIDTH = 1000;
    private static final int APPHEIGHT = 600;
    private static final int BUTTONWIDTH = 80;
    private static final int BUTTONHEIGHT = 15;

    Button addButton, removeButton, editButton, exportButton, importButton, helpButton;
    TableColumn nameCol, lastvCol, ratingCol, typeCol, progressCol;
    ColumnConstraints col1, col2;
    HBox buttonBox;
    HBox sideBox;
    GridPane mainPane;
    Scene mainScene;
    Stage primaryStage;
    TableView<Element> movieList;
    TextField nameInput;
    ChoiceBox typeInput;
    Text description;
    ImageView poster;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setMinWidth(800);
        setupScenes();
        stage.setTitle("Loggr"); //Title in the title bar
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
        setupSideBox();
        setupMovieList();
        mainPane.add(buttonBox, 0, 1);
        mainPane.add(movieList, 0, 0);
        mainPane.add(sideBox, 1, 0);
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
        nameInput = new TextField();
        nameInput.setPromptText("name");
        nameInput.setMinWidth(100);
        typeInput = new ChoiceBox<String>();
        typeInput.getItems().addAll("media",
                                    "text");
        typeInput.setValue("media");
        addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        removeButton = new Button("Remove");
        removeButton.setOnAction(e -> removeButtonClicked());
        editButton = new Button("Edit");
        exportButton = new Button("Export");
        importButton = new Button("Import");
        helpButton = new Button("?");
        setupButtonSizes();
    }

    public void addButtonClicked() {
        if (typeInput.getValue().equals("media") && !nameInput.getText().trim().equals("")) {
            MediaElement media = new MediaElement(nameInput.getText().trim(), new Date(), new Date());
            movieList.getItems().add(media);
            nameInput.clear();
        }
    }

    public void removeButtonClicked() {
        ObservableList<Element> selectedElements, allElements;
        allElements = movieList.getItems();
        selectedElements = movieList.getSelectionModel().getSelectedItems();
        selectedElements.forEach(allElements::remove);
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
        buttonBox.getChildren().addAll(nameInput,
                                       typeInput,
                                       addButton,
                                       removeButton,
                                       editButton,
                                       exportButton,
                                       importButton,
                                       helpButton);
        buttonBox.setSpacing(0);
        setupButtonGrow();
        //buttonBox.setPadding(new Insets(0, 12, 15, 12));
    }

    private void setupSideBox() {
        sideBox = new HBox();
        sideBox.setPadding(new Insets(10, 10, 10, 10));
        description = new Text();
        description.setWrappingWidth(250);
        description.setFont(new Font(16));
        sideBox.getChildren().addAll(description);
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
        movieList = new TableView<Element>();
        movieList.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>()
        {
            @Override
            public void onChanged(Change<? extends Integer> change)
            {
                Element selectedElement = movieList.getSelectionModel().getSelectedItem();
                String temp = "";
                // JSON.getData() will return an array of Strings that are details about the movie
                for (String str : JSON.getData(selectedElement.getName())) {
                    temp += str + "\n\n";
                }
                if(MediaElement.class.isInstance(selectedElement))
                {

                }
                description.setText(temp);
            }

        });
        movieList.getColumns().addAll(nameCol,
                                      lastvCol,
                                      ratingCol,
                                      typeCol,
                                      progressCol);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastvCol.setCellValueFactory(new PropertyValueFactory<>("lastViewed"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        progressCol.setCellValueFactory(new PropertyValueFactory<>("progress"));
        setupMovieListColumnWidth();
        movieList.setItems(getElements());

    }

    private void setupMovieListColumns() {
        nameCol = new TableColumn("Name");
        lastvCol = new TableColumn("Last Viewed");
        ratingCol = new TableColumn("Rating");
        typeCol = new TableColumn("Type");
        progressCol = new TableColumn("Progress");
    }

    private void setupMovieListColumnWidth() {
        nameCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        lastvCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        ratingCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        typeCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
        progressCol.prefWidthProperty().bind(movieList.widthProperty().multiply(0.2));
    }

    public ObservableList<Element> getElements() {
        ObservableList<Element> listOfElements = FXCollections.observableArrayList();
        listOfElements.add(new MediaElement("Harry Potter", new Date(), new Date()));
        return listOfElements;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
