package Maps;

import Model.Vector2d;

public class EarthMoveAllowed implements MoveAllowed{
    @Override
    public Vector2d newPosition(Vector2d oldPosition, Vector2d newPosition, Vector2d lowerLeft, Vector2d upperRight) {
        if (onRightSide(newPosition, lowerLeft, upperRight)) {
            newPosition = new Vector2d(lowerLeft.getX(), newPosition.getY());
        } else if (onLeftSide(newPosition, lowerLeft, upperRight)) {
            newPosition = new Vector2d(upperRight.getX() - 1, newPosition.getY());
        } else if (!canMoveTo(newPosition, lowerLeft, upperRight)) {
            newPosition = oldPosition;
        }
        return newPosition;
    }

    @Override
    public boolean canMoveTo(Vector2d position, Vector2d lowerLeft, Vector2d upperRight) {
        return position.getY() < upperRight.getY() && position.getY() >= lowerLeft.getY();
    }

    @Override
    public int lotsEnergy(Vector2d position, Vector2d lowerLeft, Vector2d upperRight, int EnergyNeededToReproduction) {
        return 1;
    }

    private boolean onRightSide(Vector2d position, Vector2d lowerLeft, Vector2d upperRight) {
        return canMoveTo(position, lowerLeft, upperRight) && position.getX() >= upperRight.getY();
    }

    private boolean onLeftSide(Vector2d position, Vector2d lowerLeft, Vector2d upperRight) {
        return canMoveTo(position, lowerLeft, upperRight) && position.getX() < lowerLeft.getX();
    }
}
