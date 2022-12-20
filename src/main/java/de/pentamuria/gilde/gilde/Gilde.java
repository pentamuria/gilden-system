package de.pentamuria.gilde.gilde;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Gilde {

    String name;
    int level;
    String status;
    double bank;
    String beschreibung;
    int punkte;
    String eröffnung;
    ArrayList<String> memberarray;
    int memberanzahl;
    ArrayList<String> ältestearray;
    ArrayList<String> vizearray;
    String anführer;
    String farbe;
    int maxMembers;
    ItemStack symbol;

    /**
     * Konstruktor der Gilde
     * @param name
     * @param level
     * @param status
     * @param bank
     * @param beschreibung
     * @param punkte
     * @param eröffnung
     * @param memberarray
     * @param memberanzahl
     * @param ältestearray
     * @param vizearray
     * @param anführer
     * @param farbe
     * @param maxMembers
     * @param symbol
     */
    public Gilde(String name, int level, String status, double bank, String beschreibung, int punkte, String eröffnung,
                 ArrayList<String> memberarray, int memberanzahl, ArrayList<String> ältestearray,
                 ArrayList<String> vizearray, String anführer, String farbe, int maxMembers, ItemStack symbol) {
        this.name = name;
        this.level = level;
        this.status = status;
        this.bank = bank;
        this.beschreibung = beschreibung;
        this.punkte = punkte;
        this.eröffnung = eröffnung;
        this.memberarray = memberarray;
        this.memberanzahl = memberanzahl;
        this.ältestearray = ältestearray;
        this.vizearray = vizearray;
        this.anführer = anführer;
        this.farbe = farbe;
        this.maxMembers = maxMembers;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getBank() {
        return bank;
    }
    public void setBank(double bank) {
        this.bank = bank;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public int getPunkte() {
        return punkte;
    }
    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
    public String getEröffnung() {
        return eröffnung;
    }
    public void setEröffnung(String eröffnung) {
        this.eröffnung = eröffnung;
    }
    public ArrayList<String> getMemberarray() {
        return memberarray;
    }
    public void setMemberarray(ArrayList<String> memberarray) {
        this.memberarray = memberarray;
    }
    public int getMemberanzahl() {
        return memberanzahl;
    }
    public void setMemberanzahl(int memberanzahl) {
        this.memberanzahl = memberanzahl;
    }
    public ArrayList<String> getÄltestearray() {
        return ältestearray;
    }
    public void setÄltestearray(ArrayList<String> ältestearray) {
        this.ältestearray = ältestearray;
    }
    public ArrayList<String> getVizearray() {
        return vizearray;
    }
    public void setVizearray(ArrayList<String> vizearray) {
        this.vizearray = vizearray;
    }
    public String getAnführer() {
        return anführer;
    }
    public void setAnführer(String anführer) {
        this.anführer = anführer;
    }
    public String getFarbe() {
        return farbe;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    public int getMaxMembers() {
        return maxMembers;
    }
    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }
    public ItemStack getSymbol() {
        return symbol;
    }
    public void setSymbol(ItemStack symbol) {
        this.symbol = symbol;
    }


}
