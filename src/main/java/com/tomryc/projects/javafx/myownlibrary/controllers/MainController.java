package com.tomryc.projects.javafx.myownlibrary.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

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
}
