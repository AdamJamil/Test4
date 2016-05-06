package com.company;

import com.google.gson.Gson;
import java.awt.FontFormatException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class Main extends Application implements Constants
{
    public ViewPortLoader vpl;
    private Player player;
    private Data data = new Data();
    Image img = null;

    @Override
    public void start(Stage primaryStage)
    {
        Gson gson = new Gson();
        HashMap<Short, Image> textures = new HashMap<>();
        HashMap<Short, Map> maps = new HashMap<>();
        short imagesLoaded = 0, mapsLoaded = 0;

        primaryStage.setTitle("Test");                                                       //loads javafx setup
        Canvas canvas = new Canvas(pixelWidth, pixelHeight);                                 //this code is mostly irrelevant and only implements the
        StackPane root = new StackPane();                                                    //javafx canvas, root and scene.
        root.getChildren().add(canvas);                                                      //the screen size and listeners are also added in here
        Scene scene = new Scene(root, pixelWidth, pixelHeight);
        scene.setOnKeyPressed(this::onKeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);
        primaryStage.setScene(scene);
        primaryStage.show();

        try                                                                                  //loads all images from Textures into the HashMap,
        {                                                                                    //and logs them based on the number assigned to their name
            for(imagesLoaded = 0; imagesLoaded >= 0; imagesLoaded++)
            {
                textures.put(imagesLoaded, new Image("file:" + Short.toString(imagesLoaded) + ".png"));
                System.out.println(textures.get(imagesLoaded).getHeight());
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Successfully loaded " + (imagesLoaded) + " image(s)!");
        }

        try
        {
            for(mapsLoaded = 0; mapsLoaded >= 0; mapsLoaded++)
                maps.put(mapsLoaded, new Map(new Image("Maps//" + Short.toString(mapsLoaded) + ".png")));
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Successfully loaded " + (mapsLoaded) + " map(s)!");
        }

        vpl = new ViewPortLoader(canvas.getGraphicsContext2D(), player, data);               //gives the ViewPortLoader the relevant information to draw
                                                                                             //and the canvas, onto which it will draw

        KeyFrame frame = new KeyFrame(Duration.millis(4f), (event) -> vpl.loadViewPort());   //sets loop to 4ms delay, and calls the art loader
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(frame);
        timeline.play();

    }

    public void onKeyPressed(KeyEvent e)
    {

    }

    public void onKeyReleased(KeyEvent e)
    {

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
