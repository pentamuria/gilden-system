package de.pentamuria.gilde.events;

import de.pentamuria.gilde.gilde.Gilde;
import de.pentamuria.gilde.gildensystem.GildenSystem;
import de.pentamuria.gilde.util.ActionBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GildenInvCloseListener implements Listener {

    private final GildenSystem plugin;

    public GildenInvCloseListener(GildenSystem gildenSystem) {
        this.plugin = gildenSystem;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGildenInvClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if(e.getView().getTitle().equalsIgnoreCase("§aGilden Rucksack")) {
            //plugin.bagManager.savePlayerBag(p.getUniqueId().toString(), invN);
            Gilde gilde=plugin.gildenManager.getGilde(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
            gilde.setBagOpen(false);
            ActionBar.sendActionBar(p, "§eGilden-Rucksack §7wurde §agespeichert");
        }
    }
}
