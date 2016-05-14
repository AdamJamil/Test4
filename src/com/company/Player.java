package com.company;

import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Player extends WalkingObject implements Constants
{
    public Player()
    {
        this.setObjectState(new ObjectState(front, 0));
        loadImages("Player");
    }

    public void down()
    {
        if (this.getObjectState().getStatus() == idle)
            handleMoveInput(front);
    }

    public void up()
    {
        if (this.getObjectState().getStatus() == idle)
            handleMoveInput(back);
    }

    public void left()
    {
        if (this.getObjectState().getStatus() == idle)
            handleMoveInput(left);
    }

    public void right()
    {
        if (this.getObjectState().getStatus() == idle)
            handleMoveInput(right);
    }

    public void handleMoveInput(int direction)
    {
        if (this.getObjectState().getDirection() == direction)
            this.getObjectState().setStatus(walking);
        else
            this.getObjectState().setDirection(direction);
    }
}
