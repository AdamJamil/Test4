package com.company;

import java.util.HashMap;
import javafx.scene.image.Image;

public class Drawable
{
    private SpriteKey spriteKey;
    transient HashMap<SpriteKey, Image> sprites = new HashMap<>();

    public Image getSprite()
    {
        return sprites.get(spriteKey);
    }

    public SpriteKey getSpriteKey()
    {
        return spriteKey;
    }

    public void setSpriteKey(SpriteKey spriteKey)
    {
        this.spriteKey = spriteKey;
    }

}