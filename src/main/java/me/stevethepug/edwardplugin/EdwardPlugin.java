package me.stevethepug.edwardplugin;

import me.stevethepug.edwardplugin.cmd.FunnyEffect;
import me.stevethepug.edwardplugin.cmd.Vanish;
import me.stevethepug.edwardplugin.listener.PlayerJoin;
import me.stevethepug.edwardplugin.listener.WeatherEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

//Yo bro, this my plugin, and it all about doing funny shit too edward. Period. Bro.
public final class EdwardPlugin extends JavaPlugin {

    GeneratorManager genManager = new GeneratorManager();
    public ArrayList<Player> vanishedPlayers =   new ArrayList<>();

    // Just random tracking shit
    public boolean IsTimeLockedDay = false;
    public boolean IsTimeLockedNight = false;


    // Its gotta be enabled init
    @Override
    public void onEnable() {
        System.out.println("Yo ma drillah");


        // Add our commands yo
        this.getCommand("vanish").setExecutor(new CommandManager(this));
        this.getCommand("troll").setExecutor(new CommandManager(this));
        this.getCommand("timelock").setExecutor(new CommandManager(this));

        PluginManager pm = getServer().getPluginManager();

        // Add our listeners yo
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new WeatherEvent(), this);
    }

    // Disabled also because we smart donnys
    @Override
    public void onDisable() {
        System.out.println("Bye my gringo");
    }
}
