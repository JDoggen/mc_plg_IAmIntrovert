package com.backslide999.iamintrovert.events;

import com.backslide999.iamintrovert.IAmIntrovertPlugin;
import com.backslide999.iamintrovert.services.PlayerService;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class OnPlayerLogin implements Listener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(PlayerService.getInstance().hasInvisibilityEnabled(onlinePlayer, onlinePlayer.getWorld()))
            {
                onlinePlayer.hidePlayer(IAmIntrovertPlugin.getInstance(), player);
            }
        }
    }
}
