package Maps;


import Model.Animal;
import Model.Directions;
import Model.Vector2d;
import Model.WorldElement;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {

    protected final Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public void place(Animal animal) {
        return ;

    }

    @Override
    public void move(Animal animal, Directions direction) {
        return;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }



}
