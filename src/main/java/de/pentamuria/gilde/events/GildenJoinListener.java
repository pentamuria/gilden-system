package de.pentamuria.gilde.events;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GildenJoinListener implements Listener {
    private final GildenSystem plugin;

    public GildenJoinListener(GildenSystem gildenSystem) {
        this.plugin = gildenSystem;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGildenJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        plugin.gildenManager.loadPlayerGildeCauseJoin(e.getPlayer().getUniqueId().toString());
        if(plugin.gildenManager.getPlayerGilde(e.getPlayer().getUniqueId().toString()).equalsIgnoreCase("Keine")||plugin.gildenManager.getPlayerGilde(e.getPlayer().getUniqueId().toString()).equalsIgnoreCase("Solo")) {
            Bukkit.broadcastMessage("§a§l+ "+ "§8[" + "§cSolo" + "§8] §f" + p.getName());
        } else {

            String team = plugin.gildenManager.getPlayerGildeWithColor(p);
            Bukkit.broadcastMessage("§a§l+ "+ "§8[" + team + "§8] §f" + p.getName());
        }
    }

    @EventHandler
    public void onGildenLeave(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player p = e.getPlayer();
        if(plugin.gildenManager.getPlayerGilde(e.getPlayer().getUniqueId().toString()).equalsIgnoreCase("Keine") || plugin.gildenManager.getPlayerGilde(e.getPlayer().getUniqueId().toString()).equalsIgnoreCase("Solo")) {
            Bukkit.broadcastMessage("§4§l- "+ "§8[" + "§cSolo" + "§8] §f" + p.getName());
        } else {
            String team = plugin.gildenManager.getPlayerGildeWithColor(p);
            Bukkit.broadcastMessage("§4§l- "+ "§8[" + team + "§8] §f" + p.getName());
        }
    }

}
