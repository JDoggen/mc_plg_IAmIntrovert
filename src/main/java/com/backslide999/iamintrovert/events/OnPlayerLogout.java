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
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerLogout implements Listener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPlayerLogout(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        for(World world : Bukkit.getWorlds())
        {
            if(PlayerService.getInstance().hasInvisibilityEnabled(player, world))
            {
                PlayerService.getInstance().disableInvisibility(player, world);
            }
        }
    }
}
