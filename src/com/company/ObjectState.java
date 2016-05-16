package com.company;

import java.util.Objects;

/*
    Combination of
 */
public class ObjectState implements Constants
{
    private int direction = front;
    private int animationStep = 0;
    private int status = idle;

    public ObjectState(int direction, int animationStep)
    {
        this.direction = direction;
        this.animationStep = animationStep;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public int getAnimationStep()
    {
        return animationStep;
    }

    public void setAnimationStep(int animationStep)
    {
        this.animationStep = animationStep;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String toString()
    {
        return ((direction == front) ? "F" : (direction == right) ? "R" : (direction == left)  ? "L" : "B")
             + (Integer.toString(animationStep));
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ObjectState that = (ObjectState) o;

        if (direction != that.direction)
            return false;
        return animationStep == that.animationStep;
    }

    @Override
    public int hashCode()
    {
        int result = direction;
        result = 31 * result + animationStep;
        return result;
    }
}
