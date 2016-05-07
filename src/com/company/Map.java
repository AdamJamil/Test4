package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Map
{
    private int mapWidth;
    private int mapHeight;
    //stores the image that will load the imagemap
    transient private Image imageSource;
    //imagemap stores the imagecode for each tile in the map (use texture code to decode)
    transient private Short[][] imageMap;

    public int getMapHeight()
    {
        return mapHeight;
    }

    public int getMapWidth()
    {
        return mapWidth;
    }

    public Image getImageSource()
    {
        return imageSource;
    }

    //psuedo-constructor
    public void setImageSource(Image imageSource)
    {
        this.imageSource = imageSource;
        mapWidth = (int)imageSource.getWidth();
        mapHeight = (int)imageSource.getHeight();
        imageMap = new Short[mapWidth][mapHeight];
        //next two vars are used to convert each pixel to a single numeric value
        PixelReader pixelReader = imageSource.getPixelReader();

        for(int i = 0; i < imageSource.getWidth(); i++)
        {
            for(int j = 0; j < imageSource.getHeight(); j++)
            {
                imageMap[i][j] = (short)(pixelReader.getArgb(i, j));
            }
        }
    }

    public Short[][] getImageMap()
    {
        return imageMap;
    }
}
