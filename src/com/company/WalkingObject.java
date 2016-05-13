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
            tick++;
            tick %= 64;
            if (this.getSpriteKey().getAnimationStepInt() == walking)
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
        if (this.getSpriteKey().getDirection() == Direction.BACK)
            incrementY(-1);
        else if (this.getSpriteKey().getDirection() == Direction.RIGHT)
            incrementX(1);
        else if (this.getSpriteKey().getDirection() == Direction.FRONT)
            incrementY(1);
        else if (this.getSpriteKey().getDirection() == Direction.LEFT)
            incrementX(-1);
    }

    public void updateWalkingStatus()
    {
        if (tick == 0)
            this.getSpriteKey().setAnimationStep(AnimationStep.ZERO);
        if (tick == 16)
            this.getSpriteKey().setAnimationStep(AnimationStep.ONE);
        if (tick == 32)
            this.getSpriteKey().setAnimationStep(AnimationStep.ZERO);
        if (tick == 48)
            this.getSpriteKey().setAnimationStep(AnimationStep.TWO);
        if (tick == 64)
        {
            this.getSpriteKey().setAnimationStep(AnimationStep.ZERO);
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
