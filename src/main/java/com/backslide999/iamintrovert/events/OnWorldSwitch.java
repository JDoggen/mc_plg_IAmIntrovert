package com.backslide999.iamintrovert.events;

import com.backslide999.iamintrovert.IAmIntrovertPlugin;
import com.backslide999.iamintrovert.services.PlayerService;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class OnWorldSwitch implements Listener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onWorldSwitch(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        World from = event.getFrom().getWorld();
        World to = event.getTo().getWorld();

        if(event.getFrom().getWorld() == event.getTo().getWorld())
        {
            return;
        }
        else
        {
            if(PlayerService.getInstance().hasInvisibilityEnabled(player, to))
            {
                PlayerService.getInstance().hideAllPLayers(player);
            }
            else
            {
                PlayerService.getInstance().showAllPlayers(player);
            }
        }
    }
}
