package com.backslide999.iamintrovert.commands;

import com.backslide999.iamintrovert.IAmIntrovertPlugin;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Help {

    public Help(CommandSender sender){
        List<String> help = IAmIntrovertPlugin.getInstance().fetchConfigStringList("messages.help");
        IAmIntrovertPlugin.getInstance().sendPlayerInfo(sender, help);
    }
}
