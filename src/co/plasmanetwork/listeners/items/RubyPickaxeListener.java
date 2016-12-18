package co.plasmanetwork.listeners.items;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import co.plasmanetwork.rewards.CustomRewardsListener;
import co.plasmanetwork.utils.Rewards;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Corey on 11/12/2016.
 */
public class RubyPickaxeListener implements Listener {

    static RubyPickaxeListener instance = new RubyPickaxeListener();
    OPPrison plugin;

    public RubyPickaxeListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();

    public static RubyPickaxeListener getInstance() {
        return instance;
    }

    private RubyPickaxeListener() {

    }

    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();

    public void startTasks() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    OPPrison.SEnCU.put(p.getPlayer(), OPPrison.SEnCU.get(p.getPlayer()) + 1);
                    OPPrison.SEnCD.put(p.getPlayer(), OPPrison.SEnCD.get(p.getPlayer()) - 1);
                    if (OPPrison.SEnCU.get(p.getPlayer()) <= 3600) {
                        OPPrison.pickaxeEffects.remove(p.getPlayer());
                        OPPrison.pickaxeEffects.put(p.getPlayer(), "Effects-Pickaxe-Yes");
                        return;
                    }
                    if (OPPrison.SEnCD.get(p.getPlayer()) >= 0) {
                        OPPrison.pickaxeEffects.remove(p.getPlayer());
                        OPPrison.pickaxeEffects.put(p.getPlayer(), "Effects-Pickaxe-Yes");
                    } else {
                        OPPrison.pickaxeEffects.remove(p.getPlayer());
                        OPPrison.pickaxeEffects.put(p.getPlayer(), "Effects-Pickaxe-No");
                    }
                }
            }
        }, 20L, 20L);
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
                        if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Ruby Pickaxe")) {
                            if (!(p.hasPermission(perms.OPPrison_Ruby_Use))) {
                                return;
                            }
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 2));
                        }

                    }
                }
            }
        }, 20L, 20L);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        OPPrison.pickaxeEffects.put(p.getPlayer(), "Effects-Pickaxe-Yes");
        OPPrison.SEnCU.put(p.getPlayer(), 3600); // automatically allowed to use it
        OPPrison.SEnCD.put(p.getPlayer(), 0); // can begin counting down after use
    }

    @EventHandler
    public void onPlayerUseRubySpecialty(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (!(p.getItemInHand().getType().equals(Material.DIAMOND_PICKAXE))) {
                return;
            }
            if (!(p.getItemInHand().hasItemMeta())) {
                return;
            }
            if (!(p.getItemInHand().getItemMeta().hasDisplayName())) {
                return;
            }
            if (!(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Ruby Pickaxe"))) {
                return;
            }
            if (OPPrison.pickaxeEffects.get(p.getPlayer()).equalsIgnoreCase("Effects-Pickaxe-No")) {
                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't use this for another " + ChatColor.DARK_RED + "" + OPPrison.SEnCD.get(p.getPlayer()) + "" + ChatColor.RED + " seconds!");
                return;
            }
            if (OPPrison.pickaxeEffects.get(p.getPlayer()).equalsIgnoreCase("Effects-Pickaxe-Yes")) {
                OPPrison.SEnCD.put(p.getPlayer(), 3600);
                OPPrison.SEnCU.put(p.getPlayer(), 0);
                OPPrison.pickaxeEffects.remove(p.getPlayer());
                OPPrison.pickaxeEffects.put(p.getPlayer(), "Effects-Pickaxe-No");
                if (p.hasPermission("OPPrison.Effects.Pickaxe.Simple") && (!(p.hasPermission("OPPrison.Effects.Pickaxe.Intermediate") && (!(p.hasPermission("OPPrison.Effects.Pickaxe.Advanced")))))) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 1));
                    p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You enabled your boosts! This will last 30 seconds.");
                    p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "There is a 3 minute delay to be able to use this again.");
                    return;
                }
                if (p.hasPermission("OPPrison.Effects.Pickaxe.Intermediate") && (!(p.hasPermission("OPPrison.Effects.Pickaxe.Simple") && (!(p.hasPermission("OPPrison.Effects.Pickaxe.Advanced")))))) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 2));
                    p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You enabled your boosts! This will last 30 seconds.");
                    p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "There is a 3 minute delay to be able to use this again.");
                    return;
                }
                if (p.hasPermission("OPPrison.Effects.Pickaxe.Advanced") && (!(p.hasPermission("OPPrison.Effects.Pickaxe.Simple") && (!(p.hasPermission("OPPrison.Effects.Pickaxe.Intermediate")))))) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 3));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 1));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 1));
                    p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "You enabled your boosts! This will last for 30 seconds.");
                    p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "There is a 3 minute delay to be able to use this again.");
                }
            }
        }
    }

    @EventHandler
    public void onPlayerMineBlock(BlockBreakEvent e) {
        Player p = e.getPlayer();
        int amount = rand.nextInt(19); // 20
        int chance = rand.nextInt(99); // 100
        int moneyAmount = rand.nextInt(499); // 500
        ItemStack ruby = new ItemStack(Material.REDSTONE, amount);
        ItemMeta rubyMeta = ruby.getItemMeta();
        rubyMeta.setDisplayName(ChatColor.RED + "Ruby");
        rubyMeta.setUnbreakable(true);
        rubyMeta.setLore(Arrays.asList(ChatColor.GREEN + "OPPrison currency!", ChatColor.RED + "You can use me at the shop!"));
        ruby.setItemMeta(rubyMeta);
        if (e.getBlock().getType().equals(Material.DIAMOND_BLOCK) || (e.getBlock().getType().equals(Material.GOLD_BLOCK) || (e.getBlock().getType().equals(Material.IRON_BLOCK) || (e.getBlock().getType().equals(Material.EMERALD_BLOCK))))) {
            if (chance == 49) {
                if (amount == 0) {
                    amount = 1;
                }
                if (!(p.hasPermission("OPPrison.Ruby.Use"))) {
                    return;
                }
                if (!(p.getItemInHand().hasItemMeta()) || (p.getItemInHand().getItemMeta().getDisplayName() == null)) {
                    p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You could've won " + ChatColor.DARK_RED + "" + amount + ChatColor.RED + " ruby's and " + ChatColor.DARK_RED + "$" + moneyAmount + ChatColor.RED + "!");
                    p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "Unfortunately, it requires the Ruby Pickaxe, which you can buy from '" + ChatColor.RED + "/warp shop'" + ChatColor.GOLD + "!");
                    return;
                }
                if (!(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Ruby Pickaxe"))) {
                    if (!(p.getItemInHand().getType().equals(Material.DIAMOND_PICKAXE))) {
                        return;
                    }
                    if (e.getBlock().getType().equals(Material.DIAMOND_BLOCK) || (e.getBlock().getType().equals(Material.GOLD_BLOCK) || (e.getBlock().getType().equals(Material.IRON_BLOCK) || (e.getBlock().getType().equals(Material.EMERALD_BLOCK))))) {
                        p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You could've won " + ChatColor.DARK_RED + "" + amount + ChatColor.RED + " ruby's and " + ChatColor.DARK_RED + "$" + moneyAmount + ChatColor.RED + "!");
                        p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "Unfortunately, it requires the Ruby Pickaxe, which you can buy from '" + ChatColor.RED + "/warp shop'" + ChatColor.GOLD + "!");
                        return;
                    }
                    return;
                }
                if (p.getInventory().firstEmpty() < 0) {
                    p.sendMessage(strings.defaultMsgs + ChatColor.RED + "For some reason, I couldn't place your Ruby's in your inventory!");
                    p.sendMessage(strings.defaultMsgs + ChatColor.RED + "I placed " + ChatColor.DARK_RED + "" + amount + ChatColor.RED + " ruby's on the floor instead!");
                    p.getWorld().dropItemNaturally(p.getLocation(), ruby);
                    return;
                }
                p.getInventory().addItem(ruby);
                p.updateInventory();
                if ((amount == 1)) {
                    p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "You found " + ChatColor.RED + "" + amount + ChatColor.GOLD + " ruby!");
                    Rewards.rewardMoney(p.getPlayer(), moneyAmount);
                    p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "You have earned an extra " + ChatColor.RED + "$" + moneyAmount + "" + ChatColor.GOLD + "!");
                } else {
                    p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "You found " + ChatColor.RED + "" + amount + ChatColor.GOLD + " ruby's!");
                    Rewards.rewardMoney(p.getPlayer(), moneyAmount);
                    p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "You have earned an extra " + ChatColor.RED + "$" + moneyAmount + "" + ChatColor.GOLD + "!");
                }
            }
        }
    }
}
