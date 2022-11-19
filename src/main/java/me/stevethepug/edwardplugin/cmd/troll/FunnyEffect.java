package me.stevethepug.edwardplugin.cmd.troll;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.cmd.BaseCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FunnyEffect extends BaseCommand
{
    private EdwardPlugin plugin;

    public FunnyEffect(EdwardPlugin instance) {
        super(instance);
    }


    @Override
    public String GetName()
    {
        return "funny";
    }

    @Override
    public String GetUsage()
    {
        return "/troll funny";
    }

    @Override
    public void ExecuteCommand(Player player, String[] args)
    {
        Location loc = player.getLocation();
        CreateParticle(Particle.FIREWORKS_SPARK, loc, 1000, 4, 10, 2000);
    }

    public void CreateParticle(Particle particle, Location loc, int amount, int repeat, long delay, long timer)
    {
        new BukkitRunnable()
        {
            private int i = 0;
            public void run()
            {
                if (i >= repeat)
                {
                    cancel();
                }
                i++;
                loc.getWorld().spawnParticle(particle, loc, amount);
            }
        }.runTaskTimer(plugin, delay, timer);

        Bukkit.broadcastMessage("Finished");
    }
}

        /*BukkitTask task = new BukkitRunnable()
        {
            int i = 0;
            @Override
            public void run()
            {
                i++;
                if (i )

            }
        }.runTaskTimer(plugin, delay, timer);
        Bukkit.broadcastMessage("Finished");*/

