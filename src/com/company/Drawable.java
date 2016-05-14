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
        ObjectState temp2ObjectState = new ObjectState(0, 0);
        ObjectState temp3ObjectState = new ObjectState(2, 2);
        ObjectState temp4ObjectState = new ObjectState(3, 2);
        System.out.println(temp2ObjectState);
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                System.out.println(objectState);
                {
                    ObjectState tempObjectState = new ObjectState(i, j);
                }
                System.out.println(objectState);
                System.out.println(temp2ObjectState);
                System.out.println(temp3ObjectState);
                System.out.println(temp4ObjectState);
                //sprites.put(tempObjectState, loadImage(name + "/" + tempObjectState.toString()+ ".png"));
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
        }
        if (inputStream == null)
            return null;
        return new Image(inputStream);
    }
}