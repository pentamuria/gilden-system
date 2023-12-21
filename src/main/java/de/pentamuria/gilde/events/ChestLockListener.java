package de.pentamuria.gilde.events;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestLockListener implements Listener {
    private final GildenSystem plugin;

    public ChestLockListener(GildenSystem gildenSystem) {
        this.plugin = gildenSystem;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if(event.getClickedBlock() != null && event.getClickedBlock().getType().equals(Material.CHEST)) {
            Location chestLocation = event.getClickedBlock().getLocation();
            if(plugin.chestLockManager.isChestLocked(event.getClickedBlock().getLocation())) {
                if(plugin.chestLockManager.isPlayerUnLockingChest(p) && plugin.gildenManager.hasGilde(p)) {
                    plugin.chestLockManager.unlockChest(chestLocation, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    plugin.chestLockManager.removePlayerUnLockingChest(p);
                    p.sendMessage("§7Die Kiste wurde erfolgreich §centsichert");
                    event.setCancelled(true);
                    return;
                }
                if(plugin.gildenManager.hasGilde(p) && plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase(plugin.chestLockManager.getLockedChestGilde(chestLocation))) {
                    event.setCancelled(false);
                } else {
                    event.setCancelled(true);
                    p.sendMessage("§7Diese Kiste ist §cgesichert");
                }
            } else {
                if(plugin.chestLockManager.isPlayerLockingChest(p) && plugin.gildenManager.hasGilde(p)) {
                    plugin.chestLockManager.lockChest(chestLocation, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    plugin.chestLockManager.removePlayerLockingChest(p);
                    p.sendMessage("§7Die Kiste wurde erfolgreich §agesichert");
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if(event.getBlock().getType().equals(Material.CHEST)) {
            if(plugin.chestLockManager.isChestLocked(event.getBlock().getLocation())) {
                if(plugin.gildenManager.hasGilde(p) && plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase(plugin.chestLockManager.getLockedChestGilde(event.getBlock().getLocation()))) {
                    event.setCancelled(false);
                    plugin.chestLockManager.unlockChest(event.getBlock().getLocation(), plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    plugin.chestLockManager.removePlayerLockingChest(p);
                    p.sendMessage("§7Eine gelockte Kiste wurde §cabgebaut§7!");
                } else {
                    event.setCancelled(true);
                    p.sendMessage("§7Diese Kiste ist §cgesichert");
                }
            }
        }

    }
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        for (Block block : event.blockList()) {
            // Check if the block is a chest
            if (block.getType().equals(Material.CHEST)) {
                if(plugin.chestLockManager.isChestLocked(block.getLocation())) {
                    // Cancel the explosion for this block
                    event.setYield(0); // Set the yield to 0 to prevent any block damage
                    event.blockList().remove(block);
                }

            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        Block placedBlock = event.getBlockPlaced();

        if (placedBlock.getType().equals(Material.CHEST)) {
            Location chestLocation = placedBlock.getLocation();

            if (isAdjacentToLockedChest(chestLocation)) {
                if(!plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase(plugin.chestLockManager.getLockedChestGilde(chestLocation))) {
                    event.setCancelled(true);
                    p.sendMessage("§cDu kannst keine Kiste neben einer gesicherten Kiste platzieren.");
                    return;
                }
                p.sendMessage("§cPlease lock this chest also so that the double chest is secured!");
            }

            if (plugin.chestLockManager.isPlayerLockingChest(p)) {
                if (plugin.gildenManager.hasGilde(p)) {
                    // Check if the placed chest is adjacent to a locked chest
                    plugin.chestLockManager.lockChest(chestLocation, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    plugin.chestLockManager.removePlayerLockingChest(p);
                    p.sendMessage("§7Die Kiste wurde erfolgreich §agesichert");
                } else {
                    p.sendMessage("§cDu musst in einer Gilde sein!");
                }
            }
        } else if (placedBlock.getType().equals(Material.HOPPER)) {
            Location aboveLocation = placedBlock.getLocation().clone().add(0, 1, 0);
            Block aboveBlock = aboveLocation.getBlock();

            // Check if there is a locked chest above the placed hopper
            if (aboveBlock.getType().equals(Material.CHEST) && isAdjacentToLockedChest(aboveLocation) &&
                    !plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase(plugin.chestLockManager.getLockedChestGilde(aboveLocation))) {
                event.setCancelled(true);
                p.sendMessage("§cDu kannst keinen Trichter unter eine gesicherte Kiste platzieren.");
            }
        }
    }

    private boolean isAdjacentToLockedChest(Location location) {
        for (Location lockedLocation: plugin.chestLockManager.getLockedChests().keySet()) {
            if (lockedLocation.getWorld().equals(location.getWorld()) &&
                    Math.abs(lockedLocation.getBlockX() - location.getBlockX()) <= 1 &&
                    Math.abs(lockedLocation.getBlockY() - location.getBlockY()) <= 1 &&
                    Math.abs(lockedLocation.getBlockZ() - location.getBlockZ()) <= 1) {
                return true;
            }
        }
        return false;
    }

}
