package Maps;

import Model.Vector2d;
import Model.WorldElement;

public class BasicMap extends AbstractWorldMap{
    public BasicMap(int width, int height, MoveAllowed movementDetails, int reproductionEnergy) {
        super(width, height, movementDetails, reproductionEnergy);

        float midY = (height - 1) / (float) 2;

        preferredPositions.sort((o1, o2) -> Float.compare(Math.abs(o1.getY() - midY), Math.abs(o2.getY() - midY)));
        emptyPreferred = getPreferred();
        emptyNotPreferred = getNotPreferred();
    }


    @Override
    public void updatePreferredPositions() {
    }
}
