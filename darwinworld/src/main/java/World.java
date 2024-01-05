import Maps.*;
import Model.*;
import UI.*;
import javafx.application.Application;


public class World {
    public static void main(String[] args){
        Directions dir = Directions.N;
        System.out.println(dir);
        System.out.println(dir.dirToVector());
        dir = dir.rotation(1);
        System.out.println(dir);
        dir = dir.rotation(3);
        System.out.println(dir);
        Application.launch(SimulationApp.class, args);
    }
}
