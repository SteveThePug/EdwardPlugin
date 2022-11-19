package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.entity.Player;

public abstract class BaseCommand
{
    public EdwardPlugin plugin;
    public BaseCommand(EdwardPlugin instance) {this.plugin = instance;}
    public abstract String GetName();

    public abstract String GetUsage();

    public abstract void ExecuteCommand(Player player, String args[]);
}
