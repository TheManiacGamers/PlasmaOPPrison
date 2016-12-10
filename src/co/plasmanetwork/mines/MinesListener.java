package co.plasmanetwork.mines;

import co.plasmanetwork.OPPrison;
import co.plasmanetwork.managers.ConfigsManager;
import co.plasmanetwork.managers.PermissionsManager;
import co.plasmanetwork.managers.StringsManager;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.security.Permission;

/**
 * Created by Corey on 6/12/2016.
 *///;import java.io.File;

public class MinesListener implements Listener {
    OPPrison plugin;
    static MinesListener instance = new MinesListener();

    ConfigsManager configs = ConfigsManager.getInstance();
    StringsManager strings = StringsManager.getInstance();
    PermissionsManager perms = PermissionsManager.getInstance();

    private MinesListener() {
    }

    public MinesListener(OPPrison plugin) {
        this.plugin = plugin;
    }

    public static MinesListener getInstance() {
        return instance;
    }


    private int dist = 35;

    public void startTasks() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
            @Override
            public void run() {
                for (final Player pl : Bukkit.getOnlinePlayers()) {
                    World aworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.A.World"));
                    double ax = configs.getConfig().getDouble("Mines.A.X");
                    double ay = configs.getConfig().getDouble("Mines.A.Y");
                    double az = configs.getConfig().getDouble("Mines.A.Z");
                    final Location a = new Location(aworld, ax, ay, az);


                    World bworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.B.World"));
                    double bx = configs.getConfig().getDouble("Mines.B.X");
                    double by = configs.getConfig().getDouble("Mines.B.Y");
                    double bz = configs.getConfig().getDouble("Mines.B.Z");
                    final Location b = new Location(bworld, bx, by, bz);


                    World cworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.C.World"));
                    double cx = configs.getConfig().getDouble("Mines.C.X");
                    double cy = configs.getConfig().getDouble("Mines.C.Y");
                    double cz = configs.getConfig().getDouble("Mines.C.Z");
                    final Location c = new Location(cworld, cx, cy, cz);


                    World dworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.D.World"));
                    double dx = configs.getConfig().getDouble("Mines.D.X");
                    double dy = configs.getConfig().getDouble("Mines.D.Y");
                    double dz = configs.getConfig().getDouble("Mines.D.Z");
                    final Location d = new Location(dworld, dx, dy, dz);


                    World eworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.E.World"));
                    double ex = configs.getConfig().getDouble("Mines.E.X");
                    double ey = configs.getConfig().getDouble("Mines.E.Y");
                    double ez = configs.getConfig().getDouble("Mines.E.Z");
                    final Location e = new Location(eworld, ex, ey, ez);


                    World fworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.F.World"));
                    double fx = configs.getConfig().getDouble("Mines.F.X");
                    double fy = configs.getConfig().getDouble("Mines.F.Y");
                    double fz = configs.getConfig().getDouble("Mines.F.Z");
                    final Location f = new Location(fworld, fx, fy, fz);


                    World gworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.G.World"));
                    double gx = configs.getConfig().getDouble("Mines.G.X");
                    double gy = configs.getConfig().getDouble("Mines.G.Y");
                    double gz = configs.getConfig().getDouble("Mines.G.Z");
                    final Location g = new Location(gworld, gx, gy, gz);


                    World hworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.H.World"));
                    double hx = configs.getConfig().getDouble("Mines.H.X");
                    double hy = configs.getConfig().getDouble("Mines.H.Y");
                    double hz = configs.getConfig().getDouble("Mines.H.Z");
                    final Location h = new Location(hworld, hx, hy, hz);


                    World iworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.I.World"));
                    double ix = configs.getConfig().getDouble("Mines.I.X");
                    double iy = configs.getConfig().getDouble("Mines.I.Y");
                    double iz = configs.getConfig().getDouble("Mines.I.Z");
                    final Location i = new Location(iworld, ix, iy, iz);


                    World jworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.J.World"));
                    double jx = configs.getConfig().getDouble("Mines.J.X");
                    double jy = configs.getConfig().getDouble("Mines.J.Y");
                    double jz = configs.getConfig().getDouble("Mines.J.Z");
                    final Location j = new Location(jworld, jx, jy, jz);


                    World kworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.K.World"));
                    double kx = configs.getConfig().getDouble("Mines.K.X");
                    double ky = configs.getConfig().getDouble("Mines.K.Y");
                    double kz = configs.getConfig().getDouble("Mines.K.Z");
                    final Location k = new Location(kworld, kx, ky, kz);


                    World lworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.L.World"));
                    double lx = configs.getConfig().getDouble("Mines.L.X");
                    double ly = configs.getConfig().getDouble("Mines.L.Y");
                    double lz = configs.getConfig().getDouble("Mines.L.Z");
                    final Location l = new Location(lworld, lx, ly, lz);


                    World mworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.M.World"));
                    double mx = configs.getConfig().getDouble("Mines.M.X");
                    double my = configs.getConfig().getDouble("Mines.M.Y");
                    double mz = configs.getConfig().getDouble("Mines.M.Z");
                    final Location m = new Location(mworld, mx, my, mz);


                    World nworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.N.World"));
                    double nx = configs.getConfig().getDouble("Mines.N.X");
                    double ny = configs.getConfig().getDouble("Mines.N.Y");
                    double nz = configs.getConfig().getDouble("Mines.N.Z");
                    final Location n = new Location(nworld, nx, ny, nz);


                    World oworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.O.World"));
                    double ox = configs.getConfig().getDouble("Mines.O.X");
                    double oy = configs.getConfig().getDouble("Mines.O.Y");
                    double oz = configs.getConfig().getDouble("Mines.O.Z");
                    final Location o = new Location(oworld, ox, oy, oz);


                    World pworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P.World"));
                    double px = configs.getConfig().getDouble("Mines.P.X");
                    double py = configs.getConfig().getDouble("Mines.P.Y");
                    double pz = configs.getConfig().getDouble("Mines.P.Z");
                    final Location p = new Location(pworld, px, py, pz);


                    World qworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.Q.World"));
                    double qx = configs.getConfig().getDouble("Mines.Q.X");
                    double qy = configs.getConfig().getDouble("Mines.Q.Y");
                    double qz = configs.getConfig().getDouble("Mines.Q.Z");
                    final Location q = new Location(qworld, qx, qy, qz);


                    World rworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.R.World"));
                    double rx = configs.getConfig().getDouble("Mines.R.X");
                    double ry = configs.getConfig().getDouble("Mines.R.Y");
                    double rz = configs.getConfig().getDouble("Mines.R.Z");
                    final Location r = new Location(rworld, rx, ry, rz);


                    World sworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.S.World"));
                    double sx = configs.getConfig().getDouble("Mines.S.X");
                    double sy = configs.getConfig().getDouble("Mines.S.Y");
                    double sz = configs.getConfig().getDouble("Mines.S.Z");
                    final Location s = new Location(sworld, sx, sy, sz);


                    World tworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.T.World"));
                    double tx = configs.getConfig().getDouble("Mines.T.X");
                    double ty = configs.getConfig().getDouble("Mines.T.Y");
                    double tz = configs.getConfig().getDouble("Mines.T.Z");
                    final Location t = new Location(tworld, tx, ty, tz);


                    World uworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.U.World"));
                    double ux = configs.getConfig().getDouble("Mines.U.X");
                    double uy = configs.getConfig().getDouble("Mines.U.Y");
                    double uz = configs.getConfig().getDouble("Mines.U.Z");
                    final Location u = new Location(uworld, ux, uy, uz);


                    World vworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.V.World"));
                    double vx = configs.getConfig().getDouble("Mines.V.X");
                    double vy = configs.getConfig().getDouble("Mines.V.Y");
                    double vz = configs.getConfig().getDouble("Mines.V.Z");
                    final Location v = new Location(vworld, vx, vy, vz);


                    World wworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.W.World"));
                    double wx = configs.getConfig().getDouble("Mines.W.X");
                    double wy = configs.getConfig().getDouble("Mines.W.Y");
                    double wz = configs.getConfig().getDouble("Mines.W.Z");
                    final Location w = new Location(wworld, wx, wy, wz);


                    World xworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.X.World"));
                    double xx = configs.getConfig().getDouble("Mines.X.X");
                    double xy = configs.getConfig().getDouble("Mines.X.Y");
                    double xz = configs.getConfig().getDouble("Mines.X.Z");
                    final Location x = new Location(xworld, xx, xy, xz);


                    World yworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.Y.World"));
                    double yx = configs.getConfig().getDouble("Mines.Y.X");
                    double yy = configs.getConfig().getDouble("Mines.Y.Y");
                    double yz = configs.getConfig().getDouble("Mines.Y.Z");
                    final Location y = new Location(yworld, yx, yy, yz);


                    World zworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.Z.World"));
                    double zx = configs.getConfig().getDouble("Mines.Z.X");
                    double zy = configs.getConfig().getDouble("Mines.Z.Y");
                    double zz = configs.getConfig().getDouble("Mines.Z.Z");
                    final Location z = new Location(zworld, zx, zy, zz);


                    World eliteworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.Elite.World"));
                    double elitex = configs.getConfig().getDouble("Mines.Elite.X");
                    double elitey = configs.getConfig().getDouble("Mines.Elite.Y");
                    double elitez = configs.getConfig().getDouble("Mines.Elite.Z");
                    final Location elite = new Location(eliteworld, elitex, elitey, elitez);


                    World godworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.God.World"));
                    double godx = configs.getConfig().getDouble("Mines.God.X");
                    double gody = configs.getConfig().getDouble("Mines.God.Y");
                    double godz = configs.getConfig().getDouble("Mines.God.Z");
                    final Location god = new Location(godworld, godx, gody, godz);


                    World overlordworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.Overlord.World"));
                    double overlordx = configs.getConfig().getDouble("Mines.Overlord.X");
                    double overlordy = configs.getConfig().getDouble("Mines.Overlord.Y");
                    double overlordz = configs.getConfig().getDouble("Mines.Overlord.Z");
                    final Location overlord = new Location(overlordworld, overlordx, overlordy, overlordz);


                    World p1world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P1.World"));
                    double p1x = configs.getConfig().getDouble("Mines.P1.X");
                    double p1y = configs.getConfig().getDouble("Mines.P1.Y");
                    double p1z = configs.getConfig().getDouble("Mines.P1.Z");
                    final Location p1 = new Location(p1world, p1x, p1y, p1z);


                    World p2world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P2.World"));
                    double p2x = configs.getConfig().getDouble("Mines.P2.X");
                    double p2y = configs.getConfig().getDouble("Mines.P2.Y");
                    double p2z = configs.getConfig().getDouble("Mines.P2.Z");
                    final Location p2 = new Location(p2world, p2x, p2y, p2z);


                    World p3world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P3.World"));
                    double p3x = configs.getConfig().getDouble("Mines.P3.X");
                    double p3y = configs.getConfig().getDouble("Mines.P3.Y");
                    double p3z = configs.getConfig().getDouble("Mines.P3.Z");
                    final Location p3 = new Location(p3world, p3x, p3y, p3z);


                    World p4world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P4.World"));
                    double p4x = configs.getConfig().getDouble("Mines.P4.X");
                    double p4y = configs.getConfig().getDouble("Mines.P4.Y");
                    double p4z = configs.getConfig().getDouble("Mines.P4.Z");
                    final Location p4 = new Location(p4world, p4x, p4y, p4z);


                    World p5world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P5.World"));
                    double p5x = configs.getConfig().getDouble("Mines.P5.X");
                    double p5y = configs.getConfig().getDouble("Mines.P5.Y");
                    double p5z = configs.getConfig().getDouble("Mines.P5.Z");
                    final Location p5 = new Location(p5world, p5x, p5y, p5z);


                    World p6world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P6.World"));
                    double p6x = configs.getConfig().getDouble("Mines.P6.X");
                    double p6y = configs.getConfig().getDouble("Mines.P6.Y");
                    double p6z = configs.getConfig().getDouble("Mines.P6.Z");
                    final Location p6 = new Location(p6world, p6x, p6y, p6z);


                    World p7world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P7.World"));
                    double p7x = configs.getConfig().getDouble("Mines.P7.X");
                    double p7y = configs.getConfig().getDouble("Mines.P7.Y");
                    double p7z = configs.getConfig().getDouble("Mines.P7.Z");
                    final Location p7 = new Location(p7world, p7x, p7y, p7z);


                    World p8world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P8.World"));
                    double p8x = configs.getConfig().getDouble("Mines.P8.X");
                    double p8y = configs.getConfig().getDouble("Mines.P8.Y");
                    double p8z = configs.getConfig().getDouble("Mines.P8.Z");
                    final Location p8 = new Location(p8world, p8x, p8y, p8z);


                    World p9world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P9.World"));
                    double p9x = configs.getConfig().getDouble("Mines.P9.X");
                    double p9y = configs.getConfig().getDouble("Mines.P9.Y");
                    double p9z = configs.getConfig().getDouble("Mines.P9.Z");
                    final Location p9 = new Location(p9world, p9x, p9y, p9z);


                    World p10world = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.P10.World"));
                    double p10x = configs.getConfig().getDouble("Mines.P10.X");
                    double p10y = configs.getConfig().getDouble("Mines.P10.Y");
                    double p10z = configs.getConfig().getDouble("Mines.P10.Z");
                    final Location p10 = new Location(p10world, p10x, p10y, p10z);


                    World staffworld = Bukkit.getServer().getWorld(configs.getConfig().getString("Mines.Staff.World"));
                    double staffx = configs.getConfig().getDouble("Mines.Staff.X");
                    double staffy = configs.getConfig().getDouble("Mines.Staff.Y");
                    double staffz = configs.getConfig().getDouble("Mines.Staff.Z");
                    final Location staff = new Location(staffworld, staffx, staffy, staffz);

                    if (configs.getConfig().getString("Mines") == null) {
                        Bukkit.broadcastMessage(strings.defaultMsgs + ChatColor.DARK_RED + "MINES NOT FOUND IN CONFIG. PLEASE CHECK THIS ERROR");
                        return;
                    }
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(OPPrison.plugin, new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (pl.getLocation().distance(a) < dist) {
                                if (pl.hasPermission(perms.Mines_A_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(b) < dist) {
                                if (pl.hasPermission(perms.Mines_B_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(c) < dist) {
                                if (pl.hasPermission(perms.Mines_C_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(d) < dist) {
                                if (pl.hasPermission(perms.Mines_D_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(e) < dist) {
                                if (pl.hasPermission(perms.Mines_E_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(f) < dist) {
                                if (pl.hasPermission(perms.Mines_F_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(g) < dist) {
                                if (pl.hasPermission(perms.Mines_G_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(h) < dist) {
                                if (pl.hasPermission(perms.Mines_H_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(i) < dist) {
                                if (pl.hasPermission(perms.Mines_I_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(j) < dist) {
                                if (pl.hasPermission(perms.Mines_J_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(k) < dist) {
                                if (pl.hasPermission(perms.Mines_K_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(l) < dist) {
                                if (pl.hasPermission(perms.Mines_L_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(m) < dist) {
                                if (pl.hasPermission(perms.Mines_M_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(n) < dist) {
                                if (pl.hasPermission(perms.Mines_N_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(o) < dist) {
                                if (pl.hasPermission(perms.Mines_O_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p) < dist) {
                                if (pl.hasPermission(perms.Mines_P_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(q) < dist) {
                                if (pl.hasPermission(perms.Mines_Q_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(r) < dist) {
                                if (pl.hasPermission(perms.Mines_R_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(s) < dist) {
                                if (pl.hasPermission(perms.Mines_S_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(t) < dist) {
                                if (pl.hasPermission(perms.Mines_T_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(u) < dist) {
                                if (pl.hasPermission(perms.Mines_U_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(v) < dist) {
                                if (pl.hasPermission(perms.Mines_V_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(w) < dist) {
                                if (pl.hasPermission(perms.Mines_W_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(x) < dist) {
                                if (pl.hasPermission(perms.Mines_X_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(y) < dist) {
                                if (pl.hasPermission(perms.Mines_Y_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(z) < dist) {
                                if (pl.hasPermission(perms.Mines_Z_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p1) < dist) {
                                if (pl.hasPermission(perms.Mines_P1_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p2) < dist) {
                                if (pl.hasPermission(perms.Mines_P2_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p3) < dist) {
                                if (pl.hasPermission(perms.Mines_P3_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p4) < dist) {
                                if (pl.hasPermission(perms.Mines_P4_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p5) < dist) {
                                if (pl.hasPermission(perms.Mines_P5_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p6) < dist) {
                                if (pl.hasPermission(perms.Mines_P6_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p7) < dist) {
                                if (pl.hasPermission(perms.Mines_P7_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p8) < dist) {
                                if (pl.hasPermission(perms.Mines_P8_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p9) < dist) {
                                if (pl.hasPermission(perms.Mines_P9_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(p10) < dist) {
                                if (pl.hasPermission(perms.Mines_P10_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(staff) < dist) {
                                if (pl.hasPermission(perms.Mines_Staff_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 5));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(elite) < dist) {
                                if (pl.hasPermission(perms.Mines_Elite_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 5));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(overlord) < dist) {
                                if (pl.hasPermission(perms.Mines_Overlord_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 5));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 3));
                                    return;
                                }
                            }
                            if (pl.getLocation().distance(god) < dist) {
                                if (pl.hasPermission(perms.Mines_God_Use)) {
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 3));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 5));
                                    pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 3));
                                }
                            }
                        }
                    }, 20L, 20L);
                }

            }
        }, 20L, 20L);
    }
}
