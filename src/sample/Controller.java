package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    Button toEnlarge,repaint;
    @FXML
    TextField filesrc;
    BufferedImage img;
    void load()
    {
        try {
            img = ImageIO.read(new File(filesrc.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize()
    {
        toEnlarge.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                load();
                img = Main.toEnlarge(img);
                try {
                    ImageIO.write(img,"png",new File("upscale.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        repaint.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                load();
                img = Main.replace(img);
                try {
                    ImageIO.write(img,"png",new File("red.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
