package com.company;

public class Data implements java.io.Serializable
{
    private Player player = new Player();
    private int currentMap = 0;
    private Map instanceMap = new Map();

    public Data()
    {

    }

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
