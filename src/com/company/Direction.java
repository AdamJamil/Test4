package com.company;

public enum Direction
{
    BACK(0x0),
    RIGHT(0x1),
    FRONT(0x2),
    LEFT(0x3);

    public final byte direction;

    Direction(int direction)
    {
        this.direction = (byte)direction;
    }

    @Override
    public String toString()
    {
        return (direction == 0x0) ? ("B")
              :(direction == 0x1) ? ("R")
              :(direction == 0x2) ? ("F")
              :("R");
    }
}