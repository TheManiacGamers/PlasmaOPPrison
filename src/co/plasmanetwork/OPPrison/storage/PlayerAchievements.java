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
//public class PlayerAchievements {
//
//    public int iReach10Kills, iReach50Kills, iKillHtgan, iJoin50Times, iJoin100Times, iJoin150Times, iJoin200Times, iReachAKSOf20, totalAchievements;
//    public String Reach10Kills, Reach50Kills, KillyeroC, Join50Times, Join100Times, Join150Times, Join200Times, ReachAKSOf20, ReachGod;
//    OPPrison plugin;
//
//    public PlayerAchievements(Player pl, OPPrison plugin) {
//        this.plugin = plugin;
//        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("PlasmaHub").getDataFolder(), File.separator + "PlayerDatabase");
//        File pFile = new File(userdata, File.separator + pl.getUniqueId() + ".yml");
//        final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);
//        Reach10Kills = playerData.getConfigurationSection("Achievements").getString("Reach10Kills"); //1
//        Reach50Kills = playerData.getConfigurationSection("Achievements").getString("Reach50Kills");//2
//        KillyeroC = playerData.getConfigurationSection("Achievements").getString("KillyeroC");//4
//        Join50Times = playerData.getConfigurationSection("Achievements").getString("Join50Times");//6
//        Join100Times = playerData.getConfigurationSection("Achievements").getString("Join100Times");//7
//        Join150Times = playerData.getConfigurationSection("Achievements").getString("Join150Times");//8
//        Join200Times = playerData.getConfigurationSection("Achievements").getString("Join200Times");//9
//        ReachAKSOf20 = playerData.getConfigurationSection("Achievements").getString("ReachAKSOf20");//10
//        ReachGod = playerData.getConfigurationSection("Achievements").getString("ReachGod");//11
//        totalAchievements = playerData.getConfigurationSection("Stats").getInt("totalAchievements");
//    }
//}