package com.company;

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
        int relPlayerShiftX, relPlayerShiftY;                                                //how much to shift the tiles with respect to the camera
        Map currentMap = data.getCurrentMap();

        //clears screen
        graphicsContext.clearRect(0, 0, pixelWidth, pixelHeight);

        //x component of camera clipping
        if (player.getX() <= (width / 2) * tileSize)                                         //checks if the camera can't move off to the left side anymore
        {                                                                                    //this clips the camera to the left bound (0)
            cameraStartX = 0;                                                                //the camera's 0 is now the same as the map's 0, so the playerx is the same
            relPlayerX = player.getX();                                                      //so they are set to the same value here
            relPlayerShiftX = 0;                                                             //since the camera isn't following the player anymore (in x), the shift becomes 0
        }
        else if (player.getX() >= (currentMap.getMapWidth() - (1 + width / 2)) * tileSize)   //checks if the camera can't move off to the right anymore(the 1 is because of
        {                                                                                    //rounding)the width is the distance the camera spans, so it takes that and
            cameraStartX = (currentMap.getMapWidth() - width) * tileSize;                    //subtracts it from the map right bound to find where the map should start
            relPlayerX = player.getX() - cameraStartX;                                       //this line is fairly simple
            relPlayerShiftX = 0;                                                             //same reasoning as above for this line
        }
        else                                                                                 //if the camera isn't clipped at either end, it'll follow the player
        {                                                                                    //the camera will follow behind the player, and since the player is in the middle
            cameraStartX = player.getX() - (width / 2) * tileSize;                           //the camera will move halfway across the screen
            relPlayerX = (width / 2) * tileSize;                                             //this sets the player in the middle
            relPlayerShiftX = player.getX() % tileSize;                                      //since the camera is moving, the tiles have to be offset
        }

        //y component of camera clipping
        if (player.getY() <= (height / 2) * tileSize)                                        //copied from above, refactored for vertical component
        {
            cameraStartY = 0;
            relPlayerY = player.getY();
            relPlayerShiftY = 0;
        }
        else if (player.getY() >= (currentMap.getMapHeight() - (1 + height / 2)) * tileSize)
        {
            cameraStartY = (currentMap.getMapHeight() - height) * tileSize;
            relPlayerY = player.getY() - cameraStartY;
            relPlayerShiftY = 0;
        }
        else
        {
            cameraStartY = player.getY() - (height / 2) * tileSize;
            relPlayerY = (height / 2) * tileSize;
            relPlayerShiftY = player.getY() % tileSize;
        }

        //the loop is self-explanatory
        for(int i = cameraStartX / tileSize; i < (cameraStartX / tileSize) + width; i++)
        {
            for(int j = cameraStartY / tileSize; j < (cameraStartX / tileSize) + width; j++)
            {
                graphicsContext.drawImage(textures.get(currentMap.getImageMap()[i][j]),      //i and j have to be shifted back to 0 in order to draw to the screen properly
                    ((i - cameraStartX / tileSize) * tileSize) - relPlayerShiftX,            //the imagemap stores which image to draw to each tile
                    ((j - cameraStartY / tileSize) * tileSize) - relPlayerShiftY);
            }
        }

        //draws the player with the available sprite in player(which extends drawable)
        graphicsContext.drawImage(player.getSprite(), relPlayerX, relPlayerY);
    }
}