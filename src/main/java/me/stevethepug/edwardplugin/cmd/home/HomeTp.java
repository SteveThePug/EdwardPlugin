package me.stevethepug.edwardplugin.cmd.home;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.cmd.BaseCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class HomeTp extends BaseCommand
{
    public HomeTp(EdwardPlugin instance) {
        super(instance);
    }

    @Override
    public String GetName() {
        return "tp";
    }

    @Override
    public String GetUsage() {
        return "/home tp <home_name>";
    }

    public Location getLocationFromConfig(String path)
    {
        FileConfiguration config = plugin.getConfig();
        World world = Bukkit.getWorld(config.getString(path + ".world"));
        double x = config.getDouble(path + ".x");
        double y = config.getDouble(path + ".y");
        double z = config.getDouble(path + ".z");
        float pitch = (float) config.getDouble(path + ".pitch");
        float yaw = (float) config.getDouble(path + ".yaw");
        return new Location(world, x, y, z, yaw, pitch);
    }
    @Override
    public void ExecuteCommand(Player player, String[] args) {
        //User data stored in homes.playeruuid.homename.[x,y,z,world,pitch,yaw]
        String uuid = player.getUniqueId().toString();
        if (args.length == 2) {
            //Check if home is saved, if not tell player home does not exist
            String homeName = args[1];
            String path = "homes" + "." + uuid + "." + homeName;
            if (plugin.getConfig().contains(path))
            {
                player.sendMessage("Teleporting to " + homeName);
                Location loc = getLocationFromConfig(path);
                player.teleport(loc);
            }
            else
            {
                player.sendMessage("Home does not exist!");
            }
        }
        else {
            player.sendMessage(GetUsage());
        }
    }
}
