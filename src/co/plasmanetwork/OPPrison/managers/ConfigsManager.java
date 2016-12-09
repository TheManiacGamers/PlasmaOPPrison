package co.plasmanetwork.OPPrison.managers;

import co.plasmanetwork.OPPrison.OPPrison;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by creyn63 on 5/07/2016.
 */
public class ConfigsManager {
    static ConfigsManager instance = new ConfigsManager();
    OPPrison plugin;
    Plugin p;
    FileConfiguration config;
    File cFile;
    FileConfiguration roleplaydata;
    File rpFile;
    FileConfiguration playerData;
    File pData;


    private ConfigsManager() {
    }

    public static ConfigsManager getInstance() {
        return instance;
    }

//inside Settings class {
//public Location getSpawn() {
//gets coords from file, create Location spawn = new Location blah blah
//return spawn;

    public void setup(Plugin p) {
        cFile = new File(p.getDataFolder(), "config.yml");
        if (!cFile.exists()) {
            try {
                cFile.createNewFile();
            } catch (IOException ex) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create config.yml!");

            }
        }
        config = YamlConfiguration.loadConfiguration(cFile);
        //config.options().copyDefaults(true);
        //saveConfig();

        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }

        OPPrison.log("Loaded the config.yml file successfully!");
    }


    public FileConfiguration getConfig() {
        return config;
    }


    public FileConfiguration getRPData() {
        return roleplaydata;
    }

    public void saveConfig() {
        try {
            config.save(cFile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
        }
    }

    public void saveRPData() {
        try {
            roleplaydata.save(rpFile);
        } catch (IOException ex) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save rpData.yml!");
        }

    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cFile);
    }

    public PluginDescriptionFile getDesc() {
        return p.getDescription();
    }

}
