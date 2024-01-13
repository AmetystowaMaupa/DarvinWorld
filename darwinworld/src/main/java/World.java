import UI.*;
import javafx.application.Application;

import java.io.File;


public class World {
    /*public static void main(String[] args) {
        File file = new File("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/config.csv");
        if (file.exists()) {
            System.out.println("Can Read: " + file.canRead());
            System.out.println("Can Write: " + file.canWrite());
            System.out.println("Can Execute: " + file.canExecute());
        } else {
            System.out.println("File does not exist.");
        }
    }*/
    public static void main(String[] args){
        Application.launch(App.class, args);
    }
}
