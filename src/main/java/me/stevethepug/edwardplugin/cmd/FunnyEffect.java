package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FunnyEffect implements CommandExecutor {
    EdwardPlugin plugin;
    public FunnyEffect(EdwardPlugin instance) {plugin = instance;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("funnyeffect"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                Location loc = player.getLocation();

                loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc, 10);
            }
            return true;
        }
        return false;
    }
}
