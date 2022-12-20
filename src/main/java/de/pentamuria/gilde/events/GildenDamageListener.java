package de.pentamuria.gilde.events;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GildenDamageListener implements Listener {
    private final GildenSystem plugin;

    public GildenDamageListener(GildenSystem gildenSystem) {
        this.plugin = gildenSystem;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /*@EventHandler (priority = EventPriority.HIGH)
    public void onGildenDamageByEntity(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getDamager() instanceof Player) {
                Player p = (Player) e.getEntity();
                Player t = (Player)e.getDamager();
                if(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase(plugin.gildenManager.getPlayerGilde(t.getUniqueId().toString()))&&!(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Keine")||plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Solo"))) {
                    t.sendMessage(plugin.pr + "Ihr befindet euch im §cselben Team");
                    e.setCancelled(true);
                    return;
                }
            }
        }
    }*/
}
