package me.stevethepug.edwardplugin;

import me.stevethepug.edwardplugin.cmd.FunnyEffect;
import me.stevethepug.edwardplugin.cmd.Vanish;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor
{
    EdwardPlugin plugin;

    private ArrayList<BaseCommand> commands = new ArrayList<>();

    public CommandManager(EdwardPlugin instance)
    {
        plugin = instance;
        commands.add(new TntCommand());
        commands.add(new FunnyEffect(instance));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("troll"))
            {
                if (args.length > 0)
                {
                    for (int i = 0; i < GetCommands().size(); i++)
                    {
                        if (args[0].equalsIgnoreCase(GetCommands().get(i).GetName()))
                        {
                            GetCommands().get(i).ExecuteCommand(player, args);
                        }
                    }
                }
                else
                {
                    player.sendMessage("Choose a option");

                    for (int i = 0; i < GetCommands().size(); i++)
                    {
                        player.sendMessage(GetCommands().get(i).GetUsage());
                    }
                }
            }
            else
            {
                if (player.isOp())
                {
                    if (cmd.getName().equalsIgnoreCase("vanish"))
                    {
                        Vanish vanish = new Vanish(plugin);
                        if (args.length == 0)
                        {
                            vanish.VanishPlayer(player);
                        }
                        if (args.length == 1)
                        {
                            String s = args[0];
                            if (Bukkit.getServer().getPlayer(s) != null && Bukkit.getServer().getPlayer(s).getName().equalsIgnoreCase(s))
                            {
                                Player target = Bukkit.getPlayer(s);
                                vanish.VanishPlayer(target);
                            }
                            else
                            {
                                player.sendMessage("Error: Invalid target");
                            }
                        }
                        else
                        {
                            player.sendMessage("Error: Invalid input");
                        }
                    }
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
