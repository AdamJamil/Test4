package com.company;

import com.google.gson.Gson;
import java.io.*;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application implements Constants
{
    private ViewPortLoader vpl;
    private Data data = new Data();
    private InputHandler inputHandler = new InputHandler();

    @Override
    public void start(Stage primaryStage)
    {
        Gson gson = new Gson();
        short mapsToLoad = 1, imagesToLoad = 1;
        short imagesLoaded, mapsLoaded;

        //loads javafx setup
        //this code is mostly irrelevant and only implements the
        //javafx canvas, root and scene.
        //the screen size and listeners are also added in here
        primaryStage.setTitle("Test");
        Canvas canvas = new Canvas(pixelWidth, pixelHeight);
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, pixelWidth, pixelHeight);
        scene.setOnKeyPressed(this::onKeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);
        primaryStage.setScene(scene);
        primaryStage.show();

        //loads all images from Textures into the HashMap,
        //and logs them based on the number assigned to their name
        try
        {
            for(imagesLoaded = 0; imagesLoaded < imagesToLoad; imagesLoaded++)
            {
                InputStream inputStream = new FileInputStream(new File("./res/Textures/" + Short.toString(imagesLoaded) + ".png"));
                data.getTextures().put(imagesLoaded, new Image(inputStream));
            }
        }
        catch(IllegalArgumentException|FileNotFoundException e)
        {
            e.printStackTrace();
        }

        //this block of code (below) takes the string from the file 'maps//0.txt', etc. and converts from json format into a map information object
        //it is then put into the hashmap with the key of a number, and that number is the same as the file location name
        //since the Image class cannot be loaded through a JSON, it is loaded separately (the image is also marked as transient, to dodge serialization)
        try
        {
            for(mapsLoaded = 0; mapsLoaded < mapsToLoad; mapsLoaded++)
            {
                Map temp = gson.fromJson(new Scanner(new File("./res/Maps/0.txt")).useDelimiter("\\Z").next(), Map.class);
                InputStream inputStream = new FileInputStream(new File("./res/Maps/" + Short.toString(mapsLoaded) + ".png"));
                temp.setImageSource(new Image(inputStream));
                data.getMaps().put(mapsLoaded, temp);
            }
        }
        catch(IllegalArgumentException|FileNotFoundException e)
        {
            e.printStackTrace();
        }

        //gives the ViewPortLoader the relevant information with which to draw
        vpl = new ViewPortLoader(canvas.getGraphicsContext2D(), data);

        //sets loop to 4ms delay, and calls the art loader
        KeyFrame frame = new KeyFrame(Duration.millis(4f), (event) ->
        {
            vpl.loadViewPort();
            KeyCode action = inputHandler.getAction();
            System.out.println(action);
            if (action == KeyCode.S)
                data.getPlayer().incrementY(1);
        });

        //this just puts the timeline (or main game logic) in motion
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(frame);
        timeline.play();

    }

    public void onKeyPressed(KeyEvent e)
    {
        inputHandler.keyPressed(e);
    }

    public void onKeyReleased(KeyEvent e)
    {
        inputHandler.keyReleased(e);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
