package de.pentamuria.gilde.countdowns;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import de.pentamuria.gilde.util.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class BaseCountdown {

    private static HashMap<Player, BukkitTask> countdown;
    static {
        countdown = new HashMap<>();
    }

    private Player p;
    private int count;
    private Location loc;


    public BaseCountdown(Player p) {
        this.p = p;
        this.count = 6;;
    }

    public void start(GildenSystem plugin, Location loc) {

        if(countdown.containsKey(p)) {
            return;
        }

        BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {

            @Override
            public void run() {
                sendBar(count);

                if(count == 0) {

                    p.teleport(loc);
                    p.sendMessage(plugin.pr + "Teleport zur §bBase §7war §aerfolgreich");
                    countdown.get(p).cancel();
                    countdown.remove(p);
                    return;
                }
                count--;

            }
        }, 0, 20);


        countdown.put(this.p, task);


    }

    public static void stop(Player p) {
        if(!countdown.containsKey(p)) {
            return;
        }

        countdown.get(p).cancel();
        p.sendMessage("§cCountdown abgebrochen!");
        ActionBar.sendActionBar(p, "§8[§cXXXXX§8] §e§lX");
        countdown.remove(p);
    }




    private void sendBar(int count) {
        // §8[§c§8

        String s = "§8[";
        for(int i = 0; i < count; i++) {
            s = s + "§c0";

        }
        for(int i = 0; i < (6 - count); i++) {
            s = s + "§70";
        }

        s = s + "§8] §e§l" + count;
        ActionBar.sendActionBar(this.p, s);





    }
}
