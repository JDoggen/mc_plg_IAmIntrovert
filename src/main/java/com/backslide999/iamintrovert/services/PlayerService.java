package com.backslide999.iamintrovert.services;

import com.backslide999.iamintrovert.IAmIntrovertPlugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerService {

    private static PlayerService instance;
    private ConcurrentHashMap<World, List<Player>> invisibilityEnabledPlayers;

    private PlayerService(){
        initializeInvisibilityList();
    }

    public static synchronized PlayerService getInstance(){
        if(instance == null){
            instance = new PlayerService();
        }
        return instance;
    }

    public void enableInvisibility(Player player, World world)
    {
        this.invisibilityEnabledPlayers.get(world).add(player);
        this.hideAllPLayers(player);
    }

    public void disableInvisibility(Player player, World world)
    {
        this.invisibilityEnabledPlayers.get(world).remove(player);
        this.showAllPlayers(player);
    }


    public boolean hasInvisibilityEnabled(Player player, World world)
    {
        return this.invisibilityEnabledPlayers.get(world).contains(player);
    }

    public void showAllPlayers(Player player)
    {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            player.showPlayer(IAmIntrovertPlugin.getInstance(), onlinePlayer);
        }
    }

    public void hideAllPLayers(Player player)
    {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            player.hidePlayer(IAmIntrovertPlugin.getInstance(), onlinePlayer);
        }
    }


    private void initializeInvisibilityList()
    {
        this.invisibilityEnabledPlayers = new ConcurrentHashMap<World, List<Player>>();
        for(World world : Bukkit.getWorlds())
        {
            this.invisibilityEnabledPlayers.put(world, Collections.synchronizedList(new ArrayList<Player>()));
        }
    }


}
