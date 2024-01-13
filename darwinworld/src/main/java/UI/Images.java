package UI;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Images {
    public Image grassImage;
    public Image Image1;
    public Image Image2;
    public Image Image3;
    public Image Image4;
    public Image Image5;
    public Image tunnelImage;

    public Images() {
        try {
            this.tunnelImage = new Image (new FileInputStream("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/tunel.png"));
            this.grassImage = new Image(new FileInputStream("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/trawa.png"));
            this.Image1 = new Image(new FileInputStream("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/pig.png"));
            this.Image2 = new Image(new FileInputStream("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/malpa.png"));
            this.Image3 = new Image(new FileInputStream("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/pies.png"));
            this.Image4 = new Image(new FileInputStream("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/tygrys.png"));
            this.Image5 = new Image(new FileInputStream("C:/Users/Piotr/Desktop/study/DarvinWorld/darwinworld/src/main/resources/kot.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
