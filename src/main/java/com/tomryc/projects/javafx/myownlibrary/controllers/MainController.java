package com.tomryc.projects.javafx.myownlibrary.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ResourceBundle;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.STYLESHEET_MODENA;

/**
 * Created by Tomasz Rycerz on 11/12/2018
 */
public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private void initialize(){
        topMenuButtonsController.setMainController(this);
    }

    public void setCenter(String fxmlPath){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane.setCenter(parent);

    }

    @FXML
    public void closeApplication() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void setCaspian() {
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
    }

    @FXML
    public void setModena() {
        Application.setUserAgentStylesheet(STYLESHEET_MODENA);
    }

    @FXML
    public void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage)borderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(value);

    }

    @FXML
    public void about() {

    }
}
