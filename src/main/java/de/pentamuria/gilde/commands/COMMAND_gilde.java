package de.pentamuria.gilde.commands;

import de.pentamuria.gilde.countdowns.BaseCountdown;
import de.pentamuria.gilde.gilde.Gilde;
import de.pentamuria.gilde.gildensystem.GildenSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class COMMAND_gilde implements CommandExecutor {
    private final GildenSystem plugin;

    public COMMAND_gilde(GildenSystem gildenSystem) {
        this.plugin = gildenSystem;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player)sender;

        if(args.length==0) {
            p.sendMessage("§a§lGilden-Hilfe §8[1]");
            p.sendMessage("");
            p.sendMessage("§e/gilde info");
            p.sendMessage("§e/gilde manager");
            p.sendMessage("§e/gilde bag");
            p.sendMessage("§e/gilde create <Name>");
            p.sendMessage("§e/gilde invite <Name>");
            p.sendMessage("§e/gilde kick <Name>");


        } else if(args.length==1) {
            if(args[0].equalsIgnoreCase("leave")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }
                if(plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())) {
                    p.sendMessage(plugin.pr + " §cDu kannst diese Gilde nicht verlassen");
                    p.sendMessage(plugin.pr + " §cErnenne einen neuen Anführer oder lösche die Gilde");
                } else {
                    plugin.gildenManager.sendAllGildenPlayerMessage(gilde, plugin.gildenManager.getPlayerColor(p) + p.getName() + " §3hat die Gilde §cverlassen", p);
                    plugin.gildenManager.removePlayerFromGilde(p.getUniqueId().toString(), gilde);
                    p.sendMessage(plugin.pr + " §3Du hast die Gilde " + ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + " §cverlassen");
                }
            } else if(args[0].equalsIgnoreCase("delete")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }
                if(plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())) {
                    plugin.gildenManager.removeGilde(p, gilde);
                }
            } else if(args[0].equalsIgnoreCase("manager")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                plugin.gildenInvManager.openManagerInventory(p, gilde);
            } else if(args[0].equalsIgnoreCase("browser")) {
                plugin.gildenInvManager.openMainBrowserInventory(p);
            } else if(args[0].equalsIgnoreCase("bag")) {
                Gilde gilde=plugin.gildenManager.getGilde(plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()));
                if(!gilde.isBagOpen()) {
                    p.openInventory(gilde.getBag());
                    gilde.setBagOpen(true);
                } else {
                    p.sendMessage(plugin.pr + "§7Der Gildenrucksack ist §cbereits geöffnet!");
                }

            }
        } else if(args.length==2) {
            if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("hilfe")) {
                if(args[1].equalsIgnoreCase("1")) {
                    p.sendMessage("§a§lGilden-Hilfe §8[1]");
                    p.sendMessage("");
                    p.sendMessage("§e/gilde info");
                    p.sendMessage("§e/gilde manager");
                    p.sendMessage("§e/gilde help");
                    p.sendMessage("§e/gilde create <Name>");
                    p.sendMessage("§e/gilde invite <Name>");
                    p.sendMessage("§e/gilde kick <Name>");
                } else if(args[1].equalsIgnoreCase("2")) {
                    p.sendMessage("§a§lGilden-Hilfe §8[2]");
                    p.sendMessage("");
                    p.sendMessage("§e/gilde promote <Name>");
                    p.sendMessage("§e/gilde demote <Name>");
                    p.sendMessage("§e/gilde delete");
                    p.sendMessage("§e/gilde join <Name>");
                    p.sendMessage("§e/gilde leave");
                    p.sendMessage("§e/gilde status <öffentlich|privat>");
                    p.sendMessage("§e/gilde accept <Name>");
                    p.sendMessage("§e/gilde deny <Name>");
                }
            } else if(args[0].equalsIgnoreCase("create")) {
                p.sendMessage(plugin.pr + "§c/gilde create <Name> <Kuerzel>");
            } else if(args[0].equalsIgnoreCase("base")) {
                int base = Integer.valueOf(args[1]);
                String gildeName = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                Gilde gilde = plugin.gildenManager.getGilde(gildeName);
                if (gildeName.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }
                if (base == 1) {
                    if (gilde.getBase1() != null) {
                        new BaseCountdown(p).start(plugin, gilde.getBase1());
                    } else {
                        p.sendMessage(plugin.pr + "§7Ihre Gilde hat §ckeine §bBase 1");
                    }
                } else if (base == 2) {
                    if (gilde.getBase2() != null) {
                        new BaseCountdown(p).start(plugin, gilde.getBase2());
                    } else {
                        p.sendMessage(plugin.pr + "§7Ihre Gilde hat §ckeine §bBase 2");
                    }
                }
            } else if(args[0].equalsIgnoreCase("setbase")) {
                int base = Integer.valueOf(args[1]);
                String gildeName = plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                Gilde gilde = plugin.gildenManager.getGilde(gildeName);
                if (gildeName.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }
                if(base == 1) {
                    gilde.setBase1(p.getLocation());
                    p.sendMessage(plugin.pr + "Ihre Gilden Basis §d1 §7wurde §agesetzt!");
                } else if(base == 2) {
                    gilde.setBase2(p.getLocation());
                    p.sendMessage(plugin.pr + "Ihre Gilden Basis §d2 §7wurde §agesetzt!");
                }
            } else if(args[0].equalsIgnoreCase("invite")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }


                if(plugin.gildenManager.getGilde(gilde).getMemberanzahl()>=plugin.gildenManager.getGilde(gilde).getMaxMembers()) {
                    //plugin.guildinvite.remove(p);
                    p.sendMessage(plugin.pr + " §cDeine Gilde ist bereits voll!");
                    return true;
                }
                if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(p.getUniqueId().toString())|| plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(p.getUniqueId().toString())||p.getUniqueId().toString().equalsIgnoreCase(plugin.gildenManager.getGilde(gilde).getAnführer())) {
                    Player d = Bukkit.getPlayer(args[1]);
                    if(d!=null) {
                        if(!plugin.gildenManager.getPlayerGilde(d.getUniqueId().toString()).equalsIgnoreCase("Keine")) {
                            p.sendMessage(plugin.pr + " §cDieser Spieler ist bereits in einer Gilde");
                            return true;
                        }
                        d.playSound(d.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 3);
                        d.sendMessage("§3Die Gilde " + ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + " §3hat dir eine §6Einladung §3gesendet");
                        p.sendMessage("§3Du hast §c" + d.getName() + " §3eine §6Einladung §3gesendet");
                        d.sendMessage("§3/gilde <§aaccept§3|§4deny> "+ ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde);

                        ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                        if(log.isEmpty()) {
                            log.add("§eEinladung von " + p.getName() + " an " + d.getName());
                        } else {
                            if(log.size()>=27) {
                                log.remove(0);
                                log.add("§eEinladung von " + p.getName() + " an " + d.getName());
                            } else {
                                log.add("§eEinladung von " + p.getName() + " an " + d.getName());
                            }
                        }
                        plugin.gildenManager.setGildeLog(gilde, log);

                        if(plugin.guildinvite.containsKey(d)) {
                            ArrayList<String> liste = plugin.guildinvite.get(d);
                            liste.add(gilde);
                            plugin.guildinvite.put(d, liste);
                        } else {
                            ArrayList<String> liste = new ArrayList<String>();
                            liste.add(gilde);
                            plugin.guildinvite.put(d, liste);
                        }


                    } else {
                        p.sendMessage(plugin.pr + " §cDieser Spieler ist nicht online");
                    }
                } else {
                    p.sendMessage(plugin.pr + " §cDu hast keine Berechtigung!");
                }
            } else if(args[0].equalsIgnoreCase("join")) {
                if(!plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString()).equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu musst deine Gilde erst verlassen");
                    return true;
                }
                String gilde = args[1];
                if(plugin.gildenManager.gildeExist(gilde)) {
                    if(plugin.gildenManager.getGilde(gilde).getStatus().equalsIgnoreCase("Privat")) {
                        p.sendMessage(plugin.pr + " §cFür diese Gilde brauchst du eine Einladung");
                    } else {
                        if(plugin.gildenManager.getGilde(gilde).getMemberanzahl()>=plugin.gildenManager.getGilde(gilde).getMaxMembers()) {
                            plugin.guildinvite.remove(p);
                            p.sendMessage(plugin.pr + " §cDie Gilde ist bereits voll!");
                        } else {
                            plugin.gildenManager.addPlayerToGilde(p, gilde);
                            p.sendMessage(plugin.pr + " §3Du hast die Gilde "+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + " §abetreten");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§a[+] §6" + p.getName(), p);
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§a" + p.getName() + " ist der Gilde beigetreten");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§a" + p.getName() + " ist der Gilde beigetreten");
                                } else {
                                    log.add("§a" + p.getName() + " ist der Gilde beigetreten");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);



                        }
                    }

                } else {
                    p.sendMessage(plugin.pr + " §cDiese Gilde existiert nicht");
                }





            } else if(args[0].equalsIgnoreCase("accept")) {
                if(plugin.guildinvite.containsKey(p)) {
                    ArrayList<String> gilden = plugin.guildinvite.get(p);
                    String gilde = args[1];

                    if(gilden.contains(gilde)) {

                        if(plugin.gildenManager.gildeExist(gilde)) {
                            if(plugin.gildenManager.getGilde(gilde).getMemberanzahl()>=plugin.gildenManager.getGilde(gilde).getMaxMembers()) {
                                plugin.guildinvite.remove(p);
                                p.sendMessage(plugin.pr + " §cDie Gilde ist bereits voll!");
                            } else {
                                plugin.gildenManager.addPlayerToGilde(p, gilde);
                                p.sendMessage(plugin.pr + " §3Du hast die Gilde "+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + " §abetreten");
                                plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§a[+] §6" + p.getName(), p);
                                plugin.guildinvite.remove(p);
                                ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                                if(log.isEmpty()) {
                                    log.add("§a" + p.getName() + " ist der Gilde beigetreten");
                                } else {
                                    if(log.size()>=27) {
                                        log.remove(0);
                                        log.add("§a" + p.getName() + " ist der Gilde beigetreten");
                                    } else {
                                        log.add("§a" + p.getName() + " ist der Gilde beigetreten");
                                    }
                                }
                                plugin.gildenManager.setGildeLog(gilde, log);


                            }
                        } else {
                            p.sendMessage(plugin.pr + " §cDiese Gilde existiert nicht mehr");
                            gilden.remove(gilde);
                            plugin.guildinvite.put(p, gilden);
                        }

                    } else {
                        p.sendMessage(plugin.pr + " §cDiese Gilde hat dich nicht eingeladen");
                    }
                } else {
                    p.sendMessage(plugin.pr + " §cDu hast keine Einladung erhalten");
                }

            } else if(args[0].equalsIgnoreCase("deny")) {
                if(plugin.guildinvite.containsKey(p)) {
                    ArrayList<String> gilden = plugin.guildinvite.get(p);
                    String gilde = args[1];

                    if(gilden.contains(gilde)) {
                        plugin.guildinvite.remove(p);
                        p.sendMessage(plugin.pr + " §cDu hast die Einladung von §8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §4abgelehnt");
                    } else {
                        p.sendMessage(plugin.pr + " §cDiese Gilde hat dich nicht eingeladen");
                    }
                } else {
                    p.sendMessage(plugin.pr + " §cDu hast keine Einladung erhalten");
                }
            } else if(args[0].equalsIgnoreCase("befördern") || args[0].equalsIgnoreCase("promote")) {

                if(args[1].equalsIgnoreCase(p.getName())) {
                    p.sendMessage(plugin.pr + " §cDu kannst dich nicht selber befördern");
                    return true;
                }

                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }
                Player promote = Bukkit.getPlayer(args[1]);
                if(promote !=null) {
                    if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(p.getUniqueId().toString())) {
                        if(plugin.gildenManager.getGilde(gilde).getMemberarray().contains(promote.getUniqueId().toString())) {
                            ArrayList<String> mitglieder = plugin.gildenManager.getGilde(gilde).getMemberarray();
                            ArrayList<String> älteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
                            mitglieder.remove(promote.getUniqueId().toString());
                            älteste.add(promote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setMemberarray(mitglieder);
                            plugin.gildenManager.getGilde(gilde).setÄltestearray(älteste);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + promote.getName() + " §abefördert");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + promote.getName() + " §awurde befördert", promote);
                            promote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §aDu wurdest §3befördert");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nÄltesten befördert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nÄltesten befördert");
                                } else {
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nÄltesten befördert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                            //p.sendMessage("§");
                        } else if(plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(promote.getUniqueId().toString())) {
                            ArrayList<String> älteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
                            ArrayList<String> vize = plugin.gildenManager.getGilde(gilde).getVizearray();
                            älteste.remove(promote.getUniqueId().toString());
                            vize.add(promote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setÄltestearray(älteste);
                            plugin.gildenManager.getGilde(gilde).setVizearray(vize);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + promote.getName() + " §abefördert");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + promote.getName() + " §3wurde §abefördert", promote);
                            promote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §abefördert");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nVize befördert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nVize befördert");
                                } else {
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nVize befördert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else {
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cDu hast keine Berechtigung dafür");
                        }
                    } else if(plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())){
                        if(plugin.gildenManager.getGilde(gilde).getMemberarray().contains(promote.getUniqueId().toString())) {
                            ArrayList<String> mitglieder = plugin.gildenManager.getGilde(gilde).getMemberarray();
                            ArrayList<String> älteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
                            mitglieder.remove(promote.getUniqueId().toString());
                            älteste.add(promote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setMemberarray(mitglieder);
                            plugin.gildenManager.getGilde(gilde).setÄltestearray(älteste);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + promote.getName() + " §abefördert");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + promote.getName() + " §3wurde §abefördert", promote);
                            promote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §abefördert");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nÄltesten befördert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nÄltesten befördert");
                                } else {
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nÄltesten befördert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                            //p.sendMessage("§");
                        } else if(plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(promote.getUniqueId().toString())) {
                            ArrayList<String> älteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
                            ArrayList<String> vize = plugin.gildenManager.getGilde(gilde).getVizearray();
                            älteste.remove(promote.getUniqueId().toString());
                            vize.add(promote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setÄltestearray(älteste);
                            plugin.gildenManager.getGilde(gilde).setVizearray(vize);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + promote.getName() + " §abefördert");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + promote.getName() + " §3wurde §abefördert", promote);
                            promote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §abefördert");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nVize befördert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nVize befördert");
                                } else {
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nVize befördert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else {
                            //ArrayList<String> mitglieder = plugin.gildenManager.getGilde(gilde).getMemberarray();
                            ArrayList<String> vize = plugin.gildenManager.getGilde(gilde).getVizearray();
                            vize.remove(promote.getUniqueId().toString());
                            vize.add(p.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setAnführer(promote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setVizearray(vize);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + promote.getName() + " §3zum §4Anführer §3gemacht");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + promote.getName() + " §3ist nun neuer §4Anführer", promote);
                            promote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §3zum §4Anführer §3gemacht");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nAnführer befördert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nAnführer befördert");
                                } else {
                                    log.add("§5" + promote.getName() + " wurde von " + p.getName() + " zum \nAnführer befördert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        }
                    } else {
                        p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cKeine Berechtigung");
                    }

                } else {
                    p.sendMessage(plugin.pr + " §cDieser Spieler ist nicht online!");
                }

            } else if(args[0].equalsIgnoreCase("degradieren") || args[0].equalsIgnoreCase("demote")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(args[1].equalsIgnoreCase(p.getName())) {
                    p.sendMessage(plugin.pr + " §cDu kannst dich nicht selber degradieren");
                    return true;
                }
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }
                Player demote = Bukkit.getPlayer(args[1]);
                if(demote !=null) {
                    if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(p.getUniqueId().toString())) {
                        if(plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(demote.getUniqueId().toString())) {
                            ArrayList<String> mitglieder = plugin.gildenManager.getGilde(gilde).getMemberarray();
                            ArrayList<String> älteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
                            älteste.remove(demote.getUniqueId().toString());
                            mitglieder.add(demote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setMemberarray(mitglieder);
                            plugin.gildenManager.getGilde(gilde).setÄltestearray(älteste);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4degradiert");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4degradiert", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4degradiert");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§5" + demote.getName() + " wurde von " + p.getName() + " zum \nMitglied §4degradiert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§5" + demote.getName() + " wurde von " + p.getName() + " zum \nMitglied §4degradiert");
                                } else {
                                    log.add("§5" + demote.getName() + " wurde von " + p.getName() + " zum \nMitglied §4degradiert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else {
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cDu hast keine Berechtigung dafür");
                        }
                    } else if(plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())){
                        if(plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(demote.getUniqueId().toString())) {
                            ArrayList<String> mitglieder = plugin.gildenManager.getGilde(gilde).getMemberarray();
                            ArrayList<String> älteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
                            älteste.remove(demote.getUniqueId().toString());
                            mitglieder.add(demote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setMemberarray(mitglieder);
                            plugin.gildenManager.getGilde(gilde).setÄltestearray(älteste);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4degradiert");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4degradiert", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4degradiert");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§4" + demote.getName() + " wurde von " + p.getName() + " zum \nMitglied degradiert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§4" + demote.getName() + " wurde von " + p.getName() + " zum \nMitglied degradiert");
                                } else {
                                    log.add("§4" + demote.getName() + " wurde von " + p.getName() + " zum \nMitglied degradiert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(demote.getUniqueId().toString())) {
                            ArrayList<String> vize = plugin.gildenManager.getGilde(gilde).getVizearray();
                            ArrayList<String> älteste = plugin.gildenManager.getGilde(gilde).getÄltestearray();
                            vize.remove(demote.getUniqueId().toString());
                            älteste.add(demote.getUniqueId().toString());
                            plugin.gildenManager.getGilde(gilde).setVizearray(vize);
                            plugin.gildenManager.getGilde(gilde).setÄltestearray(älteste);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4degradiert");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4degradiert", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4degradiert");
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            if(log.isEmpty()) {
                                log.add("§4" + demote.getName() + " wurde von " + p.getName() + " zum \nÄltesten degradiert");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§4" + demote.getName() + " wurde von " + p.getName() + " zum \nÄltesten degradiert");
                                } else {
                                    log.add("§4" + demote.getName() + " wurde von " + p.getName() + " zum \nÄltesten degradiert");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else {
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cDiesen Spieler kannst du nicht degradieren");
                        }
                    } else {
                        p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cKeine Berechtigung");
                    }

                } else {
                    p.sendMessage(plugin.pr + " §cDieser Spieler ist nicht online!");
                }
            } else if(args[0].equalsIgnoreCase("kick")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(args[1].equalsIgnoreCase(p.getName())) {
                    p.sendMessage(plugin.pr + " §cDu kannst dich nicht selber kicken");
                    return true;
                }
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }
                Player demote = Bukkit.getPlayer(args[1]);
                if(demote !=null) {
                    if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(p.getUniqueId().toString())) {
                        if(plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(demote.getUniqueId().toString())) {
                            plugin.gildenManager.removePlayerFromGilde(demote.getUniqueId().toString(), gilde);
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4gekickt");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4gekickt", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4gekickt");
                            if(log.isEmpty()) {
                                log.add("§c" + demote.getName() + " wurde von " + p.getName() + " §cgekickt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                } else {
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else if(plugin.gildenManager.getGilde(gilde).getMemberarray().contains(demote.getUniqueId().toString())) {
                            plugin.gildenManager.removePlayerFromGilde(demote.getUniqueId().toString(), gilde);
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4gekickt");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4gekickt", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4gekickt");
                            if(log.isEmpty()) {
                                log.add("§c" + demote.getName() + " wurde von " + p.getName() + " §cgekickt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                } else {
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else {
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cDu hast keine Berechtigung dafür");
                        }
                    } else if(plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(p.getUniqueId().toString())) {
                        if(plugin.gildenManager.getGilde(gilde).getMemberarray().contains(demote.getUniqueId().toString())) {
                            plugin.gildenManager.removePlayerFromGilde(demote.getUniqueId().toString(), gilde);
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4gekickt");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4gekickt", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4gekickt");
                            if(log.isEmpty()) {
                                log.add("§c" + demote.getName() + " wurde von " + p.getName() + " §cgekickt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                } else {
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else {
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cDu hast keine Berechtigung dafür");
                        }
                    } else if(plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())){
                        if(plugin.gildenManager.getGilde(gilde).getÄltestearray().contains(demote.getUniqueId().toString())) {
                            plugin.gildenManager.removePlayerFromGilde(demote.getUniqueId().toString(), gilde);
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4gekickt");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4gekickt", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4gekickt");
                            if(log.isEmpty()) {
                                log.add("§c" + demote.getName() + " wurde von " + p.getName() + " §cgekickt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                } else {
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else if(plugin.gildenManager.getGilde(gilde).getMemberarray().contains(demote.getUniqueId().toString())) {
                            plugin.gildenManager.removePlayerFromGilde(demote.getUniqueId().toString(), gilde);
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4gekickt");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4gekickt", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4gekickt");
                            if(log.isEmpty()) {
                                log.add("§c" + demote.getName() + " wurde von " + p.getName() + " §cgekickt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                } else {
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(demote.getUniqueId().toString())) {
                            plugin.gildenManager.removePlayerFromGilde(demote.getUniqueId().toString(), gilde);
                            ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du hast §c" + demote.getName() + " §4gekickt");
                            plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§c" + demote.getName() + " §3wurde §4gekickt", demote);
                            demote.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Du wurdest §4gekickt");
                            if(log.isEmpty()) {
                                log.add("§c" + demote.getName() + " wurde von " + p.getName() + " §cgekickt");
                            } else {
                                if(log.size()>=27) {
                                    log.remove(0);
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                } else {
                                    log.add("§c" + demote.getName() + " wurde von " + p.getName() + " gekickt");
                                }
                            }
                            plugin.gildenManager.setGildeLog(gilde, log);
                        } else {
                            p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cFehler!");
                        }
                    } else {
                        p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cKeine Berechtigung");
                    }

                } else {
                    p.sendMessage(plugin.pr + " §cDieser Spieler ist nicht online!");
                }
            } else if(args[0].equalsIgnoreCase("status")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;
                }

                if(plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())) {
                    if(args[1].equalsIgnoreCase("Privat")) {
                        plugin.gildenManager.setGildenStatus(gilde, "Privat");
                        plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§3Die Gilde ist nun §cprivat", p);
                        p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Die Gilde ist nun §cprivat");
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
                    } else if(args[1].equalsIgnoreCase("Öffentlich")) {
                        plugin.gildenManager.setGildenStatus(gilde, "Öffentlich");
                        plugin.gildenManager.sendAllGildenPlayerMessage(gilde, "§3Die Gilde ist nun §aöffentlich", p);
                        p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §3Die Gilde ist nun §aöffentlich");
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
                    } else {
                        p.sendMessage(plugin.pr + " §c/gilde status <öffentlich|");
                    }
                } else {
                    p.sendMessage("§8["+ChatColor.translateAlternateColorCodes('&', plugin.gildenManager.getGilde(gilde).getFarbe()) + gilde + "§8] §cKeine Berechtigung");
                }



            } else if(args[0].equalsIgnoreCase("manager")) {

            }
        } else if(args.length>=2) {
            if(args[0].equalsIgnoreCase("setdescription") || args[0].equalsIgnoreCase("setbeschreibung")) {
                String gilde=plugin.gildenManager.getPlayerGilde(p.getUniqueId().toString());
                if(gilde.equalsIgnoreCase("Keine")) {
                    p.sendMessage(plugin.pr + " §cDu bist in keiner Gilde");
                    return true;

                }
                /*gilde setdescription Das ist eine coole Gilde
                 * 0         1          2    3   4    5     6  args.lenght
                 * 			 0          1    2   3    4     5  args[]
                 *
                 */



                if(plugin.gildenManager.getGilde(gilde).getVizearray().contains(p.getUniqueId().toString())||plugin.gildenManager.getGilde(gilde).getAnführer().equalsIgnoreCase(p.getUniqueId().toString())) {
                    String str = "";
                    for(int i =1;i<args.length;i++) {
                        str = str+args[i] + " ";
                    }
                    plugin.gildenManager.addGildenBeschreibung(gilde, str);
                    p.sendMessage(plugin.pr + " §3Du hast die §cBeschreibung §3geändert");
                    ArrayList<String> log = plugin.gildenManager.getGildeLog(gilde);
                    if(log.isEmpty()) {
                        log.add("§dDie Beschreibung wurde von §c" + p.getName() + " §ageändert");
                    } else {
                        if(log.size()>=27) {
                            log.remove(0);
                            log.add("§dDie Beschreibung wurde von §c" + p.getName() + " §ageändert");
                        } else {
                            log.add("§dDie Beschreibung wurde von §c" + p.getName() + " §ageändert");
                        }
                    }
                    plugin.gildenManager.setGildeLog(gilde, log);
                } else {
                    p.sendMessage(plugin.pr + " §cKeine Berechtigung!");
                }
            } else if(args[0].equalsIgnoreCase("create")) {
                if(args[2].length()<=4 && args[2].length()>0) {
                    if (args[1].equalsIgnoreCase("Keine") || args[1].equalsIgnoreCase("Solo")) {
                        p.sendMessage(plugin.pr + "§cBitte benutze einen anderen Namen");
                        return true;
                    }
                    plugin.gildenManager.createNewGilde(p, args[1], args[2]);
                } else {
                    p.sendMessage(plugin.pr + "Der §cGildenkürzel §7ist zu lang §8[§4Maximal 4 Zeichen§8]");
                }
            }
        }



        return true;
    }
}
