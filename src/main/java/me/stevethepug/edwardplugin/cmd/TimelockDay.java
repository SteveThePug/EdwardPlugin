package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.entity.Player;

public class TimelockDay extends BaseCommand
{
    private EdwardPlugin plugin;

    public TimelockDay(EdwardPlugin instance) {this.plugin = instance;}
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
