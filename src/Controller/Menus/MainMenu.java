package Controller.Menus;


import Model.Player.Profile;
import com.gilecode.yagson.YaGson;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class MainMenu extends Menu implements Initializable {
    public Button exiit;
    public Button help;
    public Button start1;
    public Button start2;
    public Label username;
    public MenuItem quit;
    public MenuItem help2;
    public Button loginButton;

    public MainMenu() throws IOException {
        this.orders = new String[]{"Play", "Profiles", "Shop", "Help", "Exit"};
    }

    public void Exit() throws IOException {
        Menu.menuHandler.setCurrentMenu(Menu.loginMenu);
        ArrayList<Profile> accounts = Profile.getAccounts();
        String json = new YaGson().toJson(accounts);
        FileWriter writer = new FileWriter("Accounts\\accounts");
        writer.write(json);
        writer.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText("Dabbe");
        start1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Menu.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("PlayMenu.fxml"))));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        start2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Menu.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("PlayMenu.fxml"))));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        help.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("MainMenuHelp.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        help2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("MainMenuHelp.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("LoginMenu.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        quit.setOnAction(ActionsOfAnEvent -> exit());
        exiit.setOnAction(ActionsOfAnEvent -> exit());
    }
}

