package com.company;

import javafx.scene.image.Image;

public class Map
{
    private double mapWidth;
    private double mapHeight;
    private Image imageMap;

    public Map(Image imageMap)
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
