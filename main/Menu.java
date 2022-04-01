/*     */ package me.RafaelAulerDeMeloAraujo.main;

/*     */ import java.util.Arrays;
/*     */ import java.util.List;
import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Level;
/*     */ import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.X1.X1;
import net.md_5.bungee.api.ChatColor;
/*     */ import org.bukkit.Bukkit;
import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material; 
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender; 
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerKickEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;


/*     */ public class Menu
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   private Main main;
/*     */  
/*     */   
/*     */   public Menu(Main main)
/*     */   {
/*  62 */     this.main = main;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e) {
/*  67 */     Player p = e.getPlayer();
/*     */     if (!Join.player.contains(p)) {
/*     */ Join.player.add(p);
Bukkit.getConsoleSender().sendMessage("[KP-PVP] Adding " + p.getName() + " to Top Kills List.");
}
/*  70 */     Habilidade.removeAbility(p);
/*  71 */     Deshfire.Armadura.remove(p);
/*  72 */     Deshfire.Armadura2.remove(p);
/*  73 */     Deshfire.cooldownm.remove(p);
if (!Main.plugin.getConfig().getBoolean("bungeemode")) {
/*  74 */     Join.game.remove(p.getName());
}
/*  75 */     Cooldown.remove(p);
/*     */     
/*     */ 
/*     */ 
/*  79 */     Streak.killstreak.put(p.getName(), Integer.valueOf(0));
/*     */     

/*     */     
/*  84 */     if (this.main.getConfig().getString("JoinItem.JoinSound").equalsIgnoreCase("true"))
/*  85 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Join")), 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void createButton(Material mat, Inventory inv, int Slot, String name, String lore) {
/*  89 */     ItemStack item = new ItemStack(mat);
/*     */     
/*  91 */     ItemMeta meta = item.getItemMeta();
/*  92 */     meta.setDisplayName(name);
/*  93 */     meta.setLore(Arrays.asList(new String[] { lore }));
/*  94 */     item.setItemMeta(meta);
/*  95 */     inv.setItem(Slot, item);
/*     */   }
/*     */   @EventHandler
/*     */   public void onEvent(PlayerJoinEvent e)
/*     */   {
     Player p = e.getPlayer(); 
     if (!Main.plugin.getConfig().getBoolean("bungeemode")) {
	 return;
}
if (!Join.game.contains(p.getName())) {
/*  74 */     Join.game.add(p.getName());
}
	/*     */ 
	/* 200 */           World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
	/* 201 */           double x = Main.plugin.getConfig().getDouble("Spawn.X");
	/* 202 */           double y = Main.plugin.getConfig().getDouble("Spawn.Y");
	/* 203 */           double z = Main.plugin.getConfig().getDouble("Spawn.Z");
	/* 204 */           Location lobby = new Location(w, x, y, z);


	/*     */ 
	/* 211 */           lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
	/* 212 */           lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
	/* 213 */           p.getInventory().clear();
	/*     */           
	/*     */ 
	/* 216 */           p.teleport(lobby);
	/*     */           
	/*     */ 
	/* 219 */           p.getInventory().clear();
	/* 220 */           p.getInventory().setArmorContents(null);
	/*  94 */       p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, Main.messages.getString("KitItemName").replace("&", "§"), Arrays.asList(new String[] { this.main.getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
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
	ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
	/* 227 */           ItemMeta stats12 = stats1.getItemMeta();
	/* 228 */           stats12.setDisplayName(Main.messages.getString("ClickTestItemName").replace("&", "§"));
	/* 229 */           stats1.setItemMeta(stats12);

	/* 103 */     

	p.getInventory().setItem(4, stats1);
	/* 103 */       p.getInventory().addItem(new ItemStack[] { kits });
	/* 104 */       p.getInventory().addItem(new ItemStack[] { st });
	/*     */       
	/*     */ 
	/* 107 */       p.updateInventory();
	/*     */           
	/*     */ 

	/*     */ 
	/* 235 */           p.setExp(0.0F);
	/* 236 */           p.setExhaustion(20.0F);
	/* 237 */           p.setFireTicks(0);
	/* 238 */           p.setFoodLevel(20000);
	/* 239 */           TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(80), Integer.valueOf(40), this.main.getConfig().getString("Title.JoinTitle"), this.main.getConfig().getString("Title.JoinSubTitle"));
	API.tirarEfeitos(p);
}
/*     */   
/*     */   @EventHandler
/*     */   public void onLeave(PlayerQuitEvent e)
/*     */   {
/* 117 */     Player p = e.getPlayer();
/*     */     if (Join.game.contains(p.getName())&& !Main.plugin.getConfig().getBoolean("bungeemode")) {
/*     */ 
/*     */ 
/*     */ 
/* 122 */     p.chat("/kitpvp leave");
}
/*     */   }
@EventHandler
/*     */   public void onEventt(PlayerJoinEvent e)
/*     */   {
     Player p = e.getPlayer(); 
     if (p.getGameMode() == GameMode.SPECTATOR) {
    	 p.setGameMode(GameMode.SURVIVAL);
     }
}
/*     */   
/*     */   @EventHandler
/*     */   public void onLeave(PlayerKickEvent e)
/*     */   {
/* 128 */     Player p = e.getPlayer();
/*     */     if (Join.game.contains(p.getName()) && !Main.plugin.getConfig().getBoolean("bungeemode")) {
/*     */ 
/*     */ 
/*     */ 
/* 133 */     p.chat("/kitpvp leave");
}
/*     */   } 

/*     */ 
/*     */   private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore)
/*     */   {
/* 237 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
/* 238 */     ItemMeta meta = item.getItemMeta();
/* 239 */     meta.setDisplayName(displayName);
/* 240 */     meta.setLore(lore);
/* 241 */     item.setItemMeta(meta);
/* 242 */     return item;
/*     */   }
/*     */ 
/*     */   @EventHandler
/*     */   public void quickcommand(PlayerCommandPreprocessEvent e)
/*     */   {
/* 336 */     if ((e.getMessage().equalsIgnoreCase("/kitpvp kit")) && (Join.game.contains(e.getPlayer().getName()))) {
/* 337 */       e.setCancelled(true);
/* 338 */       Player p = e.getPlayer();
/* 339 */       p.chat("/kpkitmenu");
/*     */       
/* 341 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 343 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 344 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand1(PlayerCommandPreprocessEvent e)
/*     */   {
/* 352 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kits")) {
/* 353 */       e.setCancelled(true);
/* 354 */       Player p = e.getPlayer();
/* 355 */       p.chat("/kpkitmenu");
/* 356 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 358 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 359 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand2(PlayerCommandPreprocessEvent e)
/*     */   {
/* 367 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kitmenu")) {
/* 368 */       e.setCancelled(true);
/* 369 */       Player p = e.getPlayer();
/* 370 */       p.chat("/kpkitmenu");
/* 371 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 373 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 374 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand3(PlayerCommandPreprocessEvent e)
/*     */   {
/* 382 */     if (e.getMessage().equalsIgnoreCase("/kpkits")) {
/* 383 */       e.setCancelled(true);
/* 384 */       Player p = e.getPlayer();
/* 385 */       p.chat("/kpkitmenu");
/*     */       
/*     */ 
/* 388 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 390 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 391 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   @EventHandler
/*     */   public void quickcommand3f(PlayerCommandPreprocessEvent e)
/*     */   {
/* 382 */     if (e.getMessage().equalsIgnoreCase("/kp kits")) {
/* 383 */       e.setCancelled(true);
/* 384 */       Player p = e.getPlayer();
/* 385 */       p.chat("/kpkitmenu");
/*     */       
/*     */ 
/* 388 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 390 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 391 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void quickcommand4(PlayerCommandPreprocessEvent e)
/*     */   {
/* 400 */     if (e.getMessage().equalsIgnoreCase("/kpkit")) {
/* 401 */       e.setCancelled(true);
/* 402 */       Player p = e.getPlayer();
/* 403 */       p.chat("/kpkitmenu");
/* 404 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 406 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 407 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   @EventHandler
/*     */   public void quickcommand4t(PlayerCommandPreprocessEvent e)
/*     */   {
/* 400 */     if (e.getMessage().equalsIgnoreCase("/spawn")) {
/* 401 *
/* 402 */       Player p = e.getPlayer();
/* 403 */       
/* 404 */       if (Join.game.contains(p.getName()))
/*     */       {
	 p.sendMessage("§eTeleporting in 5 seconds");
	 e.setCancelled(true);
	 p.getInventory().clear();
	 p.setHealth(1.0);
	 API.darEfeito(p, PotionEffectType.SLOW, 99, 6);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
			{
      public void run()
      {
/* 406 */   for (PotionEffect effect : p.getActivePotionEffects()) {
	/*  70 */         p.removePotionEffect(effect.getType());
	/*     */       }
	/*  72 */       p.sendMessage(String.valueOf(Main.getInstace().getConfig().getString("Prefix").replace("&", "§")) + Main.getInstace().getConfig().getString("Message.Clear").replace("&", "§"));
	/*  73 */       p.getInventory().clear();
	/*  74 */       p.getInventory().setHelmet(new ItemStack(Material.AIR));
	/*  75 */       p.getInventory().setChestplate(new ItemStack(Material.AIR));
	/*  76 */       Habilidade.removeAbility(p);
	/*  77 */       me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown.remove(p);
	/*  78 */       Deshfire.cooldownm.remove(p);
	/*  79 */       Deshfire.armadura.remove(p);
	/*  80 */       Gladiator.lutando.remove(p);
	/*  81 */       Gladiator.gladgladiator.remove(p);
	/*  82 */       org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
	/*  83 */       double x = Main.plugin.getConfig().getDouble("Spawn.X");
	/*  84 */       double y = Main.plugin.getConfig().getDouble("Spawn.Y");
	/*  85 */       double z = Main.plugin.getConfig().getDouble("Spawn.Z");
	/*  86 */       Location lobby = new Location(w, x, y, z);
	/*  87 */       lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
	/*  88 */       lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
	/*  89 */       p.getInventory().clear();
	/*  90 */       p.teleport(lobby);
	/*     */       p.setHealth(20);
	/*  92 */       p.getInventory().setLeggings(new ItemStack(Material.AIR));
	/*  93 */       p.getInventory().setBoots(new ItemStack(Material.AIR));
	/*  94 */       p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, Main.messages.getString("KitItemName").replace("&", "§"), Arrays.asList(new String[] { Main.getInstace().getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
	/*  95 */       ItemStack kits = new ItemStack(Material.EMERALD);
	/*  96 */       ItemMeta kits2 = kits.getItemMeta();
	/*  97 */       kits2.setDisplayName(Main.messages.getString("ShopItemName").replace("&", "§"));
	/*  98 */       kits.setItemMeta(kits2);
	/*  99 */       ItemStack st = new ItemStack(Material.BLAZE_ROD);
	/* 100 */       ItemMeta st2 = st.getItemMeta();
	/* 101 */       st2.setDisplayName(Main.messages.getString("1v1ItemName").replace("&", "§"));
	/* 102 */       st.setItemMeta(st2);
	ItemStack stats = new ItemStack(Material.NAME_TAG);
	/* 227 */           ItemMeta stats2 = stats.getItemMeta();
	/* 228 */           stats2.setDisplayName(Main.messages.getString("StatsItemName").replace("&", "§"));
	/* 229 */           stats.setItemMeta(stats2);
	p.getInventory().setItem(3, stats);
	ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
	/* 227 */           ItemMeta stats12 = stats1.getItemMeta();
	/* 228 */           stats12.setDisplayName(Main.messages.getString("ClickTestItemName").replace("&", "§"));
	/* 229 */           stats1.setItemMeta(stats12);
	p.getInventory().setArmorContents(null);
	/* 103 */       p.getInventory().addItem(new ItemStack[] { kits });
	/* 104 */       p.getInventory().addItem(new ItemStack[] { st });
	p.getInventory().setItem(4, stats1);
	/*     */       p.setAllowFlight(false);
	/*     */ p.setHealth(20);
	/* 107 */    
	/*     */       
	/*     */ API.tirarEfeitos(p);
	/* 107 */       p.updateInventory();
/*     */         

/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 159 */         ((Player)p).playSound(((Player)p).getLocation(), Sound.valueOf(Main.getInstace().getConfig().getString("Sound.SucefullMessage")), 2.0F, 2.0F);
/* 160 */           	         } }, 100L);
	}
}

/* 407 */        
/*     */       
/*     */     
/*     */   } 
@EventHandler
public void onBauKit(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.EMERALD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      p.openInventory(Shop.shop);
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
}
@EventHandler
public void onKit(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.BOOK)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      Bukkit.dispatchCommand(p, "kpkitmenu");
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
}
@EventHandler
public void onKit2(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.WOOD_SWORD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      ClickTest.StartClick(p);
    }
  }
}

@EventHandler
public void onStats(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.NAME_TAG)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      p.sendMessage("§b");
      int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
      int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".deaths");
      p.sendMessage(Main.messages.getString("Status").replace("&", "§").replace("%player%", p.getName()));
      p.sendMessage("");
      p.sendMessage(Main.messages.getString("StatusKills").replace("&", "§") + kills);
      p.sendMessage(Main.messages.getString("StatusDeaths").replace("&", "§") + deaths);      
      p.sendMessage(Main.messages.getString("StatusCoins").replace("&", "§") + Coins.getCoins(p.getName()));
      p.sendMessage(Main.messages.getString("StatusKS").replace("&", "§") + Streak.killstreak.get(p.getName()));
      p.sendMessage(Main.messages.getString("StatusXP").replace("&", "§") + XP.getXP(p.getName()));
      p.sendMessage(Main.messages.getString("StatusLevel").replace("&", "§") + Level.getLevel(p));
      p.sendMessage("§b");
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
}
@EventHandler
public void v1(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.BLAZE_ROD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
    	if (Main.cfg_x1.getString("x1.coords.spawn.world") == null) {
    		p.sendMessage(ChatColor.YELLOW + "The KitPvP 1vs1 is not seted yet!");
    		return;
    	}
      X1.entrar1v1(p);
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
} 
/*     */   public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
/*     */   {
/* 452 */     return false;
/*     */   }
/*     */ }

