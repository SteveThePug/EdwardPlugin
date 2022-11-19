package me.stevethepug.edwardplugin.cmd.timelock;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.cmd.BaseCommand;
import me.stevethepug.edwardplugin.cmd.SetTime;
import org.bukkit.entity.Player;

public class TimelockNight extends BaseCommand
{

    public TimelockNight(EdwardPlugin instance) {super(instance);}

    @Override
    public String GetName()
    {
        return "night";
    }

    @Override
    public String GetUsage()
    {
        return "/timelock night";
    }

    @Override
    public void ExecuteCommand(Player player, String[] args)
    {
        SetTime time = new SetTime(plugin);
        time.LocktimeNight(player);
    }
}
