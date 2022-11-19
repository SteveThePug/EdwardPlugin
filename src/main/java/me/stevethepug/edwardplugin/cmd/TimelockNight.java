package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.entity.Player;

public class TimelockNight extends BaseCommand
{
    private EdwardPlugin plugin;

    public TimelockNight(EdwardPlugin instance) {this.plugin = instance;}

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
