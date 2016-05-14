package com.company;

public enum Direction
{
    BACK(0x0),
    RIGHT(0x1),
    FRONT(0x2),
    LEFT(0x3);

    private byte direction;

    Direction(int direction)
    {
        this.direction = (byte)direction;
    }

    public void setDirection(int direction)
    {
        System.out.println("I am here");
        this.direction = (byte)direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction.getDirection();
    }

    public byte getDirection()
    {
        return direction;
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