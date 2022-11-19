package me.stevethepug.edwardplugin;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class TntCommand extends BaseCommand
{
    @Override
    public String GetName(){return "tnt";}
    @Override
    public String GetUsage(){return "/troll tnt <target>";}

    @Override
    public void ExecuteCommand(Player player, String[] args)
    {
        if (args.length > 1)
        {
            Player target = Bukkit.getPlayer(args[1]);
            target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 5);
            player.sendMessage("Tnt bombed " + target.getDisplayName());
        }
        else
        {
            player.sendMessage("Error: Invalid input");
        }
    }
}
