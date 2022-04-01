package me.RafaelAulerDeMeloAraujo.ScoreboardManager;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import me.RafaelAulerDeMeloAraujo.main.Main;
public class ScoreboardBuilder {

	public ScoreboardBuilder(Main plugin) {
		new ScoreboardTask(this).runTaskTimer(plugin, 0, 3 * 20L);
	}
	
	public void build(Player player) {
		player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
		
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("pvp", "dummy");
		
		objective.setDisplayName(Main.messages.getString("ScoreBoardTitle").replace("&", "§"));
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		String l10 = "§3";
		String l9 = Main.messages.getString("ScoreBoardKit").replace("&", "§");
		String l8 = "§2";
		String l7 = Main.messages.getString("ScoreBoardKills").replace("&", "§");
		String l6 = Main.messages.getString("ScoreBoardDeaths").replace("&", "§");
		String l5 = Main.messages.getString("ScoreBoardKS").replace("&", "§");
		String l4 = "§1";
		String l3 = Main.messages.getString("ScoreBoardCoins").replace("&", "§");
		String l2 = Main.messages.getString("ScoreBoardXP").replace("&", "§");
		String l1 = "§0";
		String l0 = Main.messages.getString("ScoreBoardLevel").replace("&", "§");;
		
		scoreboard.registerNewTeam("kit").addEntry(l9);
		scoreboard.registerNewTeam("kills").addEntry(l7);
		scoreboard.registerNewTeam("deaths").addEntry(l6);
		scoreboard.registerNewTeam("killstreak").addEntry(l5);
		scoreboard.registerNewTeam("coins").addEntry(l3);
		scoreboard.registerNewTeam("xp").addEntry(l2);
		scoreboard.registerNewTeam("level").addEntry(l0);
		objective.getScore(l10).setScore(10);
		objective.getScore(l9).setScore(9);
		objective.getScore(l8).setScore(8);
		objective.getScore(l7).setScore(7);
		objective.getScore(l6).setScore(6);
		objective.getScore(l5).setScore(5);
		objective.getScore(l4).setScore(4);
		objective.getScore(l3).setScore(3);
		objective.getScore(l2).setScore(2);
		objective.getScore(l1).setScore(1);
		objective.getScore(l0).setScore(0);
		
		player.setScoreboard(scoreboard);
		update(player);
	}
	
	public static void update(Player player) {
		if (player.getScoreboard().getObjective("pvp") == null) {
			return;
		}
		Scoreboard scoreboard = player.getScoreboard();
		
		scoreboard.getTeam("kit").setSuffix(Habilidade.getAbility(player));
		scoreboard.getTeam("kills").setSuffix(String.valueOf(AntiDeathDrop.GetKills(player)));
		scoreboard.getTeam("deaths").setSuffix(String.valueOf(AntiDeathDrop.GetDeaths(player)));
		scoreboard.getTeam("killstreak").setSuffix(String.valueOf(((Integer)Streak.killstreak.get(player.getName())).intValue()));
		scoreboard.getTeam("coins").setSuffix(String.valueOf(Coins.getCoins(player.getName())));
		scoreboard.getTeam("xp").setSuffix(String.valueOf(XP.getXP(player.getName())));
		scoreboard.getTeam("level").setSuffix(String.valueOf(Level.getLevel(player)));
	}
}
