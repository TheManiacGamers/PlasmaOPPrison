package co.plasmanetwork.listeners.items;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.StringsManager;
import org.bukkit.event.Listener;

import java.util.Random;

/**
 * Created by Corey on 11/12/2016.
 */
public class PurrptasticPickaxeListener implements Listener {
    static PurrptasticPickaxeListener instance = new PurrptasticPickaxeListener();
    OPPrison plugin;

    public PurrptasticPickaxeListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    Random rand = new Random();

    public static PurrptasticPickaxeListener getInstance() {
        return instance;
    }

    private PurrptasticPickaxeListener() {

    }

    StringsManager strings = StringsManager.getInstance();


}
