package ru.compas;

public class Player extends character {
    public int max_hp;
    public int hp;
    public int max_mana;
    public int mana;
    public String unique_code;
    int strength;
    int intellect;
    int damage;
    int level;
    int xp;
    int protection;
    String type;
    boolean battleAction;
    boolean dialogue;


    public Player() {
        max_hp = 30;
        hp =15;
        max_mana = 20;
        mana = 10;
    }
}
