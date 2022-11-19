package me.stevethepug.edwardplugin.cmd;

import me.stevethepug.edwardplugin.EdwardPlugin;
import me.stevethepug.edwardplugin.RepeatTask;
import org.bukkit.entity.Player;

import java.util.ArrayList;


enum Setting
{
    day,
    night,
    off,
}

public class SetTime
{
    EdwardPlugin plugin;

    public Setting TimeSetting;

    public ArrayList<RepeatTask> TimelockTasks = new ArrayList<>();

    public SetTime(EdwardPlugin instance)
    {
        plugin = instance;
    }

    public void SetDay(Player player)
    {
        player.getWorld().setTime(1000);
    }

    public void SetNight(Player player)
    {
        player.getWorld().setTime(13000);
    }

    public void Locktime(Player player, String arg)
    {
        if (arg.equalsIgnoreCase("day"))
        {
            if (TimeSetting == Setting.night)
            {
                TimeSetting = Setting.off;
                for (RepeatTask t : TimelockTasks)
                {
                    if (t.GetTaskName().equalsIgnoreCase("night"))
                    {
                        t.CancelTask();
                        player.sendMessage("Time no longer locked");
                    }
                }
            }
            else if (TimeSetting == Setting.day)
            {
                TimeSetting = Setting.off;
                for (RepeatTask t : TimelockTasks)
                {
                    if (t.GetTaskName().equalsIgnoreCase("day"))
                    {
                        t.CancelTask();
                        player.sendMessage("Time no longer locked");
                    }
                }
            }
            else
            {
                TimeSetting = Setting.day;
                LocktimeDay(player);
            }
        }

        if (arg.equalsIgnoreCase("night"))
        {
            if (TimeSetting == Setting.day)
            {
                TimeSetting = Setting.off;
                for (RepeatTask t : TimelockTasks)
                {
                    if (t.GetTaskName().equalsIgnoreCase("day"))
                    {
                        t.CancelTask();
                        player.sendMessage("Time no longer locked");
                        return;
                    }
                }
            }
            else if (TimeSetting == Setting.night)
            {
                TimeSetting = Setting.off;
                for (RepeatTask t : TimelockTasks)
                {
                    if (t.GetTaskName().equalsIgnoreCase("night"))
                    {
                        t.CancelTask();
                        player.sendMessage("Time no longer locked");
                        return;
                    }
                }
            }
            else
            {
                TimeSetting = Setting.night;
                LocktimeNight(player);
            }
        }
    }

    public void LocktimeDay(Player player)
    {
        RepeatTask taskDay = new RepeatTask(plugin, "day", 0, 100)
        {
            @Override
            public void run()
            {
                player.getWorld().setTime(6000);
            }
        };
        TimelockTasks.add(taskDay);
        player.sendMessage("Time locked to Day");
    }

    public void LocktimeNight(Player player)
    {
        RepeatTask taskNight = new RepeatTask(plugin, "night", 0, 100)
        {
            @Override
            public void run()
            {
                player.getWorld().setTime(18000);
            }
        };
        TimelockTasks.add(taskNight);
        player.sendMessage("Time locked to Night");

    }
}
