package controllers;
import com.jfoenix.controls.JFXButton;
import dao.access.CotisationAccess;
import dao.access.UserAccess;
import dao.models.Cotisation;
import dao.models.User;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import dao.models.Cotisation;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class UserController extends Controller implements Initializable {


    public static User user;
    public JFXButton cotisationsButton;
    public JFXButton eventsButton;
    public Label usernameLabel;
    public VBox container;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        user = AuthController.connectedUser;
        String username = user.getFirstname()+" "+user.getLastname();
        usernameLabel.setText(username);
    }

    public void loadEvents()
    {

    }

    public void loadCotisations()
    {
        System.out.println("here");
        ObservableList<Cotisation> cotisations = CotisationAccess.getAll();
        Label headerTitle = new Label("Les cotisations du club. Les avez-vous toutes payées?");
        headerTitle.setFont(Font.font("Calibri", 20));
        headerTitle.setTextFill(Color.web("#26302e", 0.8));

        if(container.getChildren().isEmpty())
        {
            container.getChildren().add(headerTitle);
            for(Cotisation cotisation: cotisations)
            {
                VBox pane = new VBox();
                pane.setSpacing(15);
                Label amountText = new Label("Somme à payer: ");
                Label descriptionText = new Label("Description: ");
                Label dateText = new Label("Date limite de paiement: ");
                amountText.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
                amountText.setTextFill(Color.web("#144c41", 0.8));
                dateText.setFont(Font.font("Calibri", FontWeight.BOLD,16));
                dateText.setTextFill(Color.web("#144c41", 0.8));
                descriptionText.setFont(Font.font("Calibri", FontWeight.BOLD,16));
                descriptionText.setTextFill(Color.web("#144c41", 0.8));

                Label amount = new Label(String.valueOf(cotisation.getAmount()));
                Label description = new Label(cotisation.getDescription());
                Label date = new Label(cotisation.getTimeLimit());
                HBox hBox = new HBox(10);
                hBox.getChildren().addAll(amountText, amount);
                pane.getChildren().add(hBox);
                hBox = new HBox(10);
                hBox.getChildren().addAll(descriptionText, description);
                pane.getChildren().add(hBox);
                hBox = new HBox(10);
                hBox.getChildren().addAll(dateText, date);
                pane.getChildren().addAll(hBox);

                pane.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);" +
                        "-fx-background-color: white;");
                pane.setMaxWidth(600);
                pane.setMinHeight(140);
                pane.setPadding(new Insets(20,20,20,20));
                container.getChildren().add(pane);

            }

            container.setSpacing(50);
            container.setPadding(new Insets( 60, 20, 20, 20));

        }


    }

}
