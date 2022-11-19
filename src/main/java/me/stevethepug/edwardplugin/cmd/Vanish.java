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
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("vanish"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                if (player.isOp())
                {
                    if (args.length == 0)
                    {
                        VanishPlayer(player);
                    }
                    if (args.length == 1)
                    {
                        String s = args[0];
                        if (Bukkit.getServer().getPlayer(s) != null && Bukkit.getServer().getPlayer(s).getName().equalsIgnoreCase(s))
                        {
                            Player p = Bukkit.getPlayer(s);
                            VanishPlayer(p);
                        } else
                        {
                            player.sendMessage("Error: Invalid target");
                        }
                    } else
                    {
                        player.sendMessage("Error: Invalid input");
                    }
                }
            }
        }
        return true;
    }
    public void VanishPlayer(Player player)
    {
        if (plugin.vanishedPlayers.contains(player))
        {
            plugin.vanishedPlayers.remove(player);
            player.showPlayer(plugin, player);
            player.sendMessage("boo nig");
        }
        else
        {
            plugin.vanishedPlayers.add(player);
            player.hidePlayer(plugin, player);
            player.sendMessage("raahted man gone");
        }
    }
}
