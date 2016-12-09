//package co.plasmanetwork.OPPrison.storage;
//
//import co.plasmanetwork.OPPrison.OPPrison;
//import org.bukkit.Bukkit;
//import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
//import org.bukkit.entity.Player;
//
//import java.io.File;
//
///**
// * Created by creyn63 on 5/07/2016.
// */
//public class PlayerInformation {
//
//    OPPrison plugin;
//
//    public int BALANCE;
//    public String GROUP;
//
//    public PlayerInformation(Player pl, OPPrison plugin) {
//        this.plugin = plugin;
//        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PlasmaHub").getDataFolder(), File.separator + "PlayerDatabase");
//        File pFile = new File(userdata, File.separator + pl.getUniqueId() + ".yml");
//        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
//        GROUP = playerData.getConfigurationSection("Options").getString("Group");
//    }
//
//
//}
