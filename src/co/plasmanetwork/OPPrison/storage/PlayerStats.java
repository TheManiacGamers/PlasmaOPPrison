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
// * Created by Corey on 5/11/2016.
// */
//public class PlayerStats {
//
//    public int kills, deaths, highestks, level, xptonxtlevel, killstreak, totalLogins;
//    OPPrison plugin;
//
//    public PlayerStats(Player pl, OPPrison plugin) {
//        this.plugin = plugin;
//        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PlasmaHub").getDataFolder(), File.separator + "PlayerDatabase");
//        File pFile = new File(userdata, File.separator + pl.getUniqueId() + ".yml");
//        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
//        kills = playerData.getConfigurationSection("Stats").getInt("Kills");
//        deaths = playerData.getConfigurationSection("Stats").getInt("Deaths");
//        highestks = playerData.getConfigurationSection("Stats").getInt("HighestKS");
//        level = playerData.getConfigurationSection("Stats").getInt("Level");
//        xptonxtlevel = playerData.getConfigurationSection("Stats").getInt("XPtoNxtLvl");
//        killstreak = playerData.getConfigurationSection("Stats").getInt("Killstreak");
//        totalLogins = playerData.getConfigurationSection("Stats").getInt("totalLogins");
//    }
//}