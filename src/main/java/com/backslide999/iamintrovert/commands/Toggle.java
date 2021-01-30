package com.backslide999.iamintrovert.commands;

import com.backslide999.iamintrovert.IAmIntrovertPlugin;
import com.backslide999.iamintrovert.services.PlayerService;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class Toggle {

    public void run(@Nonnull Player player)
    {
        String cmd = PlayerService.getInstance().hasInvisibilityEnabled(player, player.getWorld()) ? "off" : "on";
        this.run(player, cmd);
    }

    public void run(@Nonnull Player player, @Nonnull  String command)
    {
        if(!player.hasPermission("iai.toggle." + player.getWorld().getName())) {
            IAmIntrovertPlugin.getInstance().sendPlayerDefaultWarning(player, "unauthorized");
            return;
        }
        switch(command)
        {
            case "on":
                PlayerService.getInstance().enableInvisibility(player, player.getWorld());
                IAmIntrovertPlugin.getInstance().sendPlayerDefaultInfo(player, "toggle_on");
                break;
            case "off":
                PlayerService.getInstance().disableInvisibility(player, player.getWorld());
                IAmIntrovertPlugin.getInstance().sendPlayerDefaultInfo(player, "toggle_off");
                break;
            default:
                IAmIntrovertPlugin.getInstance().sendPlayerDefaultWarning(player, "only_on_or_off");
                break;
        }

    }



}
