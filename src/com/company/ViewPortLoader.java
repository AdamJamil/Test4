package com.company;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.HashMap;

public class ViewPortLoader implements Constants
{
    private GraphicsContext graphicsContext;
    private Player player;
    private Data data;
    private HashMap<Short, Image> textures = new HashMap<>();
    private HashMap<Short, Map> maps = new HashMap<>();

    public ViewPortLoader(GraphicsContext aGraphicsContext, Data someData)
    {
        graphicsContext = aGraphicsContext;                                                  //gets the gc that was loaded in Main, so that it can draw to it
        data = someData;                                                                     //gets more relevant information for drawing
        player = data.getPlayer();
        textures = data.getTextures();
        maps = data.getMaps();
    }

    public void loadViewPort()
    {
        int cameraStartX, cameraStartY;                                                      //coordinate of the top-leftmost pixel drawn
        int relPlayerX, relPlayerY;                                                          //where the player appears relative to the camera
        Map currentMap = maps.get(data.getCurrentMap());

        //clears screen
        graphicsContext.clearRect(0, 0, pixelWidth, pixelHeight);

        //x component of camera clipping
        if (player.getX() <= (width / 2) * tileSize)                                         //clips camera to left map bound
        {
            cameraStartX = 0;
            relPlayerX = player.getX();
        }
        else if (player.getX() >= (currentMap.getMapWidth() - (width / 2)) * tileSize)       //or clips camera to right map bound
        {
            cameraStartX = (currentMap.getMapWidth() - width) * tileSize;
            relPlayerX = player.getX() - cameraStartX;
        }                                                                                    //or simply sets camera x to player x
        else
        {
            cameraStartX = player.getX() - (width / 2) * tileSize;
        }

        //y component of camera clipping
        if (player.getY() <= (height / 2) * tileSize)                                         //clips camera to top map bound
        {
            cameraStartY = 0;
            relPlayerY = player.getY();
        }

        if (player.getY() >= (currentMap.getMapHeight() - (height / 2)) * tileSize)          //or clips camera to bottom map bound
        {
            cameraStartY = (currentMap.getMapHeight() - height) * tileSize;
            relPlayerY = player.getY() - cameraStartY;
        }                                                                                    //or simply sets camera y to player y
        else
        {
            cameraStartY = player.getY() - (height / 2) * tileSize;
        }


    }
}