package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AuthController {


    public JFXButton okButton;

    public void okClicked(ActionEvent event) throws IOException
    {
        System.out.println("Ok clicked");
        URL url = new File("src/views/welcome-view.fxml").toURL();
        Parent root = FXMLLoader.load(url);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root, 980, 700));
        window.show();

    }


}