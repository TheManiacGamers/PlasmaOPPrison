package co.plasmanetwork.listeners.items;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by Corey on 13/12/2016.
 */
public class QuartzPickaxeListener {

    static QuartzPickaxeListener instance = new QuartzPickaxeListener();
    OPPrison plugin;

    public QuartzPickaxeListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();

    public static QuartzPickaxeListener getInstance() {
        return instance;
    }

    private QuartzPickaxeListener() {

    }

    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();

    @EventHandler
    public void onRandomSpecialQuartz(BlockBreakEvent e) {
        Player p = e.getPlayer();
        int chance = rand.nextInt(50);
        if (chance == 24) {
            // add plasma quartz
        }
    }

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
                        if (!(p.getItemInHand().getType().equals(Material.IRON_PICKAXE))) {
                            return;
                        }
                        if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLACK + "Tr" + ChatColor.MAGIC + "o" + ChatColor.WHITE + "ll" + ChatColor.DARK_RED + " Pickaxe")) {
                            if (!(p.hasPermission(perms.OPPrison_Quartz_Use))) {
                                return;
                            } // 0 is equal to one. 1 is equal to two. etc.
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 0));
                        }

                    }
                }
            }
        }, 20L, 20L);
    }
}
