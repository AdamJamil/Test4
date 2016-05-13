package com.company;

/**
 * Created by 10009702 on 5/12/2016.
 */
public class ObjectState
{
    Direction direction = Direction.FRONT;
    AnimationStep animationStep = AnimationStep.ZERO;
    Status

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

    public int getAnimationStepInt()
    {
        return (int)animationStep.animationStep;
    }

    public String toString()
    {
        return direction.toString() + animationStep.toString();
    }
}
