package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Created by yges on 5/8/2016.
 */
public class WalkingObject extends Drawable
{
    private int x;
    private int y;
    private int direction = 0;
    private float delay = 4f;
    private short tick = 0;
    private Timeline timeline;

    public WalkingObject()
    {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        //dir -> (0 = still, 1 = north, 2 = east, 3 = south, 4 = west)
        KeyFrame frame = new KeyFrame(Duration.millis(delay), (event) ->
        {
            tick++;
            if (direction == 1)
            {
                incrementY(1);
            }
        });
    }

    public void checkWalkingStatus()
    {
        if (tick == 0)
            walkingStatus = WalkingStatus.B0;
        if (tick == 16)
            walkingStatus = WalkingStatus.B1;
        if (tick == 32)
            walkingStatus = WalkingStatus.B0;
        if (tick == 48)
            walkingStatus = WalkingStatus.B2;
        if (tick == 64)
        {
            walkingStatus = WalkingStatus.B0;
            tick = 0;
            direction = 0;
        }
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void incrementX(int increment)
    {
        x += increment;
    }

    public void incrementY(int increment)
    {
        y += increment;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}