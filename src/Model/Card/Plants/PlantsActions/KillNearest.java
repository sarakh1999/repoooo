package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.Cell;

public class KillNearest extends Action {
    public double calculateDistance(Cell p, Cell z) {
        return Math.sqrt(((p.x - z.x) * (p.x - z.x)) + ((p.y - z.y) * (p.y - z.y)));
    }

    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        double MinRad = 100;
        int X = 0;
        int Y = 19;
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell cell : i) {
                if (cell.getZombies().size() > 0) {
                    if (calculateDistance(plant.getCell(), cell) < MinRad) {
                        X = cell.x;
                        Y = cell.y;
                        MinRad = calculateDistance(plant.getCell(), cell);
                    }
                }
            }
        }
        //todo
        battle.getMap().getCell(plant.getCell().x, plant.getCell().y).getZombies().remove(battle.getMap().getCell(X, Y));
        battle.getMap().getCell(X, Y).getZombies().set(0, null);
    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {

    }

}
