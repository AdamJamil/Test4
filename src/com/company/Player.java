package com.company;

import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class Player extends WalkingObject implements Constants
{
    Player()
    {
        this.setObjectState(new ObjectState(front, 0));
        loadImages("Player");
    }

    //if the direction is not nothing, then if the player is still it is instructed to begin walking
    //otherwise it sets the buffer
    void handleInput(int direction)
    {
        if (direction != noAction)
            if (this.getObjectState().getStatus() == idle)
                handleMoveInput(direction);
            else if (this.getTick() > firstTickToBuffer)
                this.setBuffer(direction);
    }

    //if, for only one frame, one direction is pressed,
    //the character will change directions without moving in the new direction
    private void handleMoveInput(int direction)
    {
        if (this.getObjectState().getDirection() == direction)
            this.getObjectState().setStatus(walking);
        else
            this.getObjectState().setDirection(direction);
    }
}
