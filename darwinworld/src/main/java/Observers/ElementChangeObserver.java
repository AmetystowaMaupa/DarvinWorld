package Observers;

import Model.Vector2d;
import Model.WorldElement;

public interface ElementChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition, WorldElement object);

    void animalDies(WorldElement animal);
}
