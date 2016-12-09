package co.plasmanetwork.OPPrison.utils;

import co.plasmanetwork.OPPrison.OPPrison;
import co.plasmanetwork.OPPrison.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by creyn63 on 5/07/2016.
 */
public class CoreysAPI {
    OPPrison plugin;
    private static CoreysAPI instance = new CoreysAPI();
    StringsManager strings = StringsManager.getInstance();

    public CoreysAPI() {
    }

    public static CoreysAPI getInstance() {
        return instance;
    }

    public void broadcastMessage(String args) {
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "[" + ChatColor.LIGHT_PURPLE + "Broadcast" + ChatColor.DARK_PURPLE + "]" + ChatColor.DARK_GRAY + " >> " + ChatColor.WHITE + args.replaceAll("(&([a-o0-9]))", "\u00A7$2"));
    }

    public void setMessage(String name, String message) {
        File f = new File(plugin.getDataFolder() + File.separator + "messages.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
        if (!config.isSet(name)) {
            config.set(name, message);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addMessage(String name, String message) {
        File f = new File(plugin.getDataFolder() + File.separator + "messages.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
        if (!config.isSet(name)) {
            config.addDefault(name, message);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}