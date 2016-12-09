package co.plasmanetwork.utils;

import co.plasmanetwork.OPPrison;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Corey on 4/12/2016.
 */
public class Rewards {
    public Economy econ = null;

    public static Rewards instance = new Rewards();
    OPPrison plugin;

    public Rewards(OPPrison plugin) {
        this.plugin = plugin;
    }

    public static Rewards getInstance() {
        return instance;
    }

    public Rewards() {

    }

    public static boolean balance(Player player, double cost) {
        if (OPPrison.econ.hasAccount(player)
                && OPPrison.econ.getBalance(player) >= cost) {
            return true;
        } else {
            return false;
        }
    }

    public static void withdraw(Player player, double cost) {
        OPPrison.econ.withdrawPlayer(player, cost);
        return;
    }

    public static boolean checkXPL(Player player) {
        if ((player.getLevel() < 1)) {
            return false;
        }
        return true;
    }

    public static void giveXPL(Player player, int amount) {
        player.giveExpLevels(amount);
    }

    public static void rewardXP(Player player, int amount) {
        player.giveExp(amount);
    }

    public static void rewardMoney(Player player, double amount) {
        if (OPPrison.econ.hasAccount(player)) {
            OPPrison.econ.depositPlayer(player, amount);
        } else {
            Bukkit.getServer()
                    .broadcastMessage("Something has gone horribly wrong! Specified player does not have an economy account!");
        }
    }
}
