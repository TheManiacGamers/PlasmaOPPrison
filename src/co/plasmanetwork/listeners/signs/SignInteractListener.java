package co.plasmanetwork.listeners.signs;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import co.plasmanetwork.other.MinesLocations;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Corey on 11/12/2016.
 */
public class SignInteractListener implements Listener {
    OPPrison plugin;

    public SignInteractListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();
    MinesLocations mLoc = MinesLocations.getInstance();


    @EventHandler
    public void signCreation(SignChangeEvent event) {
        if (event.getLine(0).equalsIgnoreCase("[Sell]")) {
            if (event.getPlayer().hasPermission(perms.OPPrison_Build_Sign_Sell_Create)) {

                String l0 = event.getLine(0);
                String l1 = event.getLine(1);
                String l2 = event.getLine(2);
                String l3 = event.getLine(3);

                event.setLine(0, ChatColor.GOLD + "" + ChatColor.BOLD + "[Sell]");
                event.setLine(1, ChatColor.GREEN + "" + ChatColor.BOLD + "Mine " + l1);
                event.setLine(2, ChatColor.BLUE + "" + ChatColor.BOLD + "Interact with me");
                event.setLine(3, ChatColor.BLUE + "" + ChatColor.BOLD + "to sell your items");
            } else {
                event.getPlayer().sendMessage(strings.);
            }
        }
    }

    @EventHandler
    public void onPlayerInteractSign(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block blockClicked = e.getClickedBlock();
            if (blockClicked.getType() == Material.WALL_SIGN || blockClicked.getType() == Material.SIGN_POST) {
                Sign sign = (Sign) blockClicked.getState();

                // SELL SIGNS
                if (sign.getLine(0).equalsIgnoreCase("[Sell]") && (sign.getLine(1).equalsIgnoreCase("Mine A"))) {
                    if (p.hasPermission(perms.OPPrison_Interact_Sign_Sell_Use)) {
                        sign.setLine(0, ChatColor.GRAY + "[" + ChatColor.GREEN + "Sell" + ChatColor.GRAY + "]");
                        sign.setLine(1, ChatColor.RED + "Mine A");
                    }
                }

                // BUY SIGNS
                if (sign.getLine(1).equalsIgnoreCase("[Buy]")) {
                    if (p.hasPermission(perms.OPPrison_Interact_Sign_Buy_Use)) {

                    }
                }
            }
        }
    }
}