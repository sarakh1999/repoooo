package Controller.Menus;

import Controller.GameMode.*;
import Model.Player.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayMenu extends Menu implements Initializable {

    public Button dayM;
    public Button zombieM;
    public Button backButton;
    public Button waterM;
    public Button pVp;
    public Button railM;

public void setStyle(){
    dayM.setStyle("");
}


    public PlayMenu() throws IOException {
        this.orders = new String[]{"Day", "Water", "Rail", "ZombieGameMode", "PvP"};
    }

    public void startDayGame(Player player1, Player player2) {
        Day day = new Day();
        Battle battle = new Battle(player1, player2, day);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startWaterGame(Player player1, Player player2) {
        Water water = new Water();
        Battle battle = new Battle(player1, player2, water);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startRailGame(Player player1, Player player2) {
        Rail rail = new Rail();
        Battle battle = new Battle(player1, player2, rail);
        Menu.menuHandler.setCurrentMenu(Menu.railMenu);
        Menu.railMenu.player1 = player1;
        Menu.railMenu.player2 = player2;
        Menu.railMenu.rail = rail;
        Menu.railMenu.battle = battle;
    }

    public void startZombieGame(Player player1, Player player2) {
        ZombieGameMode zombieGameMode = new ZombieGameMode();
        Battle battle = new Battle(player1, player2, zombieGameMode);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void jhajCJUK() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        dayM.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("CollectionMenu.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //todo
    }
}
