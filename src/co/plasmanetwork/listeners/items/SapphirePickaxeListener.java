package co.plasmanetwork.listeners.items;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by Corey on 11/12/2016.
 */
public class SapphirePickaxeListener implements Listener {
    static SapphirePickaxeListener instance = new SapphirePickaxeListener();
    OPPrison plugin;

    public SapphirePickaxeListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();

    public static SapphirePickaxeListener getInstance() {
        return instance;
    }

    private SapphirePickaxeListener() {

    }

    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();

    public void startTasks() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getItemInHand().hasItemMeta()) {
                        if (!(p.getItemInHand().hasItemMeta())) {
                            return;
                        }
                        if (!(p.getItemInHand().getItemMeta().hasDisplayName())) {
                            return;
                        }
                        if (!(p.getItemInHand().getType().equals(Material.DIAMOND_PICKAXE))) {
                            return;
                        }
                        if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Sapphire Pickaxe")) {
                            if (!(p.hasPermission(perms.OPPrison_Sapphire_Use))) {
                                return;
                            } // 0 is equal to one. 1 is equal to two. etc.
                            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20, 0));
                        }

                    }
                }
            }
        }, 20L, 20L);
    }

}
