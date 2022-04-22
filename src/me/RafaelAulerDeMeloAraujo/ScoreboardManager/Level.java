package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;

import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import me.RafaelAulerDeMeloAraujo.main.Main;


public class Level
{
    public static Integer getLevel(final Player p) {
        final double a = XP.getXP(p.getName());
        if (a == 0.0) {
            return 0;
        }
        if (a > 0.0 && a % (int)Main.customization.getInt("XP-Required-To-LevelUP") >= 0) {
            return (int)a/Main.customization.getInt("XP-Required-To-LevelUP");
        }
    return 0;
}
    public static final int getXPToLevelUp(Player p) {
        // How much XP is needed to level?
       return (int) (Main.customization.getInt("XP-Required-To-LevelUP") - (XP.getXP(p.getName()) - Main.customization.getInt("XP-Required-To-LevelUP") * getLevel(p))); // 600XP for lvl1, 700XP for lvl2, 800XP for lvl3 ...
   }
}
//1799
//0