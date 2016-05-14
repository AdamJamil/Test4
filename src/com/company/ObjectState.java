package com.company;

import java.util.Objects;

/**
 * Created by 10009702 on 5/12/2016.
 */
public class ObjectState
{
    Direction direction = Direction.FRONT;
    AnimationStep animationStep = AnimationStep.ZERO;
    Status status = Status.IDLE;

    public ObjectState(int direction, int animationStep)
    {
        this.direction.setDirection(direction);
        this.animationStep.setAnimationStep(animationStep);
    }

    public ObjectState(Direction direction, AnimationStep animationStep)
    {
        this.direction.setDirection(direction);
        this.animationStep.setAnimationStep(animationStep);
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public AnimationStep getAnimationStep()
    {
        return animationStep;
    }

    public int getAnimationStepInt()
    {
        return (int)animationStep.getAnimationStep();
    }

    public void setAnimationStep(AnimationStep animationStep)
    {
        this.animationStep = animationStep;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public String toString()
    {
        return direction.toString() + animationStep.toString();
    }

    @Override
    public int hashCode()
    {
        return direction.getDirection() + (animationStep.getAnimationStep() * 4);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final ObjectState that = (ObjectState) obj;
        if (this.direction != that.direction || this.animationStep != that.animationStep)
            return false;
        return true;
    }
}
