package co.plasmanetwork.rewards;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by Corey on 11/12/2016.
 */
public class CustomItemListener implements Listener {
    static CustomItemListener instance = new CustomItemListener();
    OPPrison plugin;

    public CustomItemListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();

    public static CustomItemListener getInstance() {
        return instance;
    }

    private CustomItemListener() {

    }

    StringsManager strings = StringsManager.getInstance();

    public void startTasks() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {

            }
        }, 20L, 20L);
    }


}
