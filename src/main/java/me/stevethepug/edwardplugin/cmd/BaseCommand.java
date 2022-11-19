package me.stevethepug.edwardplugin.cmd;

import org.bukkit.entity.Player;

public abstract class BaseCommand
{
    public abstract String GetName();

    public abstract String GetUsage();

    public abstract void ExecuteCommand(Player player, String args[]);
}
