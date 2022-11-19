package me.stevethepug.edwardplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class RepeatTask implements Runnable
{
    private String taskName;
    private int taskId;

    public RepeatTask(EdwardPlugin plugin, String s, int i, int j)
    {
        taskName = s;
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, i, j);
    }

    public void CancelTask()
    {
        Bukkit.getScheduler().cancelTask(taskId);
    }

    public String GetTaskName()
    {
        return taskName;
    }
}
