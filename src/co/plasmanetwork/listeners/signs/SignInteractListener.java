package co.plasmanetwork.listeners.signs;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import co.plasmanetwork.other.MinesLocations;
import co.plasmanetwork.utils.Rewards;
import com.sk89q.minecraft.util.commands.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Corey on 11/12/2016.
 */
public class SignInteractListener implements Listener {
    OPPrison plugin;
    public Economy econ = null;

    public SignInteractListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();
    MinesLocations mLoc = MinesLocations.getInstance();

    int redstone = 1;
    int redstoneOre = redstone + 1;
    int redstoneBlock = redstone * 9;
    int gold = 1;
    int goldOre = gold + 1;
    int goldBlock = gold * 9;
    int emerald = 1;
    int emeraldOre = emerald + 1;
    int emeraldBlock = emerald * 9;
    int iron = 1;
    int ironOre = iron + 1;
    int ironBlock = iron * 9;
    int diamond = 5;
    int diamondOre = diamond + 1;
    int diamondBlock = diamond * 9;
    int coal = 2;
    int coalOre = coal + 1;
    int coalBlock = coal * 9;
    int lapis = 1;
    int lapisOre = lapis + 1;
    int lapisBlock = lapis * 9;
    int woodPlank = 1;
    int woodLog = woodPlank * 4;
    int cobblestone = 1;
    int stone = cobblestone + 1;


    int totalCash = 0;
    int diamondBlockTotalCash = 0;
    int goldBlockTotalCash = 0;
    int redstoneBlockTotalCash = 0;
    int redstoneOreTotalCash = 0;
    int redstoneTotalCash = 0;
    int goldOreTotalCash = 0;
    int goldTotalCash = 0;
    int emeraldBlockTotalCash = 0;
    int emeraldOreTotalCash = 0;
    int emeraldTotalCash = 0;
    int ironBlockTotalCash = 0;
    int ironOreTotalCash = 0;
    int ironTotalCash = 0;
    int diamondOreTotalCash = 0;
    int diamondTotalCash = 0;
    int coalBlockTotalCash = 0;
    int coalOreTotalCash = 0;
    int coalTotalCash = 0;
    int lapisBlockTotalCash = 0;
    int lapisOreTotalCash = 0;
    int lapisTotalCash = 0;
    int woodPlankTotalCash = 0;
    int woodLogTotalCash = 0;
    int stoneTotalCash = 0;
    int cobblestoneTotalCash = 0;

    @EventHandler
    public void signCreation(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Sell]")) {
            if (event.getPlayer().hasPermission(perms.OPPrison_Sign_Sell_Create)) {

                String l0 = event.getLine(0);
                String l1 = event.getLine(1);
                String l2 = event.getLine(2);
                String l3 = event.getLine(3);

                event.setLine(0, ChatColor.GOLD + "" + ChatColor.BOLD + "[Sell]");
                event.setLine(1, ChatColor.GREEN + "" + ChatColor.BOLD + "OPPrison");
                event.setLine(2, ChatColor.BLUE + "" + ChatColor.BOLD + "Sell your");
                event.setLine(3, ChatColor.BLUE + "" + ChatColor.BOLD + "Items here");
            } else {
                event.getPlayer().sendMessage(strings.noPermissionPlace);
            }
        }
    }

    public static int getAmount(Player player, Material mat) {
        PlayerInventory inventory = player.getInventory();
        ItemStack[] items = inventory.getContents();
        int has = 0;
        for (ItemStack item : items) {
            if ((item != null) && (item.getType() == mat) && (item.getAmount() > 0)) {
                has += item.getAmount();
            }

        }
        return has;
    }

    @EventHandler
    public void onPlayerInteractSign(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block blockClicked = e.getClickedBlock();
            if (blockClicked.getType() == Material.WALL_SIGN || blockClicked.getType() == Material.SIGN_POST) {
                Sign sign = (Sign) blockClicked.getState();

                // SELL SIGNS
                // MINE A
                if (sign.getLine(0).equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "[Sell]")) {
                    if (sign.getLine(1).equalsIgnoreCase(ChatColor.GREEN + "" + ChatColor.BOLD + "OPPrison")) {
                        if (p.hasPermission(perms.OPPrison_Sign_Sell_Use)) {
                            totalCash = 0;
                            if (p.getInventory().contains(Material.STONE)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.STONE);
                                int dollarAmountStone = itemAmount * stone;
                                p.getInventory().remove(Material.STONE);
                                stoneTotalCash = dollarAmountStone;
                            }
                            if (p.getInventory().contains(Material.COBBLESTONE)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.COBBLESTONE);
                                int dollarAmountCobblestone = itemAmount * cobblestone;
                                p.getInventory().remove(Material.COBBLESTONE);
                                cobblestoneTotalCash = dollarAmountCobblestone;
                            }
                            if (p.getInventory().contains(Material.COAL)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.COAL);
                                int dollarAmountCoal = itemAmount * coal;
                                p.getInventory().remove(Material.COAL);
                                coalTotalCash = dollarAmountCoal;
                            }
                            if (p.getInventory().contains(Material.COAL_ORE)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.COAL_ORE);
                                int dollarAmountCoalOre = itemAmount * coalOre;
                                p.getInventory().remove(Material.COAL_ORE);
                                coalOreTotalCash = dollarAmountCoalOre;
                            }
                            if (p.getInventory().contains(Material.COAL_BLOCK)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.COAL_BLOCK);
                                int dollarAmountCoalBlock = itemAmount * coalBlock;
                                p.getInventory().remove(Material.COAL_BLOCK);
                                coalBlockTotalCash = dollarAmountCoalBlock;
                            }
                            if (p.getInventory().contains(Material.IRON_INGOT)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.IRON_INGOT);
                                int dollarAmountIron = itemAmount * iron;
                                p.getInventory().remove(Material.IRON_INGOT);
                                ironTotalCash = dollarAmountIron;
                            }
                            if (p.getInventory().contains(Material.IRON_ORE)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.IRON_ORE);
                                int dollarAmountIronOre = itemAmount * ironOre;
                                p.getInventory().remove(Material.IRON_ORE);
                                ironOreTotalCash = dollarAmountIronOre;
                            }
                            if (p.getInventory().contains(Material.IRON_BLOCK)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.COAL);
                                int dollarAmountIronBlock = itemAmount * ironBlock;
                                p.getInventory().remove(Material.COAL);
                                ironBlockTotalCash = dollarAmountIronBlock;
                            }
                            if (p.getInventory().contains(Material.GOLD_ORE)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.GOLD_ORE);
                                int dollarAmountGoldOre = itemAmount * goldOre;
                                p.getInventory().remove(Material.GOLD_ORE);
                                goldOreTotalCash = dollarAmountGoldOre;
                            }
                            if (p.getInventory().contains(Material.GOLD_INGOT)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.GOLD_INGOT);
                                int dollarAmountGold = itemAmount * gold;
                                p.getInventory().remove(Material.GOLD_INGOT);
                                goldTotalCash = dollarAmountGold;
                            }
                            if (p.getInventory().contains(Material.GOLD_BLOCK)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.GOLD_BLOCK);
                                int dollarAmountGoldBlock = itemAmount * goldBlock;
                                p.getInventory().remove(Material.GOLD_BLOCK);
                                goldBlockTotalCash = dollarAmountGoldBlock;
                            }
                            if (p.getInventory().contains(Material.DIAMOND_ORE)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.DIAMOND_ORE);
                                int dollarAmountDiamondOre = itemAmount * diamondOre;
                                p.getInventory().remove(Material.DIAMOND_ORE);
                                diamondOreTotalCash = dollarAmountDiamondOre;
                            }
                            if (p.getInventory().contains(Material.DIAMOND)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.DIAMOND);
                                int dollarAmountDiamond = itemAmount * diamond;
                                p.getInventory().remove(Material.DIAMOND);
                                diamondTotalCash = dollarAmountDiamond;
                            }
                            if (p.getInventory().contains(Material.DIAMOND_BLOCK)) {
                                int itemAmount = getAmount(p.getPlayer(), Material.DIAMOND_BLOCK);
                                int dollarAmountDiamondBlock = itemAmount * diamondBlock;
                                p.getInventory().remove(Material.DIAMOND_BLOCK);
                                diamondBlockTotalCash = dollarAmountDiamondBlock;
                            }
                            totalCash = diamondBlockTotalCash +
                                    goldBlockTotalCash +
                                    redstoneBlockTotalCash +
                                    redstoneOreTotalCash +
                                    redstoneTotalCash +
                                    goldOreTotalCash +
                                    goldTotalCash +
                                    emeraldBlockTotalCash +
                                    emeraldOreTotalCash +
                                    emeraldTotalCash +
                                    ironBlockTotalCash +
                                    ironOreTotalCash +
                                    ironTotalCash +
                                    diamondOreTotalCash +
                                    diamondTotalCash +
                                    coalBlockTotalCash +
                                    coalOreTotalCash +
                                    coalTotalCash +
                                    lapisBlockTotalCash +
                                    lapisOreTotalCash +
                                    lapisTotalCash +
                                    woodPlankTotalCash +
                                    woodLogTotalCash +
                                    stoneTotalCash +
                                    cobblestoneTotalCash;
                            if (totalCash == 0) {
                                p.sendMessage(strings.noItemsToSell);
                                totalCash = 0;
                                return;
                            }
                            p.sendMessage(strings.defaultMsgs + ChatColor.GOLD + "You earned $" + ChatColor.RED + totalCash + ChatColor.GOLD + " from selling those items!");
                            Rewards.rewardMoney(p, totalCash);
                            p.updateInventory();
                            diamondBlockTotalCash = 0;
                            goldBlockTotalCash = 0;
                            redstoneBlockTotalCash = 0;
                            redstoneOreTotalCash = 0;
                            redstoneTotalCash = 0;
                            goldOreTotalCash = 0;
                            goldTotalCash = 0;
                            emeraldBlockTotalCash = 0;
                            emeraldOreTotalCash = 0;
                            emeraldTotalCash = 0;
                            ironBlockTotalCash = 0;
                            ironOreTotalCash = 0;
                            ironTotalCash = 0;
                            diamondOreTotalCash = 0;
                            diamondTotalCash = 0;
                            coalBlockTotalCash = 0;
                            coalOreTotalCash = 0;
                            coalTotalCash = 0;
                            lapisBlockTotalCash = 0;
                            lapisOreTotalCash = 0;
                            lapisTotalCash = 0;
                            woodPlankTotalCash = 0;
                            woodLogTotalCash = 0;
                            stoneTotalCash = 0;
                            cobblestoneTotalCash = 0;
                            totalCash = 0;
                        }
                    }
                }

                // BUY SIGNS
                if (sign.getLine(1).equalsIgnoreCase("[Buy]")) {
                    if (p.hasPermission(perms.OPPrison_Sign_Buy_Use)) {

                    }
                }
            }
        }
    }
}