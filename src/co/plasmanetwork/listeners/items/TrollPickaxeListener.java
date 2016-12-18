package co.plasmanetwork.listeners.items;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by Corey on 11/12/2016.
 */
public class TrollPickaxeListener implements Listener {
    static TrollPickaxeListener instance = new TrollPickaxeListener();
    OPPrison plugin;

    public TrollPickaxeListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();

    public static TrollPickaxeListener getInstance() {
        return instance;
    }

    private TrollPickaxeListener() {

    }

    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();

    //ChatColor.BLACK + "Tr" + ChatColor.MAGIC + "o" + ChatColor.WHITE + "ll" + ChatColor.DARK_RED + " Pickaxe"
    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) { // i see no "if (e.getBlock().getType().equals(Material.DIAMOND_BLOCK){ section.
        Player p = e.getPlayer();
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
            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLACK + "Tr" + ChatColor.MAGIC + "o" + ChatColor.WHITE + "ll" + ChatColor.DARK_RED + " Pickaxe")) {
                if (!(p.hasPermission(perms.OPPrison_Troll_Use))) {
                    return;
                }
                int jumpChance = rand.nextInt(50);
                int moveChance = rand.nextInt(20);
                int moveAmount = rand.nextInt(5); // moves up to 5 blocks, randomly, on a random amount of blocks
                int chance = rand.nextInt(30);
                if (chance == 5) {
                    ItemStack temp = p.getInventory().getItemInOffHand();
                    ItemStack mainHand = p.getInventory().getItemInMainHand();
                    p.getInventory().setItemInOffHand(mainHand);
                    p.getInventory().setItemInMainHand(temp);
                    p.updateInventory();
                }
                if (jumpChance == 25) {
                    p.setVelocity(p.getLocation().getDirection().multiply(0).setY(1.2));
                }
//                if (moveChance == 10) {
//                    // idea
//                    World world = Bukkit.getServer().getWorld(p.getLocation().getWorld().getName());
//                    double x = p.getLocation().getX();
//                    double y = p.getLocation().getY();
//                    double z = p.getLocation().getZ();
//                    double yaw = p.getLocation().getYaw();
//                    double pitch = p.getLocation().getPitch();
//                    Location newLoc = new Location(world, x + moveAmount, y, z + moveAmount, (float) yaw, (float) pitch);
//                    p.teleport(newLoc);
//                }
            }
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
                        if (!(p.getItemInHand().getType().equals(Material.DIAMOND_PICKAXE))) {
                            return;
                        }
                        if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLACK + "Tr" + ChatColor.MAGIC + "o" + ChatColor.WHITE + "ll" + ChatColor.DARK_RED + " Pickaxe")) {
                            if (!(p.hasPermission(perms.OPPrison_Troll_Use))) {
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
