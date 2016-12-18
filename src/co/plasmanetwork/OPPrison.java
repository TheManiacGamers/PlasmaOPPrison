package co.plasmanetwork;

import co.plasmanetwork.listeners.items.*;
import co.plasmanetwork.managers.ConfigsManager;
import co.plasmanetwork.managers.StringsManager;
import co.plasmanetwork.mines.MinesListener;
import co.plasmanetwork.other.ServerTasks;
import co.plasmanetwork.other.Tasks;
import co.plasmanetwork.registers.ListenersRegister;
import co.plasmanetwork.rewards.CustomRewardsListener;
import co.plasmanetwork.utils.CoreysAPI;
import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Corey on 19/08/2016.
 */
public class OPPrison extends JavaPlugin implements Listener {
    private static OPPrison instance;
    public static OPPrison plugin;
    private ArrayList<Class> cmdClasses;
    public static HashMap<String, String> messageData = new HashMap<String, String>();
    //    public static HashMap<UUID, PlayerInformation> playerInfo = new HashMap<>();
//    public static HashMap<UUID, PlayerStats> playerStats = new HashMap<>();
//    public static HashMap<UUID, PlayerAchievements> playerAchs = new HashMap<>();
//    public static HashMap<UUID, String> canUseSEnCD = new HashMap<>();
    public static HashMap<Player, String> pickaxeEffects = new HashMap<>();
    private ServerTasks sTasks = ServerTasks.getInstance();
    private Tasks tasks = Tasks.getInstance();
    private MinesListener mList = MinesListener.getInstance();
    // ITEMS
    private CrystalPickaxeListener cPickList = CrystalPickaxeListener.getInstance();
    private RubyPickaxeListener rPickList = RubyPickaxeListener.getInstance();
    private SapphirePickaxeListener sPickList = SapphirePickaxeListener.getInstance();
    private TrollPickaxeListener tPickList = TrollPickaxeListener.getInstance();
    private PurrptasticPickaxeListener pPickList = PurrptasticPickaxeListener.getInstance();

    private CustomRewardsListener customRewards = CustomRewardsListener.getInstance();
    private ConfigsManager configs = ConfigsManager.getInstance();
    private CoreysAPI api = CoreysAPI.getInstance();
    private ListenersRegister listeners = ListenersRegister.getInstance();
    //    private MessagesRegister mreg = MessagesRegister.getInstance();
    public static HashMap<Player, Integer> onlineFor = new HashMap<>();
    public static HashMap<Player, Integer> sneakingFor = new HashMap<>();
    public static HashMap<Player, Integer> SEnCU = new HashMap<>();
    public static HashMap<Player, Integer> SEnCD = new HashMap<>();
    public static HashMap<Player, String> canFly = new HashMap<>();
    public static HashMap<Player, String> prestigeConfirm = new HashMap<>();

    private StringsManager strings = StringsManager.getInstance();
    private CommandsManager<CommandSender> commands;
    public static Economy econ = null;
    //    public static Permission perms = null;
    public static Chat chat = null;

    public OPPrison() {
    }

    public static OPPrison getInstance() {
        return instance;
    }

    public static void log(String message) {
        System.out.println("[OPPrison] " + message);
    }

//    public void onReload() {
//        if (Bukkit.getOnlinePlayers().size() != 0) {
//            for(Player player : Bukkit.getOnlinePlayers()) {
//                PlayerData.loadedPlayer.put(player.getUniqueId(), new PlayerData(player.getUniqueId()));
//            }
//        }
//    }

    public void onEnable() {
        plugin = this;
        this.plugin = plugin;
        configs.setup(plugin);
        configs.saveConfig();
        registerCommandClass(Commands.class);
        registerCommandClass(MinesCommands.class);
        registerCommands();
//        playerInfo = new HashMap<>();
//        playerStats = new HashMap<>();
//        playerAchs = new HashMap<>();
        pickaxeEffects = new HashMap<>();
        if (!setupEconomy()) {
            log(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
//        setupPermissions();
        setupChat();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new Runnable() {

            @Override
            public void run() {
                for (World w : Bukkit.getServer().getWorlds()) {
                    w.setTime(0L);
                }
            }
        }, 0L, 10000L);

        onlineFor = new HashMap<>();
        listeners.registerListeners(plugin);

        getServer().

                getMessenger().

                registerOutgoingPluginChannel(this, "BungeeCord");

        File dir = new File("PlayerDatabase");
        if (!dir.exists())

        {
            log("Could not find the PlayerDatabase folder, Generating it!");
            dir.mkdir();
        } else

        {
            log("Found the PlayerDatabase folder!");
        }        // Getting the location of the database, so the rest of this event knows where to actually save everything.

        File f = new File(getDataFolder() + File.separator + "messages.yml");
        //        mreg.setup(plugin);
//        mreg.saveMsgs();
        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
        for (
                String message : config.getConfigurationSection("").

                getKeys(false))

        {
            messageData.put(message, config.getString(message));
        }
        if (!(Bukkit.getServer().

                getOnlinePlayers().

                size() == 0))

        {
            for (Player p : Bukkit.getOnlinePlayers()) {
                OPPrison.SEnCU.put(p.getPlayer(), 0);
                OPPrison.SEnCD.put(p.getPlayer(), 3660);
                OPPrison.pickaxeEffects.put(p.getPlayer(), "Effects-Pickaxe-Yes");
//                p.sendMessage(strings.defaultMsgs + ChatColor.DARK_RED + "ATTENTION: THIS PLUGIN WILL NOT WORK FOR YOU PROPERLY IF YOU DO NOT RELOG. PLEASE DO SO NOW.");
            }
        }
        tasks.startTasks();

        log("Essentials Tasks have been started.");
//        customRewards.startTasks();
        mList.startTasks();

        log("Mines Listener task has been started.");
        sTasks.startRestartTasks();

        log("Auto Restart task has been started.");
        cPickList.startTasks();

        log("Crystal Pickaxe Tasks has been started");
        rPickList.startTasks();

        log("Ruby Pickaxe Tasks has been started");
        tPickList.startTasks();

        log("Troll Pickaxe Tasks has been started");
        sPickList.startTasks();

        log("Sapphire Pickaxe Tasks has been started");

        log("All tasks have been started.");

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

//    private boolean setupPermissions() {
//        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
//        perms = rsp.getProvider();
//        return perms != null;
//    }

//    public void onDisable() {
//        if (Bukkit.getOnlinePlayers().size() != 0) {
//            for (final Player found : Bukkit.getOnlinePlayers()) {
//                OPPrison.playerInfo.remove(found.getUniqueId());
//                File playerDB = new File(plugin.getDataFolder(), File.separator + "PlayerDatabase" + File.separator);
//                File pFile = new File(playerDB, found.getUniqueId() + ".yml");
//                final FileConfiguration playerData = YamlConfiguration.loadConfiguration(pFile);                                  // Loading the players UUID.yml, so you can edit it and save it, etc.
//                PlayerInformation pInfo = OPPrison.playerInfo.get(found.getUniqueId());
//                PlayerStats pStats = OPPrison.playerStats.get(found.getUniqueId());
//                PlayerAchievements pAchs = OPPrison.playerAchs.get(found.getUniqueId());
//                playerData.getConfigurationSection("Options").set("Group", pInfo.GROUP);
//                playerData.getConfigurationSection("Stats").set("Kills", pStats.kills);
//                playerData.getConfigurationSection("Stats").set("Deaths", pStats.deaths);
//                playerData.getConfigurationSection("Stats").set("Level", pStats.level);
//                playerData.getConfigurationSection("Stats").set("XPtoNxtLvl", pStats.xptonxtlevel);
//                playerData.getConfigurationSection("Stats").set("Killstreak", pStats.killstreak);
//                playerData.getConfigurationSection("Stats").set("HighestKS", pStats.highestks);
//                playerData.set("Achievements.Reach10Kills", pAchs.Reach10Kills);
//                playerData.set("Achievements.Reach50Kills", pAchs.Reach50Kills);
//                playerData.set("Achievements.KillyeroC", pAchs.KillyeroC);
//                playerData.set("Achievements.Join50Times", pAchs.Join50Times);
//                playerData.set("Achievements.Join100Times", pAchs.Join100Times);
//                playerData.set("Achievements.Join150Times", pAchs.Join150Times);
//                playerData.set("Achievements.Join200Times", pAchs.Join200Times);
//                playerData.set("Achievements.ReachAKSOf20", pAchs.ReachAKSOf20);
//                playerData.set("Achievements.ReachGod", pAchs.ReachGod);
//                playerData.set("Stats.Count.Reach10Kills", pAchs.iReach10Kills);
//                playerData.set("Stats.Count.Reach50Kills", pAchs.iReach50Kills);
//                playerData.set("Stats.Count.Join50Times", pAchs.iJoin50Times);
//                playerData.set("Stats.Count.Join100Times", pAchs.iJoin100Times);
//                playerData.set("Stats.Count.Join150Times", pAchs.iJoin150Times);
//                playerData.set("Stats.Count.Join200Times", pAchs.iJoin200Times);
//                playerData.set("Stats.Count.ReachAKSOf20", pAchs.iReachAKSOf20);
//                try {
//                    playerData.save(pFile);                                                                                         // Saving the player file.
//                } catch (IOException ex) {
//                    found.sendMessage(strings.prefix + ChatColor.RED + "Error saving your player file, please try relogging, if you see this message again, contact a staff member.");
//                }
//            }
//        }
//    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            commands.execute(cmd.getName(), args, sender, sender);
        } catch (CommandPermissionsException e) {

            sender.sendMessage(ChatColor.RED + "You don't have permission.");
        } catch (MissingNestedCommandException e) {
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (CommandUsageException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (WrappedCommandException e) {
            if (e.getCause() instanceof NumberFormatException) {

                sender.sendMessage(ChatColor.RED + "You need to enter a number!");
            } else {
                sender.sendMessage(ChatColor.RED + "Error occurred, contact developer. [TheManiacGamers]");
                sender.sendMessage(ChatColor.RED + "Message: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (CommandException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
        }

        return true;
    }

    protected void registerCommandClass(Class cmdClass) {
        if (cmdClasses == null)
            cmdClasses = new ArrayList<Class>();

        cmdClasses.add(cmdClass);
    }

    protected void registerCommands() {
        if (cmdClasses == null || cmdClasses.size() < 1) {

            log("Could not register commands! Perhaps you registered no classes?");
            return;
        }

        // Register the commands that we want to use
        commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender player, String perm) {
                return getInstance().hasPerm(player, perm);
            }


        };
        commands.setInjector(new SimpleInjector(this));
        final CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(this, commands);

        for (Class cmdClass : cmdClasses)
            cmdRegister.register(cmdClass);
    }

    public boolean hasPerm(CommandSender sender, String perm) {
        return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
    }

    public static void sendPluginMessage(OPPrison plugin, String bungeeCord, byte[] bytes) {
    }
}
