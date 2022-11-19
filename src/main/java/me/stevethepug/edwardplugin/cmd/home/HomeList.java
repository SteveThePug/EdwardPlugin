package me.stevethepug.edwardplugin.cmd.home;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.cmd.BaseCommand;
import org.bukkit.entity.Player;

public class HomeList extends BaseCommand {
    public HomeList(EdwardPlugin instance) {
        super(instance);
    }

    @Override
    public String GetName() {
        return "list";
    }

    @Override
    public String GetUsage() {
        return "/home list";
    }

    @Override
    public void ExecuteCommand(Player player, String[] args) {
        String uuid = player.getUniqueId().toString();
        String path = "homes" + "." + uuid;
        player.sendMessage("Your current homes:");
        for (String homeName : plugin.getConfig().getConfigurationSection(path).getKeys(false)) {player.sendMessage(homeName);};
    }
}
