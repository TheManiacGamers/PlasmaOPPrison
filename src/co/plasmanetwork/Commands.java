package co.plasmanetwork;

import co.plasmanetwork.managers.ConfigsManager;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import co.plasmanetwork.other.MinesLocations;
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
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

/**
 * Created by Corey on 3/12/2016.
 */
public class Commands {
    StringsManager strings = StringsManager.getInstance();
    ConfigsManager configs = ConfigsManager.getInstance();
    MinesLocations mines = MinesLocations.getInstance();
    OPPrison plugin;
    PermissionsManager perms = PermissionsManager.getInstance();

    public Commands(OPPrison plugin) {
        this.plugin = plugin;
    }

    @Command(aliases = "prestige", desc = "Go back to A, but become prestige!")
    public void onPrestige(CommandContext args, CommandSender sender) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (OPPrison.prestigeConfirm.get(p.getPlayer()).equalsIgnoreCase("No")) {
                p.sendMessage(strings.defaultMsgs + "This will set you back to A, and you will lose all of your money");
                p.sendMessage(strings.defaultMsgs + "Please type /prestige to confirm.");
            } else {

            }
        } else {
            sender.sendMessage(strings.needToBePlayerCMD);
        }
    }

    @Command(aliases = "setsapphire", desc = "Set the location for the Sapphire mine")
    public void onSetSapphire(CommandContext args, CommandSender sender) {
        Player p = (Player) sender;
        Location sapphireLoc = p.getLocation();
        configs.getConfig().set("Sapphire.World", sapphireLoc.getWorld().getName());
        configs.getConfig().set("Sapphire.X", sapphireLoc.getX());
        configs.getConfig().set("Sapphire.Y", sapphireLoc.getY());
        configs.getConfig().set("Sapphire.Z", sapphireLoc.getZ());
        configs.getConfig().set("Sapphire.Yaw", sapphireLoc.getYaw());
        configs.getConfig().set("Sapphire.Pitch", sapphireLoc.getPitch());
        configs.saveConfig();
        sender.sendMessage(strings.prefix + ChatColor.GREEN + "The location of the Sapphire mine has been set to your location!");
    }

    @Command(aliases = "sapphire", desc = "Teleport to the Secret Sapphire mine.")
    public void onPlayerSapphire(CommandContext args, CommandSender sender) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!(p.hasPermission(perms.OPPrison_Commands_Sapphire))) {
                p.sendMessage(strings.noPermissionCMD);
                return;
            }
            if (!(p.getItemInHand().hasItemMeta())) {
                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You must be holding the Sapphire pickaxe to use this feature.");
                return;
            }
            if (!(p.getItemInHand().getItemMeta().hasDisplayName())) {
                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You must be holding the Sapphire pickaxe to use this feature.");
                return;
            }
            if (!(p.getItemInHand().getType().equals(Material.DIAMOND_PICKAXE))) {
                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You must be holding the Sapphire pickaxe to use this feature.");
                return;
            }
            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Sapphire Pickaxe")) {
                if (!(p.hasPermission(perms.OPPrison_Sapphire_Use))) {
                    return;
                }
                if (configs.getConfig().getString("Sapphire") == null) {
                    Bukkit.broadcastMessage(strings.defaultMsgs + ChatColor.RED + "SAPPHIRE LOCATION HAS NOT BEEN SET.");
                    return;
                }
                World world = Bukkit.getServer().getWorld(configs.getConfig().getString("Sapphire.World"));
                double x = configs.getConfig().getDouble("Sapphire.X");
                double y = configs.getConfig().getDouble("Sapphire.Y");
                double z = configs.getConfig().getDouble("Sapphire.Z");
                double yaw = configs.getConfig().getDouble("Sapphire.Yaw");
                double pitch = configs.getConfig().getDouble("Sapphire.Pitch");
                Location spawn = new Location(world, x, y, z, (float) yaw, (float) pitch);
                p.teleport(spawn);
            } else {
                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You must be holding the Sapphire pickaxe to use this feature.");
            }
        } else {
            sender.sendMessage(strings.needToBePlayerCMD);
        }
    }

    @Command(aliases = "opp", desc = "Base command for the OPPrison plugin.", help = "Base command for the OPPrison plugin. Use /opp help")
    public void onPrison(CommandContext args, CommandSender sender) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            if (!(p.hasPermission(perms.OPPrison_Commands))) {
                p.sendMessage(strings.noPermissionCMD);
                return;
            }
            if (args.argsLength() == 0) {
                if (!(p.hasPermission(perms.OPPrison_Commands_Version))) {
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
                        if (!(p.hasPermission(perms.OPPrison_Give_Item_PurrptasticPickaxe))) {
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
                        if (!(p.hasPermission(perms.OPPrison_Give_Item_Ruby))) {
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
                    if (args.getString(1).equalsIgnoreCase("ruby-block")) {
                        if (!(p.hasPermission(perms.OPPrison_Give_Item_Ruby))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack ruby = new ItemStack(Material.REDSTONE_BLOCK, 1);
                        ItemMeta rubyMeta = ruby.getItemMeta();
                        rubyMeta.setDisplayName(ChatColor.RED + "Ruby Block");
                        rubyMeta.setUnbreakable(true);
                        rubyMeta.setLore(Arrays.asList(ChatColor.GREEN + "OPPrison currency in block form!", ChatColor.RED + "You can use me at the shop!", ChatColor.AQUA + "Designed for those expensive items."));
                        ruby.setItemMeta(rubyMeta);
                        p.getInventory().addItem(ruby);
                        p.updateInventory();
                        p.sendMessage(strings.defaultMsgs + "You have been given 1 Ruby Block!");
                        return;
                    }
                    if (args.getString(1).equalsIgnoreCase("ruby-pickaxe")) {
                        if (!(p.hasPermission(perms.OPPrison_Give_Item_RubyPickaxe))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack rubyPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                        ItemMeta rubyPickaxeMeta = rubyPickaxe.getItemMeta();
                        rubyPickaxeMeta.setDisplayName(ChatColor.RED + "Ruby Pickaxe");
                        rubyPickaxeMeta.setLore(Arrays.asList(ChatColor.GREEN + "This pickaxe allows you", ChatColor.GREEN + " to find random Ruby's", ChatColor.GREEN + "  and money whilst mining!", "     ----======----", ChatColor.RED + "Quite Expensive!", ChatColor.RED + "Quite Shiny!", ChatColor.RED + "Definitely worth it!", " ", ChatColor.BLUE + "When in hand:", ChatColor.AQUA + " Speed III"));
                        rubyPickaxeMeta.setUnbreakable(true);
                        rubyPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 15, true);
                        rubyPickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 6, true);
                        rubyPickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                        rubyPickaxe.setItemMeta(rubyPickaxeMeta);
                        p.getInventory().addItem(rubyPickaxe);
                        p.updateInventory();
                        p.sendMessage(strings.defaultMsgs + "You have been given the Ruby Pickaxe!");
                        return;
                    }
                    if (args.getString(1).equalsIgnoreCase("crystal-pickaxe")) {
                        if (!(p.hasPermission(perms.OPPrison_Give_Item_RubyPickaxe))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack crystalPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                        ItemMeta crystalPickaxeMeta = crystalPickaxe.getItemMeta();
                        crystalPickaxeMeta.setDisplayName(ChatColor.BLUE + "Crystal Pickaxe");
                        crystalPickaxeMeta.setLore(Arrays.asList(ChatColor.GREEN + "This pickaxe allows you", ChatColor.GREEN + " to mine in a ", ChatColor.GREEN + "  3 block radius!", "     ----======----", ChatColor.RED + "Totally Expensive!", ChatColor.RED + "Rarest Item!", ChatColor.RED + "What a Wowser!", " ", ChatColor.BLUE + "When in hand:", ChatColor.AQUA + " Speed III", ChatColor.AQUA + " Fire Resistance I", ChatColor.AQUA + " Jump I"));
                        crystalPickaxeMeta.setUnbreakable(true);
                        crystalPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 20, true);
                        crystalPickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
                        crystalPickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                        crystalPickaxe.setItemMeta(crystalPickaxeMeta);
                        p.getInventory().addItem(crystalPickaxe);
                        p.updateInventory();
                        p.sendMessage(strings.defaultMsgs + "You have been given the Crystal Pickaxe!");
                        return;
                    }
                    if (args.getString(1).equalsIgnoreCase("sapphire-pickaxe")) {
                        if (!(p.hasPermission(perms.OPPrison_Give_Item_RubyPickaxe))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack sapphirePickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                        ItemMeta sapphirePickaxeMeta = sapphirePickaxe.getItemMeta();
                        sapphirePickaxeMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Sapphire Pickaxe");
                        sapphirePickaxeMeta.setLore(Arrays.asList(ChatColor.GREEN + "/sapphire to access a special mine,", ChatColor.GREEN + " you must be holding me", ChatColor.GREEN + "  to access the mine!", "     ----======----", ChatColor.RED + "Is it worth it?!", ChatColor.RED + "Sounds pretty cool!", ChatColor.RED + "I likey!", " ", ChatColor.BLUE + "When in hand:", ChatColor.AQUA + " Jump I"));
                        sapphirePickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 4, true);
                        sapphirePickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                        sapphirePickaxeMeta.addEnchant(Enchantment.DURABILITY, 5, true);
                        sapphirePickaxe.setItemMeta(sapphirePickaxeMeta);
                        p.getInventory().addItem(sapphirePickaxe);
                        p.updateInventory();
                        p.sendMessage(strings.defaultMsgs + "You have been given the Sapphire Pickaxe!");
                        return;
                    }
                    if (args.getString(1).equalsIgnoreCase("troll-pickaxe")) {
                        if (!(p.hasPermission(perms.OPPrison_Give_Item_RubyPickaxe))) {
                            p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You can't give yourself this item.");
                            return;
                        }
                        ItemStack trollPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
                        ItemMeta trollPickaxeMeta = trollPickaxe.getItemMeta();
                        trollPickaxeMeta.setDisplayName(ChatColor.BLACK + "Tr" + ChatColor.MAGIC + "o" + ChatColor.WHITE + "ll" + ChatColor.DARK_RED + " Pickaxe");
                        trollPickaxeMeta.setLore(Arrays.asList(ChatColor.GREEN + "One of the fastest pickaxe's on OPPrison,", ChatColor.GREEN + " but are you willing to put up", ChatColor.GREEN + "  with it's flaws? Have fun.", "     ----======----", ChatColor.RED + "Trololol!", ChatColor.RED + "Random Potion Effects, good and bad!", ChatColor.RED + "Might occasionally leave your hand.", " ", ChatColor.BLUE + "When in hand:", ChatColor.AQUA + " Unlucky V", ChatColor.AQUA + " Speed I"));
                        trollPickaxeMeta.setUnbreakable(true);
                        trollPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 50, true); // omg xDD imagine that efficiency 600
                        trollPickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 14, true);
                        trollPickaxeMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);
                        trollPickaxe.setItemMeta(trollPickaxeMeta);
                        p.getInventory().addItem(trollPickaxe);
                        p.updateInventory();
                        p.sendMessage(strings.defaultMsgs + "You have been given the Troll Pickaxe!");
                    } else {
                        p.sendMessage(strings.incorrectArgs);
                        p.sendMessage(strings.incorrectArgsFix + "<purrptastic-pickaxe, ruby, ruby-block, ruby-pickaxe, crystal-pickaxe, sapphire-pickaxe, troll-pickaxe>");
                    }
                }
            } else {
                sender.sendMessage(strings.tooManyArgs);
            }
        } else

        {
            sender.sendMessage(strings.needToBePlayerCMD);
        }
    }
}