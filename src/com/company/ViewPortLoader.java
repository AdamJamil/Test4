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
    private HashMap<Short, Image> textures;

    public ViewPortLoader(GraphicsContext aGraphicsContext, Data someData)
    {
        graphicsContext = aGraphicsContext;                                                  //gets the gc that was loaded in Main, so that it can draw to it
        data = someData;                                                                     //gets more relevant information for drawing
        player = data.getPlayer();
        textures = data.getTextures();
    }

    public void loadViewPort()
    {
        int cameraStartX, cameraStartY;                                                      //coordinate of the top-leftmost pixel drawn
        int relPlayerX, relPlayerY;                                                          //where the player appears relative to the camera
        int relPlayerShiftX, relPlayerShiftY;
        Map currentMap = data.getCurrentMap();

        //clears screen
        graphicsContext.clearRect(0, 0, pixelWidth, pixelHeight);

        //x component of camera clipping
        if (player.getX() <= (width / 2) * tileSize)                                         //clips camera to left map bound
        {
            cameraStartX = 0;
            relPlayerX = player.getX();
            relPlayerShiftX = 0;
        }
        else if (player.getX() >= (currentMap.getMapWidth() - (1 + width / 2)) * tileSize)   //or clips camera to right map bound
        {
            cameraStartX = (currentMap.getMapWidth() - width) * tileSize;
            relPlayerX = player.getX() - cameraStartX;
            relPlayerShiftX = 0;
        }
        else                                                                                 //or simply sets camera x to player x
        {
            cameraStartX = player.getX() - (width / 2) * tileSize;
            relPlayerX = (width / 2) * tileSize;
            relPlayerShiftX = player.getX() % tileSize;
        }

        //y component of camera clipping
        if (player.getY() <= (height / 2) * tileSize)                                        //clips camera to top map bound
        {
            cameraStartY = 0;
            relPlayerY = player.getY();
            relPlayerShiftY = 0;
        }
        else if (player.getY() >= (currentMap.getMapHeight() - (1 + height / 2)) * tileSize) //or clips camera to bottom map bound
        {
            cameraStartY = (currentMap.getMapHeight() - height) * tileSize;
            relPlayerY = player.getY() - cameraStartY;
            relPlayerShiftY = 0;
        }
        else                                                                                 //or simply sets camera y to player y
        {
            cameraStartY = player.getY() - (height / 2) * tileSize;
            relPlayerY = (height / 2) * tileSize;
            relPlayerShiftY = player.getY() % tileSize;
        }

        for(int i = cameraStartX / tileSize; i < (cameraStartX / tileSize) + width; i++)
        {
            for(int j = cameraStartY / tileSize; j < (cameraStartX / tileSize) + width; j++)
            {
                graphicsContext.drawImage(textures.get(currentMap.getImageMap()[i][j]), ((i - cameraStartX / tileSize) * tileSize) - relPlayerShiftX, ((j - cameraStartY / tileSize) * tileSize) - relPlayerShiftY);
            }
        }

        graphicsContext.drawImage(player.getSprite(), relPlayerX, relPlayerY);
    }
}