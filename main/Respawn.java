package me.RafaelAulerDeMeloAraujo.main;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.X1.X1;


public class Respawn implements Listener {
	

	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		
		if (Join.game.contains((e.getEntity().getName()))) {
			
			Player victim = e.getEntity();
			e.setDeathMessage("");
			
			victim.getWorld().playEffect(victim.getLocation().add(0.0D, 1.0D, 0.0D), Effect.STEP_SOUND, 152);
			respawnPlayer(victim);
			
		}
	
	}

	private void respawnPlayer(Player p) {
		
			
			Location deathLocation = p.getLocation();
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> p.spigot().respawn(), 1);
			
			p.setGameMode(GameMode.SPECTATOR);
			p.teleport(deathLocation);
			

			if (X1.inx1.contains(p)) {
				new BukkitRunnable() {
					
					int time = 5;
					
					@Override
					public void run() {
						
						
						
						if (time != 0) {

							TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(20), Main.getInstace().getConfig().getString("Title.DeathTitle"), Main.getInstace().getConfig().getString("Title.DeathSubTitle"));
							p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Main.getInstance().getConfig().getString("Sound.Respawning")), 3.0F, 3.0F);
							time--;
							
						} else {
							/* 191 */       p.getInventory().setArmorContents(null);
							/*     */       
							/* 193 */       p.updateInventory();
							/* 194 */       Habilidade.removeAbility(p);
							/* 195 */       Deshfire.Armadura.remove(p);
							/* 196 */       Deshfire.Armadura2.remove(p);
							/* 197 */       Deshfire.cooldownm.remove(p);
							/*     */       p.setGameMode(GameMode.SURVIVAL);
							/* 199 */       Cooldown.remove(p);
							
							  X1.entrar1v1(p);

							  World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("SpawnD.World"));
						      double x = Main.cfg_x1.getDouble("x1.coords.loc_1.x");
						      double y = Main.cfg_x1.getDouble("x1.coords.loc_1.y");
						      double z = Main.cfg_x1.getDouble("x1.coords.loc_1.z");
						      Location onevsone = new Location(w, x, y, z);
						      onevsone.setPitch((float)Main.cfg_x1.getDouble("x1.coords.loc_2.pitch"));
						      onevsone.setYaw((float)Main.cfg_x1.getDouble("x1.coords.loc_2.yaw"));
							  p.teleport(onevsone);
							p.sendMessage(ChatColor.YELLOW + "You respawned");
							p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 0));
							p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Main.getInstance().getConfig().getString("Sound.RespawnSucess")), 3.0F, 3.0F);
							
							
							cancel();
							
						}
						
					}
					
				}.runTaskTimer(Main.getInstance(), 0L, 20L);
			} else {
				new BukkitRunnable() {
					
					int time = 5;
					
					@Override
					public void run() {
						
						
						
						if (time != 0) {

							TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(20), Main.getInstace().getConfig().getString("Title.DeathTitle"), Main.getInstace().getConfig().getString("Title.DeathSubTitle"));
							p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Main.getInstance().getConfig().getString("Sound.Respawning")), 3.0F, 3.0F);
							time--;
							
						} else {
							

							
							
							/*     */      World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("SpawnD.World"));
							/* 153 */      double x = Main.plugin.getConfig().getDouble("SpawnD.X");
							/* 154 */      double y = Main.plugin.getConfig().getDouble("SpawnD.Y");
							/* 155 */      double z = Main.plugin.getConfig().getDouble("SpawnD.Z");
							/* 156 */      Location lobby = new Location(w, x, y, z);
							/* 157 */      lobby.setPitch((float)Main.plugin.getConfig().getDouble("SpawnD.Pitch"));
							/* 158 */      lobby.setYaw((float)Main.plugin.getConfig().getDouble("SpawnD.Yaw"));
							                ItemStack shop = new ItemStack(Material.BOOK);
							/*  96 */       ItemMeta shop2 = shop.getItemMeta();
							/*  97 */       shop2.setDisplayName(Main.messages.getString("KitItemName").replace("&", "§"));
							/*  98 */       shop.setItemMeta(shop2);
							/*  95 */       ItemStack kits = new ItemStack(Material.EMERALD);
							/*  96 */       ItemMeta kits2 = kits.getItemMeta();
							/*  97 */       kits2.setDisplayName(Main.messages.getString("ShopItemName").replace("&", "§"));
							/*  98 */       kits.setItemMeta(kits2);
							/*  99 */       ItemStack st = new ItemStack(Material.BLAZE_ROD);
							/* 100 */       ItemMeta st2 = st.getItemMeta();
							/* 101 */       st2.setDisplayName(Main.messages.getString("1v1ItemName").replace("&", "§"));
							/* 102 */       st.setItemMeta(st2);
							ItemStack stats = new ItemStack(Material.NAME_TAG);
							/* 227 */           ItemMeta stats2 = kits.getItemMeta();
							/* 228 */           stats2.setDisplayName(Main.messages.getString("StatsItemName").replace("&", "§"));
							/* 229 */           stats.setItemMeta(stats2);
							p.getInventory().setItem(3, stats);
							p.getInventory().setItem(0, shop);
							ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
							/* 227 */           ItemMeta stats12 = kits.getItemMeta();
							/* 228 */           stats12.setDisplayName(Main.messages.getString("ClickTestItemName").replace("&", "§"));
							/* 229 */           stats1.setItemMeta(stats12);
							p.getInventory().setItem(4, stats1);
							/* 103 */       p.getInventory().addItem(new ItemStack[] { kits });
							/* 104 */       p.getInventory().addItem(new ItemStack[] { st });
							/*     */       
							/*     */ 
							/* 107 */       
							/*     */       
							/*     */ 
							/*     */ 
							/*     */ 
							/* 187 */       p.setExp(0.0F);
							/* 188 */       p.setExhaustion(20.0F);
							/* 189 */       p.setFireTicks(0);
							/* 190 */       p.setFoodLevel(20000);
							/* 191 */       p.getInventory().setArmorContents(null);
							/*     */       
							/* 193 */       p.updateInventory();
							/* 194 */       Habilidade.removeAbility(p);
							/* 195 */       Deshfire.Armadura.remove(p);
							/* 196 */       Deshfire.Armadura2.remove(p);
							/* 197 */       Deshfire.cooldownm.remove(p);
							/*     */       p.setGameMode(GameMode.SURVIVAL);
							/* 199 */       Cooldown.remove(p);

							p.teleport(lobby);
							p.sendMessage(ChatColor.YELLOW + "You respawned");
							p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 0));
							p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Main.getInstance().getConfig().getString("Sound.RespawnSucess")), 3.0F, 3.0F);
							
							
							cancel();
							
						}
						
					}
					
				}.runTaskTimer(Main.getInstance(), 0L, 20L);
			}
	}
	
	
	

			
		

		
}
