package com.company;

public class Player implements java.io.Serializable
{
    private int x;
    private int y;

    public Player()
    {
        x = 0;
        y = 0;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
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
