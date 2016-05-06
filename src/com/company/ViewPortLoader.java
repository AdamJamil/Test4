package com.company;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.HashMap;

public class ViewPortLoader implements Constants
{
    private short imagesLoaded = 0;
    private short mapsLoaded = 0;
    private HashMap<Short, Image> textures = new HashMap<>();
    private HashMap<Short, Image> mapTileSets = new HashMap<>();
    private HashMap<Short, Map> mapInformation = new HashMap<>();
    private GraphicsContext graphicsContext;
    private Player player;
    private Data data;

    public ViewPortLoader(GraphicsContext aGraphicsContext, Player aPlayer, Data someData)
    {
        graphicsContext = aGraphicsContext;                                                  //gets the gc that was loaded in Main, so that it can draw to it
        player = aPlayer;                                                                    //gets the player so that it can be drawn
        data = someData;                                                                     //gets more relevant information for drawing

        try                                                                                  //loads all images from Textures into the HashMap,
        {                                                                                    //and logs them based on the number assigned to their name
            for(imagesLoaded = 0; imagesLoaded >= 0; imagesLoaded++)
            {
                textures.put(imagesLoaded, new Image("Textures//" + Short.toString(imagesLoaded) + ".png"));
                System.out.println(textures.get(imagesLoaded).getHeight());
            }
        } catch(IllegalArgumentException e) {System.out.println("Successfully loaded " + (imagesLoaded) + " image(s)!");}

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
        graphicsContext.clearRect(0, 0, pixelWidth, pixelHeight);                            //clears screen
        Image img = null;

        try
        {
            //img = new Image("Textures//0.png");
        }
        catch (NullPointerException e) {e.printStackTrace();}
        graphicsContext.drawImage(img, 0, 0);
    }
}