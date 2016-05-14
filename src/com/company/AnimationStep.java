package com.company;

public enum AnimationStep
{
    ZERO(0x0),
    ONE(0x1),
    TWO(0x2),
    THREE(0x3);

    private byte animationStep;

    AnimationStep(int animationStep)
    {
        this.animationStep = (byte)animationStep;
    }

    public void setAnimationStep(int animationStep)
    {
        this.animationStep = (byte)animationStep;
    }

    public void setAnimationStep(AnimationStep animationStep)
    {
        this.animationStep = (byte)animationStep.getAnimationStep();
    }

    public byte getAnimationStep()
    {
        return animationStep;
    }

    @Override
    public String toString()
    {
        return (animationStep == 0x0) ? ("0")
                :(animationStep == 0x1) ? ("1")
                :(animationStep == 0x2) ? ("2")
                :("3");
    }
}