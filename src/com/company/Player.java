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
        this.setObjectState(new ObjectState(Direction.FRONT, AnimationStep.ZERO));
        loadImages("Player");
    }
}
