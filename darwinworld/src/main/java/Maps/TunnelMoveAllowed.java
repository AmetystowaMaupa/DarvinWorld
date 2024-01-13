package Maps;

import Model.Vector2d;

public class TunnelMoveAllowed implements MoveAllowed{

    @Override
    public Vector2d newPosition(Vector2d oldPosition, Vector2d newPosition, Vector2d lowerLeft, Vector2d upperRight) {
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position, Vector2d lowerLeft, Vector2d upperRight) {
        return false;
    }

    @Override
    public int lotsEnergy(Vector2d position, Vector2d lowerLeft, Vector2d upperRight, int energyNeededForReproduction) {
        return 0;
    }
}
