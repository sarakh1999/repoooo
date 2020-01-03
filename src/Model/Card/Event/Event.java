package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Map.Map;
import java.util.ArrayList;

public class Event {
    private static ArrayList<Event> events=new ArrayList<>();

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static void addToEvents(Event event) {
        events.add(event);
    }

    public boolean check(Plant plant, Battle battle, int d) {
        return false;
    }

}