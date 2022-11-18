package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
    EdwardPlugin plugin;

    public Vanish(EdwardPlugin instance) {plugin = instance;}
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("vanish"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                if (player.isOp())
                {
                    if (plugin.vanishedPlayers.contains(player))
                    {
                        for (Player p : Bukkit.getOnlinePlayers())
                        {
                            p.showPlayer(plugin, player);
                        }
                        plugin.vanishedPlayers.remove(player);
                        player.sendMessage("boo nig");
                    }
                    else if (!plugin.vanishedPlayers.contains(player))
                    {
                        for (Player p : Bukkit.getOnlinePlayers())
                        {
                            player.hidePlayer(plugin, p);
                        }
                        plugin.vanishedPlayers.add(player);
                        player.sendMessage("raahted man gone");
                    }
                }
            }
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("funny"))
        {
            return true;
        }
        return false;
    }
}
