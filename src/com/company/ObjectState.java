package com.company;

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

    public int getAnimationStepInt()
    {
        return (int)animationStep.getAnimationStep();
    }

    public String toString()
    {
        return direction.toString() + animationStep.toString();
    }
}
