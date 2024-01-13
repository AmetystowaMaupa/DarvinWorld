package Maps;

import Model.Vector2d;

public interface MoveAllowed {
    Vector2d newPosition(Vector2d oldPosition, Vector2d newPosition, Vector2d lowerLeft, Vector2d upperRight);

    boolean canMoveTo(Vector2d position, Vector2d lowerLeft, Vector2d upperRight);

    int lotsEnergy(Vector2d position, Vector2d lowerLeft, Vector2d upperRight, int energyNeededForReproduction);
}
