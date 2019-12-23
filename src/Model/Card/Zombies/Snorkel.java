package Model.Card.Zombies;

import Model.Card.Plants.PeaOrProjectile;
import Model.Map.Cell;

public class Snorkel extends Zombie {

    private int armour;

    public Snorkel(String name, int AP, int HP, Cell cell, int health, int speed, int armour, boolean pea) {
        super(name, AP, HP, cell, health, speed, armour, pea);
    }
}
