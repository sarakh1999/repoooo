package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GameMode {
    //players that it is 0 (gardener) or 1 (zombie) are set in the menu

    private int waveCounter = 0;
    private boolean canWave = true;
    private ArrayList<Zombie> waveZombies = new ArrayList<>();
    protected boolean landMower[] = new boolean[6];
    public int lastTurnWaved = 0;
    public Player player1 = new Player();
    public Player player2 = new Player();
    private Battle battle = new Battle(player1, player2, this);

    public abstract void wave(Battle battle) throws IOException;

    public abstract boolean canWave(Battle battle);

    public abstract boolean handleWin(Profile profile, Battle battle);

    public abstract void updateCollection(Battle battle) throws IOException;

    public abstract void generateSun(Battle battle);

    public abstract ArrayList<Card> getAvailableCards();

    public Map generateMap() {
        if (this instanceof Day)
            return this.generateLandMap();
        else
            return this.generateWaterMap();
    }

    public ArrayList<Zombie> getWaveZombies() {
        return waveZombies;
    }

    public int getWaveCounter() {
        return waveCounter;
    }

    public void setWaveCounter(int waveCounter) {
        this.waveCounter += waveCounter;
    }

    public boolean CanWave() {
        return canWave;
    }

    public boolean checkState() {
        return false;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        battle = battle;
    }

    //chamanzan
    public boolean landMower(int i) {
        if (landMower[i]) {
            landMower[i] = false;
            for (int k = 0; k < battle.getMap().cells[i].length; k++) {
                //todo
                //maybe lead to error
                battle.getMap().cells[i][k].getZombies().clear();
            }
            return true;
        }
        return false;
    }

    public boolean zombieReachedToTheEnd(Battle battle) {
        System.err.println("IN zombieReachedToTheEnd");
        for (int i = 0; i < Map.getHEIGHT(); i++) {
            if (battle.getMap().getCell(i, 1).getZombies().size() != 0) {
                System.err.println("finish  size    " + battle.getMap().getCell(i, 1).getZombies().size());
                if (!landMower[i])
                    return true;
            }
        }
        System.err.println("continue");
        return false;
    }

    public boolean allZombiesAreDead(Profile profile, Battle battle) {
        System.err.println("IN allZombiesAreDead");
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                if (!j.getZombies().isEmpty()) {
                    System.err.println("continue  size    " +j.getZombies().size());
                    return false;
                }
            }
        }
        System.err.println("finish");
        return true;
    }

    public Map generateLandMap() {
        Map m = new Map();
        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        return m;
    }

    public Map generateWaterMap() {
        Map m = new Map();
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setCell(i, j, new Cell(i, j, true));
            }
        }
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        return m;
    }


    public void generateZombies(Battle battle) throws IOException {
        int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
        boolean zombieIsMade = false;
        Zombie zombie = null;
        while (!zombieIsMade) {
            int zombieNumber = (int) (Math.random() * (12 + 1));
            zombie = Zombie.makeZombie(Zombie.getZombies().get(zombieNumber).getName());
            if (zombie.getName().equalsIgnoreCase("SnorkelZombie") ||
                    zombie.getName().equalsIgnoreCase("DolphinRiderZombie")) {
                zombieIsMade = false;
            } else {
                zombieIsMade = true;
            }
        }
        zombie.setCell(battle.getMap().getCell(randomPlace, 21));
        battle.getMap().getCell(randomPlace, 21).addZombie(zombie);
    }


    public void setLastTurnWaved(int lastTurnWaved) {
        this.lastTurnWaved += lastTurnWaved;
    }

    public int removeDeadZombies(Battle battle) {
        ArrayList<Zombie> zombiesToBeDeleted = new ArrayList<>();
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                for (Zombie z : j.getZombies()) {
                    if (z.getHP() == 0) {
                        zombiesToBeDeleted.add(z);
                    }
                }
            }
        }

        for (int k = 0; k < zombiesToBeDeleted.size(); k++) {
            int x = zombiesToBeDeleted.get(k).getCell().x();
            int y = zombiesToBeDeleted.get(k).getCell().y();
            battle.getMap().getCell(x, y).getZombies().remove(zombiesToBeDeleted.get(k));
        }
        return zombiesToBeDeleted.size();
    }

    public int removeDeadPlants(Battle battle) {
        System.out.println("update coleectionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        ArrayList<Plant> plantsToBeDeleted = new ArrayList<>();
//        for (Cell[] i : battle.getMap().getCells()) {
//            for (Cell j : i) {
//                if (j.getPlant()!=null && j.getPlant().getHP() == 0) {
//                    plantsToBeDeleted.add(j.getPlant());
//                }
//            }
//        }
//        for (int k = 0; k < plantsToBeDeleted.size(); k++) {
//            int x = plantsToBeDeleted.get(k).getCell().x();
//            int y = plantsToBeDeleted.get(k).getCell().y();
//            battle.getMap().getCell(x, y).setPlant(null);
//            System.out.println("size    "+battle.getMap().getCell(x,y).getZombies().size());
//        }
        System.out.println("finitoooooooooooooooooooooooooooooooooooooooooooooooooo");
        return plantsToBeDeleted.size();
    }

}
