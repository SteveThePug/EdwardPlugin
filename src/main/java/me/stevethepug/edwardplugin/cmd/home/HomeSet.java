package me.stevethepug.edwardplugin.cmd.home;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.cmd.BaseCommand;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getConsoleSender;
import static org.bukkit.Bukkit.getWorld;

public class HomeSet extends BaseCommand {
    public HomeSet(EdwardPlugin instance) {
        super(instance);
    }

    @Override
    public String GetName() {
        return "set";
    }

    @Override
    public String GetUsage() {
        return "/home set <home_name>";
    }

    public void setLocationIntoConfig(Location loc, String path)
    {
        FileConfiguration config = plugin.getConfig();
        config.set(path + ".world", loc.getWorld().getName());
        config.set(path + ".x", loc.getX());
        config.set(path + ".y", loc.getY());
        config.set(path + ".z", loc.getZ());
        config.set(path + ".pitch", loc.getPitch());
        config.set(path + ".yaw", loc.getYaw());
        plugin.saveConfig();
    }
    @Override
    public void ExecuteCommand(Player player, String[] args) {
        //User data stored in homes.playeruuid.homename.[x,y,z,world,pitch,yaw]
        String uuid = player.getUniqueId().toString();
        if (args.length == 2)
        {
            String homeName = args[1];
            String path = "homes" + "." + uuid + "." + homeName;
            //Check if name already exists, if not then add home to the config
            if (plugin.getConfig().contains(path))
            {
                player.sendMessage("Replaced home: " + homeName);
                setLocationIntoConfig(player.getLocation(), path);
            }
            else
            {
                player.sendMessage("Created new home: " + homeName);
                setLocationIntoConfig(player.getLocation(), path);
            }
        }
        else
        {
            player.sendMessage(GetUsage());
        }
    }
}
