package com.company;

import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Player extends Drawable implements java.io.Serializable
{
    private int x;
    private int y;

    public Player()
    {
        x = 0;
        y = 0;
        walkingStatus = WalkingStatus.F0;
        InputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(new File("./res/Sprites/Player/F1.png"));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        sprites.put(WalkingStatus.F0, new Image(inputStream));
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void incrementX(int increment)
    {
        x += increment;
    }

    public void incrementY(int increment)
    {
        y += increment;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }


}
