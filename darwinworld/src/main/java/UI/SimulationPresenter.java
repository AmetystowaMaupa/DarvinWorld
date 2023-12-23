package UI;

import Maps.BasicMap;
import Maps.MapVisualizer;
import Maps.WorldMap;
import Model.Vector2d;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class SimulationPresenter{
    @FXML
    private Label infoLabel;
    @FXML
    private GridPane mapGrid;
    private WorldMap map;

    public void setWorldMap(WorldMap map) {
        this.map = map;
    }

    public void drawMap(WorldMap map){
        map = new BasicMap(10,10);
        Label label = new Label(new MapVisualizer(map).draw(new Vector2d(0,0), new Vector2d(10,10)));
        mapGrid.add(label, 0,0);
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void handleStartButton() {
        drawMap(map);
    }
}
