package com.company;

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
    private Canvas canvas;
    private Player player;
    private Data data;

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Test");                                                       //loads javafx setup
        canvas = new Canvas(pixelWidth, pixelHeight);                                        //this code is mostly irrelevant and only implements the
        StackPane root = new StackPane();                                                    //javafx canvas, root and scene.
        root.getChildren().add(canvas);                                                      //the screen size and listeners are also added in here
        Scene scene = new Scene(root, pixelWidth, pixelHeight);
        scene.setOnKeyPressed(this::onKeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);
        primaryStage.setScene(scene);
        primaryStage.show();

        vpl = new ViewPortLoader(canvas, player, data);                                      //gives the ViewPortLoader the relevant information to draw
                                                                                             //and the canvas, onto which it will draw
        KeyFrame frame = new KeyFrame(Duration.millis(4f), (event) -> vpl.loadViewPort());   //sets loop to 4ms delay, and calls the art loader
    }

    public void onKeyPressed(KeyEvent e)
    {

    }

    public void onKeyReleased(KeyEvent e)
    {

    }

    public void save(Serializable data, String fileName)                                     //kenny's methods for save/load
    {                                                                                        //get kenny to comment this!
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName))))
        {
            objectOutputStream.writeObject(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Data load(String fileName) throws Exception
    {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName))))
        {
            return (Data)objectInputStream.readObject();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
