package com.tomryc.projects.javafx.myownlibrary.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

/**
 * Created by Tomasz Rycerz on 11/12/2018
 */
public class TopMenuButtonsController {

    public static final String LIBRARY_FXML = "/fxml/Library.fxml";
    public static final String LIST_BOOKS_FXML = "/fxml/ListBooks.fxml";
    public static final String STATISTICS_FXML = "/fxml/Statistics.fxml";
    public static final String ADD_BOOK_FXML = "/fxml/AddBook.fxml";
    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openLibrary() {
        mainController.setCenter(LIBRARY_FXML);
    }

    @FXML
    public void openListBooks() {
        mainController.setCenter(LIST_BOOKS_FXML);
    }

    @FXML
    public void openStatistics() {
        mainController.setCenter(STATISTICS_FXML);
    }

    @FXML
    public void addBook() {
        if(toggleButtons.getSelectedToggle()!=null){
            toggleButtons.getSelectedToggle().setSelected(false);
        }
        mainController.setCenter(ADD_BOOK_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


}
