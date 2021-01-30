package com.backslide999.iamintrovert;

import com.backslide999.iamintrovert.commands.executors.IAmIntrovertListener;
import com.backslide999.iamintrovert.events.OnPlayerLogin;
import com.backslide999.iamintrovert.events.OnPlayerLogout;
import com.backslide999.iamintrovert.events.OnWorldSwitch;
import com.backslide999.library.*;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfigurationOptions;

import java.util.logging.Logger;

public class IAmIntrovertPlugin extends BasePlugin {

    private static IAmIntrovertPlugin instance;
    public static IAmIntrovertPlugin getInstance(){
        return instance;
    }
    public final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        instance = this;

        // Read config file
        this.logInfo("Reading Config file");
        this.reload();

        // Register Commands
        this.logInfo("Registering Commands");
        this.getCommand("iai").setExecutor(new IAmIntrovertListener());

        // Register Events
        // Register Events
        this.logInfo("Registering Events");
        this.getServer().getPluginManager().registerEvents(new OnWorldSwitch(), this);
        this.getServer().getPluginManager().registerEvents(new OnPlayerLogin(), this);
        this.getServer().getPluginManager().registerEvents(new OnPlayerLogout(), this);

    }

    public void reload(){
        this.reload(null);
    }

    public void reload(CommandSender sender) {
        this.reloadConfig();
        FileConfigurationOptions config = getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
