package co.plasmanetwork.OPPrison;

import co.plasmanetwork.OPPrison.managers.ConfigsManager;
import co.plasmanetwork.OPPrison.managers.StringsManager;
import co.plasmanetwork.OPPrison.other.MinesLocations;
import com.sk89q.minecraft.util.commands.ChatColor;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Created by Corey on 3/12/2016.
 */
public class Commands {
    StringsManager strings = StringsManager.getInstance();
    ConfigsManager configs = ConfigsManager.getInstance();
    MinesLocations mines = MinesLocations.getInstance();
    OPPrison plugin;

    public Commands(OPPrison plugin) {
        this.plugin = plugin;
    }

    @Command(aliases = "opp", desc = "Base command for the OPPrison plugin.", help = "Base command for the OPPrison plugin. Use /opp help")
    public void onPrison(CommandContext args, CommandSender sender) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            if (!(p.hasPermission("OPPrison.Commands"))) {
                p.sendMessage(strings.noPermissionCMD);
                return;
            }
            if (args.argsLength() == 0) {
                if (!(p.hasPermission("OPPrison.Commands.Version"))) {
                    p.sendMessage(strings.noPermissionCMD);
                    return;
                }
                sender.sendMessage(strings.nothingToDisplay);
                return;
            }
            if (args.argsLength() == 1) {
                if (!(p.hasPermission("OPPrison.Commands.HERE"))) {
                    p.sendMessage(strings.noPermissionCMD);
                    return;
                }
                sender.sendMessage(strings.nothingToDisplay);
                return;
            }
            if (args.argsLength() == 2) {
                if (args.getString(0).equalsIgnoreCase("item")) {
                    if (args.getString(1).equalsIgnoreCase("purrptastic-pickaxe")) {
                        if (!(p.hasPermission("OPPrison.Give.Item.PurrptasticPickaxe"))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack luckyPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                        ItemMeta lpMeta = luckyPickaxe.getItemMeta();
                        lpMeta.setDisplayName(ChatColor.GOLD + "Purrptastic Pickaxe");
                        lpMeta.setLore(Arrays.asList(ChatColor.GREEN + "Use this Purrptastic Pickaxe to receive crazy prizes!", ChatColor.RED + "This can only be used on PurPur blocks."));
                        lpMeta.addEnchant(Enchantment.ARROW_DAMAGE, 100, true);
                        lpMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
                        lpMeta.addEnchant(Enchantment.DAMAGE_ALL, 15, true);
                        lpMeta.setUnbreakable(true);
                        luckyPickaxe.setItemMeta(lpMeta);
                        p.getInventory().addItem(luckyPickaxe);
                        p.updateInventory();
                        sender.sendMessage(strings.defaultMsgs + "You have been given the Purrptastic Pickaxe!");
                        return;
                    }
                    if (args.getString(1).equalsIgnoreCase("ruby")) {
                        if (!(p.hasPermission("OPPrison.Give.Item.Ruby"))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack ruby = new ItemStack(Material.REDSTONE, 64);
                        ItemMeta rubyMeta = ruby.getItemMeta();
                        rubyMeta.setDisplayName(ChatColor.RED + "Ruby");
                        rubyMeta.setUnbreakable(true);
                        rubyMeta.setLore(Arrays.asList(ChatColor.GREEN + "OPPrison currency!", ChatColor.RED + "You can use me at the shop!"));
                        ruby.setItemMeta(rubyMeta);
                        p.getInventory().addItem(ruby);
                        p.updateInventory();
                        p.sendMessage(strings.defaultMsgs + "You have been given 64 Ruby's!");
                        return;
                    }
                    if (args.getString(1).equalsIgnoreCase("ruby-pickaxe")) {
                        if (!(p.hasPermission("OPPrison.Give.Item.RubyPickaxe"))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack rubyPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                        ItemMeta rubyPickaxeMeta = rubyPickaxe.getItemMeta();
                        rubyPickaxeMeta.setDisplayName(ChatColor.RED + "Ruby Pickaxe");
                        rubyPickaxeMeta.setLore(Arrays.asList(ChatColor.GREEN + "This pickaxe allows you", ChatColor.GREEN + " to find random Ruby's", ChatColor.GREEN + "  and money whilst mining!", "     ----======----", ChatColor.RED + "Quite Expensive!", ChatColor.RED + "Quite Shiny!", ChatColor.RED + "Definitely worth it!"));
                        rubyPickaxeMeta.setUnbreakable(true);
                        rubyPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 15, true);
                        rubyPickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 6, true);
                        rubyPickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                        rubyPickaxe.setItemMeta(rubyPickaxeMeta);
                        p.getInventory().addItem(rubyPickaxe);
                        p.updateInventory();
                        p.sendMessage(strings.defaultMsgs + "You have been given the Ruby Pickaxe!");
                    } else {
                        p.sendMessage(strings.incorrectArgs);
                        p.sendMessage(strings.incorrectArgsFix + "<purrptastic-pickaxe, ruby, ruby-pickaxe>");
                    }
                }
            } else {
                sender.sendMessage(strings.tooManyArgs);
            }
        } else {
            sender.sendMessage(strings.needToBePlayerCMD);
        }
    }
}