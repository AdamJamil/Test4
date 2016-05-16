package com.company;

import javafx.scene.image.Image;
import java.util.HashMap;

/*  This class holds nearly all the game information, including the player, current variables and images (not sprites)
    Contains getter methods for all variables held
    Creates empty new objects on start
 */

public class Data implements java.io.Serializable
{
    private Player player = new Player();
    private Short currentMapIndex = 0;
    private Map currentMap;
    private transient HashMap<Short, Image> textures;
    private transient HashMap<Short, Map> maps;

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
