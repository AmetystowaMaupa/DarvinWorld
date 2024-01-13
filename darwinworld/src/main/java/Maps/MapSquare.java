package Maps;

import Model.WorldElement;

import java.util.ArrayList;
import java.util.List;

public class MapSquare {
    private final ArrayList<WorldElement> objects;
    private boolean grass;
    private int deathCounter;

    public MapSquare() {
        this.grass = false;

        this.objects = new ArrayList<>();
        this.deathCounter = 0;
    }
    public boolean didGrassGrow() {
        return grass;
    }
    public void growGrass() {
        grass = true;
    }
    public void eatGrass() {
        grass = false;
    }

    private void increaseDeathCounter() {
        deathCounter += 1;
    }

    public int getDeathCounter() {
        return deathCounter;
    }

    public List<WorldElement> getObjects() {
        return objects;
    }

    public void removeObject(WorldElement object) {
        objects.remove(object);
    }

    public void placeObject(WorldElement object) {
        objects.add(object);
    }

    public void animalDie(WorldElement animal) {
        removeObject(animal);
        increaseDeathCounter();
    }
}
