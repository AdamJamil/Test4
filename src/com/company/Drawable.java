package com.company;

import java.util.HashMap;
import javafx.scene.image.Image;

public class Drawable
{
    private Status status;
    transient HashMap<Status, Image> sprites = new HashMap<>();

    public Image getSprite()
    {
        return sprites.get(this.status);
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }
}