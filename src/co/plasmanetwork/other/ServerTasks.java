package co.plasmanetwork.other;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Corey on 10/12/2016.
 */
public class ServerTasks {

    static ServerTasks instance = new ServerTasks();
    OPPrison plugin;

    public ServerTasks(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();

    public static ServerTasks getInstance() {
        return instance;
    }

    private ServerTasks() {

    }

    public void sendToServer(Player p, String targetServer) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(targetServer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        p.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
    }

    StringsManager strings = StringsManager.getInstance();

    public void startRestartTasks() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(strings.defaultMsgs + ChatColor.BOLD + "Server is restarting in 5 minutes.");
            }
        }, 72000 * 23 + 20 * 60 * 55);
        Bukkit.getScheduler().scheduleSyncDelayedTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(strings.defaultMsgs + ChatColor.BOLD + "Server is restarting in 1 minutes.");
            }
        }, 72000 * 23 + 20 * 60 * 59);
        Bukkit.getScheduler().scheduleSyncDelayedTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(strings.defaultMsgs + ChatColor.BOLD + "Server is restarting in 10 seconds.");
            }
        }, 72000 * 23 + 20 * 60 * 59 + 20 * 50);
        Bukkit.getScheduler().scheduleSyncDelayedTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(strings.defaultMsgs + ChatColor.BOLD + "Server is restarting in 5 seconds.");
            }
        }, 72000 * 23 + 20 * 60 * 59 + 20 * 55);
        Bukkit.getScheduler().scheduleSyncDelayedTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(strings.defaultMsgs + ChatColor.BOLD + "Server is restarting now.");
            }
        }, 72000 * 23 + 20 * 60 * 59 + 20 * 59);
        Bukkit.getScheduler().scheduleSyncDelayedTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    sendToServer(p, "Hub");
                    p.sendMessage(strings.defaultMsgs + ChatColor.RED + "You have been sent to Hub!");
                    p.sendMessage(strings.defaultMsgs + ChatColor.DARK_RED + "Reason: " + ChatColor.RED + "Server is restarting.");
                    /// PUT STUFF TO SAFE IN HERE.
                    /// IMPORTANT TO READ.
                    /// PUT STUFF, SUCH AS, SAVING PLAYER FILES.
                }
                Bukkit.getServer().shutdown();
            }
        }, 1728000);
    }
}

//        t/s = 20
//        t/m = 20*60 = 1200
//        t/h = 20*60*60 = 72000
//        t/day = 20*60*60*24 = 1728000
//        t/week = 20*60*60*24*7 = 12096000
//        t/month(30.4days) = 20*60*60*24*30,4 = 52531200
//        t/year(365.2days) = 20*60*60*24*365,2 = 631065600
