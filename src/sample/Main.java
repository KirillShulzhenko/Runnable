package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    static BufferedImage replace(BufferedImage source)
    {
        BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                if(source.getRGB(x,y) == -1446160)
                {
                    result.setRGB(x, y, Color.RED.getRGB());
                }
                else
                {
                    result.setRGB(x, y, source.getRGB(x,y));
                }
            }
        }
        return result;

    }
    static BufferedImage toEnlarge(BufferedImage source)
    {


        AffineTransform tx = new AffineTransform();
        tx.setTransform(2.0,0.0,0.0,2.0,0,0);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BICUBIC);

        File output = new File("rr.png");
        BufferedImage newImage = null;
        return op.filter(source, newImage);

    }
}
