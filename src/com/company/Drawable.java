package com.company;

import java.util.HashMap;
import javafx.scene.image.Image;

public class Drawable
{
    WalkingStatus walkingStatus;
    transient HashMap<WalkingStatus, Image> sprites = new HashMap<>();

    public Image getSprite()
    {
        return sprites.get(this.walkingStatus);
    }
}