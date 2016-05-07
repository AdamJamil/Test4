package com.company;

import javafx.scene.image.Image;
import java.util.HashMap;

public class Data implements java.io.Serializable
{
    private Player player = new Player();
    private Short currentMapIndex = 0;
    private Map currentMap;
    private HashMap<Short, Image> textures;
    private HashMap<Short, Map> maps;

    public Data()
    {
        textures = new HashMap<>();
        maps = new HashMap<>();
        currentMapIndex = 0;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setCurrentMap(Map newMap)
    {
        currentMap = newMap;
    }

    public Map getCurrentMap()
    {
        currentMap = maps.get(currentMapIndex);
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
