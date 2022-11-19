package me.stevethepug.edwardplugin;

import me.stevethepug.edwardplugin.cmd.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Set;

public class CommandManager implements CommandExecutor
{
    EdwardPlugin plugin;

    SetTime setTime;

    private ArrayList<BaseCommand> trollCommands = new ArrayList<>();
    private ArrayList<BaseCommand> timelockCommands = new ArrayList<>();

    public CommandManager(EdwardPlugin instance)
    {
        plugin = instance;
        trollCommands.add(new Tnt());
        trollCommands.add(new FunnyEffect(plugin));
        timelockCommands.add(new TimelockDay(plugin));
        timelockCommands.add(new TimelockNight(plugin));
        setTime = new SetTime(plugin);
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
                    for (int i = 0; i < GetTrollCommands().size(); i++)
                    {
                        if (args[0].equalsIgnoreCase(GetTrollCommands().get(i).GetName()))
                        {
                            GetTrollCommands().get(i).ExecuteCommand(player, args);
                        }
                    }
                }
                else
                {
                    player.sendMessage("Choose a option");

                    for (int i = 0; i < GetTrollCommands().size(); i++)
                    {
                        player.sendMessage(GetTrollCommands().get(i).GetUsage());
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
                    if (cmd.getName().equalsIgnoreCase("day"))
                    {
                        setTime.SetDay(player);
                        player.sendMessage("Time set to Day");
                    }
                    if (cmd.getName().equalsIgnoreCase("night"))
                    {
                        setTime.SetNight(player);
                        player.sendMessage("Time set to Night");
                    }
                    if (cmd.getName().equalsIgnoreCase("timelock"))
                    {
                        if (args.length > 0)
                        {
                            for(int i = 0; i < GetTimelockCommands().size(); i++)
                            {
                                if (args[0].equalsIgnoreCase(GetTimelockCommands().get(i).GetName()))
                                {
                                    GetTimelockCommands().get(i).ExecuteCommand(player, args);
                                }
                            }
                        }
                        else
                        {
                            player.sendMessage("Choose a option");

                            for (int i = 0; i < GetTimelockCommands().size(); i++)
                            {
                                player.sendMessage(GetTimelockCommands().get(i).GetUsage());
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public ArrayList<BaseCommand> GetTrollCommands()
    {
        return trollCommands;
    }

    public ArrayList<BaseCommand> GetTimelockCommands()
    {
        return timelockCommands;
    }
}
