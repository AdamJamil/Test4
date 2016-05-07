package com.company;

import javafx.scene.image.Image;

import java.util.HashMap;

public class Data implements java.io.Serializable
{
    private Player player = new Player();
    private int currentMap = 0;
    private HashMap<Short, Image> textures = new HashMap<>();
    private HashMap<Short, Map> maps = new HashMap<>();

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

    public HashMap<Short, Image> getTextures()
    {
        return textures;
    }

    public HashMap<Short, Map> getMaps()
    {
        return maps;
    }
}
