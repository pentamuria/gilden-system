package de.pentamuria.gilde.events;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import de.pentamuria.gilde.util.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GildenInvListener implements Listener {


    private final GildenSystem plugin;

    public GildenInvListener(GildenSystem gildenSystem) {
        this.plugin = gildenSystem;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onGildenInvClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§aWähle Gilden-Farbe")) {
            e.setCancelled(true);
            if(e.getSlot()==0) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&f");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==1) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&6");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==2) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&d");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==3) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&9");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==4) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&e");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==5) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&a");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==6) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&8");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==7) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&7");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==8) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&3");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);
                    }

                }, 1);
            } else if(e.getSlot()==9) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&5");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);

                    }

                }, 1);
            } else if(e.getSlot()==10) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&1");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);

                    }

                }, 1);
            } else if(e.getSlot()==11) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&2");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);

                    }

                }, 1);
            } else if(e.getSlot()==12) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&c");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);

                    }

                }, 1);
            } else if(e.getSlot()==13) {
                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&0");

                plugin.gildenInvManager.openSymbolAuswahl(p);


            } else if(e.getSlot()==14) {

                plugin.gildenManager.changeGildenFarbe(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), "&b");
                p.closeInventory();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        plugin.gildenInvManager.openSymbolAuswahl(p);

                    }

                }, 1);

            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§aWähle Gilden-Symbol")) {
            e.setCancelled(true);
            if (e.getView().getTitle().equalsIgnoreCase("§aWähle Gilden-Symbol")) {
                if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
                    plugin.gildenManager.changeGildenSymbol(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), new ItemStack(Material.DIAMOND_SWORD));
                } else if (e.getCurrentItem().getType().equals(Material.BOW)) {
                    plugin.gildenManager.changeGildenSymbol(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), new ItemStack(Material.BOW));
                } else {
                    plugin.gildenManager.changeGildenSymbol(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), new ItemStack(e.getCurrentItem().getType()));
                }

                String name = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        p.closeInventory();
                    }

                }, 1);

                Inventory inv = Bukkit.createInventory(null, 9, "§aEröffnungsinformationen");

                ItemStack item1 = plugin.gildenManager.getGilde(name).getSymbol();
                ItemMeta meta1 = item1.getItemMeta();
                meta1.setDisplayName("§aName: " + ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(name).getFarbe()) + name);
                ArrayList<String> lore1 = new ArrayList<String>();
                lore1.add("§aGildenlevel: §c1");
                lore1.add("§aDatum: §c" + plugin.gildenManager.getGilde(name).getEröffnung());
                lore1.add("§aAnzahl: §c" + plugin.gildenManager.getGilde(name).getMemberanzahl());
                lore1.add("§aAnführer: §c" + p.getName());
                meta1.setLore(lore1);
                item1.setItemMeta(meta1);
                inv.setItem(4, item1);

                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

                    @Override
                    public void run() {
                        p.openInventory(inv);
                        plugin.gildenManager.refreshPlayerScoreboardTeam(p, plugin.gildenManager.getGilde(name));
                    }

                }, 1);
                p.sendMessage(plugin.pr + " §aDu hast eine Gilde erstellt!");
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§aEröffnungsinformationen")) {
            e.setCancelled(true);
        } else if(e.getView().getTitle().equalsIgnoreCase("§aGilden-Manager")) {
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lMitglieder:")) {
                        String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        if(plugin.gildenManager.getGilde(gilde).getMemberarray()==null||plugin.gildenManager.getGilde(gilde).getMemberarray().isEmpty()) {
                            return;
                        } else {
                            int anzahl = plugin.gildenManager.getGilde(gilde).getMemberarray().size();
                            plugin.gildenInvManager.openMitgliederInv(p, anzahl, gilde);
                        }
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lÄlteste:")) {
                        String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        if(plugin.gildenManager.getGilde(gilde).getÄltestearray()==null||plugin.gildenManager.getGilde(gilde).getÄltestearray().isEmpty()) {
                            return;
                        } else {
                            int anzahl = plugin.gildenManager.getGilde(gilde).getÄltestearray().size();
                            plugin.gildenInvManager.openÄltesteInv(p, anzahl, gilde);
                        }
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lVize-Anführer:")) {
                        String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        if(plugin.gildenManager.getGilde(gilde).getVizearray()==null||plugin.gildenManager.getGilde(gilde).getVizearray().isEmpty()) {
                            return;
                        } else {
                            int anzahl = plugin.gildenManager.getGilde(gilde).getVizearray().size();
                            plugin.gildenInvManager.openVizeInv(p, anzahl, gilde);
                        }
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4§lAnführer:")) {
                        String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        plugin.gildenInvManager.openGildeAnführerInv(p, gilde);

                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lStatus:")) {
                        String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        plugin.gildenInvManager.openGildenStatusInv(p, gilde);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lLog-Buch:")) {
                        String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        plugin.gildenInvManager.openGildenLogInv(p, gilde);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lLevel:")) {
                        //String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        //plugin.gildenInvManager.openGildenLevelInv(p, gilde);
                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lBank:")) {
                        String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                        if(plugin.gildenManager.getGilde(gilde).getMemberarray().contains(p.getUniqueId().toString())) {
                            p.closeInventory();
                            p.sendMessage("§cKeine Berechtigung!");
                        } else {
                            plugin.gildenInvManager.openBankInv(p, gilde);
                        }

                    } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lDaily-Reward:")) {


                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§4Anführer")) {
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                    plugin.gildenInvManager.openManagerInventory(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§cMitglied-Information")){
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                        plugin.gildenInvManager.openMitgliederInv(p, plugin.gildenManager.getGilde(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString())).getMemberarray().size(), plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§6Ältester-Information")){
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                        plugin.gildenInvManager.openMitgliederInv(p, plugin.gildenManager.getGilde(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString())).getMemberarray().size(), plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§bVize-Information")){
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                        plugin.gildenInvManager.openMitgliederInv(p, plugin.gildenManager.getGilde(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString())).getMemberarray().size(), plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§cMitglieder")){
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                        plugin.gildenInvManager.openManagerInventory(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    } else if(e.getCurrentItem().getType().equals(Material.LEGACY_SKULL_ITEM)) {
                        String[] name = e.getCurrentItem().getItemMeta().getDisplayName().split("§c");
                        plugin.gildenInvManager.openGildenMitgliedInv(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), UUIDFetcher.getUUID(name[1]).toString());
                        //p.sendMessage(UUIDFetcher.getUUID(name[1]).toString());
                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§6Älteste")){
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                        plugin.gildenInvManager.openManagerInventory(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    } else if(e.getCurrentItem().getType().equals(Material.LEGACY_SKULL_ITEM)) {
                        String[] name = e.getCurrentItem().getItemMeta().getDisplayName().split("§6");
                        plugin.gildenInvManager.openGildenÄltesterInv(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), UUIDFetcher.getUUID(name[1]).toString());
                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§bVize-Anführer")){
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                        plugin.gildenInvManager.openManagerInventory(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    } else if(e.getCurrentItem().getType().equals(Material.LEGACY_SKULL_ITEM)) {
                        String[] name = e.getCurrentItem().getItemMeta().getDisplayName().split("§b");
                        plugin.gildenInvManager.openGildenVizeInv(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()), UUIDFetcher.getUUID(name[1]).toString());
                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§fStatus umändern")) {
            e.setCancelled(true);
            if(!e.getSlotType().equals(InventoryType.SlotType.OUTSIDE)) {
                String gilde = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(p.getUniqueId().toString())||plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())) {
                    if(e.getSlot()==11) {
                        if(plugin.gildenManager.getGilde(gilde).getStatus().equalsIgnoreCase("öffentlich")) {

                        } else {
                            p.closeInventory();
                            plugin.gildenManager.setGildenStatus(gilde, "öffentlich");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§3Die Gilde ist nun §a§l§nÖffentlich");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§3Die Gilde wurde von §c" + p.getName() + " §3auf §aÖffentlich §3gestellt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§3Die Gilde wurde von §c" + p.getName() + " §3auf §aÖffentlich §3gestellt");
                                } else {
                                    log.add("§3Die Gilde wurde von §c" + p.getName() + " §3auf §aÖffentlich §3gestellt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);

                        }
                    } else if(e.getSlot()==15) {
                        if(plugin.gildenManager.getGilde(gilde).getStatus().equalsIgnoreCase("privat")) {

                        } else {
                            p.closeInventory();
                            plugin.gildenManager.setGildenStatus(gilde, "privat");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§3Die Gilde ist nun §c§l§nPrivat");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§3Die Gilde wurde von §c" + p.getName() + " §3auf §cPrivat §3gestellt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§3Die Gilde wurde von §c" + p.getName() + " §3auf §cPrivat §3gestellt");
                                } else {
                                    log.add("§3Die Gilde wurde von §c" + p.getName() + " §3auf §cPrivat §3gestellt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        }
                    } else if(e.getSlot()==26) {
                        plugin.gildenInvManager.openManagerInventory(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    }

                } else {
                    p.closeInventory();
                    p.sendMessage(plugin.pr + " §cKeine Berechtigung");
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§5Gilden-Log")) {
            e.setCancelled(true);
            if(e.getCurrentItem()!=null) {
                if(e.getCurrentItem().hasItemMeta()) {
                    if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                        plugin.gildenInvManager.openManagerInventory(p, plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                    }
                }
            }
        } else if(e.getView().getTitle().equalsIgnoreCase("§6Gilden-Bank")) {
            e.setCancelled(true);
        } else if(e.getView().getTitle().equalsIgnoreCase("§aGilden-Level")) {
            e.setCancelled(true);
        }

    }
}
