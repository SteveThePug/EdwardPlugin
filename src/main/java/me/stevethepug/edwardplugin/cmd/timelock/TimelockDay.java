package me.stevethepug.edwardplugin.cmd.timelock;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.cmd.BaseCommand;
import me.stevethepug.edwardplugin.cmd.SetTime;
import org.bukkit.entity.Player;

public class TimelockDay extends BaseCommand
{
    public TimelockDay(EdwardPlugin instance) {
        super(instance);}
    @Override
    public String GetName()
    {
        return "day";
    }

    @Override
    public String GetUsage()
    {
        return "/timelock day";
    }

    @Override
    public void ExecuteCommand(Player player, String[] args)
    {
        SetTime time = new SetTime(plugin);
        time.LocktimeDay(player);
    }
}
