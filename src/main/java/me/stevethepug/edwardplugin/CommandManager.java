package me.stevethepug.edwardplugin;

import me.stevethepug.edwardplugin.cmd.FunnyEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor
{
    private ArrayList<BaseCommand> commands = new ArrayList<>();

    public CommandManager(EdwardPlugin instance)
    {
        commands.add(new TntCommand());
        commands.add(new FunnyEffect(instance));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;

            if (args.length > 0)
            {
                for (int i = 0; i < GetCommands().size(); i++)
                {
                    if (args[0].equalsIgnoreCase(GetCommands().get(i).GetName()))
                    {
                        GetCommands().get(i).ExecuteCommand(player, args);
                    }
                }
            } else if (args.length == 0)
            {
                player.sendMessage("Choose a option");

                for (int i = 0; i < GetCommands().size(); i++)
                {
                    player.sendMessage(GetCommands().get(i).GetUsage());
                }
            }
        }
        return true;
    }

    public ArrayList<BaseCommand> GetCommands()
    {
        return commands;
    }
}
