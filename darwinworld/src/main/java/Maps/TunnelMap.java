package Maps;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TunnelMap extends AbstractWorldMap{

    private Map<Vector2d, Tunnel> tunnels = new HashMap<>();

    public TunnelMap(int numberOfTunnels, int width, int height, MoveAllowed movementDetails, int reproductionEnergy) {
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
