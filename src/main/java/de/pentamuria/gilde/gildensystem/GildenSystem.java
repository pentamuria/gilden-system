package de.pentamuria.gilde.gildensystem;

import de.pentamuria.gilde.commands.COMMAND_gilde;
import de.pentamuria.gilde.events.GildenChatListener;
import de.pentamuria.gilde.events.GildenDamageListener;
import de.pentamuria.gilde.events.GildenInvListener;
import de.pentamuria.gilde.events.GildenJoinListener;
import de.pentamuria.gilde.manager.GildenInventoryManager;
import de.pentamuria.gilde.manager.GildenManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class GildenSystem extends JavaPlugin {

    private String prefix = "§aGilden System §8- §7";
    public String pr = "§aGilde §8- §7";

    // Manager Classes
    public GildenManager gildenManager;
    public GildenInventoryManager gildenInvManager;

    // Listen
    public ArrayList<Player> msgtoggle;
    public HashMap<Player, ArrayList<String>> guildinvite;

    public static GildenSystem gildenSystem;

    public boolean globalMute = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        gildenSystem = this;
        loadCommands();
        loadEvents();
        loadManager();

        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin wurde §agestartet!");

        /********* Load Gilden Data **********/
        long a = System.currentTimeMillis();
        Bukkit.getConsoleSender().sendMessage("§4[!] §bDaten werden geladen...");
        gildenManager.loadAllGilden();
        long b = System.currentTimeMillis();
        long time  = (b-a)/1000;
        Bukkit.getConsoleSender().sendMessage("§4[!] §bDaten wurden §ageladen §8[§a" + time + " Sekunden§8]");
        Bukkit.getConsoleSender().sendMessage("§e" + gildenManager.getAlleGilden().size() + " Gilden §ageladen" );
        Bukkit.getConsoleSender().sendMessage("§6Gilden: " + gildenManager.getAlleGilden());
        Bukkit.getConsoleSender().sendMessage("§e" + gildenManager.getAllePlayerGilden().size() + " Spieler §ageladen" );
        Bukkit.getConsoleSender().sendMessage("§6Spieler: " + gildenManager.getAllePlayerGilden());

        // Start Countdowns
        startGildenLoader();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin wurde §4gestoppt!");
        long a = System.currentTimeMillis();
        Bukkit.getConsoleSender().sendMessage("§4[!] §bDaten werden gespeichert...");
        gildenManager.upLoadAll();
        long b = System.currentTimeMillis();
        long time  = (b-a)/1000;
        Bukkit.getConsoleSender().sendMessage("§4[!] §bDaten wurden §ageladen §8[§a" + time + " Sekunden§8]");
        Bukkit.getConsoleSender().sendMessage("§e" + gildenManager.getAlleGilden().size() + " Gilden §agespeichert" );
        Bukkit.getConsoleSender().sendMessage("§6Gilden: " + gildenManager.getAlleGilden());
        Bukkit.getConsoleSender().sendMessage("§e" + gildenManager.getAllePlayerGilden().size() + " Spieler §agespeichert");
    }

    private void loadCommands() {
        // Load all Command Classes
        COMMAND_gilde cCOMMAND_gilde = new COMMAND_gilde(this);
        getCommand("gilde").setExecutor(cCOMMAND_gilde);

    }

    private void loadEvents() {
        // Load all Event Classes
        new GildenInvListener(this);
        new GildenChatListener(this);
        new GildenJoinListener(this);
        new GildenDamageListener(this);
    }

    private void loadManager() {
        // Load all Manager Classes
        gildenManager = new GildenManager(this);
        gildenInvManager = new GildenInventoryManager(this);
        // Listen
        msgtoggle = new ArrayList<>();
        guildinvite = new HashMap<Player, ArrayList<String>>();
    }

    private void startGildenLoader() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

            @Override
            public void run() {
                long a = System.currentTimeMillis();
                Bukkit.getConsoleSender().sendMessage("§4[!] §bDaten werden gespeichert...");
                Bukkit.getConsoleSender().sendMessage("§8---------------------------");
                gildenManager.upLoadAll();
                long b = System.currentTimeMillis();
                long time  = (b-a)/1000;
                Bukkit.getConsoleSender().sendMessage("§4[!] §bDaten wurden §agespeichert §8[§a" + time + " sec§8]");

                Bukkit.getConsoleSender().sendMessage("§6Veränderte §eGilden: §f" + gildenManager.updatedGilden);
                Bukkit.getConsoleSender().sendMessage("§aNeue §eGilden: §f" + gildenManager.neueGilden);
                Bukkit.getConsoleSender().sendMessage("§4Gelöschte §eGilden: §f" + gildenManager.gelöschteGilden);
                Bukkit.getConsoleSender().sendMessage("§8---------------------------");
                gildenManager.updatedGilden = 0;
                gildenManager.neueGilden = 0;
                gildenManager.gelöschteGilden = 0;

            }

            //}, 20*60*20, 20*60*20);
        }, 20*60*15, 20*60*15);
    }
}
