package View;

import Controller.Menus.*;
import Model.Player.Player;
import Model.Player.Profile;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu.init();
        Profile profile;
        Player player;
        while (true) {
            String input = scanner.nextLine();
            if (Menu.menuHandler.getCurrentMenu() == Menu.loginMenu){
                if (input.equalsIgnoreCase("create account")){
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    Menu.profileMenu.create_account(username,password);
                }
                else if (input.equalsIgnoreCase("login")) {
                    String username = scanner.nextLine();
                    String password = scanner.nextLine();
                    profile = Menu.loginMenu.Login(username,password);
                }
                else if (input.equalsIgnoreCase("Leaderboard"))
            }
        }
    }
}
