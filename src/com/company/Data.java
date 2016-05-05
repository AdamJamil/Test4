package com.company;

public class Data implements java.io.Serializable
{
    private Player player;
    private int currentMap;

    public Player getPlayer()
    {
        return player;
    }

    public void setCurrentMap(int newMap)
    {
        currentMap = newMap;
    }

    public int getCurrentMap()
    {
        return currentMap;
    }
}
