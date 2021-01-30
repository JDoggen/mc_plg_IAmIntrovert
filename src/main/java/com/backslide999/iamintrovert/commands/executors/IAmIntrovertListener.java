package com.backslide999.iamintrovert.commands.executors;

import com.backslide999.iamintrovert.IAmIntrovertPlugin;
import com.backslide999.iamintrovert.commands.Help;
import com.backslide999.iamintrovert.commands.Toggle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IAmIntrovertListener implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = null;
        if (sender instanceof Player)
        {
            player = (Player) sender;
        }


        if (player != null)
        {
            if (args.length == 0)
            {
                new Toggle().run(player);
                return true;
            }
            else
            {
                switch (args[0])
                {
                    case "on":
                    case "off":
                        new Toggle().run(player, args[0]);
                        return true;
                    case "reload":
                        return false;
                    default:
                        new Help(sender);
                        return true;
                }
            }
        }
        else
        {
            IAmIntrovertPlugin.getInstance().sendPlayerDefaultWarning(sender, "no_command_line");
            return true;
        }
    }
}
