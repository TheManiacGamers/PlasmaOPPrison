package co.plasmanetwork;

import co.plasmanetwork.managers.ConfigsManager;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Corey on 8/12/2016.
 */
public class MinesCommands {
    OPPrison plugin;
    StringsManager strings = StringsManager.getInstance();
    ConfigsManager configs = ConfigsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();

    public MinesCommands(OPPrison plugin) {
        this.plugin = plugin;
    }

    @Command(aliases = "pmp", desc = "Base commands for the mines.", usage = "set <mine>", help = "Base command for the mines.")
    public void onPM(CommandContext args, CommandSender sender) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!(p.hasPermission(perms.OPPrison_Commands_Pmp))) {
                return;
            }
            if (args.argsLength() == 0) {
                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "/pmp set <mine>");
                return;
            }
            if (args.argsLength() == 1) {
                p.sendMessage(strings.defaultMsgs + ChatColor.RED + "/pmp set <mine>");
                return;
            }
            if (args.argsLength() == 2) {
                if (args.getString(0).equalsIgnoreCase("set")) {
                    if (args.getString(1).equalsIgnoreCase("a")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.A.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.A.X", pLoc.getX());
                        configs.getConfig().set("Mines.A.Y", pLoc.getY());
                        configs.getConfig().set("Mines.A.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'A' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }
                    if (args.getString(1).equalsIgnoreCase("b")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.B.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.B.X", pLoc.getX());
                        configs.getConfig().set("Mines.B.Y", pLoc.getY());
                        configs.getConfig().set("Mines.B.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'B' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("c")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.C.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.C.X", pLoc.getX());
                        configs.getConfig().set("Mines.C.Y", pLoc.getY());
                        configs.getConfig().set("Mines.C.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'C' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("d")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.D.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.D.X", pLoc.getX());
                        configs.getConfig().set("Mines.D.Y", pLoc.getY());
                        configs.getConfig().set("Mines.D.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'D' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("e")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.E.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.E.X", pLoc.getX());
                        configs.getConfig().set("Mines.E.Y", pLoc.getY());
                        configs.getConfig().set("Mines.E.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'E' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("f")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.F.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.F.X", pLoc.getX());
                        configs.getConfig().set("Mines.F.Y", pLoc.getY());
                        configs.getConfig().set("Mines.F.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'F' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("g")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.G.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.G.X", pLoc.getX());
                        configs.getConfig().set("Mines.G.Y", pLoc.getY());
                        configs.getConfig().set("Mines.G.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'G' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("h")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.H.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.H.X", pLoc.getX());
                        configs.getConfig().set("Mines.H.Y", pLoc.getY());
                        configs.getConfig().set("Mines.H.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'H' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("i")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.I.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.I.X", pLoc.getX());
                        configs.getConfig().set("Mines.I.Y", pLoc.getY());
                        configs.getConfig().set("Mines.I.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'I' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("j")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.J.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.J.X", pLoc.getX());
                        configs.getConfig().set("Mines.J.Y", pLoc.getY());
                        configs.getConfig().set("Mines.J.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'J' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("k")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.K.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.K.X", pLoc.getX());
                        configs.getConfig().set("Mines.K.Y", pLoc.getY());
                        configs.getConfig().set("Mines.K.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'K' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("l")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.L.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.L.X", pLoc.getX());
                        configs.getConfig().set("Mines.L.Y", pLoc.getY());
                        configs.getConfig().set("Mines.L.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'L' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("m")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.M.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.M.X", pLoc.getX());
                        configs.getConfig().set("Mines.M.Y", pLoc.getY());
                        configs.getConfig().set("Mines.M.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'M' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("n")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.N.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.N.X", pLoc.getX());
                        configs.getConfig().set("Mines.N.Y", pLoc.getY());
                        configs.getConfig().set("Mines.N.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'N' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("o")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.O.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.O.X", pLoc.getX());
                        configs.getConfig().set("Mines.O.Y", pLoc.getY());
                        configs.getConfig().set("Mines.O.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'O' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P.X", pLoc.getX());
                        configs.getConfig().set("Mines.P.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("q")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.Q.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.Q.X", pLoc.getX());
                        configs.getConfig().set("Mines.Q.Y", pLoc.getY());
                        configs.getConfig().set("Mines.Q.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'Q' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("r")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.R.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.R.X", pLoc.getX());
                        configs.getConfig().set("Mines.R.Y", pLoc.getY());
                        configs.getConfig().set("Mines.R.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'R' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("s")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.S.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.S.X", pLoc.getX());
                        configs.getConfig().set("Mines.S.Y", pLoc.getY());
                        configs.getConfig().set("Mines.S.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'S' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("t")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.T.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.T.X", pLoc.getX());
                        configs.getConfig().set("Mines.T.Y", pLoc.getY());
                        configs.getConfig().set("Mines.T.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'T' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("u")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.U.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.U.X", pLoc.getX());
                        configs.getConfig().set("Mines.U.Y", pLoc.getY());
                        configs.getConfig().set("Mines.U.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'U' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("v")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.V.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.V.X", pLoc.getX());
                        configs.getConfig().set("Mines.V.Y", pLoc.getY());
                        configs.getConfig().set("Mines.V.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'V' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("w")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.W.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.W.X", pLoc.getX());
                        configs.getConfig().set("Mines.W.Y", pLoc.getY());
                        configs.getConfig().set("Mines.W.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'W' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("x")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.X.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.X.X", pLoc.getX());
                        configs.getConfig().set("Mines.X.Y", pLoc.getY());
                        configs.getConfig().set("Mines.X.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'X' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("y")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.Y.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.Y.X", pLoc.getX());
                        configs.getConfig().set("Mines.Y.Y", pLoc.getY());
                        configs.getConfig().set("Mines.Y.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'Y' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("z")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.Z.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.Z.X", pLoc.getX());
                        configs.getConfig().set("Mines.Z.Y", pLoc.getY());
                        configs.getConfig().set("Mines.Z.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'Z' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("elite")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.Elite.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.Elite.X", pLoc.getX());
                        configs.getConfig().set("Mines.Elite.Y", pLoc.getY());
                        configs.getConfig().set("Mines.Elite.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'Elite' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("overlord")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.Overlord.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.Overlord.X", pLoc.getX());
                        configs.getConfig().set("Mines.Overlord.Y", pLoc.getY());
                        configs.getConfig().set("Mines.Overlord.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'Overlord' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("god")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.God.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.God.X", pLoc.getX());
                        configs.getConfig().set("Mines.God.Y", pLoc.getY());
                        configs.getConfig().set("Mines.God.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'God' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p1")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P1.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P1.X", pLoc.getX());
                        configs.getConfig().set("Mines.P1.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P1.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P1' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p2")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P2.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P2.X", pLoc.getX());
                        configs.getConfig().set("Mines.P2.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P2.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P2' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p3")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P3.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P3.X", pLoc.getX());
                        configs.getConfig().set("Mines.P3.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P3.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P3' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p4")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P4.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P4.X", pLoc.getX());
                        configs.getConfig().set("Mines.P4.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P4.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P4' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p5")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P5.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P5.X", pLoc.getX());
                        configs.getConfig().set("Mines.P5.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P5.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P5' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p6")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P6.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P6.X", pLoc.getX());
                        configs.getConfig().set("Mines.P6.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P6.Z", pLoc.getZ());

                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P6' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p7")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P7.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P7.X", pLoc.getX());
                        configs.getConfig().set("Mines.P7.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P7.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P7' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p8")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P8.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P8.X", pLoc.getX());
                        configs.getConfig().set("Mines.P8.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P8.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P8' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p9")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P9.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P9.X", pLoc.getX());
                        configs.getConfig().set("Mines.P9.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P9.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P9' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("p10")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.P10.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.P10.X", pLoc.getX());
                        configs.getConfig().set("Mines.P10.Y", pLoc.getY());
                        configs.getConfig().set("Mines.P10.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'P10' has been set to your location.");
                        configs.saveConfig();
                        return;
                    }

                    if (args.getString(1).equalsIgnoreCase("Staff")) {
                        Location pLoc = p.getLocation();
                        configs.getConfig().set("Mines.Staff.World", pLoc.getWorld().getName());
                        configs.getConfig().set("Mines.Staff.X", pLoc.getX());
                        configs.getConfig().set("Mines.Staff.Y", pLoc.getY());
                        configs.getConfig().set("Mines.Staff.Z", pLoc.getZ());
                        p.sendMessage(strings.defaultMsgs + ChatColor.GREEN + "The mine's location for 'Staff' has been set to your location.");
                        configs.saveConfig();

                    } else {
                        p.sendMessage(strings.incorrectArgs);

                    }
                } else {
                    p.sendMessage(strings.incorrectCMD);
                }
            } else {
                sender.sendMessage(strings.needToBePlayerCMD);
            }
        }
    }
}
