package co.plasmanetwork.OPPrison.other;

import co.plasmanetwork.OPPrison.OPPrison;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

/**
 * Created by Corey on 6/12/2016.
 */
public class MinesLocations {
    OPPrison plugin;
    File minesFile;
    FileConfiguration minesFileConf;
    static MinesLocations instance = new MinesLocations();
    FileConfiguration config;
    File cFile;
    FileConfiguration roleplaydata;
    File rpFile;
    FileConfiguration playerData;
    File pData;


    private MinesLocations() {
    }

    public static MinesLocations getInstance() {
        return instance;
    }

    public void setup(OPPrison p) {
        minesFile = new File(p.getDataFolder(), "mines.yml");
        if (!minesFile.exists()) {
            try {
                minesFile.createNewFile();
            } catch (IOException ex) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create mines.yml!");

            }
        }
        minesFileConf = YamlConfiguration.loadConfiguration(minesFile);
    }

    public FileConfiguration getConfig() {
        return minesFileConf;
    }

    public void reloadConfig() {
        minesFileConf = YamlConfiguration.loadConfiguration(minesFile);
    }

    public void saveMines() {
        try {
            minesFileConf.save(minesFile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save mines.yml!");
        }
    }


}