package com.company;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Map
{
    private int mapWidth;
    private int mapHeight;
    transient private Image imageSource;
    transient private int[][] imageMap;

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

    public void setImageSource(Image imageSource)
    {
        this.imageSource = imageSource;
        imageMap = new int[(int)imageSource.getWidth()][(int)imageSource.getHeight()];
        PixelReader pixelReader = imageSource.getPixelReader();
        Color pixelColor;
        for(int i = 0; i < imageSource.getWidth(); i++)
        {
            for(int j = 0; j < imageSource.getHeight(); j++)
            {
                pixelColor = pixelReader.getColor(i,j);
                imageMap[i][j] = (int)(pixelColor.getBlue() + (pixelColor.getGreen() * 256) + (pixelColor.getRed() * 256 * 256));
            }
        }
    }
}
