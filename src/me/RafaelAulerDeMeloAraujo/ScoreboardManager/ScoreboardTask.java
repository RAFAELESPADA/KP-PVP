package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;

public class ScoreboardTask extends BukkitRunnable {

	private final ScoreboardBuilder builder;
	
	public ScoreboardTask(ScoreboardBuilder builder) {
		this.builder = builder;
	}
	
	@Override
	public void run() {
		Bukkit.getOnlinePlayers().stream().filter(
				online -> online.getScoreboard().getObjective("pvp") != null && Main.plugin.getConfig().getBoolean("bungeemode")))
		).forEach(builder::update);
	}
}

