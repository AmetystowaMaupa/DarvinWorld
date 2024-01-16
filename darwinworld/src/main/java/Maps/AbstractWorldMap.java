package Maps;


import Model.*;
import Observers.ElementChangeObserver;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap, ElementChangeObserver, MoveValidator {
    protected final Map<Vector2d, MapSquare> elements;
    private int animalsNumber;
    private int grassNumber;
    private int animalsDead = 0;
    private int lifeOfDeadAnimal = 0;
    protected final int mapSize;
    private final Vector2d lowerLeft;
    protected final Vector2d upperRight;
    private final int reproductionEnergy;
    protected final List<Vector2d> preferredPositions = new ArrayList<>();
    protected List<Vector2d> emptyPreferred;
    protected List<Vector2d> emptyNotPreferred;
    protected final ArrayList<Animal> animalsList = new ArrayList<>();

    protected AbstractWorldMap(int width, int height, int reproductionEnergy) {
        elements = new HashMap<>();
        this.reproductionEnergy = reproductionEnergy;
        mapSize = width * height;
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(width, height);
        animalsNumber = 0;
        grassNumber = 0;

        initMap(width, height);

    }
    @Override
    public abstract boolean moveValidator(Vector2d destination);

    private void initMap(int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Vector2d position = new Vector2d(i, j);
                MapSquare square = new MapSquare();
                elements.put(position, square);
                preferredPositions.add(position);
            }
        }
    }


    @Override
    public void moveAnimals(){
        for (Animal animal : animalsList){
            MoveTuple posChange = animal.move(this::moveValidator);
            int newX = posChange.getNewPosition().getX() >= 0 ? posChange.getNewPosition().getX() % upperRight.getX() : upperRight.getX() + (posChange.getNewPosition().getX() % upperRight.getX());
            int oldX = posChange.getOldPosition().getX() >= 0 ? posChange.getOldPosition().getX() % upperRight.getX() : upperRight.getX() + (posChange.getOldPosition().getX() % upperRight.getX());
            Vector2d newCords = new Vector2d(newX,posChange.getNewPosition().getY());
            Vector2d oldCords = new Vector2d(oldX,posChange.getOldPosition().getY());
            posChange.setNewPosition(newCords);
            posChange.setOldPosition(oldCords);
            positionChanged(posChange.oldPosition,posChange.newPosition,animal);
        }
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition, Animal object) {
        if (elements.containsKey(oldPosition) && elements.containsKey(newPosition)) {
            elements.get(oldPosition).removeObject(object);
            elements.get(newPosition).placeObject(object);
        }
    }

    public abstract void updatePreferredPositions();

    public List<Vector2d> getPreferred() {
        return new LinkedList<>(preferredPositions.subList(0, (int) Math.round(0.2 * mapSize)));
    }

    protected List<Vector2d> getNotPreferred() {
        return new LinkedList<>(preferredPositions.subList((int) Math.round(0.2 * mapSize), preferredPositions.size()));
    }

    protected boolean isEmptySquares() {
        return !emptyPreferred.isEmpty() || !emptyNotPreferred.isEmpty();
    }

    protected Vector2d drawPosition() {
        Random random = new Random();
        Vector2d position;

        if (emptyPreferred.isEmpty()) {
            position = emptyNotPreferred.get(random.nextInt(emptyNotPreferred.size()));
            emptyNotPreferred.remove(position);
            return position;
        }
        if (emptyNotPreferred.isEmpty()) {
            position = emptyPreferred.get(random.nextInt(emptyPreferred.size()));
            emptyPreferred.remove(position);
            return position;
        }

        int preference = random.nextInt(100);
        if (preference >= 20) {
            position = emptyPreferred.get(random.nextInt(emptyPreferred.size()));
            emptyPreferred.remove(position);
        } else {
            position = emptyNotPreferred.get(random.nextInt(emptyNotPreferred.size()));
            emptyNotPreferred.remove(position);
        }
        return position;
    }

    @Override
    public void animalDies(WorldElement animal) {
        Vector2d position = animal.getPosition();
        if (elements.get(position).getObjects().contains(animal)) {
            MapSquare square = elements.get(position);
            square.animalDie(animal);
            animalsList.remove((Animal) animal);
            animalsNumber -= 1;
            this.setAnimalsDead();
            this.setLifeOfDeadAnimal((Animal) animal);
        }
    }

    public boolean inMap(Vector2d position) {
        return position.precedes(upperRight) && position.follows(lowerLeft);
    }


    @Override
    public void place(Animal object) {
        Vector2d position = object.getPosition();
        if (inMap(position)) {
            elements.get(position).placeObject(object);
            animalsNumber += 1;
            animalsList.add(object);
            object.setObserver(this);
            System.out.println(elements.get(position).toString() + " " + position.toString());
        }
    }

    private void addGrass(Vector2d position) {
        MapSquare square = elements.get(position);
        square.growGrass();
        grassNumber += 1;
    }


    public int getAnimalsNumber() {
        return animalsNumber;
    }

    public int getGrassNumber() {
        return grassNumber;
    }

    private void deleteGrass(Vector2d position) {
        elements.get(position).eatGrass();
        grassNumber -= 1;

        if (getPreferred().contains(position)) {
            emptyPreferred.add(position);
        } else {
            emptyNotPreferred.add(position);
        }
    }

    private boolean isGrass(Vector2d position) {
        return elements.get(position).didGrassGrow();
    }

    //private boolean isTunnel(Vector2d position) {return elements.get(position).}

    public void eatGrass(Vector2d position) {
        if (isGrass(position)) {
            deleteGrass(position);
        }
    }

    public void growGrass(int grassPerDay) {
        for (int i = 0; i < grassPerDay; i++) {
            if (isEmptySquares()) {
                Vector2d position = drawPosition();
                addGrass(position);
            }
        }
    }

    public Map<Vector2d, MapSquare> getElements() {
        return elements;
    }

    public String toString() {
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    public int getAnimalsDead() {
        return animalsDead;
    }

    private void setAnimalsDead() {
        this.animalsDead = this.animalsDead + 1;
    }

    public int getLifeOfDeadAnimal() {
        return lifeOfDeadAnimal;
    }

    public void setLifeOfDeadAnimal(Animal animal) {
        //this.lifeOfDeadAnimal = this.lifeOfDeadAnimal + animal.getLifeLength();
    }
}
