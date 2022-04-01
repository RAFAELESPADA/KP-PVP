package me.RafaelAulerDeMeloAraujo.Listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.X1.X1;
import me.RafaelAulerDeMeloAraujo.main.Main;

import org.bukkit.event.Listener;


public class Protection implements Listener {



@EventHandler(priority = EventPriority.HIGHEST)
public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
	
	if (event.getEntity() instanceof Player && (event.getDamager() instanceof Player) && Join.game.contains(event.getEntity().getName()) && Join.game.contains(event.getDamager().getName()) && !X1.lutadores.containsKey(event.getDamager().getName()) && !X1.lutadores.containsKey(event.getEntity().getName())) {

		final Player damaged = (Player) event.getEntity();
		final Player damager = (Player) event.getDamager();
		if (Habilidade.getAbility(damaged) == "None") {
			event.setCancelled(true);
		}
		if (Habilidade.getAbility(damager) == "None") {
			event.setCancelled(true);
		}
		if (Habilidade.getAbility(damaged) == Main.cfg_x1.getString("x1.ability")) {
			event.setCancelled(true);
		}
		}
	}
}
