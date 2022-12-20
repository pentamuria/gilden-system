package de.pentamuria.gilde.manager;

import de.pentamuria.gilde.gildensystem.GildenSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class GildenChatManager {

    private GildenSystem plugin;


    public GildenChatManager(GildenSystem main) {
        this.plugin = main;
    }

    public void sendAllGildenPlayerMessage(String gilde, String message, Player except) {

        ArrayList<String> allplayer = plugin.gildenManager.getGilde(gilde).getMemberarray();
        ArrayList<String> allälteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
        ArrayList<String> allvize = plugin.gildenManager.getGilde(gilde).getVizearray();
        String anführer = plugin.gildenManager.getGilde(gilde).getAnführer();

        Player führer = Bukkit.getPlayer(UUID.fromString(anführer));
        if(führer !=null) {
            if(führer.getName().equalsIgnoreCase(except.getName())) {
                return;
            }
            führer.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
        }
        for(String mitglieder : allplayer) {
            Player mitglied = Bukkit.getPlayer(UUID.fromString(mitglieder));
            if(mitglied !=null) {
                if(mitglied.getName().equalsIgnoreCase(except.getName())) {
                    return;
                }
                mitglied.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
            }
        }
        for(String älteste : allälteste) {
            Player ältester = Bukkit.getPlayer(UUID.fromString(älteste));
            if(ältester !=null) {
                if(ältester.getName().equalsIgnoreCase(except.getName())) {
                    return;
                }
                ältester.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
            }
        }
        for(String vize : allvize) {
            Player vizer = Bukkit.getPlayer(UUID.fromString(vize));
            if(vizer !=null) {
                if(vizer.getName().equalsIgnoreCase(except.getName())) {
                    return;
                }
                vizer.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
            }
        }

    }


    public void sendAllGildenPlayerSound(String gilde, Sound sound, float arg1, float arg2) {

        ArrayList<String> allplayer = plugin.gildenManager.getGilde(gilde).getMemberarray();
        ArrayList<String> allälteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
        ArrayList<String> allvize = plugin.gildenManager.getGilde(gilde).getVizearray();
        String anführer = plugin.gildenManager.getGilde(gilde).getAnführer();

        Player führer = Bukkit.getPlayer(UUID.fromString(anführer));
        if(führer !=null) {

            führer.playSound(führer.getLocation(), sound, arg1, arg2);
        }
        for(String mitglieder : allplayer) {
            Player mitglied = Bukkit.getPlayer(UUID.fromString(mitglieder));
            if(mitglied !=null) {

                mitglied.playSound(mitglied.getLocation(), sound, arg1, arg2);
            }
        }
        for(String älteste : allälteste) {
            Player ältester = Bukkit.getPlayer(UUID.fromString(älteste));
            if(ältester !=null) {

                ältester.playSound(ältester.getLocation(), sound, arg1, arg2);
            }
        }
        for(String vize : allvize) {
            Player vizer = Bukkit.getPlayer(UUID.fromString(vize));
            if(vizer !=null) {
                vizer.playSound(vizer.getLocation(), sound, arg1, arg2);
            }
        }

    }


    public void sendAllGildenPlayerMessage(String gilde, String message) {

        ArrayList<String> allplayer = plugin.gildenManager.getGilde(gilde).getMemberarray();
        ArrayList<String> allälteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
        ArrayList<String> allvize = plugin.gildenManager.getGilde(gilde).getVizearray();
        String anführer = plugin.gildenManager.getGilde(gilde).getAnführer();

        Player führer = Bukkit.getPlayer(UUID.fromString(anführer));
        if(führer !=null) {

            führer.sendMessage("§8["+ ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
        }
        for(String mitglieder : allplayer) {
            Player mitglied = Bukkit.getPlayer(UUID.fromString(mitglieder));
            if(mitglied !=null) {

                mitglied.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
            }
        }
        for(String älteste : allälteste) {
            Player ältester = Bukkit.getPlayer(UUID.fromString(älteste));
            if(ältester !=null) {

                ältester.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
            }
        }
        for(String vize : allvize) {
            Player vizer = Bukkit.getPlayer(UUID.fromString(vize));
            if(vizer !=null) {
                vizer.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] " + message);
            }
        }

    }


    /*public void sendAllGildenPlayerPacket(String gilde, PacketPlayOutChat packet) {

        ArrayList<String> allplayer = plugin.gildenManager.getGilde(gilde).getMemberarray();
        ArrayList<String> allälteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
        ArrayList<String> allvize = plugin.gildenManager.getGilde(gilde).getVizearray();
        String anführer = plugin.gildenManager.getGilde(gilde).getAnführer();

        Player führer = Bukkit.getPlayer(UUID.fromString(anführer));
        if(führer !=null) {
            ((CraftPlayer) führer).getHandle().playerConnection.sendPacket(packet);
        }
        for(String mitglieder : allplayer) {
            Player mitglied = Bukkit.getPlayer(UUID.fromString(mitglieder));
            if(mitglied !=null) {

                ((CraftPlayer) mitglied).getHandle().playerConnection.sendPacket(packet);
            }
        }
        for(String älteste : allälteste) {
            Player ältester = Bukkit.getPlayer(UUID.fromString(älteste));
            if(ältester !=null) {

                ((CraftPlayer) ältester).getHandle().playerConnection.sendPacket(packet);
            }
        }
        for(String vize : allvize) {
            Player vizer = Bukkit.getPlayer(UUID.fromString(vize));
            if(vizer !=null) {
                ((CraftPlayer) vizer).getHandle().playerConnection.sendPacket(packet);
            }
        }

    }*/

}
