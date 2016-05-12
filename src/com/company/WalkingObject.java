package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Created by yges on 5/8/2016.
 */
public class WalkingObject extends Drawable implements Constants
{
    private int x;
    private int y;
    private int direction = 0;
    private float delay = 4f;
    private short tick = 0;
    private Timeline timeline;

    public WalkingObject()
    {
        //dir -> (0 = back, 1 = right, 2 = front, 3 = left)
        KeyFrame frame = new KeyFrame(Duration.millis(delay), (event) ->
        {
            tick++;
            tick %= 64;
            if (this.getStatus().walkingStatus == walking)
            {
                moveObject();
                if (tick % 16 == 0)
                    updateWalkingStatus();
            }
        });

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    public void moveObject()
    {
        if (direction == 0)
            incrementY(-1);
        else if (direction == 1)
            incrementX(1);
        else if (direction == 2)
            incrementY(1);
        else if (direction == 3)
            incrementX(-1);
    }

    public void updateWalkingStatus()
    {
        if (tick == 0)
            this.setStatus((byte)((this.getStatus().status - Status.B.status) * 4));
        if (tick == 16)
            this.setStatus(Status.B1);
        if (tick == 32)
            this.setStatus(Status.B0);
        if (tick == 48)
            this.setStatus(Status.B2);
        if (tick == 64)
            this.setStatus(Status.B0);
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
