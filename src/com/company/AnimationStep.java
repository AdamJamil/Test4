package com.company;

public enum AnimationStep
{
    ZERO(0x0),
    ONE(0x1),
    TWO(0x2),
    THREE(0x3);

    public final byte step;

    AnimationStep(int step)
    {
        this.step = (byte)step;
    }

    @Override
    public String toString()
    {
        return (step == 0x0) ? ("0")
              :(step == 0x1) ? ("1")
              :(step == 0x2) ? ("2")
              :("3");
    }
}