package co.plasmanetwork.other;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import co.plasmanetwork.utils.BountifulAPI;
import com.sk89q.minecraft.util.commands.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by Corey on 4/12/2016.
 */
public class Tasks {
    public Economy econ = null;


    static Tasks instance = new Tasks();
    OPPrison plugin;

    public Tasks(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();
    String sneakingFor = "1";
    PermissionsManager perms = PermissionsManager.getInstance();

    public static Tasks getInstance() {
        return instance;
    }

    private Tasks() {

    }

    StringsManager strings = StringsManager.getInstance();

    public void startTasks() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.setFoodLevel(20);
                }
            }
        }, 20L, 20L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (OPPrison.sneakingFor.get(p.getPlayer()) == null) {
                        OPPrison.sneakingFor.put(p.getPlayer(), 0);
                    }
                    if (p.isSneaking()) {
                        if (!(p.hasPermission(perms.OPPrison_Sneak_Launch))) {
                            return;
                        }
                        OPPrison.sneakingFor.put(p.getPlayer(), OPPrison.sneakingFor.get(p.getPlayer()) + 1);
                        if (OPPrison.sneakingFor.get(p.getPlayer()).equals(10)) {
                            if (p.getLocation().getWorld().getName().equalsIgnoreCase("mines")) {
                                if (p.getLocation().getY() <= 14) {
                                    p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(5));
                                    OPPrison.sneakingFor.remove(p.getPlayer());
                                    OPPrison.sneakingFor.put(p.getPlayer(), 0);
                                } else {
                                    p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You are not low enough to use this feature.");
                                }
                            } else {
                                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can only use this feature in the mines world.");
                            }
                        }
                    } else {
                        OPPrison.sneakingFor.remove(p.getPlayer());
                        OPPrison.sneakingFor.put(p.getPlayer(), 0);
                    }
                }
            }
        }, 20L, 20L);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    if (OPPrison.onlineFor.get(online.getPlayer()) == null) {
                        OPPrison.onlineFor.put(online.getPlayer(), 0);
                    }
//                    if (OPPrison.onlineFor.get(online.getPlayer()) >= 0) {
//                        OPPrison.onlineFor.put(online.getPlayer(), 0);
//                    }
                    OPPrison.onlineFor.put(online.getPlayer(), OPPrison.onlineFor.get(online.getPlayer()) + 1);
                }
            }
        }, 20, 20L); // should be 1 second
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!(p.hasPermission(perms.OPPrison_Effects_Online))) {
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600)) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 6, 2));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 1 hour, here's a potion effect!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 2)) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 6, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 6, 1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 2 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 3)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 6, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 6, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * 6, 1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 3 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 4)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 6, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 6, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * 6, 1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 4 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 5)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200 * 6, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 6, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 6, 1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 5 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 6)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * 6, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 6, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 6, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200 * 6, 2));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 6 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 7)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * 10, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 10, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 10, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200 * 10, 5));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 7 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 8)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 10, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 10, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * 10, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200 * 10, 5));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 8 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 9)) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 10, 7));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 10, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * 10, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200 * 10, 6));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 9 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 10)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 10, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 10, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200 * 10, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * 10, 3));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 10 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 11)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 10, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 10, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 10, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 10, 1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 11 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 12)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 10, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 10, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 10, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 10, 1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 12 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 13)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 14, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 14, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 14, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 14, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 14, 1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 13 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 14)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 14, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 14, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 14, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 14, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 14, 2));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 14 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 15)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 14, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 14, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 14, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 14, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 14, 4));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 15, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 16)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 14, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 14, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 14, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 14, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 14, 5));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 16 hours here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 17)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 14, 7));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 14, 8));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 14, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 14, 5));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 14, 5));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 17 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 18)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 14, 8));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 14, 7));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 14, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 14, 7));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 14, 7));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 18 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 19)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 20, 10));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 20, 8));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 20, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 20, 8));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 20, 9));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 19 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 20)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 20, 12));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 20, 10));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 20, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 20, 10));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 20, 10));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 20 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 21)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 20, 14));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 20, 12));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 20, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 20, 12));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 20, 12));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 21 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 22)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 20, 15));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 20, 14));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 20, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 20, 14));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 20, 12));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 22 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 23)) {

                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 20, 16));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 20, 16));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 20, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 20, 15));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 20, 14));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 23 hours, here's some potion effects!");
                        return;
                    }
                    if (OPPrison.onlineFor.get(p.getPlayer()).equals(3600 * 24)) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200 * 20, 20));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * 20, 20));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * 20, 6));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * 20, 20));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200 * 20, 20));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 20, 20);
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You have been online for 24 hours, here's some potion effects!");
                    } else {
                        return;
                    }

                }
            }
        }, 20L, 20L); // should be 1 second
    }
}
