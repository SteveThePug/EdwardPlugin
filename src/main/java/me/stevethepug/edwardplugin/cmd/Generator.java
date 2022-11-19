package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Generator implements CommandExecutor
{
    EdwardPlugin plugin;

    public Generator(EdwardPlugin instance) {plugin = instance;}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("generator"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;

                if (args.length == 0)
                {
                    player.sendMessage("Test");
                }
            }
        }
        return false;
    }
}
