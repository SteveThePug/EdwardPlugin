package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Vanish{
    EdwardPlugin plugin;

    public String GetUsage() {
        return "/vanish";
    }
    public Vanish(EdwardPlugin instance) {plugin = instance;}
    // This method is called, when somebody uses our command

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
