package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Vanish extends BaseCommand {
    //Array of players using the vanishing command
    ArrayList<Player> playersVanishing;
    EdwardPlugin plugin;
    public Vanish(EdwardPlugin instance) {plugin = instance; playersVanishing = new ArrayList<>();}
    @Override
    public String GetName() {
        return "vanish";
    }

    @Override
    public String GetUsage() {
        return "/vanish <user>";
    }

    @Override
    public void ExecuteCommand(Player player, String[] args) {
        if (playersVanishing.contains(player))
        {
            player.sendMessage("Showing other players");
            playersVanishing.remove(player);
            for (Player otherPlayer : Bukkit.getOnlinePlayers())
            {
                player.showPlayer(plugin, otherPlayer);
            }
        }
        else
        {
            player.sendMessage("Hiding other players");
            playersVanishing.add(player);
            for (Player otherPlayer : Bukkit.getOnlinePlayers())
            {
                player.hidePlayer(plugin, otherPlayer);
            }
        }
    }
}
