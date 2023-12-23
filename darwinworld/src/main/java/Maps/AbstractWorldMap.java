package Maps;


import Model.Vector2d;
import Model.WorldElement;

public abstract class AbstractWorldMap implements WorldMap {


    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public WorldElement objectAt(Vector2d posiotion) {
        return null;
    }



}
