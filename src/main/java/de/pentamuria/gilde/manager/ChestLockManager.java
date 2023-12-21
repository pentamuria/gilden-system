package de.pentamuria.gilde.manager;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ChestLockManager {

    private HashMap<Location, String> lockedChest = new HashMap<>();
    private ArrayList<Player> isLockingChest = new ArrayList<Player>();
    private ArrayList<Player> isUnLockingChest = new ArrayList<Player>();

    private GildenSystem main;

    public ChestLockManager(GildenSystem main) {
        this.main = main;
    }

    /**
     * Check if a Player is currently trying to lock a chest
     * @param p
     * @return
     */
    public boolean isPlayerLockingChest(Player p) {
        return isLockingChest.contains(p);
    }

    public boolean isPlayerUnLockingChest(Player p) {
        return isUnLockingChest.contains(p);
    }

    /**
     * Available Player to Lock Guild Chest
     * @param p
     */
    public void addPlayerLockingChest(Player p) {
        if(!isPlayerLockingChest(p)) {
            isLockingChest.add(p);
            removePlayerUnLockingChest(p);
        }
    }

    /**
     * Available Player to UnLock Guild Chest
     * @param p
     */
    public void addPlayerUnLockingChest(Player p) {
        if(!isPlayerUnLockingChest(p)) {
            isUnLockingChest.add(p);
            removePlayerLockingChest(p);
        }
    }

    public HashMap<Location, String> getLockedChests() {
        return lockedChest;
    }

    /**
     * Remove Player from locking the Guild Chest
     * @param p
     */
    public void removePlayerLockingChest(Player p) {
        if(isPlayerLockingChest(p)) isLockingChest.remove(p);
    }

    public void removePlayerUnLockingChest(Player p) {
        if(isPlayerUnLockingChest(p)) isUnLockingChest.remove(p);
    }

    /**
     * Lock the chest via guild
     * @param loc
     * @param gilde
     * @return
     */
    public boolean lockChest(Location loc, String gilde) {
        if(isChestLocked(loc)) {
            return false;
        }
        lockedChest.put(loc, gilde);
        // Synchro oder direktes File löschen

        return true;
    }

    /**
     * Unlock the chest via guild
     * @param loc
     * @param gilde
     * @return
     */
    public boolean unlockChest(Location loc, String gilde) {
        if(!isChestLocked(loc)) {
            return false;
        }
        if(!lockedChest.get(loc).equalsIgnoreCase(gilde)) {
            return false;
        }
        lockedChest.remove(loc);

        // Synchro oder direktes File löschen

        return true;
    }

    /**
     * Check if a chest is locked
     * @param loc
     * @return
     */
    public boolean isChestLocked(Location loc) {
        return lockedChest.containsKey(loc);
    }

    /**
     * Get Gilde which locked chest
     * @param loc
     * @return
     */
    public String getLockedChestGilde(Location loc) {
        if(isChestLocked(loc)) {
            return lockedChest.get(loc);
        }
        return "";
    }


    /**
     * Save locked chests to file
     */
    public void saveLockedChestsToFile() {
        File file = new File("plugins/Pentamuria/LockedChest", "chestlock.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);


        // Save each locked chest to the file
        for (Location loc : lockedChest.keySet()) {
            String locString = convertLocationToString(loc);
            Bukkit.getConsoleSender().sendMessage(locString);
            cfg.set(locString, lockedChest.get(loc));
        }
        Bukkit.getConsoleSender().sendMessage("§7Alle §egesicherten Kisten §7wurden §agesichert");

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load locked chests from file
     */
    public void loadLockedChests() {
        File file = new File("plugins/Pentamuria/LockedChest", "chestlock.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if (file.exists()) {
            for (String key : cfg.getKeys(false)) {
                Location loc = convertStringToLocation(key);
                Bukkit.getConsoleSender().sendMessage(loc.toString());
                String gildeName = cfg.getString(key);
                lockedChest.put(loc, gildeName);
            }
            Bukkit.getConsoleSender().sendMessage("§7Alle §egesicherten Kisten §7wurden §ageladen");
        }
    }

    /**
     * Convert a Location object to a string for storage in the file
     *
     * @param loc The location to convert
     * @return A string representation of the location
     */
    private String convertLocationToString(Location loc) {
        return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
    }

    /**
     * Convert a string back to a Location object
     *
     * @param locString The string to convert
     * @return The Location object
     */
    private Location convertStringToLocation(String locString) {
        String[] parts = locString.split(",");
        String worldName = parts[0];
        double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);
        double z = Double.parseDouble(parts[3]);
        return new Location(main.getServer().getWorld(worldName), x, y, z);
    }

}
