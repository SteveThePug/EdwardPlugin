package me.stevethepug.edwardplugin.listener;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    EdwardPlugin plugin;

    public PlayerJoin(EdwardPlugin instance) {plugin = instance;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Bukkit.broadcastMessage("Whats up my nig " + e.getPlayer().getName());
        {
            Player player = e.getPlayer();
            for(int i = 0; i < plugin.vanishedPlayers.size(); i++)
            {
                player.hidePlayer(plugin, plugin.vanishedPlayers.get(i));
            }

            Bukkit.broadcastMessage("Wagwan yute");
        }
    }
}
