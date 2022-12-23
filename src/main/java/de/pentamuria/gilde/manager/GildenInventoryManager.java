package de.pentamuria.gilde.manager;

import de.pentamuria.gilde.gilde.Gilde;
import de.pentamuria.gilde.gildensystem.GildenSystem;
import de.pentamuria.gilde.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class GildenInventoryManager {

    private GildenSystem plugin;
    public GildenInventoryManager(GildenSystem main) {
        this.plugin = main;
    }

    public void openSymbolAuswahl(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, "§aWähle Gilden-Symbol");

        ItemStack item = new ItemStack(Material.GRASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bGras");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§e§l<Auswählen>");
        meta.setLore(lore);
        item.setItemMeta(meta);

        ItemStack item1 = new ItemStack(Material.BRICK);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§bZiegel");
        ArrayList<String> lore1 = new ArrayList<String>();
        lore1.add("§e§l<Auswählen>");
        meta1.setLore(lore1);
        item1.setItemMeta(meta1);

        ItemStack item2 = new ItemStack(Material.NETHER_BRICK);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§bNetherstein");
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add("§e§l<Auswählen>");
        meta2.setLore(lore2);
        item2.setItemMeta(meta2);

        ItemStack item3 = new ItemStack(Material.QUARTZ_BLOCK);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§bQuartz");
        ArrayList<String> lore3 = new ArrayList<String>();
        lore3.add("§e§l<Auswählen>");
        meta3.setLore(lore3);
        item3.setItemMeta(meta3);

        ItemStack item4 = new ItemStack(Material.TNT);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§bTnT");
        ArrayList<String> lore4 = new ArrayList<String>();
        lore4.add("§e§l<Auswählen>");
        meta4.setLore(lore4);
        item4.setItemMeta(meta4);

        ItemStack item5 = new ItemStack(Material.OBSIDIAN);
        ItemMeta meta5 = item5.getItemMeta();
        meta5.setDisplayName("§bObsidian");
        ArrayList<String> lore5 = new ArrayList<String>();
        lore5.add("§e§l<Auswählen>");
        meta5.setLore(lore5);
        item5.setItemMeta(meta5);

        ItemStack item6 = new ItemStack(Material.LEGACY_WORKBENCH);
        ItemMeta meta6 = item6.getItemMeta();
        meta6.setDisplayName("§bZiegel");
        ArrayList<String> lore6 = new ArrayList<String>();
        lore6.add("§e§l<Auswählen>");
        meta6.setLore(lore6);
        item6.setItemMeta(meta6);

        ItemStack item7 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta7 = item7.getItemMeta();
        meta7.setDisplayName("§bDiamantschwert");
        ArrayList<String> lore7 = new ArrayList<String>();
        lore7.add("§e§l<Auswählen>");
        meta7.setLore(lore7);
        item7.setItemMeta(meta7);

        ItemStack item8 = new ItemStack(Material.BOW);
        ItemMeta meta8 = item8.getItemMeta();
        meta8.setDisplayName("§bBogen");
        ArrayList<String> lore8 = new ArrayList<String>();
        lore8.add("§e§l<Auswählen>");
        meta8.setLore(lore8);
        item8.setItemMeta(meta8);

        inv.setItem(0, item);
        inv.setItem(1, item1);
        inv.setItem(2, item2);
        inv.setItem(3, item3);
        inv.setItem(4, item4);
        inv.setItem(5, item5);
        inv.setItem(6, item6);
        inv.setItem(7, item7);
        inv.setItem(8, item8);

        p.openInventory(inv);


    }

    public void openFarbeAuswahl(Player p) {
        Inventory inv = Bukkit.createInventory(null, 18, "§aWähle Gilden-Farbe");


        ItemStack item = new ItemBuilder(Material.WHITE_WOOL, 1).setName("§fWeiß").addLoreLine("§e§l<Auswählen>").toItemStack();

        ItemStack item1 = new ItemBuilder(Material.ORANGE_WOOL, 1).setName("§6Orange").addLoreLine("§e§l<Auswählen>").toItemStack();

        ItemStack item2 = new ItemBuilder(Material.MAGENTA_WOOL, 1).setName("§dMagenta").addLoreLine("§e§l<Auswählen>").toItemStack();

        ItemStack item3 = new ItemBuilder(Material.LIGHT_BLUE_WOOL, 1).setName("§9Hellblau").addLoreLine("§e§l<Auswählen>").toItemStack();

        ItemStack item4 = new ItemBuilder(Material.YELLOW_WOOL, 1).setName("§eGelb").addLoreLine("§e§l<Auswählen>").toItemStack();

        ItemStack item5 = new ItemBuilder(Material.LIME_WOOL, 1).setName("§aHellgrün").addLoreLine("§e§l<Auswählen>").toItemStack();

        ItemStack item7 = new ItemBuilder(Material.GRAY_WOOL, 1).setName("§8Dunkelgrau").addLoreLine("§e§l<Auswählen>").toItemStack();

        ItemStack item8 = new ItemBuilder(Material.LIGHT_GRAY_WOOL, 1).setName("§7Hellgrau").addLoreLine("§e§l<Auswählen>").toItemStack();
        
        ItemStack item9 = new ItemBuilder(Material.CYAN_WOOL, 1).setName("§3Dunkeltürkis").addLoreLine("§e§l<Auswählen>").toItemStack();
        
        ItemStack item10 = new ItemBuilder(Material.PURPLE_WOOL, 1).setName("§5Lila").addLoreLine("§e§l<Auswählen>").toItemStack();
        
        ItemStack item11 = new ItemBuilder(Material.BLUE_WOOL, 1).setName("§1Dunkelblau").addLoreLine("§e§l<Auswählen>").toItemStack();
        
        ItemStack item13 = new ItemBuilder(Material.GREEN_WOOL, 1).setName("§2Dunkelgrün").addLoreLine("§e§l<Auswählen>").toItemStack();
        
        ItemStack item14 = new ItemBuilder(Material.RED_WOOL, 1).setName("§cRot").addLoreLine("§e§l<Auswählen>").toItemStack();
        
        ItemStack item15 = new ItemBuilder(Material.BLACK_WOOL, 1).setName("§0Schwarz").addLoreLine("§e§l<Auswählen>").toItemStack();
        
        ItemStack item16 = new ItemBuilder(Material.DIAMOND, 1).setName("§bTürkis").addLoreLine("§e§l<Auswählen>").toItemStack();

        inv.setItem(0, item);
        inv.setItem(1, item1);
        inv.setItem(2, item2);
        inv.setItem(3, item3);
        inv.setItem(4, item4);
        inv.setItem(5, item5);
        //inv.setItem(6, item6);
        inv.setItem(6, item7);
        inv.setItem(7, item8);
        inv.setItem(8, item9);
        inv.setItem(9, item10);
        inv.setItem(10, item11);
        //inv.setItem(11, item12);
        inv.setItem(11, item13);
        inv.setItem(12, item14);
        inv.setItem(13, item15);
        inv.setItem(14, item16);
        p.openInventory(inv);

    }

    public void openMainBrowserInventory(Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, "§bGilden-Browser");

        /*
         *  0  1  2  3  4  5  6  7  8
         *  9 10 11 12 13 14 15 16 17
         * 18 19 20 21 22 23 24 25 26
         * 27 28 29 30 31 32 33 34 35
         */
        if(plugin.gildenManager.alleGilden.size()<=26) {
            int i = 0;
            for(Map.Entry<String, Gilde> entry : plugin.gildenManager.alleGilden.entrySet()) {
                Gilde gilde = entry.getValue();
                ItemStack item = entry.getValue().getSymbol();
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', gilde.getFarbe()) + gilde.getName());
                ArrayList<String> lore1 = new ArrayList<String>();
                lore1.add("§c"+ "Mitglieder: " + gilde.getMemberanzahl() + "|" + gilde.getMaxMembers());
                lore1.add("§aLevel: " + gilde.getLevel());
                if(gilde.getStatus().equalsIgnoreCase("Privat")) {
                    lore1.add("§bStatus: §cPrivat");
                } else {
                    lore1.add("§bStatus: §aÖffentlich");
                }
                lore1.add("");
                lore1.add("§c§lBeschreibung:");
                String[] split = gilde.getBeschreibung().split("/%");
                for(String i1 : split) {
                    lore1.add(ChatColor.translateAlternateColorCodes('&', i1));
                }
                meta.setLore(lore1);
                item.setItemMeta(meta);
                inv.setItem(i, item);
                i=i+1;
            }
            ItemStack item2 = new ItemStack(Material.HOPPER);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName("§a§lFilter §4[Nicht verfügbar]");
            ArrayList<String> lore2 = new ArrayList<String>();
            lore2.add("§b§oNach Liste");
            lore2.add("§bLevel aufsteigend");
            lore2.add("§bLevel absteigend");
            lore2.add("§bNur §aoffene");
            lore2.add("§bNur §cprivate");
            lore2.add("§bNicht voll");
            meta2.setLore(lore2);
            item2.setItemMeta(meta2);
            inv.setItem(31, item2);
            //item2.setItemMeta(meta2);

            ItemStack item3 = new ItemStack(Material.OAK_SIGN);
            ItemMeta meta3 = item3.getItemMeta();
            meta3.setDisplayName("§a§lSuchen §4[Nicht verfügbar]");
            ArrayList<String> lore3 = new ArrayList<String>();
            meta3.setLore(lore3);
            item3.setItemMeta(meta3);
            item3.setItemMeta(meta3);
            inv.setItem(29, item3);

            ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
            for(int i1 = 0; i1<inv.getSize();i1++) {
                if(i1==27||i1==28||i1==30||i1==32||i1==33||i1==34||i1==35) {
                    inv.setItem(i1, c);
                }
            }

            //inv.setItem(35, item2);
        } else if(plugin.gildenManager.alleGilden.size()<=52) {
            ItemStack item1 = new ItemStack(Material.ARROW);
            ItemMeta meta1 = item1.getItemMeta();
            meta1.setDisplayName("§cSeite §8(2)");
            item1.setItemMeta(meta1);
            inv.setItem(35, item1);
            ItemStack item2 = new ItemStack(Material.HOPPER);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName("§a§lFilter");
            ArrayList<String> lore2 = new ArrayList<String>();
            lore2.add("§bNach Liste");
            lore2.add("§bLevel aufsteigend");
            lore2.add("§bLevel absteigend");
            lore2.add("§bNur §aoffene");
            lore2.add("§bNur §cprivate");
            lore2.add("§bNicht voll");
            meta2.setLore(lore2);
            item2.setItemMeta(meta2);
            inv.setItem(31, item2);
            ItemStack item3 = new ItemStack(Material.LEGACY_WORKBENCH);
            ItemMeta meta3 = item3.getItemMeta();
            meta3.setDisplayName("§a§lSuchen");
            ArrayList<String> lore3 = new ArrayList<String>();
            meta3.setLore(lore3);
            item3.setItemMeta(meta3);
            item3.setItemMeta(meta3);
            inv.setItem(29, item3);
            /*****************************************/
            int i = 0;
            for(Map.Entry<String, Gilde> entry : plugin.gildenManager.alleGilden.entrySet()) {
                if(i<=26) {
                    Gilde gilde = entry.getValue();
                    ItemStack item = entry.getValue().getSymbol();
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', gilde.getFarbe()) + gilde.getName());
                    ArrayList<String> lore1 = new ArrayList<String>();
                    lore1.add("§c"+ "Mitglieder: " + gilde.getMemberanzahl() + "|" + gilde.getMaxMembers());
                    lore1.add("§aLevel: " + gilde.getLevel());
                    if(gilde.getStatus().equalsIgnoreCase("Privat")) {
                        lore1.add("§bStatus: §cPrivat");
                    } else {
                        lore1.add("§bStatus: §aÖffentlich");
                    }
                    lore1.add("");
                    lore1.add("§c§lBeschreibung:");
                    String[] split = gilde.getBeschreibung().split("/%");
                    for(String i1 : split) {
                        lore1.add(ChatColor.translateAlternateColorCodes('&', i1));
                    }
                    meta.setLore(lore1);
                    item.setItemMeta(meta);
                    inv.setItem(i, item);
                    i=i+1;
                }

            }
        }
        p.openInventory(inv);




    }


    @SuppressWarnings("static-access")
    public void openManagerInventory(Player p, String gildeName) {
        //p.sendMessage("§cTest: " + plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
        if(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Keine")) {
            p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
            return;
        }

        Inventory inv = Bukkit.createInventory(null, 45, "§aGilden-Manager");
        /*
         * |  -  -  -  -  -  -  -
         * | 10 11 12 13 14 15 16  |
         * | 19 20 21 22 23 24 25  |
         * | 28 29 30 31 32 33 34  |
         * 	  -  -  -  -  -  -  -
         */
        Gilde gilde = plugin.gildenManager.getGilde(gildeName);

        ItemStack item1 = gilde.getSymbol();
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', gilde.getFarbe()) + gildeName);
        ArrayList<String> lore1 = new ArrayList<String>();
        if(gilde.getMemberanzahl()==gilde.getMaxMembers()) {
            lore1.add("§f"+ "Mitglieder: §c" + gilde.getMemberanzahl() + "§8|§c" + gilde.getMaxMembers());
        } else {
            lore1.add("§f"+ "Mitglieder: §a" + gilde.getMemberanzahl() + "§8|§c" + gilde.getMaxMembers());
        }

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        inv.setItem(13, item1);
        ItemStack item2 = new ItemStack(Material.CLOCK);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§e§lEröffungsdatum:");
        ArrayList<String> lore2 = new ArrayList<String>();
        lore2.add("§d"+ gilde.getEröffnung());
        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        inv.setItem(15, item2);
        ItemStack item3 = new ItemStack(Material.EMERALD);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§a§lLevel:");
        ArrayList<String> lore3 = new ArrayList<String>();
        lore3.add("§d"+ gilde.getLevel());
        //p.sendMessage("§cPunkte: " + plugin.gildenManager.getGildenPunkte(gilde));
        //p.sendMessage("§aPunkteForNext: " + plugin.gildenManager.getGildenDoubleForNextLevel(plugin.gildenManager.getGildenLevel(gilde))/100);

        int percentage = gilde.getPunkte()/(plugin.gildenManager.getGildenDoubleForNextLevel(gilde.getLevel())/100);
        lore3.add("§aProzess: §b"+percentage+"%");
        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        inv.setItem(11, item3);
        ItemStack item4 = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§c§lMitglieder:");
        ArrayList<String> lore4 = new ArrayList<String>();
        lore4.add("§dAnzahl: " + gilde.getMemberarray().size());
        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        inv.setItem(29, item4);
        ItemStack item5 = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta5 = item5.getItemMeta();
        meta5.setDisplayName("§6§lÄlteste:");
        ArrayList<String> lore5 = new ArrayList<String>();
        lore5.add("§dAnzahl: " + gilde.getÄltestearray().size());
        meta5.setLore(lore5);
        item5.setItemMeta(meta5);
        inv.setItem(30, item5);
        ItemStack item6 = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta6 = item6.getItemMeta();
        meta6.setDisplayName("§b§lVize-Anführer:");
        ArrayList<String> lore6 = new ArrayList<String>();
        lore6.add("§dAnzahl: " + gilde.getVizearray().size());
        meta6.setLore(lore6);
        item6.setItemMeta(meta6);
        inv.setItem(32, item6);
        ItemStack item7 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta7 = item7.getItemMeta();
        meta7.setDisplayName("§4§lAnführer:");
        ArrayList<String> lore7 = new ArrayList<String>();
        Player c = Bukkit.getPlayer(UUID.fromString(gilde.getAnführer()));
        if(c!=null) {
            lore7.add("§d"+ Bukkit.getPlayer(UUID.fromString(gilde.getAnführer())).getName());
        } else {
            lore7.add("§d"+ Bukkit.getOfflinePlayer(UUID.fromString(gilde.getAnführer())).getName());
        }






        meta7.setLore(lore7);
        item7.setItemMeta(meta7);
        inv.setItem(33, item7);
        if(gilde.getStatus().equalsIgnoreCase("Privat")) {
            ItemStack item8 = new ItemStack(Material.ANVIL);
            ItemMeta meta8 = item8.getItemMeta();
            meta8.setDisplayName("§f§lStatus:");
            ArrayList<String> lore8 = new ArrayList<String>();
            lore8.add("§cPrivat");
            meta8.setLore(lore8);
            item8.setItemMeta(meta8);
            inv.setItem(21, item8);

        } else if(gilde.getStatus().equalsIgnoreCase("öffentlich")) {
            ItemStack item8 = new ItemStack(Material.ANVIL);
            ItemMeta meta8 = item8.getItemMeta();
            meta8.setDisplayName("§f§lStatus:");
            ArrayList<String> lore8 = new ArrayList<String>();
            lore8.add("§aÖffentlich");
            meta8.setLore(lore8);
            item8.setItemMeta(meta8);
            inv.setItem(21, item8);
        } else {
            ItemStack item8 = new ItemStack(Material.ANVIL);
            ItemMeta meta8 = item8.getItemMeta();
            meta8.setDisplayName("§f§lStatus:");
            ArrayList<String> lore8 = new ArrayList<String>();
            lore8.add(gilde.getStatus());
            meta8.setLore(lore8);
            item8.setItemMeta(meta8);
            inv.setItem(21, item8);
        }
        ItemStack item9 = new ItemStack(Material.BOOK);
        ItemMeta meta9 = item9.getItemMeta();
        meta9.setDisplayName("§5§lLog-Buch:");
        ArrayList<String> lore9 = new ArrayList<String>();
        lore9.add("§e<Öffnen>");
        meta9.setLore(lore9);
        item9.setItemMeta(meta9);
        inv.setItem(23, item9);

        ItemStack item11 = new ItemStack(Material.PAPER);
        ItemMeta meta11 = item11.getItemMeta();
        meta11.setDisplayName("§cBeschreibung:");
        ArrayList<String> lore11 = new ArrayList<String>();
        String[] split = gilde.getBeschreibung().split("/%");
        for(String i : split) {
            lore11.add(ChatColor.translateAlternateColorCodes('&', i));
        }
        //lore11.add(ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGildenBeschreibung(gilde)));
        meta11.setLore(lore11);
        item11.setItemMeta(meta11);
        inv.setItem(16, item11);



        for(int i = 0;i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                ItemStack item = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
                inv.setItem(i, item);
            }

        }


        p.openInventory(inv);


    }

    public int getGildenDoubleForNextLevel(int level) {
        //File file = new File("plugins/SkyBlock/Gilden/" + name, "gildeninfos.yml");

        if(level==1) {
            return 500;
        } else if(level==2) {
            return 1000;
        } else if(level==3) {
            return 2000;
        } else if(level==4) {
            return 3000;
        } else if(level==5) {
            return 4000;
        } else if(level==6) {
            return 5000;
        } else if(level==7) {
            return 6000;
        } else if(level==8) {
            return 7000;
        } else if(level==9) {
            return 8000;
        } else if(level==10) {
            return 9000;
        } else if(level==11) {
            return 10000;
        } else if(level==12) {
            return 11000;
        } else if(level==13) {
            return 12000;
        } else if(level==14) {
            return 13000;
        } else if(level==15) {
            return 14000;
        } else if(level==16) {
            return 15000;
        } else if(level==17) {
            return 16000;
        } else if(level==18) {
            return 17000;
        } else if(level==19) {
            return 18000;
        } else if(level==20) {
            return 19000;
        } else if(level==21) {
            return 20000;
        } else if(level==22) {
            return 21000;
        } else if(level==23) {
            return 22000;
        } else if(level==24) {
            return 23000;
        } else {
            return 10000000;
        }
    }

    public ItemStack getGildenDailyBelohnung(int level) {

        if(level==2) {
            return new ItemStack(Material.COAL, 2);
        } else if(level==3) {
            return new ItemStack(Material.COAL, 4);
        } else if(level==4) {
            return new ItemStack(Material.COAL, 6);
        } else if(level==5) {
            return new ItemStack(Material.COAL, 8);
        } else if(level==6) {
            return new ItemStack(Material.COAL, 10);
        } else if(level==7) {
            return new ItemStack(Material.IRON_INGOT, 2);
        } else if(level==8) {
            return new ItemStack(Material.IRON_INGOT, 4);
        } else if(level==9) {
            return new ItemStack(Material.IRON_INGOT, 6);
        } else if(level==10) {
            return new ItemStack(Material.IRON_INGOT, 8);
        } else if(level==11) {
            return new ItemStack(Material.IRON_INGOT, 10);
        } else if(level==12) {
            return new ItemStack(Material.GOLD_INGOT, 2);
        } else if(level==13) {
            return new ItemStack(Material.GOLD_INGOT, 4);
        } else if(level==14) {
            return new ItemStack(Material.GOLD_INGOT, 6);
        } else if(level==15) {
            return new ItemStack(Material.GOLD_INGOT, 8);
        } else if(level==16) {
            return new ItemStack(Material.GOLD_INGOT, 10);
        } else if(level==17) {
            return new ItemStack(Material.DIAMOND, 2);
        } else if(level==18) {
            return new ItemStack(Material.DIAMOND, 4);
        } else if(level==19) {
            return new ItemStack(Material.DIAMOND, 6);
        } else if(level==20) {
            return new ItemStack(Material.DIAMOND, 8);
        } else if(level==21) {
            return new ItemStack(Material.DIAMOND, 10);
        } else if(level==22) {
            return new ItemStack(Material.EMERALD, 2);
        } else if(level==23) {
            return new ItemStack(Material.EMERALD, 4);
        } else if(level==24) {
            return new ItemStack(Material.EMERALD, 6);
        } else if(level==25) {
            return new ItemStack(Material.EMERALD, 8);
        } else {
            return new ItemStack(Material.STICK, 1);
        }

    }
    public void openMitgliederInv(Player p, int anzahl, String gilde) {
        if(anzahl<=8) {
            Inventory inv = Bukkit.createInventory(null, 9, "§cMitglieder");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getMemberarray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }

                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§c" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=17) {
            Inventory inv = Bukkit.createInventory(null, 18, "§cMitglieder");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getMemberarray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§c" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=26) {
            Inventory inv = Bukkit.createInventory(null, 27, "§cMitglieder");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getMemberarray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§c" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=35) {
            Inventory inv = Bukkit.createInventory(null, 36, "§cMitglieder");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getMemberarray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§c" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else {
            Inventory inv = Bukkit.createInventory(null, 45, "§cMitglieder");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getÄltestearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§c" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        }
    }
    public void openÄltesteInv(Player p, int anzahl, String gilde) {
        if(anzahl<=8) {
            Inventory inv = Bukkit.createInventory(null, 9, "§6Älteste");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getÄltestearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§6" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=17) {
            Inventory inv = Bukkit.createInventory(null, 18, "§6Älteste");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getÄltestearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§6" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=26) {
            Inventory inv = Bukkit.createInventory(null, 27, "§6Älteste");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getÄltestearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§6" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=35) {
            Inventory inv = Bukkit.createInventory(null, 36, "§6Älteste");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getÄltestearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§6" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else {
            Inventory inv = Bukkit.createInventory(null, 45, "§6Älteste");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getÄltestearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§6" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§c§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        }
    }
    public void openVizeInv(Player p, int anzahl, String gilde) {
        if(anzahl<=8) {
            Inventory inv = Bukkit.createInventory(null, 9, "§bVize-Anführer");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getVizearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§b" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§b§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=17) {
            Inventory inv = Bukkit.createInventory(null, 18, "§bVize-Anführer");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getVizearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§b" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§b§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=26) {
            Inventory inv = Bukkit.createInventory(null, 27, "§bVize-Anführer");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getVizearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§b" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§b§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else if(anzahl<=35) {
            Inventory inv = Bukkit.createInventory(null, 36, "§bVize-Anführer");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getVizearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§b" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§b§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        } else {
            Inventory inv = Bukkit.createInventory(null, 45, "§bVize-Anführer");
            for(String uuid : plugin.gildenManager.getGilde(gilde).getVizearray()) {
                String name = "";
                Player online = Bukkit.getPlayer(UUID.fromString(uuid));
                if(online!=null) {
                    name = online.getName();
                } else {
                    name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
                }
                ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta meta = (SkullMeta)skull.getItemMeta();
                meta.setOwner(name);
                meta.setDisplayName("§b" + name);
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("§e<Linksklick>");
                meta.setLore(lore);
                skull.setItemMeta(meta);
                inv.addItem(skull);
            }
            ItemStack back = new ItemStack(Material.ARROW);
            ItemMeta meta = back.getItemMeta();
            meta.setDisplayName("§b§nZurück");
            back.setItemMeta(meta);
            inv.addItem(back);
            p.openInventory(inv);
        }
    }
    public void openGildeAnführerInv(Player p, String gilde) {
        Inventory inv = Bukkit.createInventory(null, 27, "§4Anführer");
        String name = "";
        String uuid = plugin.gildenManager.getGilde(gilde).getAnführer();
        Player online = Bukkit.getPlayer(UUID.fromString(uuid));
        if(online!=null) {
            name = online.getName();
        } else {
            //OfflinePlayer offline = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
            name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
        }
        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setOwner(name);
        meta.setDisplayName("§b" + name);
        ArrayList<String> lore1 = new ArrayList<String>();
        //Player checkOffline = Bukkit.getPlayer(name)
        if(online!=null) {
            lore1.add("§fMomentan §a§nOnline");
        } else {
            lore1.add("§fMomentan §4§nOffline");
        }
        meta.setLore(lore1);
        skull.setItemMeta(meta);
        inv.setItem(13, skull);

        ItemStack item4 = new ItemStack(Material.PAPER);
        ItemMeta meta4 = item4.getItemMeta();
        if(p!=null) {
            if(plugin.msgtoggle.contains(p)) {
                meta4.setDisplayName("§5§l§nNachrichten:§c Aus");
            } else {
                meta4.setDisplayName("§5§l§nNachrichten:§a An");
            }
        } else {
            meta4.setDisplayName("§5§l§nNachrichten:§a An");
        }
        item4.setItemMeta(meta4);
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta5 = back.getItemMeta();
        meta5.setDisplayName("§b§nZurück");
        back.setItemMeta(meta5);
        inv.setItem(26, back);
        p.openInventory(inv);


        inv.setItem(22, item4);

        ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, c);
            }
        }


        p.openInventory(inv);



    }

    public void openGildenMitgliedInv(Player p, String gilde, String playeruuid) {
        Inventory inv = Bukkit.createInventory(null, 27, "§cMitglied-Information");
        String name = "";
        String uuid = playeruuid;
        Player online = Bukkit.getPlayer(UUID.fromString(uuid));
        if(online!=null) {
            name = online.getName();
        } else {
            //OfflinePlayer offline = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
            name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
        }
        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setOwner(name);
        meta.setDisplayName("§c" + name);
        ArrayList<String> lore1 = new ArrayList<String>();
        if(online!=null) {
            lore1.add("§fMomentan §a§nOnline");
        } else {
            lore1.add("§fMomentan §4§nOffline");
        }
        lore1.add("§6§l§nGilden-Rang:§c Mitglied");
        meta.setLore(lore1);
        skull.setItemMeta(meta);
        inv.setItem(13, skull);


        ItemStack item4 = new ItemStack(Material.PAPER);
        ItemMeta meta4 = item4.getItemMeta();
        if(p!=null) {
            if(plugin.msgtoggle.contains(p)) {
                meta4.setDisplayName("§5§l§nNachrichten:§c Aus");
            } else {
                meta4.setDisplayName("§5§l§nNachrichten:§a An");
            }
        } else {
            meta4.setDisplayName("§5§l§nNachrichten:§a An");
        }
        item4.setItemMeta(meta4);
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta5 = back.getItemMeta();
        meta5.setDisplayName("§b§nZurück");
        back.setItemMeta(meta5);
        inv.setItem(26, back);
        p.openInventory(inv);


        inv.setItem(22, item4);

        ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, c);
            }
        }
        p.openInventory(inv);
    }
    public void openGildenÄltesterInv(Player p, String gilde, String playeruuid) {
        Inventory inv = Bukkit.createInventory(null, 27, "§6Ältester-Information");
        String name = "";
        String uuid = playeruuid;
        Player online = Bukkit.getPlayer(UUID.fromString(uuid));
        if(online!=null) {
            name = online.getName();
        } else {
            //OfflinePlayer offline = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
            name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
        }
        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setOwner(name);
        meta.setDisplayName("§6" + name);
        ArrayList<String> lore1 = new ArrayList<String>();
        if(online!=null) {
            lore1.add("§fMomentan §a§nOnline");
        } else {
            lore1.add("§fMomentan §4§nOffline");
        }
        lore1.add("§6§l§nGilden-Rang:§6 Ältester");
        meta.setLore(lore1);
        skull.setItemMeta(meta);
        inv.setItem(13, skull);



        ItemStack item4 = new ItemStack(Material.PAPER);
        ItemMeta meta4 = item4.getItemMeta();
        if(p!=null) {
            if(plugin.msgtoggle.contains(p)) {
                meta4.setDisplayName("§5§l§nNachrichten:§c Aus");
            } else {
                meta4.setDisplayName("§5§l§nNachrichten:§a An");
            }
        } else {
            meta4.setDisplayName("§5§l§nNachrichten:§a An");
        }
        item4.setItemMeta(meta4);
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta5 = back.getItemMeta();
        meta5.setDisplayName("§b§nZurück");
        back.setItemMeta(meta5);
        inv.setItem(26, back);
        p.openInventory(inv);

        inv.setItem(22, item4);

        ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, c);
            }
        }
        p.openInventory(inv);
    }
    public void openGildenVizeInv(Player p, String gilde, String playeruuid) {
        Inventory inv = Bukkit.createInventory(null, 27, "§bVize-Information");
        String name = "";
        String uuid = playeruuid;
        Player online = Bukkit.getPlayer(UUID.fromString(uuid));
        if(online!=null) {
            name = online.getName();
        } else {
            //OfflinePlayer offline = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
            name=Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName();
        }
        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setOwner(name);
        meta.setDisplayName("§b" + name);
        ArrayList<String> lore1 = new ArrayList<String>();
        if(p!=null) {
            lore1.add("§fMomentan §a§nOnline");
        } else {
            lore1.add("§fMomentan §4§nOffline");
        }
        lore1.add("§6§l§nGilden-Rang:§b Vize-Anführer");
        meta.setLore(lore1);
        skull.setItemMeta(meta);
        inv.setItem(13, skull);

        ItemStack item4 = new ItemStack(Material.PAPER);
        ItemMeta meta4 = item4.getItemMeta();
        if(p!=null) {
            if(plugin.msgtoggle.contains(p)) {
                meta4.setDisplayName("§5§l§nNachrichten:§c Aus");
            } else {
                meta4.setDisplayName("§5§l§nNachrichten:§a An");
            }
        } else {
            meta4.setDisplayName("§5§l§nNachrichten:§a An");
        }
        item4.setItemMeta(meta4);
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta5 = back.getItemMeta();
        meta5.setDisplayName("§b§nZurück");
        back.setItemMeta(meta5);
        inv.setItem(26, back);
        p.openInventory(inv);

        inv.setItem(22, item4);

        ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, c);
            }
        }
        p.openInventory(inv);
    }



    public void openGildenStatusInv(Player p, String gilde) {
        Inventory inv = Bukkit.createInventory(null, 27, "§fStatus umändern");

        ItemStack item1 = new ItemStack(Material.LIME_DYE, 1);
        ItemMeta meta1 = item1.getItemMeta();
        if(plugin.gildenManager.getGilde(gilde).getStatus().equalsIgnoreCase("öffentlich")) {
            meta1.setDisplayName("§aÖffentlich §a§l✔");
        } else {
            meta1.setDisplayName("§aÖffentlich §4§l✘");
        }
        item1.setItemMeta(meta1);

        ItemStack item2 = new ItemStack(Material.RED_DYE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        if(plugin.gildenManager.getGilde(gilde).getStatus().equalsIgnoreCase("privat")) {
            meta2.setDisplayName("§cPrivat §a§l✔");
        } else {
            meta2.setDisplayName("§cPrivat §4§l✘");
        }
        item2.setItemMeta(meta2);
        inv.setItem(11, item1);
        inv.setItem(15, item2);
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta5 = back.getItemMeta();
        meta5.setDisplayName("§b§nZurück");
        back.setItemMeta(meta5);
        inv.setItem(26, back);
        p.openInventory(inv);

        ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, c);
            }
        }
        p.openInventory(inv);


    }
    public void openGildenLogInv(Player p, String gilde) {
        Inventory inv = Bukkit.createInventory(null, 36, "§5Gilden-Log");

        for(int i = 0; i<plugin.gildenManager.getGildeLog(gilde).size();i++) {
            ItemStack log = new ItemStack(Material.PAPER);
            ItemMeta lmeta = log.getItemMeta();
            lmeta.setDisplayName(plugin.gildenManager.getGildeLog(gilde).get(i));
            log.setItemMeta(lmeta);
            inv.setItem(i, log);
        }


        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta5 = back.getItemMeta();
        meta5.setDisplayName("§b§nZurück");
        back.setItemMeta(meta5);
        inv.setItem(35, back);
        //p.openInventory(inv);
        ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, c);
            }
        }
        p.openInventory(inv);
    }
    public void openBankInv(Player p, String gilde) {
        Inventory inv = Bukkit.createInventory(null, 27, "§6Gilden-Bank");


        p.openInventory(inv);
    }
    public void openGildenLevelInv(Player p, String gilde) {
        Inventory inv = Bukkit.createInventory(null, 27, "§aGilden-Level");


        ItemStack item1 = new ItemStack(Material.CHEST);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§6100 Taler §aeinzahlen");
        item1.setItemMeta(meta1);
        inv.setItem(10, item1);

        ItemStack item2 = new ItemStack(Material.CHEST);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§6500 Taler §aeinzahlen");
        item2.setItemMeta(meta2);
        inv.setItem(11, item2);

        ItemStack item3 = new ItemStack(Material.CHEST);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§61000 Taler §aeinzahlen");
        item3.setItemMeta(meta3);
        inv.setItem(15, item3);

        ItemStack item4 = new ItemStack(Material.CHEST);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§65000 Taler §aeinzahlen");
        item4.setItemMeta(meta4);
        inv.setItem(16, item4);

        ItemStack item5 = new ItemStack(Material.OAK_SIGN);
        ItemMeta meta5 = item5.getItemMeta();
        meta5.setDisplayName("§6Bestimmt viel §aeinzahlen");
        item5.setItemMeta(meta5);
        inv.setItem(22, item5);

        ItemStack level = new ItemStack(Material.EMERALD);
        ItemMeta meta = level.getItemMeta();
        meta.setDisplayName("§aLevel: §d" + plugin.gildenManager.getGilde(gilde).getLevel());
        ArrayList<String> lore = new ArrayList<String>();
        int percentage = plugin.gildenManager.getGilde(gilde).getPunkte()/(plugin.gildenManager.getGildenDoubleForNextLevel(plugin.gildenManager.getGilde(gilde).getLevel())/100);
        lore.add("§eProcess: §b" + percentage + "%");
        lore.add("§ePunkte: §a" + plugin.gildenManager.getGilde(gilde).getPunkte()+"§8|§c"+plugin.gildenManager.getGildenDoubleForNextLevel(plugin.gildenManager.getGilde(gilde).getLevel()));
        lore.add("");
        lore.add("§a§nBelohnung:");
        lore.add(plugin.gildenManager.getGildenBelohnung(plugin.gildenManager.getGilde(gilde).getLevel()+1));
        lore.add("§5+2 Gilden-Plätze");
        meta.setLore(lore);
        level.setItemMeta(meta);
        inv.setItem(13, level);
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backmeta = back.getItemMeta();
        backmeta.setDisplayName("§b§nZurück");
        back.setItemMeta(backmeta);
        inv.setItem(26, back);
        //p.openInventory(inv);
        ItemStack c = new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§d").toItemStack();
        for(int i = 0; i<inv.getSize();i++) {
            if(inv.getItem(i)==null) {
                inv.setItem(i, c);
            }
        }
        p.openInventory(inv);
    }
}
