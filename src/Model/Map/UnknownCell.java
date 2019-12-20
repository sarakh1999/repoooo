package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

public class UnknownCell extends Cell {

    @Override
    boolean canBePlanted(Plant plant) {
        return false;
    }

    @Override
    boolean canBeZombied(Zombie zombie) {
        return false;
    }

    @Override
    void removePlant() {

    }

    @Override
    public void plant(Plant plant) {

    }
}