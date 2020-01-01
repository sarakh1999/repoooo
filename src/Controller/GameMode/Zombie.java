package Controller.GameMode;

import Model.Card.Plants.Plant;
import Model.Map.LandCell;
import Model.Map.Map;
import Model.Map.WaterCell;
import Model.Player.Profile;

import java.util.ArrayList;

public class Zombie extends GameMode {
    @Override
    public void wave() {

        int size = 0;
        ArrayList<Plant> randomPlants = new ArrayList<>();
        randomPlants.add(Plant.findPlant("Explode-o-nut"));
        randomPlants.add(Plant.findPlant("Explode-o-nut"));
        randomPlants.add(Plant.findPlant("Explode-o-nut"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("SnowPea"));
        randomPlants.add(Plant.findPlant("SnowPea"));
        randomPlants.add(Plant.findPlant("Cabbage-pult"));
        randomPlants.add(Plant.findPlant("Cabbage-pult"));
        randomPlants.add(Plant.findPlant("GatlingPea"));
        randomPlants.add(Plant.findPlant("PotatoMine"));

        if (getBattle().getMap().getCell(0, 2) instanceof LandCell) {
            randomPlants.add(Plant.findPlant("PotatoMine"));
            randomPlants.add(Plant.findPlant("PotatoMine"));
            size = randomPlants.size();
        }

        if (getBattle().getMap().getCell(0, 2) instanceof WaterCell) {
            randomPlants.add(Plant.findPlant("TangleKelp"));
            randomPlants.add(Plant.findPlant("TangleKelp"));
            randomPlants.add(Plant.findPlant("Cattail"));
            randomPlants.add(Plant.findPlant("LilyPad"));
            randomPlants.add(Plant.findPlant("LilyPad"));
            randomPlants.add(Plant.findPlant("LilyPad"));
            size = randomPlants.size();
        }

        int randomNumberOfPlants = (int) (Math.random() * ((size) + 1)) + size;

    }

    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
        return false;
    }

    @Override
    public void updateCollection() {

    }

    @Override
    public void getAvailableCards() {

    }

    @Override
    public void generateSun(Battle battle) {

    }

    @Override
    public Map generateMap() {
        //todo
        //zamin mitune land ya water bashe
        Map m = new Map();
        for (int i = 0; i < Map.getHEIGHT(); i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setUnknownCell(i, j, new LandCell());
            }
        }
        getBattle().setMap(m);
        return m;
    }
}
