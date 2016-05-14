package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import javafx.scene.image.Image;

public class Drawable
{
    private ObjectState objectState;
    transient HashMap<ObjectState, Image> sprites = new HashMap<>();

    public Image getSprite()
    {
        System.out.println(sprites.containsKey(new ObjectState(2, 1)));
        return sprites.get(objectState);
    }

    public ObjectState getObjectState()
    {
        return objectState;
    }

    public void setObjectState(ObjectState objectState)
    {
        this.objectState = objectState;
    }

    public void loadImages(String name)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                ObjectState tempObjectState = new ObjectState(i, j);
                sprites.put(tempObjectState, loadImage(name + "/" + tempObjectState.toString()+ ".png"));
            }
        }
    }

    public Image loadImage(String folderAndFileName)
    {
        InputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(new File("./res/Sprites/" + folderAndFileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FAILURE");
        }
        System.out.println(folderAndFileName);
        if (inputStream == null)
            return null;
        return new Image(inputStream);
    }
}