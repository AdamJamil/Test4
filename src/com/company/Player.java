package com.company;

import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Player extends WalkingObject
{
    public Player()
    {
        this.setStatus(Status.F0);
        InputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(new File("./res/Sprites/Player/F1.png"));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        sprites.put(Status.F0, new Image(inputStream));
    }
}
