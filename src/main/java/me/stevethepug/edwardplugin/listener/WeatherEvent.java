package me.stevethepug.edwardplugin.listener;

import me.stevethepug.edwardplugin.EdwardPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvent implements Listener
{
    @EventHandler(priority= EventPriority.HIGHEST)
    public void OnWeatherChange(WeatherChangeEvent event)
    {
        boolean weather = event.toWeatherState();
        if (weather)
            event.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void OnThunderChange(ThunderChangeEvent event)
    {
        boolean thunder = event.toThunderState();
        if(thunder)
            event.setCancelled(true);
    }
}
