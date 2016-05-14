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

    public void handleInput(int direction)
    {
        if (direction != -1)
            if (this.getObjectState().getStatus() == idle)
                handleMoveInput(direction);
            else if (this.getTick() > firstTickToBuffer)
                this.setBuffer(direction);
    }

    public void handleMoveInput(int direction)
    {
        if (this.getObjectState().getDirection() == direction)
            this.getObjectState().setStatus(walking);
        else
            this.getObjectState().setDirection(direction);
    }
}
