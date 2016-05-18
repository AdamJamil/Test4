package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

/*
    This class stores the information relevant to any world map
    It uses an Image to load each tile, where each pixel's ARGB corresponds to a number
    Each number corresponds to a .png, which is that tile
    to-do: try and figure out if one can run the program in real time and change the imageSource without an I/O error
    Potential error cause: imageMap uses Short
    Does not rely on any other class
 */

class Map
{
    private int mapWidth;
    private int mapHeight;
    transient private short[][] imageMap;   //imagemap stores the imagecode for each tile in the map (use texture code to decode)

    //pseudo-constructor -> loads imageSource and imageMap
    void setImageSource(Image imageSource)
    {
        mapWidth = (int)imageSource.getWidth();
        mapHeight = (int)imageSource.getHeight();
        imageMap = new short[mapWidth][mapHeight];
        PixelReader pixelReader = imageSource.getPixelReader();

        for(int i = 0; i < imageSource.getWidth(); i++)
            for(int j = 0; j < imageSource.getHeight(); j++)
                imageMap[i][j] = (short)(pixelReader.getArgb(i, j));
    }

    //used in viewPortLoader
    short[][] getImageMap()
    {
        return imageMap;
    }

    int getMapHeight()
    {
        return mapHeight;
    }

    int getMapWidth()
    {
        return mapWidth;
    }

    /*
    public Image getImageSource()
    {
        return imageSource;
    }
    */
}
