package co.plasmanetwork.OPPrison.registers;

import co.plasmanetwork.OPPrison.OPPrison;
import co.plasmanetwork.OPPrison.utils.CoreysAPI;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static co.plasmanetwork.OPPrison.OPPrison.log;

/**
 * Created by Corey on 3/12/2016.
 */
public class MessagesRegister {

    OPPrison plugin;
    CoreysAPI api = CoreysAPI.getInstance();
    FileConfiguration msgsConf;
    File f = new File(plugin.getDataFolder() + File.separator + "messages.yml");
    FileConfiguration fConf = YamlConfiguration.loadConfiguration(f);

    public MessagesRegister(OPPrison plugin) {
        this.plugin = plugin;
    }

    public MessagesRegister() {

    }

    public static MessagesRegister instance = new MessagesRegister();

    public static MessagesRegister getInstance() {
        return instance;
    }

    public String serverMsgs = (ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + "Server" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "] " + ChatColor.GREEN);

    public void setup(OPPrison plugin) {
        try {
            f.createNewFile();
            api.addMessage("noPermission", serverMsgs + "&cYou do not have permission.");
            api.addMessage("noPermissionInteract", serverMsgs + "&cYou do not have permission to interact with this.");
            api.addMessage("specifyArguments", serverMsgs + "&cYou need to specify arguments! Try using '&4/prison help&c' for more information!");
            api.addMessage("mustBePlayer", serverMsgs + "&cYou must be a player to execute this command.");
            api.addMessage("unknownCommand", serverMsgs + "&cI can't seem to recognise that command. Try &4/help&c!");
            api.addMessage("welcomeMessage", "&aWelcome to &c&lPlasmaNetwork&a, we hope you enjoy your stay!");
            api.addMessage("joinMessage", "&6Welcome back to &c&lPlasmaNetwork&6!");
            api.addMessage("joinNotifyMessage", ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY);
            api.addMessage("quitNotifyMessage", ChatColor.DARK_GRAY + "[" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY);
            api.addMessage("plasmanetworkPrefix", ChatColor.GRAY + "-=[ " + ChatColor.GREEN + "" + ChatColor.BOLD + "Plasma Network" + ChatColor.GRAY + " ]=-");
            log("Setting Messages.yml to default messages");
            saveMsgs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveMsgs() {
        try {
            fConf.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
