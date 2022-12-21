package de.pentamuria.gilde.events;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GildenChatListener implements Listener {

    private final GildenSystem plugin;

    public GildenChatListener(GildenSystem gildenSystem) {
        this.plugin = gildenSystem;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGildenChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        e.setCancelled(true);
        if(plugin.globalMute) {
            p.sendMessage(plugin.pr + " §dGlobalMute §cist aktiviert");
        } else {
            if(e.getMessage().startsWith("@all") ||e.getMessage().startsWith("@All") || plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Solo") || plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Keine")) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    String message = e.getMessage().replace("@all", "");
                    String color = ChatColor.translateAlternateColorCodes('&', message);
                    if(plugin.gildenManager.hasGilde(p)) {
                        all.sendMessage("§f[@All] §8[" + plugin.gildenManager.getPlayerGildeWithColor(p) + "§8] " + plugin.gildenManager.getPlayerColor(p) + p.getName() + "§f: §7" + color);
                    } else {
                        all.sendMessage("§f[@All] §8[" + plugin.gildenManager.getPlayerGildeWithColor(p) + "§8] §3" + p.getName() + "§f: §7" + color);
                    }

                }
            } else {
                String message = e.getMessage();
                plugin.gildenManager.sendAllGildenPlayerMessage(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), plugin.gildenManager.getPlayerColor(p)+p.getName() + "§8: §f"+message);
            }
        }
    }
}
