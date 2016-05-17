package com.company;

import javafx.scene.image.Image;
import java.util.HashMap;

/*  This class holds nearly all the game information, including the player, current variables and images (not sprites)
    Contains getter methods for all variables held
    Creates empty new objects on start
 */

class Data implements java.io.Serializable
{
    private Player player = new Player();
    private Short currentMapIndex = 0;
    private Map currentMap;
    private transient HashMap<Short, Image> textures;
    private transient HashMap<Short, Map> maps;

    Data()
    {
        textures = new HashMap<>();
        maps = new HashMap<>();
        currentMapIndex = 0;
    }

    Player getPlayer()
    {
        return player;
    }

    public void setCurrentMap(Map newMap)
    {
        currentMap = newMap;
    }

    Map getCurrentMap()
    {
        currentMap = maps.get(currentMapIndex);
        return currentMap;
    }

    HashMap<Short, Image> getTextures()
    {
        return textures;
    }

    HashMap<Short, Map> getMaps()
    {
        return maps;
    }
}
