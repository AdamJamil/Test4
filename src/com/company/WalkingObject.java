package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/*
    Extended by anything that requires a walk method
    Uses a keyframe to check walking status and update movement
    Uses a buffer for any Player class that extends this
    THIS IS ASYNCHRONOUS
 */

class WalkingObject extends Drawable implements Constants, Walking
{
    private int x;
    private int y;
    private short tick = 0;
    private int buffer = noAction;

    WalkingObject()
    {
        KeyFrame frame = new KeyFrame(Duration.millis(4f), (event) ->
        {
            if (this.getObjectState().getStatus() == walking)
            {
                tick++;
                moveObject();
                if (tick % tileSize / 4 == 0)                                       //updates the status every time the player has moved across a fourth of the tile
                    updateWalkingStatus();
                tick %= tileSize;                                                   //resets the clock once it hits the max
            }
            if (this instanceof Player)                                             //this buffers inputs for any Player class
                if (buffer != noAction && tick == 0)                                //only lets the buffer be pushed if the clock has reset
                {
                    ((Player)this).handleInput(buffer);
                    buffer = noAction;
                }
        });

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    //moves the object in the direction it is moving by one
    private void moveObject()
    {
        if (this.getObjectState().getDirection() == back)
            incrementY(-1);
        else if (this.getObjectState().getDirection() == right)
            incrementX(1);
        else if (this.getObjectState().getDirection() == front)
            incrementY(1);
        else if (this.getObjectState().getDirection() == left)
            incrementX(-1);
    }

    //changes the animationStep every time the object has moved a quarter cross the tile
    //on finish, the status is reset to idle
    private void updateWalkingStatus()
    {
        assert tick % (tileSize / 4) == 0;
        if (tick == 0)
            this.getObjectState().setAnimationStep(0);
        else if (tick == tileSize / 4)
            this.getObjectState().setAnimationStep(1);
        else if (tick == tileSize / 2)
            this.getObjectState().setAnimationStep(0);
        else if (tick == tileSize * 3 / 4)
            this.getObjectState().setAnimationStep(2);
        else if (tick == tileSize)
        {
            this.getObjectState().setAnimationStep(0);
            this.getObjectState().setStatus(idle);
        }
    }

    private void incrementX(int increment)
    {
        x += increment;
    }

    private void incrementY(int increment)
    {
        y += increment;
    }

    int getX()
    {
        return x;
    }

    void setX(int x)
    {
        this.x = x;
    }

    int getY()
    {
        return y;
    }

    void setY(int y)
    {
        this.y = y;
    }

    short getTick()
    {
        return tick;
    }

    void setBuffer(int buffer)
    {
        this.buffer = buffer;
    }
}
