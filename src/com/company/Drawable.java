package com.company;

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

}