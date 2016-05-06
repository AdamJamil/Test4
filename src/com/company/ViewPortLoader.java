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

    public ViewPortLoader(GraphicsContext aGraphicsContext, Data someData)
    {
        graphicsContext = aGraphicsContext;                                                  //gets the gc that was loaded in Main, so that it can draw to it
        data = someData;                                                                     //gets more relevant information for drawing
    }

    public void loadViewPort()
    {
        int cameraStartX, cameraStartY;                                                      //coordinate of the top-leftmost pixel drawn
        int relPlayerX, relPlayerY;                                                          //where the player appears relative to the camera
        graphicsContext.clearRect(0, 0, pixelWidth, pixelHeight);                            //clears screen
    }
}