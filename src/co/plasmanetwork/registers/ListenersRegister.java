package co.plasmanetwork.registers;

import co.plasmanetwork.OPPrison;

import co.plasmanetwork.listeners.*;
import co.plasmanetwork.listeners.items.*;
import co.plasmanetwork.listeners.signs.SignInteractListener;
import co.plasmanetwork.mines.MinesListener;
import co.plasmanetwork.rewards.CustomItemListener;
import co.plasmanetwork.rewards.CustomRewardsListener;
import org.bukkit.plugin.PluginManager;

/**
 * Created by creyn63 on 5/07/2016.
 */
public class ListenersRegister {
    OPPrison plugin;

    public ListenersRegister(OPPrison plugin) {
        this.plugin = plugin;
    }

    public ListenersRegister() {

    }

    public static ListenersRegister instance = new ListenersRegister();

    public static ListenersRegister getInstance() {
        return instance;
    }

    public void registerListeners(OPPrison plugin) {
        OPPrison.log("Beginning to enable the registers.");
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(plugin), plugin);
        OPPrison.log("Player Listener Class was registered.");
        pm.registerEvents(new PlayerStatsListener(plugin), plugin);
        OPPrison.log("Player Statistics Listener Class was registered.");
        pm.registerEvents(new PlayerAchListener(plugin), plugin);
        OPPrison.log("Player Achievement Listener Class was registered.");
        pm.registerEvents(new PVPListener(plugin), plugin);
        OPPrison.log("PVP Listener Class was registered.");
        pm.registerEvents(new WorldListener(plugin), plugin);
        OPPrison.log("World Listener Class was registered.");
        pm.registerEvents(new CustomRewardsListener(plugin), plugin);
        OPPrison.log("Custom Rewards Listener Class was registered.");
        pm.registerEvents(new MinesListener(plugin), plugin);
        OPPrison.log("Mines Listener Class was registered.");
        pm.registerEvents(new SignInteractListener(plugin), plugin);
        OPPrison.log("Sign Interact Listener Class was registered.");
        pm.registerEvents(new CustomItemListener(plugin), plugin);
        OPPrison.log("Custom Item Listener Class was registered.");
        pm.registerEvents(new CrystalPickaxeListener(plugin), plugin);
        OPPrison.log("Crystal Pickaxe Listener Class was registered.");
        pm.registerEvents(new PurrptasticPickaxeListener(plugin), plugin);
        OPPrison.log("Purrptastic Pickaxe Listener Class was registered.");
        pm.registerEvents(new RubyPickaxeListener(plugin), plugin);
        OPPrison.log("Ruby Pickaxe Listener Class was registered.");
        pm.registerEvents(new SapphirePickaxeListener(plugin), plugin);
        OPPrison.log("Sapphire Pickaxe Listener Class was registered.");
        pm.registerEvents(new TrollPickaxeListener(plugin), plugin);
        OPPrison.log("Troll Pickaxe Listener Class was registered.");

    }
}
