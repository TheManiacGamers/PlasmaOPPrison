package co.plasmanetwork.listeners;

import co.plasmanetwork.OPPrison;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

/**
 * Created by Corey on 3/12/2016.
 */
public class WorldListener implements Listener {

    OPPrison plugin;

    public WorldListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    private boolean denyRain = true;
    private boolean denyNight = true;

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        if (!(e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.CUSTOM))) {
            e.setCancelled(true);
        }
    }

    public void onEntityInteract(EntityInteractEvent event) {
        if (event.getBlock().getType() == Material.SOIL && event.getEntity() instanceof LivingEntity)
            event.setCancelled(true);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
    public void onWeatherChange(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(denyRain);
        }
        denyRain = true;
    }

}
