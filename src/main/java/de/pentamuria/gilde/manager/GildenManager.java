package de.pentamuria.gilde.manager;

import de.pentamuria.gilde.gilde.Gilde;
import de.pentamuria.gilde.gildensystem.GildenSystem;
import de.pentamuria.gilde.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class GildenManager extends GildenChatManager {

    public HashMap<String, Gilde> alleGilden;
    public HashMap<String, String> allePlayerGilde;

    public int neueGilden = 0;
    public int gelöschteGilden = 0;
    public int updatedGilden = 0;
    private GildenSystem plugin;


    public GildenManager(GildenSystem main) {
        super(main);
        this.plugin = main;
        alleGilden = new HashMap<>();
        allePlayerGilde = new HashMap<>();

    }


    public ArrayList<String> getAlleGilden() {
        ArrayList<String> all = new ArrayList<String>();
        for(String f : alleGilden.keySet()) {
            all.add(f);
        }
        return all;
    }
    public ArrayList<String> getAllePlayerGilden() {
        ArrayList<String> all = new ArrayList<String>();
        for(String f : allePlayerGilde.keySet()) {
            all.add(f);
        }
        return all;
    }


    private ArrayList<String> getAllGuilds() {
        File file = new File("plugins/Gilden", "gilden.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        if (file.exists()) {
            ArrayList<String> allguilds = (ArrayList<String>) cfg.getStringList("gilden");
            return allguilds;
        } else {
            return new ArrayList<String>();
        }
    }

    private Gilde loadGilde(String name) {
        File file = new File("plugins/Gilden/" + name, "gildeninfos.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (file.exists()) {
            Inventory inv = Bukkit.createInventory(null, 5*9, "§aGilden Rucksack");
            if(cfg.contains("Bag")) {
                ItemStack[] content = ((List<ItemStack>) cfg.get("Bag")).toArray(new ItemStack[0]);
                inv.setContents(content);
            } else {
                inv.addItem(new ItemStack(Material.OAK_LOG, 1));
            }
            Location base1 = null;
            Location base2 = null;
            if(cfg.contains("Base1") && cfg.get("Base1")!=null) {
                base1 = (Location) cfg.get("Base1");
            }
            if(cfg.contains("Base2") && cfg.get("Base2")!=null) {
                base2 = (Location) cfg.get("Base2");
            }

            Gilde gilde = new Gilde(name, cfg.getString("Kuerzel"), 1, cfg.getString("Status"), cfg.getDouble("Bank"),
                    cfg.getString("Beschreibung"), cfg.getInt("punkte"), cfg.getString("Eröffnung"),
                    (ArrayList<String>) cfg.getStringList("Memberarray"), cfg.getInt("Memberanzahl"),
                    (ArrayList<String>) cfg.getStringList("Ältestearray"),
                    (ArrayList<String>) cfg.getStringList("Vizearray"), cfg.getString("Anführer"),
                    cfg.getString("Farbe"), cfg.getInt("MaxMembers"), (ItemStack) cfg.get("Symbol"), inv,
                    base1, base2);
            return gilde;

        } else {
            return null;
        }
    }

    public void loadAllGilden() {
        alleGilden = new HashMap<>();
        allePlayerGilde = new HashMap<>();
        for (String name : getAllGuilds()) {
            alleGilden.put(name, loadGilde(name));
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            allePlayerGilde.put(p.getUniqueId().toString(), loadPlayerGilde(p.getUniqueId().toString()));
        }
        Bukkit.getConsoleSender().sendMessage("§aAlle Gilden: §7" + alleGilden);
        Bukkit.getConsoleSender().sendMessage("§aAlle Player Gilden: §7" + allePlayerGilde);

    }
    public void loadPlayerGildeCauseJoin(String uuid) {

        if(!allePlayerGilde.containsKey(uuid)) {
            String gildenName = loadPlayerGilde(uuid);

            if(gildeExist(gildenName)) {
                allePlayerGilde.put(uuid, loadPlayerGilde(uuid));
                //Bukkit.broadcastMessage("§6" + uuid + " §bwurde geladen für §e" + gildenName);
            } else {
                //Bukkit.broadcastMessage("§6" + uuid + " §bwurde geladen für §cKeine") ;
                allePlayerGilde.put(uuid, "Keine");
            }


        }
    }

    private String loadPlayerGilde(String uuid) {
        File file = new File("plugins/playerdata/" + uuid, "gilde.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (file.exists()) {
            if (cfg.contains("Gilde")) {
                return cfg.getString("Gilde");
            } else {
                return "Keine";
            }
        } else {
            return "Keine";
        }
    }

    public Gilde getGilde(String name) {
        if(alleGilden.containsKey(name)) {
            return alleGilden.get(name);
        } else {
            return null;
        }
    }

    public void updateGilde(String name, Gilde gilde) {
        alleGilden.put(name, gilde);
    }

    public String getPlayerGilde(String uuid) {
        if(allePlayerGilde.containsKey(uuid)) {
            return allePlayerGilde.get(uuid);
        } else {
            return "Keine";
        }


    }

    public void updatePlayerGilde(String uuid, String gilde) {
        allePlayerGilde.put(uuid, gilde);
    }

    public String getPlayerGildeWithColor(Player p) {

        if (getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Keine")||getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Keine")) {
            return "§cKeine";
        } else {

            String gildeName = getPlayerGilde(p.getUniqueId().toString());
            return ChatColor.translateAlternateColorCodes('&', getGilde(gildeName).getFarbe()) + gildeName;
        }
    }

    public String getPlayerGildeWithColor(String gilde) {

        if (gilde.equalsIgnoreCase("Keine")||gilde.equalsIgnoreCase("Keine")) {
            return "§cKeine";
        } else {
            return ChatColor.translateAlternateColorCodes('&', getGilde(gilde).getFarbe()) + gilde;
        }
    }

    public String getPlayerColor(Player p) {
        String gilde = getPlayerGilde(p.getUniqueId().toString());
        ArrayList<String> allplayer = getGilde(gilde).getMemberarray();
        ArrayList<String> allälteste = getGilde(gilde).getÄltestearray();
        ArrayList<String> allvize = getGilde(gilde).getVizearray();
        // String anführer = GuildManager.getGildenAnführer(gilde);
        if (allplayer.contains(p.getUniqueId().toString())) {

            return "§c";
        } else if (allälteste.contains(p.getUniqueId().toString())) {

            return "§6";
        } else if (allvize.contains(p.getUniqueId().toString())) {

            return "§b";
        } else {
            return "§4";
        }
    }



    public void removePlayerFromGilde(String uuid, String gilde) {

        allePlayerGilde.put(uuid, "Keine");

        ArrayList<String> members = getGilde(gilde).getMemberarray();
        ArrayList<String> älteste = getGilde(gilde).getÄltestearray();
        ArrayList<String> vize = getGilde(gilde).getVizearray();
        String anführer = getGilde(gilde).getAnführer();

        if (!members.isEmpty()&&members.contains(uuid)) {
            members.remove(uuid);
            getGilde(gilde).setMemberarray(members);
        }
        if (!älteste.isEmpty()&&älteste.contains(uuid)) {
            älteste.remove(uuid);
            getGilde(gilde).setÄltestearray(älteste);
        }
        if (!vize.isEmpty()&&vize.contains(uuid)) {
            vize.remove(uuid);
            getGilde(gilde).setVizearray(vize);
        }
        if (anführer.equalsIgnoreCase(uuid)) {
            getGilde(gilde).setAnführer(null);
        }

        int zahl = getGilde(gilde).getMemberanzahl() - 1;
        getGilde(gilde).setMemberanzahl(zahl);

        refreshPlayerScoreboardTeam(Bukkit.getPlayer(UUID.fromString(uuid)));


    }

    public void removeGilde(Player p, String name) {

        sendAllGildenPlayerMessage(name, "§Diese Gilde wird gelöscht...", p);

        removePlayerFromGilde(getGilde(name).getAnführer(), name);
        try {
            //System.out.println("Delete Members");
            if(getGilde(name).getMemberarray()!=null&&!getGilde(name).getMemberarray().isEmpty()) {
                //System.out.println("Member: " + getGilde(name).getMemberarray());
                for (String mitglieder : getGilde(name).getMemberarray()) {
                    //System.out.println("Mitglied: " + mitglieder);
                    removePlayerFromGilde(mitglieder, name);
                }
            }

            if(getGilde(name).getÄltestearray()!=null&&!getGilde(name).getÄltestearray().isEmpty()) {
                //System.out.println("Älteste: " + getGilde(name).getÄltestearray());
                for (String älteste : getGilde(name).getÄltestearray()) {
                    removePlayerFromGilde(älteste, name);
                }
            }
            if(getGilde(name).getVizearray()!=null&&!getGilde(name).getVizearray().isEmpty()) {
                //System.out.println("Vize: " + getGilde(name).getVizearray());
                for (String vize : getGilde(name).getVizearray()) {
                    removePlayerFromGilde(vize, name);
                }
            }
        } catch (Exception ex) {

        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                alleGilden.remove(name);

            }

        }, 1);
        p.sendMessage(plugin.pr + " §cDu hast deine Gilde gelöscht!");


    }

    public void createNewGilde(Player p, String gildenName, String kuerzel) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter df;
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

        String d = date.format(df);

        ArrayList<String> allmembers = new ArrayList<String>();
        ArrayList<String> allälteste = new ArrayList<String>();
        ArrayList<String> allvize = new ArrayList<String>();

        if (gildenName.equalsIgnoreCase("Keine")) {
            p.sendMessage(plugin.pr + " §cBitte nehme einen anderen Namen!");
            return;
        }

        if (gildeExist(gildenName)) {
            p.sendMessage(plugin.pr + " §cDiese Gilde existiert bereits");
            return;
        }
        if(hasGilde(p)) {
            p.sendMessage(plugin.pr + " §cDu bist bereits in einer Gilde");
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, "§aGilden Rucksack");
        inv.addItem(new ItemStack(Material.OAK_LOG, 1));
        Gilde gilde = new Gilde(gildenName, kuerzel, 1, "Privat", 0.0, "&cKeine Beschreibung vorhanden", 0, d, allmembers, 1,
                allälteste, allvize, p.getUniqueId().toString(), "&c", 10, new ItemStack(Material.BARRIER), inv,
                null, null);
        alleGilden.put(gildenName, gilde);

        p.sendMessage("§e§lGilden-Eröffnung");

        updatePlayerGilde(p.getUniqueId().toString(), gildenName);

        plugin.gildenInvManager.openFarbeAuswahl(p);


    }

    public String getGildenBelohnung(int level) {

        if(level==2||level==3) {
            return "§c+10 Taler §6[Tägliche-Belohnung]";
        } else {
            return "§c+20 Taler §6[Tägliche-Belohnung]";
        }





    }
    public int getGildenDailyBelohnung(int level) {

        if(level==2) {
            return 10;
        } else if(level==3) {
            return 20;
        } else if(level==4) {
            return 40;
        } else if(level==5) {
            return 60;
        } else if(level==6) {
            return 80;
        } else if(level==7) {
            return 100;
        } else if(level==8) {
            return 120;
        } else if(level==9) {
            return 140;
        } else if(level==10) {
            return 160;
        } else if(level==11) {
            return 180;
        } else if(level==12) {
            return 200;
        } else if(level==13) {
            return 220;
        } else if(level==14) {
            return 240;
        } else if(level==15) {
            return 280;
        } else if(level==16) {
            return 300;
        } else if(level==17) {
            return 320;
        } else if(level==18) {
            return 340;
        } else if(level==19) {
            return 360;
        } else if(level==20) {
            return 380;
        } else if(level==21) {
            return 400;
        } else if(level==22) {
            return 420;
        } else if(level==23) {
            return 440;
        } else if(level==24) {
            return 460;
        } else if(level==25) {
            return 480;
        } else {
            return 0;
        }

    }

    public boolean hasGilde(Player p) {
        if(getPlayerGilde(p.getUniqueId().toString())!=null) {
            if(getPlayerGilde(p.getUniqueId().toString()).contains("Keine")||getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Keine")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean gildeExist(String gildenName) {
        if (alleGilden.containsKey(gildenName)) {
            return true;
        } else {
            return false;
        }
    }

    // TODO funktioniert nicht
    public ArrayList<String> getGildeLog(String name) {
        return new ArrayList<String>();
    }

    // TODO funktioniert nicht
    public void setGildeLog(String name, ArrayList<String> log) {
    }

    public void addPlayerToGilde(Player player, String gildeName) {
        allePlayerGilde.put(player.getUniqueId().toString(), gildeName);
        Gilde gilde = getGilde(gildeName);
        ArrayList<String> memberarray = gilde.getMemberarray();
        memberarray.add(player.getUniqueId().toString());
        gilde.setMemberarray(memberarray);
        gilde.setMemberanzahl(gilde.getMemberanzahl() + 1);
        updateGilde(gildeName, gilde);
        refreshPlayerScoreboardTeam(player, gilde);
    }

    /**
     * Refreshes Sidebar Scoreboard of Player
     * Refreshes nametag of player for everyone
     * @param p
     * @param gilde
     */
    public void refreshPlayerScoreboardTeam(Player p, Gilde gilde) {
        plugin.scoreboardAPI.getPlayerScoreboard().updateGilde(p, getPlayerGildeWithColor(gilde.getName()));
        String colorCode = gilde.getFarbe(); // Your color code
        char code = colorCode.charAt(1); // Extract the color code character after the "&"
        ChatColor chatColor = ChatColor.getByChar(code);
        String kuerzel = gilde.getKuerzel() + " ";
        for(Player all : Bukkit.getOnlinePlayers()) {
            plugin.scoreboardAPI.getPlayerScoreboard().getCustomScoreboard(all).removePlayer(p);
            plugin.scoreboardAPI.getPlayerScoreboard().getCustomScoreboard(all).addPlayer(
                    p,
                    getPlayerGilde(p.getUniqueId().toString()),
                    kuerzel,
                    " §c" + plugin.statsAPI.stats.getPlayerStats(p.getUniqueId().toString()).getDeaths(),
                    chatColor);
        }
    }

    /**
     * For leaving the guild!
     * Refreshes Sidebar Scorebooard of Player
     * Refreshes nametag of player for everyone
     * @param p
     */
    public void refreshPlayerScoreboardTeam(Player p) {
        plugin.scoreboardAPI.getPlayerScoreboard().updateGilde(p, getPlayerGildeWithColor(p));
        String colorCode = hasGilde(p) ? getGilde(getPlayerGilde(p.getUniqueId().toString())).getFarbe() : "&c"; // Your color code
        char code = colorCode.charAt(1); // Extract the color code character after the "&"
        ChatColor chatColor = ChatColor.getByChar(code);
        String kuerzel = hasGilde(p) ? getGilde(getPlayerGilde(p.getUniqueId().toString())).getKuerzel() + " " : "";

        for(Player all : Bukkit.getOnlinePlayers()) {
            plugin.scoreboardAPI.getPlayerScoreboard().getCustomScoreboard(all).removePlayer(p);
            plugin.scoreboardAPI.getPlayerScoreboard().getCustomScoreboard(all).addPlayer(
                    p,
                    getPlayerGilde(p.getUniqueId().toString()),
                    kuerzel,
                    " §c" + plugin.statsAPI.stats.getPlayerStats(p.getUniqueId().toString()).getDeaths(),
                    chatColor);
        }
    }

    public void setGildenStatus(String gildenName, String status) {
        Gilde gilde = getGilde(gildenName);
        gilde.setStatus(status);
        updateGilde(gildenName, gilde);
    }

    public void addGildenBeschreibung(String gildenName, String beschreibung) {
        Gilde gilde = getGilde(gildenName);
        gilde.setBeschreibung(beschreibung);
        updateGilde(gildenName, gilde);
    }

    public void changeGildenFarbe(String gildenName, String farbe) {
        Gilde gilde = getGilde(gildenName);
        gilde.setFarbe(farbe);
        updateGilde(gildenName, gilde);
    }

    public void changeGildenSymbol(String gildenName, ItemStack itemStack) {
        Gilde gilde = getGilde(gildenName);
        gilde.setSymbol(itemStack);
        updateGilde(gildenName, gilde);
    }

    public void upLoadAll() {
        /*
         * Gilden änderungen Neue Gilden, Gelöschte Gilden PlayerGilden
         */
        ArrayList<String> gildenCurrent = new ArrayList<>();
        for (String gilde : alleGilden.keySet()) {
            gildenCurrent.add(gilde);
        }
        /*
         * Ändert alle Gilden-Datein auf AKTUELL
         *
         */
        uploadGildenChanges(gildenCurrent);

        /*
         * Erstellt neue Gilden Löscht alte Gilden Aktualisiert die Liste mit allen
         * Gilden
         */
        uploadGildenListe(gildenCurrent);

        /*
         * Alle Änderung im File, wo die Gilde des Spielers definiert ist
         */
        uploadPlayerGildenChanges();

    }

    private void uploadPlayerGildenChanges() {
        for (String uuid : allePlayerGilde.keySet()) {
            addPlayerToGilde(uuid, allePlayerGilde.get(uuid));
        }
    }

    private void uploadGildenChanges(ArrayList<String> gilden) {
        File file = new File("plugins/Gilden", "gilden.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (file.exists()) {
            ArrayList<String> old = (ArrayList<String>) cfg.getStringList("gilden");
            if(old!=null&&!old.isEmpty()) {
                for (String name : old) {
                    if(gilden.contains(name)) {
                        Bukkit.getConsoleSender().sendMessage("§a[Update] §eGilde " + name + " §bwurde §aaktualisiert");
                        updatedGilden++;
                        updateGildeFile(getGilde(name));
                    }
                }
            }
        }

    }

    public void removeGuildFile(String name) {
        File delete = new File("plugins/Gilden/" + name);
        if (delete.isDirectory()) {
            try {
                deleteDirectory(delete);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    // function to delete subdirectories and files
    public void deleteDirectory(File file)
    {
        // store all the paths of files and folders present
        // inside directory
        for (File subfile : file.listFiles()) {

            // if it is a subfolder,e.g Rohan and Ritik,
            // recursiley call function to empty subfolder
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }

            // delete files and empty subfolders
            subfile.delete();
        }
    }
    public int getGildenDoubleForNextLevel(int level) {
        //File file = new File("plugins/Gilden/" + name, "gildeninfos.yml");

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

    public void uploadGildenListe(ArrayList<String> gilden) {
        File file = new File("plugins/Gilden", "gilden.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Bukkit.getConsoleSender().sendMessage(plugin.pr + "§aErstelle§7/§cEntferne §7alle §bGilden");
        if (file.exists()) {
            ArrayList<String> old = (ArrayList<String>) cfg.getStringList("gilden");
            for (String name : old) {
                if (!gilden.contains(name)) {
                    Bukkit.getConsoleSender().sendMessage("§4[Remove] §eGilde " + name + " §bwurde §4entfernt!");
                    gelöschteGilden++;
                    removeGuildFile(name);
                }
            }
            for (String name : gilden) {
                if (!old.contains(name)) {
                    Bukkit.getConsoleSender().sendMessage("§a[Neu] §eGilde " + name + " §bwurde §aerstellt!");
                    neueGilden++;
                    createNewGildeFile(getGilde(name));
                }
            }

            file.delete();
        } else {
            for (String name : gilden) {
                Bukkit.getConsoleSender().sendMessage("§a[Neu] §eGilde " + name + " §bwurde §aerstellt!");
                neueGilden++;
                createNewGildeFile(getGilde(name));
            }
        }
        cfg.set("gilden", gilden);
        try {
            cfg.save(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void updateGildeFile(Gilde gilde) {
        File file = new File("plugins/Gilden/" + gilde.getName(), "gildeninfos.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        cfg.set("Name", gilde.getName());
        cfg.set("Kuerzel", gilde.getKuerzel());
        cfg.set("Level", gilde.getLevel());
        cfg.set("Status", gilde.getStatus());
        cfg.set("Bank", gilde.getBank());
        cfg.set("Farbe", gilde.getFarbe());
        cfg.set("Beschreibung", gilde.getBeschreibung());
        cfg.set("punkte", gilde.getPunkte());
        cfg.set("Eröffnung", gilde.getEröffnung());
        cfg.set("Memberarray", gilde.getMemberarray());
        cfg.set("Memberanzahl", gilde.getMemberanzahl());
        cfg.set("Ältestearray", gilde.getÄltestearray());
        cfg.set("Vizearray", gilde.getVizearray());
        cfg.set("Anführer", gilde.getAnführer());
        cfg.set("Symbol", gilde.getSymbol());
        cfg.set("Bag", gilde.getBag().getContents());
        cfg.set("Base1", gilde.getBase1());
        cfg.set("Base2", gilde.getBase2());

        cfg.set("MaxMembers", gilde.getMaxMembers());
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewGildeFile(Gilde gilde) {
        File file = new File("plugins/Gilden/" + gilde.getName(), "gildeninfos.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Bukkit.getConsoleSender().sendMessage("§cErstelle Gilde...§a" + gilde);
        cfg.set("Name", gilde.getName());
        cfg.set("Kuerzel", gilde.getKuerzel());
        cfg.set("Level", gilde.getLevel());
        cfg.set("Status", gilde.getStatus());
        cfg.set("Bank", gilde.getBank());
        cfg.set("Farbe", gilde.getFarbe());
        cfg.set("Beschreibung", gilde.getBeschreibung());
        cfg.set("punkte", gilde.getPunkte());
        cfg.set("Eröffnung", gilde.getEröffnung());
        cfg.set("Memberarray", gilde.getMemberarray());
        cfg.set("Memberanzahl", gilde.getMemberanzahl());
        cfg.set("Ältestearray", gilde.getÄltestearray());
        cfg.set("Vizearray", gilde.getVizearray());
        cfg.set("Anführer", gilde.getAnführer());
        cfg.set("Symbol", gilde.getSymbol());
        cfg.set("Bag", gilde.getBag().getContents());
        cfg.set("Base1", gilde.getBase1());
        cfg.set("Base2", gilde.getBase2());

        cfg.set("MaxMembers", gilde.getMaxMembers());
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerToGilde(String uuid, String gilde) {
        File file = new File("plugins/playerdata/" + uuid, "gilde.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("Gilde", gilde);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
