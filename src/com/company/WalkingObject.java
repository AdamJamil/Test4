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
    private float delay = 4f;
    private short tick = 0;
    private Timeline timeline;

    public WalkingObject()
    {
        //dir -> (0 = back, 1 = right, 2 = front, 3 = left)
        KeyFrame frame = new KeyFrame(Duration.millis(delay), (event) ->
        {
            if (this.getObjectState().getStatus() == walking)
            {
                tick++;
                moveObject();
                if (tick % 16 == 0)
                    updateWalkingStatus();
                tick %= 64;
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
        if (this.getObjectState().getDirection() == back)
            incrementY(-1);
        else if (this.getObjectState().getDirection() == right)
            incrementX(1);
        else if (this.getObjectState().getDirection() == front)
            incrementY(1);
        else if (this.getObjectState().getDirection() == left)
            incrementX(-1);
    }

    public void updateWalkingStatus()
    {
        if (tick == 0)
            this.getObjectState().setAnimationStep(0);
        if (tick == 16)
            this.getObjectState().setAnimationStep(1);
        if (tick == 32)
            this.getObjectState().setAnimationStep(0);
        if (tick == 48)
            this.getObjectState().setAnimationStep(2);
        if (tick == 64)
        {
            this.getObjectState().setAnimationStep(0);
            this.getObjectState().setStatus(idle);
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
