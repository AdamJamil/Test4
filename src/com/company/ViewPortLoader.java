package com.company;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import java.util.HashMap;

public class ViewPortLoader implements Constants
{
    private short imagesLoaded = 0;
    private short mapsLoaded = 0;
    private HashMap<Short, Image> textures = new HashMap<>();
    private HashMap<Short, Image> mapTileSets = new HashMap<>();
    private HashMap<Short, Map> mapInformation = new HashMap<>();
    private Canvas canvas;
    private Player player;
    private Data data;

    public ViewPortLoader(Canvas aCanvas, Player aPlayer, Data someData)
    {
        canvas = aCanvas;                                                                    //gets the canvas that was loaded in Main, so that it can draw to it
        player = aPlayer;                                                                    //gets the player so that it can be drawn
        data = someData;                                                                     //gets more relevant information for drawing

        try                                                                                  //loads all images from Textures into the HashMap,
        {                                                                                    //and logs them based on the number assigned to their name
            for(imagesLoaded = 0; imagesLoaded >= 0; imagesLoaded++)
                textures.put(imagesLoaded, new Image("Textures//" + Short.toString(imagesLoaded) + ".png"));
        } catch(IllegalArgumentException e) {System.out.println("Successfully loaded " + (imagesLoaded ) + " image(s)!");}

        try                                                                                  //loads all maps, just like the images
        {
            for(mapsLoaded = 0; mapsLoaded >= 0; mapsLoaded++)
                mapTileSets.put(mapsLoaded, new Image("Maps//" + Short.toString(mapsLoaded) + ".png"));
        } catch(IllegalArgumentException e) {System.out.println("Successfully loaded " + (mapsLoaded) + " map(s)!");}
    }

    public void loadViewPort()
    {
        int cameraStartX, cameraStartY;                                                      //coordinate of the top-leftmost pixel drawn
        int relPlayerX, relPlayerY;                                                          //where the player appears relative to the camera
        canvas.getGraphicsContext2D().clearRect(0, 0, pixelWidth, pixelHeight);              //clears screen
        if (player.getX() <= )
    }
}
