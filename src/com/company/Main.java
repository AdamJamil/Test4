package com.company;

import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

        vpl = new ViewPortLoader(canvas);                                                    //creates the ViewPortLoader objects and gives it the canvas so that
                                                                                             //it can draw to it
        KeyFrame frame = new KeyFrame(Duration.millis(4f), (event) ->                        //sets loop to 4ms delay
        {
            vpl.loadViewPort();
        });
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
