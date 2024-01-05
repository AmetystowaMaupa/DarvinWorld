package Maps;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TunnelMap extends AbstractWorldMap{

    private final int height;
    private final int width;
    private final int numberOfTunnels;
    private Map<Vector2d, Tunnel> tunnels = new HashMap<>();
    public TunnelMap(int numberOfTunnels, int height, int width) {
        super();
        this.numberOfTunnels = numberOfTunnels;
        this.width = width;
        this.height = height;
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(height, width, numberOfTunnels);
        List<Vector2d> positions = new ArrayList<>();
        for(Vector2d pos: randomPositionGenerator){
            positions.add(pos);
        }
        for(int i=0;i<positions.size();i+=2){
            Tunnel tunnel = new Tunnel(positions.get(i),positions.get(i+1));
            tunnels.put(positions.get(i), tunnel);
            tunnels.put(positions.get(i + 1), tunnel);
        }
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || tunnels.containsKey(position);
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.containsKey(position))
            return animals.get(position);
        else
            return tunnels.get(position);
    }

}
