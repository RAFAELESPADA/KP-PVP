package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.FastBoard;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Level;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreboardBuilder;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.WaveAnimation;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import me.RafaelAulerDeMeloAraujo.main.Main;





public class API
{
  
    public static String NomeServer;

    public static String fimcooldown;
    /*     */ private static me.RafaelAulerDeMeloAraujo.ScoreboardManager.WaveAnimation waveAnimation;
    private static String text = "";
	  public static String monkCooldownMessage = "§c§bYou cannot use your ability for more: §5 %s seconds!";
	  public String monkedMessage = "§cYou use your ability !";
	  public static int cooldownmonk = 15;
	  public static boolean sendThroughInventory = true;
	  public static transient HashMap<ItemStack, Long> monkStaff = new HashMap<ItemStack, Long>();
	
	public static ArrayList<String> admin = new ArrayList<String>();
	public static ArrayList<String> report = new ArrayList<String>();
	
	public static ArrayList<String> used = new ArrayList<String>();
	public static ArrayList<String> warp = new ArrayList<String>();
	
	public static ArrayList<String> Velotrol2 = new ArrayList<String>();
	public static ArrayList<String> freeze = new ArrayList<String>();
	public static ArrayList<String> freezing = new ArrayList<String>();
	
	public static HashMap<Player, String> kit = new HashMap<Player, String>();
    
    public static void MensagemCooldown(final Player p) {

        p.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("KitCooldown").replace("&", "§")).replace("%time%", String.valueOf(Cooldown.cooldown(p))));
    }
   
    	   static {
    	       
    	        API.NomeServer = Main.getInstance().getConfig().getString("Prefix").replace("&", "§");
    	        API.fimcooldown = Main.getInstance().getConfig().getString("Prefix").replace("&", "§") + (Main.messages.getString("KitCooldownEnd").replace("&", "§"));
    	    
    	    
    	    
    	   }
    	   public static void init() {
    		   waveAnimation = new WaveAnimation(Main.messages.getString("ScoreBoardTitle"), Main.messages.getString("ScoreBoardWaveColor1").replace("&", "§"), Main.messages.getString("ScoreBoardWaveColor2").replace("&", "§"), Main.messages.getString("ScoreBoardWaveColor3").replace("&", "§"), 3);
    		   text = waveAnimation.next();
    		      for (Player p : Bukkit.getOnlinePlayers()) {
    		      new BukkitRunnable() {	
    		    		@Override
    		    			public void run() {
    		    	/*     */         if (!Main.getInstance().getConfig().getBoolean("ScoreBoardEnabled")) {
    		    		return;
    		    	}
    		    	/*     */               else if (!Join.game.contains(p.getName())) {
    		    		return;
    		    	}
    		    	/*     */ 	/*     */       FastBoard board = new FastBoard(p);

    		    				 board.updateTitle(Main.messages.getString("ScoreBoardTitle").replace("&", "§"));
    		    	String l10 = "§3";
    		    	String l9 = Main.messages.getString("ScoreBoardKit").replace("&", "§") + Habilidade.getAbility(p);
    		    	String l8 = "§2";
    		    	String l7 = Main.messages.getString("ScoreBoardKills").replace("&", "§") + AntiDeathDrop.GetKills(p);
    		    	String l6 = Main.messages.getString("ScoreBoardDeaths").replace("&", "§") + AntiDeathDrop.GetDeaths(p);
    		    	String l5 = Main.messages.getString("ScoreBoardKS").replace("&", "§") + (Integer)Streak.killstreak.get(p.getName()).intValue();
    		    	String l4 = "§1";
    		    	String l3 = Main.messages.getString("ScoreBoardCoins").replace("&", "§") + Coins.getCoins(p.getName());
    		    	String l2 = Main.messages.getString("ScoreBoardXP").replace("&", "§") + XP.getXP(p.getName());
    		    	String l1 = "§0";
    		    	String l0 = Main.messages.getString("ScoreBoardLevel").replace("&", "§") + Level.getLevel(p);
    		    	String lxp = Main.messages.getString("ScoreBoardNeedXP").replace("&", "§");

    		    	board.updateLines(
    		    	        l10,
    		    	        l9,
    		    	        l8,
    		    	        l7,
    		    	        l6,
    		    	        l5,
    		    	        l4,
    		    	        l3,
    		    	        l2,
    		    	        l1,
    		    	        l0,
    		    	        lxp,
    		    	        String.valueOf(Level.getXPToLevelUp(p)
    		    	));
    		    	ScoreboardBuilder.boards.put(p.getUniqueId(), board);
    		    		}}.runTaskTimer(Main.getInstance(), 1 * 20L, 20L * Main.getInstance().getConfig().getInt("ScoreBoard-Interval-Update"));
    			Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
    				public void run() {
    					text = waveAnimation.next();
    					
    					for (Player onlines : Bukkit.getOnlinePlayers()) {
    						 if (onlines == null) {
    							 continue;
    						 }
    						 if (!onlines.isOnline()) {
    							 continue;
    						 }
    						 if (onlines.isDead()) {
    							 continue;
    						 }
    					 	 Scoreboard score = onlines.getScoreboard();
    						 if (score == null) {
    							 continue;
    						 }
    						 Objective objective = score.getObjective(DisplaySlot.SIDEBAR);
    						 if (objective == null) {
    							 continue;
    						 }
    						 objective.setDisplayName(text);
    						 
    					}
    				}
    			}, 40, 2L);
    		}
    		      }
    		      
    		      
    	   public static void sopa(final Player p) {
    		   ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    		   /* 50 */       ItemMeta sopas = sopa.getItemMeta();
    		   /* 51 */       sopas.setDisplayName("§6Soup");
    		   /* 52 */       sopa.setItemMeta(sopas);
    		   for (int i = 0; i <= 34; i++) {
    				/* 76 */         p.getInventory().addItem(new ItemStack[] { sopa });
    			}
   	    }
	    public static void tirarArmadura(final Player p) {
	        p.getInventory().setHelmet(new ItemStack(Material.AIR));
	        p.getInventory().setChestplate(new ItemStack(Material.AIR));
	        p.getInventory().setLeggings(new ItemStack(Material.AIR));
	        p.getInventory().setBoots(new ItemStack(Material.AIR));
	    }
	    public static void ferro(final Player p) {
	        p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
	        p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
	        p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
	        p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	    }
	    public static ItemStack darArmadura(final Material material, final Color cor) {
	        final ItemStack item = new ItemStack(material);
	        final LeatherArmorMeta itemm = (LeatherArmorMeta)item.getItemMeta();
	        itemm.setColor(cor);
	        item.setItemMeta((ItemMeta)itemm);
	        return item;
	    }
	    
		  public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
		        p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
		    }
			public static String cor(String s) {
				return s.replace("&", "§");
			} 

public static void tirarEfeitos(final Player p) {
    p.removePotionEffect(PotionEffectType.ABSORPTION);
    p.removePotionEffect(PotionEffectType.BLINDNESS);
    p.removePotionEffect(PotionEffectType.CONFUSION);
    p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.FAST_DIGGING);
    p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.HARM);
    p.removePotionEffect(PotionEffectType.HEAL);
    p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    p.removePotionEffect(PotionEffectType.HUNGER);
    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    p.removePotionEffect(PotionEffectType.INVISIBILITY);
    p.removePotionEffect(PotionEffectType.JUMP);
    p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    p.removePotionEffect(PotionEffectType.POISON);
    p.removePotionEffect(PotionEffectType.REGENERATION);
    p.removePotionEffect(PotionEffectType.SATURATION);
    p.removePotionEffect(PotionEffectType.SLOW);
    p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    p.removePotionEffect(PotionEffectType.SPEED);
    p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    p.removePotionEffect(PotionEffectType.WEAKNESS);
    p.removePotionEffect(PotionEffectType.WITHER);
}
public static void give(Player p)
{
	
   ItemStack marrom21 = new ItemStack(Material.COMPASS);
   ItemMeta marrom211 = marrom21.getItemMeta();
   marrom211.setDisplayName("§eCompass");
   List<String> itemlorem11 = new ArrayList();
   itemlorem11.add("§cFind enemies near you!");
   marrom211.setLore(itemlorem11);
   marrom21.setItemMeta(marrom211);
	  	
   ItemStack sopas = new ItemStack(Material.BOWL, 64);
   ItemMeta ksopas = sopas.getItemMeta();
   ksopas.setDisplayName("§eBowl");
   sopas.setItemMeta(ksopas);
   
   ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
   ItemMeta kcogur = cogur.getItemMeta();
   kcogur.setDisplayName("§3--> §cRed §3<--");
   cogur.setItemMeta(kcogur);
   ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
   ItemMeta kcogum = cogum.getItemMeta();
   kcogum.setDisplayName("§3--> §8Brown §3<--");
   cogum.setItemMeta(kcogum);
  p.getInventory().setItem(14, cogum);
  p.getInventory().setItem(15, cogur);
  p.getInventory().setItem(8, marrom21);
  p.getInventory().setItem(13, sopas);
  if (Habilidade.getAbility(p) == "Fisherman") {
	  return;
  }
  if (!Main.getInstance().getConfig().getBoolean("FullIron") && Habilidade.getAbility(p) != "Tank") {
	  ItemStack capacete0 = new ItemStack(Material.AIR);
		p.getInventory().setHelmet(capacete0);
	/* 64 */       p.getInventory().setChestplate(capacete0);
	/* 65 */       p.getInventory().setLeggings(capacete0);
	/* 66 */       p.getInventory().setBoots(capacete0);
  }
  else if (Habilidade.getAbility(p) == "Cactus" || Habilidade.getAbility(p) == "Airman" || Habilidade.getAbility(p) == "Pyro" || Habilidade.getAbility(p) == "Jumper" || Habilidade.getAbility(p) == "Wasp" || Habilidade.getAbility(p) == "Spiderman" && Main.getInstance().getConfig().getBoolean("FullIron")) {
	  ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	   /* 47 */       souperaa.setDisplayName("§cSword");
	   /* 48 */       dima.setItemMeta(souperaa);
	                  
	   p.getInventory().setItem(0, dima);
	   return;
  }
  else if (Habilidade.getAbility(p) == "PvP" && Main.getInstance().getConfig().getBoolean("FullIron")) {
	  ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	   /* 47 */       souperaa.setDisplayName("§cSword");
	   dima.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	   /* 48 */       dima.setItemMeta(souperaa);
	                  
	   p.getInventory().setItem(0, dima);
	   return;
  }
  else if (Habilidade.getAbility(p) == "PvP" && !Main.getInstance().getConfig().getBoolean("FullIron")) {
	  ItemStack dima = new ItemStack(Material.IRON_SWORD);
	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	   /* 47 */       souperaa.setDisplayName("§cSword");
	   dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	   /* 48 */       dima.setItemMeta(souperaa);
	                  
	   p.getInventory().setItem(0, dima);
	   return;
  }
	   else if (Habilidade.getAbility(p) == "Cactus" || Habilidade.getAbility(p) == "Airman" || Habilidade.getAbility(p) == "Jumper" || Habilidade.getAbility(p) == "Wasp" || Habilidade.getAbility(p) == "Spiderman" && !Main.getInstance().getConfig().getBoolean("FullIron")) {
		   ItemStack capacete0 = new ItemStack(Material.AIR);
			p.getInventory().setHelmet(capacete0);
		/* 64 */       p.getInventory().setChestplate(capacete0);
		/* 65 */       p.getInventory().setLeggings(capacete0);
		/* 66 */       p.getInventory().setBoots(capacete0);
	   }
	   else  if (Habilidade.getAbility(p) == "Pyro" && !Main.getInstance().getConfig().getBoolean("FullIron")) {
	  p.getInventory().clear();
	   ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	   /*  48 */     ItemMeta sopas1 = sopa.getItemMeta();
	   /*  49 */     sopas1.setDisplayName("§6Soup");
	   /*  50 */     sopa.setItemMeta(sopas1);
	   for (Object bow = p.getActivePotionEffects().iterator(); ((Iterator)bow).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)bow).next();
	   /* 329 */         p.removePotionEffect(effect.getType());
	   /*     */       }
	   /* 331 */       ItemStack sword3 = new ItemStack(Material.STONE_SWORD);
	   /* 332 */       sword3.addEnchantment(Enchantment.KNOCKBACK, 2);
	   /* 333 */       sword3.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	   /* 334 */       ItemStack flecha = new ItemStack(Material.ARROW, 64);
	   /* 335 */       sword3.addEnchantment(Enchantment.FIRE_ASPECT, 1);
	   /* 336 */       Object bow1 = new ItemStack(Material.BOW);
	   /* 337 */       ((ItemStack)bow1).addEnchantment(Enchantment.ARROW_DAMAGE, 1);
	   ((ItemStack)bow1).addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
	   /* 338 */       ((ItemStack)bow1).addEnchantment(Enchantment.ARROW_FIRE, 1);
	   /* 339 */       ItemStack capacete0 = new ItemStack(Material.AIR);
		p.getInventory().setHelmet(capacete0);
	/* 64 */       p.getInventory().setChestplate(capacete0);
	/* 65 */       p.getInventory().setLeggings(capacete0);
	/* 66 */       p.getInventory().setBoots(capacete0);
	   /* 340 */     Bukkit.getConsoleSender().sendMessage("SOMEONE CHOOSED KIT PYRO WHEN FULL IRON IS SET TO OFF!");
	   /* 341 */       p.getInventory().addItem(new ItemStack[] { (ItemStack)bow1 });
	   /* 342 */       p.getInventory().addItem(new ItemStack[] { flecha });
	   /* 343 */       for (int i = 0; i <= 33; i++) {
	   /* 344 */         p.getInventory().addItem(new ItemStack[] { sopa });
	   /*     */       }
  }
	    if (Habilidade.getAbility(p) != "Basic" && Habilidade.getAbility(p) != "Viking" && Habilidade.getAbility(p) != "Wasp" && Habilidade.getAbility(p) != "PvP" && !Main.getInstance().getConfig().getBoolean("FullIron")) {
	   ItemStack dima = new ItemStack(Material.STONE_SWORD);
	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	   /* 47 */       souperaa.setDisplayName("§cSword");
	   /* 48 */       dima.setItemMeta(souperaa);
	   Bukkit.getConsoleSender().sendMessage("Giving Stone Sword to " + p.getName() + "because he chooses the kit: " + Habilidade.getAbility(p));
	                  p.getInventory().setItem(0, dima);
	   }
  else if (Habilidade.getAbility(p) != "Basic" && Habilidade.getAbility(p) != "Viking" && Habilidade.getAbility(p) != "Wasp" && Habilidade.getAbility(p) != "PvP"  && Main.getInstance().getConfig().getBoolean("FullIron")) {
	   ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	   /* 47 */       souperaa.setDisplayName("§cSword");
	   /* 48 */       dima.setItemMeta(souperaa);
	                  Bukkit.getConsoleSender().sendMessage("Giving Diamond Sword to " + p.getName() + "because he chooses the kit: " + Habilidade.getAbility(p));
	   p.getInventory().setItem(0, dima);
	   }
   else if (Habilidade.getAbility(p) == "Viking" && Main.getInstance().getConfig().getBoolean("FullIron")) {
	   ItemStack dima = new ItemStack(Material.DIAMOND_AXE);
	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	   /* 47 */       souperaa.setDisplayName("§cAxe");
	   /* 48 */       dima.setItemMeta(souperaa);
	                  dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	                  p.getInventory().setItem(0, dima);
   }
	                  else if (Habilidade.getAbility(p) == "Viking" && !Main.getInstance().getConfig().getBoolean("FullIron")) {
	                	  ItemStack dima = new ItemStack(Material.STONE_AXE);
	               	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	               	   /* 47 */       souperaa.setDisplayName("§cAxe");
	               	   /* 48 */       dima.setItemMeta(souperaa);
	               	                 
	               	p.getInventory().setItem(0, dima);
	   }
	                  else if (Habilidade.getAbility(p) == "Basic" && Main.getInstance().getConfig().getBoolean("FullIron")) {
   ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
   /* 47 */       souperaa.setDisplayName("§cSword");
   /* 48 */       dima.setItemMeta(souperaa);
                  dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                  p.getInventory().addItem(new ItemStack[] { dima });
   }
   else if (Habilidade.getAbility(p) == "Basic" && !Main.getInstance().getConfig().getBoolean("FullIron")) {
	   ItemStack dima = new ItemStack(Material.STONE_SWORD);
	   /* 46 */       ItemMeta souperaa = dima.getItemMeta();
	   /* 47 */       souperaa.setDisplayName("§cSword");
	   /* 48 */       dima.setItemMeta(souperaa);
	                  dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	                  p.getInventory().addItem(new ItemStack[] { dima });
	   }
   
   if (Main.getInstance().getConfig().getBoolean("FullIron") && Habilidade.getAbility(p) != "Tank") {
   ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
	/*    */       
	/* 57 */       ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
	/*    */       
	/* 59 */       ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
	/*    */       
	/* 61 */       ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
	/*    */       
	/* 63 */       p.getInventory().setHelmet(capacete0);
	/* 64 */       p.getInventory().setChestplate(peitoral0);
	/* 65 */       p.getInventory().setLeggings(calca0);
	/* 66 */       p.getInventory().setBoots(Bota0);
   }
	else if (!Main.getInstance().getConfig().getBoolean("FullIron") && Habilidade.getAbility(p) != "Tank"){
		ItemStack capacete0 = new ItemStack(Material.AIR);
		p.getInventory().setHelmet(capacete0);
	/* 64 */       p.getInventory().setChestplate(capacete0);
	/* 65 */       p.getInventory().setLeggings(capacete0);
	/* 66 */       p.getInventory().setBoots(capacete0);
   }
	else if (Main.getInstance().getConfig().getBoolean("FullIron") && Habilidade.getAbility(p) == "Tank"){
		p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		/* 399 */       p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
		/* 400 */       p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
		/* 401 */       p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
		}
	else if (!Main.getInstance().getConfig().getBoolean("FullIron") && Habilidade.getAbility(p) == "Tank"){
		p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
		/* 399 */       p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		/* 400 */       p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		/* 401 */       p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
		}

}
}