package me.stevethepug.edwardplugin.cmd.home;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.cmd.BaseCommand;
import org.bukkit.entity.Player;

public class HomeRemove extends BaseCommand {
    public HomeRemove(EdwardPlugin instance) {
        super(instance);
    }

    @Override
    public String GetName() {
        return "remove";
    }

    @Override
    public String GetUsage() {
        return "/home remove <home_name>";
    }

    @Override
    public void ExecuteCommand(Player player, String[] args) {
        String uuid = player.getUniqueId().toString();
        if (args.length == 2)
        {
            String homeName = args[1];
            String path = "homes" + "." + uuid + "." + homeName;

            player.sendMessage("Removing home: " + homeName);
            plugin.getConfig().set(path, null);
        }
        else
        {
            player.sendMessage(GetUsage());
        }
    }
}
