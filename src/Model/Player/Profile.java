package Model.Player;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import com.gilecode.yagson.YaGson;

import java.util.ArrayList;

public class Profile {
    private ArrayList<Zombie> purchasedZombies = new ArrayList<Zombie>();
    private ArrayList<Plant> purchasedPlants = new ArrayList<>();
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    private String username;
    private String password;
    private int score;
    private int externalCoins;

    public Profile(String username, String password) {
        this.password = password;
        this.username = username;

        purchasedPlants.add(Plant.findPlant("PeaShooter"));
        purchasedPlants.add(Plant.findPlant("SnowPea"));
        purchasedPlants.add(Plant.findPlant("Explode-o-nut"));
        purchasedPlants.add(Plant.findPlant("Scaredy-shroom"));
        purchasedPlants.add(Plant.findPlant("Kernel-pult"));
        purchasedPlants.add(Plant.findPlant("SunFlower"));
        purchasedPlants.add(Plant.findPlant("CherryBomb"));

        purchasedZombies.add(Zombie.findZombie("ZombieGameMode"));
        purchasedZombies.add(Zombie.findZombie("Zomboni"));
        purchasedZombies.add(Zombie.findZombie("ScreenDoorZombie"));
        purchasedZombies.add(Zombie.findZombie("FootballZombie"));
        purchasedZombies.add(Zombie.findZombie("ConeheadZombie"));
        purchasedZombies.add(Zombie.findZombie("BalloonZombie"));
        purchasedZombies.add(Zombie.findZombie("BungeeZombie"));

    }

    public static Profile makeProfile(Profile profile) {
        YaGson yaGson = new YaGson();
        String s = profile.toString();
        Profile profile1 = yaGson.fromJson(s, Profile.class);
        profiles.add(profile1);
        return profile1;
    }

    public String getUsername() {
        return username;
    }

    public void change_username(String username) {
        this.username = username;
    }

    public void change_Password(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void delete_account(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password))
            profiles.remove(this);
    }

    public static Profile login(String username, String password) {
        for (Profile p : profiles) {
            if (p.password.equals(password) && p.username.equals(username))
                return p;
        }
        return null;
    }

    public static ArrayList<Profile> getAccounts() {
        return profiles;
    }

    public static void addAccount(Profile profile) {
        profiles.add(profile);
    }

    public ArrayList<Zombie> getPurchasedZombies() {
        return purchasedZombies;
    }

    public ArrayList<Plant> getPurchasedPlants() {
        return purchasedPlants;
    }

    public void addZombie(Zombie zombie) {
        this.purchasedZombies.add(zombie);
    }

    public static void setProfiles(ArrayList<Profile> profiles) {
        Profile.profiles = profiles;
    }

    public int getExternalCoins() {
        return externalCoins;
    }

    public void addPlant(Plant plant) {
        this.purchasedPlants.add(plant);
    }

    public void setExternalCoins(int externalCoins) {
        this.externalCoins += externalCoins;
    }

    public static boolean validUsername(String username) {
        for (Profile x : profiles)
            if (x.getUsername().equals(username))
                return false;
        return true;
    }

}