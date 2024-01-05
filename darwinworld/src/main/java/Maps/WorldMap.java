package Maps;

import Model.Animal;
import Model.Directions;
import Model.Vector2d;
import Model.WorldElement;


/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap extends MoveValidator {

    /**
     * Place a animal on the map.
     *
     * @param animal The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the move is not valid.
     */
    void place(Animal animal);

    /**
     * Moves an animal (if it is present on the map) according to specified direction.
     * If the move is not possible, this method has no effect.
     */
    void move(Animal animal, Directions direction) ;

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an element at a given position.
     *
     * @param posiotion The position of the element.
     * @return element or null if the position is not occupied.
     */
    WorldElement objectAt(Vector2d posiotion);
    //Collection<WorldElement> getElements();
    //abstract Boundary getCurrentBounds();
    String toString();
    //void addObserver(MapChangeListener observer);
    //void removeObserver(MapChangeListener observer);
    //void mapChanged(String message);

}
