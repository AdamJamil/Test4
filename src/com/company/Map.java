package com.company;

import com.google.gson.Gson;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Map
{
    private double mapWidth;
    private double mapHeight;
    private Image imageMap;
    private short imageMapID;

    public Map(Image imageMap, short mapsLoaded)
    {
        this.imageMap = imageMap;
        mapHeight = imageMap.getHeight();
        mapWidth = imageMap.getWidth();
    }

    public double getMapHeight()
    {
        return mapHeight;
    }

    public double getMapWidth()
    {
        return mapWidth;
    }

    public Image getImageMap()
    {
        return imageMap;
    }

    public void setImageMap(Image imageMap)
    {
        this.imageMap = imageMap;
    }
}
