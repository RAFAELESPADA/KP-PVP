package me.RafaelAulerDeMeloAraujo.X1;

/*     */ 
/*     */ import java.util.ArrayList;
import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
import java.util.Optional;
import java.util.Random;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;

/*     */ import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Player.Spigot;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
/*     */ 
/*    */ public class Sumo
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   
/*    */   public Sumo(Main main)
/*    */   {
/* 19 */     this.main = main;
/*    */   }
/*    */   
/*     */   
/*     */ public static Map<String, String> convites = new HashMap();
/*  47 */   
/*  48 */   public static Map<String, String> lutadores = new HashMap();
/*  49 */   public static ArrayList<Player> hide = new ArrayList();
/*  50 */   public static ArrayList<Player> insumo = new ArrayList();
private BukkitTask runTaskLater;
/*     */   
/*     */   public static void sairSumo(Player p) {
/*  53 */     p.getInventory().clear();
/*  54 */     insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
insumo.remove(p);
/*  56 */     org.bukkit.World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
/*  57 */     double x = Main.plugin.getConfig().getDouble("Spawn.X");
/*  58 */     double y = Main.plugin.getConfig().getDouble("Spawn.Y");
/*  59 */     double z = Main.plugin.getConfig().getDouble("Spawn.Z");
/*  60 */     Location lobby = new Location(w, x, y, z);
/*  61 */     lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
/*  62 */     lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
/*  63 */     p.getInventory().clear();
/*  64 */     p.teleport(lobby);
/*  65 */     p.getInventory().setLeggings(new ItemStack(Material.AIR));
/*  66 */     p.getInventory().setBoots(new ItemStack(Material.AIR));
/*  67 */     ItemStack shop = new ItemStack(Material.BOOK);
/*  68 */     ItemMeta shop2 = shop.getItemMeta();
/*  69 */     shop2.setDisplayName( Main.messages.getString("KitItemName").replace("&", "§"));
/*  70 */     shop.setItemMeta(shop2);

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
ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
/* 227 */           ItemMeta stats12 = kits.getItemMeta();
/* 228 */           stats12.setDisplayName(Main.messages.getString("ClickTestItemName").replace("&", "§"));
/* 229 */           stats1.setItemMeta(stats12);
ItemStack warp = new ItemStack(Material.PAPER);
/* 227 */           ItemMeta warp2 = warp.getItemMeta();
/* 228 */           warp2.setDisplayName("§aWarps");
/* 229 */           warp.setItemMeta(warp2);
p.getInventory().setItem(8, warp);
p.getInventory().setItem(4, stats1);
p.getInventory().setItem(3, stats);
p.getInventory().setItem(0 , shop);
p.getInventory().setItem(1 , kits);
p.getInventory().setItem(2 , st);

/*     */       
/*     */ 
/* 107 */       p.updateInventory();
/*  83 */     Habilidade.removeAbility(p);
/*  84 */     p.setHealth(20.0D);
/*     */     
/*     */ 
/*  87 */     p.updateInventory();
/*  88 */     p.sendMessage(Main.messages.getString("SumoLeave").replace("&", "§"));
p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Sound.1v1")), 5.0F, 5.0F);
TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(60), Integer.valueOf(20), Main.getInstance().getConfig().getString("Title.SumoLeave").replace("&", "§"), "");
/*     */   }
/*     */   @EventHandler
public void onDamage(EntityDamageByEntityEvent event) {
    if (!(event.getEntity() instanceof Player)
            || !(event.getDamager() instanceof Player)) {
        return;
    }
if (!Join.game.contains(event.getEntity().getName())) {
	return;
}
    Player damager = (Player) event.getDamager();
    Player victim = (Player) event.getEntity();

 if (insumo.contains(victim) && insumo.contains(damager)) {
        event.setDamage(0);
    }
}
/*     */  @EventHandler
public void onMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);

    if (!Sumo.insumo.contains(player) || !Join.game.contains(player.getName())) {
        return;
    }
    if (!lutadores.containsKey(player.getName())) {
    	return;
    }
    Player matou = Bukkit.getServer().getPlayerExact((String)lutadores.get(player.getName()));
    if (!block.getType().toString().contains("WATER") || matou == null) {
        return;
    }
    /* 243 */     if (!Habilidade.getAbility(player).equalsIgnoreCase("SumoFight") && !Habilidade.getAbility(matou).equalsIgnoreCase("SumoFight")) {
    /* 244 */       return;
    }
    /* 245 */     if ((player instanceof Player)) {
    /* 246 */       
    /* 247 */       player.setFireTicks(0);
    /* 248 */       for (PotionEffect effect : player.getActivePotionEffects())
    /* 249 */         player.removePotionEffect(effect.getType());
    /*     */     }
    /* 251 */     if (((player instanceof Player)) && ((matou instanceof Player))) {
    /* 252 */       
    /* 253 */       player.setFireTicks(0);
    /* 254 */       for (PotionEffect effect : matou.getActivePotionEffects())
    /* 255 */         player.removePotionEffect(effect.getType());
    /*     */     }
    /* 257 */     
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /*     */ 
    /* 280 */       new BukkitRunnable()
    /*     */       {
    /*     */         public void run()
    /*     */         {
    /* 262 */       
    /* 264 */           Player morreu = player;
    /* 265 */           morreu.spigot().respawn();
    /* 266 */           Sumo.lutadores.remove(morreu.getName());
    /* 267 */           Sumo.lutadores.remove(matou.getName());
    Bukkit.getConsoleSender().sendMessage("§b" + morreu.getName() + " has been killed by " + matou.getName() + " on kitpvp Sumo");
    /* 268 */           Sumo.hide.remove(matou);
    /* 269 */           Sumo.hide.remove(morreu);
    /* 270 */           Sumo.entrar1v1(matou);
    /* 271 */           Sumo.entrar1v1(player);
    /* 272 */           morreu.updateInventory();
    /* 273 */           matou.updateInventory();
   int addkill = AntiDeathDrop.GetKills(player);
   Main.plugin.getConfig().set("status." + matou.getName().toLowerCase() + ".kills", Integer.valueOf(addkill + 1));
   Main.plugin.saveConfig();
   Streak.addtokillstreak(matou);
   Streak.killstreak.put(player.getName(), Integer.valueOf(0));
    /* 274 */           for (Player online : Bukkit.getOnlinePlayers()) {
    /* 275 */             morreu.showPlayer(online);
    /* 276 */             matou.showPlayer(online);
    /*     */           }
    /*     */           
    /*     */         }
    /* 280 */       }.runTaskLater(Main.plugin, 5L);
    /*     */     }

/*     */ 
/*     */   public static void entrar1v1(Player p)
/*     */   {
	
	if (Main.cfg_x1.getString("sumo.coords.spawn.world") == null) {
        p.sendMessage(ChatColor.YELLOW + "Sumo is not seted yet!");
        return;
      } 
	org.bukkit.World w = Bukkit.getServer().getWorld(Main.cfg_x1.getString("sumo.coords.spawn.world"));
/*  97 */     insumo.add(p);
/*  98 */     p.teleport(new Location(w, Main.cfg_x1.getDouble("sumo.coords.spawn.x"), 
/*  99 */       Main.cfg_x1.getDouble("sumo.coords.spawn.y"), Main.cfg_x1.getDouble("sumo.coords.spawn.z")));
/* 100 */     p.getInventory().clear();
/* 101 */     p.getInventory().setArmorContents(null);
/*     */     
/* 103 */     ItemStack v1 = new ItemStack(Material.APPLE);
/* 104 */     ItemMeta v12 = v1.getItemMeta();
/* 105 */     v12.setDisplayName(Main.messages.getString("SumoInviteItemName").replace("&", "§"));
/* 106 */     v1.setItemMeta(v12);
/* 107 */     ItemStack rd1 = new ItemStack(Material.REDSTONE);
/* 108 */     ItemMeta rd12 = rd1.getItemMeta();
/* 109 */     rd12.setDisplayName(Main.messages.getString("SumoLeaveItemName").replace("&", "§"));
/* 110 */     rd1.setItemMeta(rd12);
/*     */     
/* 112 */     p.getInventory().setItem(0, v1);
/* 113 */     p.getInventory().setItem(8, rd1);
/*     */     
/* 115 */     
/* 116 */     p.setHealth(20.0D);
/* 117 */     p.setExp(0.0F);
/* 118 */     p.setLevel(0);
/* 119 */     Habilidade.setAbility(p, Main.cfg_x1.getString("sumo.ability"));
p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Sound.1v1")), 5.0F, 5.0F);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void set1v1(Player p)
/*     */   {
/* 125 */     p.getInventory().clear();
/* 126 */     p.getInventory().setArmorContents(null);
Habilidade.setAbility(p, "SumoFight");
/* 141 */     
/*     */   }
/*     */  
      

/*     */ 
/*     */ 
/*     */ 
/*     */   public static void aceitar(Player p1, Player p2)
/*     */   {
	org.bukkit.World w1 = Bukkit.getServer().getWorld(Main.cfg_x1.getString("sumo.coords.loc_1.world"));
	org.bukkit.World w2 = Bukkit.getServer().getWorld(Main.cfg_x1.getString("sumo.coords.loc_2.world"));
/* 152 */     p1.teleport(new Location(w1, Main.cfg_x1.getDouble("sumo.coords.loc_1.x"), 
/* 153 */       Main.cfg_x1.getDouble("sumo.coords.loc_1.y"), Main.cfg_x1.getDouble("sumo.coords.loc_1.z"), 
/* 154 */       Float.valueOf((float)Main.cfg_x1.getDouble("sumo.coords.loc_1.yaw")).floatValue(), Float.valueOf((float)Main.cfg_x1.getDouble("sumo.coords.loc_1.pitch")).floatValue()));
/* 155 */     p2.teleport(new Location(w2, Main.cfg_x1.getDouble("sumo.coords.loc_2.x"), 
/* 156 */       Main.cfg_x1.getDouble("sumo.coords.loc_2.y"), Main.cfg_x1.getDouble("sumo.coords.loc_2.z"), 
/* 157 */       Float.valueOf((float)Main.cfg_x1.getDouble("sumo.coords.loc_2.yaw")).floatValue(), Float.valueOf((float)Main.cfg_x1.getDouble("sumo.coords.loc_2.pitch")).floatValue()));
/*     */     
/* 159 */     set1v1(p1);
/* 160 */     set1v1(p2);
/* 161 */     lutadores.put(p1.getName(), p2.getName());
/* 162 */     lutadores.put(p2.getName(), p1.getName());
/* 163 */     convites.remove(p1.getName());
/* 164 */     for (Player pp : Bukkit.getOnlinePlayers()) {
/* 165 */       p1.hidePlayer(pp);
/*     */     }
/* 167 */     hide.add(p1);
/* 168 */     for (Player pp : Bukkit.getOnlinePlayers()) {
/* 169 */       p2.hidePlayer(pp);
/*     */     }
/* 171 */     hide.add(p2);
/* 172 */     p1.showPlayer(p2);
/* 173 */     p2.showPlayer(p1);
/* 174 */     p1.updateInventory();
/* 175 */     p2.updateInventory();
/* 176 */     p2.sendMessage(Main.cfg_x1.getString("sumo.msg.invite_accept").replace("$player$", p1.getName()).replace("&", "§"));
/* 177 */     p1.sendMessage(Main.cfg_x1.getString("sumo.msg.guest_accept").replace("$player$", p2.getName()).replace("&", "§"));
p1.playSound(p1.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Sound.1v1")), 5.0F, 5.0F);
p2.playSound(p2.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Sound.1v1")), 5.0F, 5.0F);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void interact(PlayerInteractEvent e) {
/* 182 */     if ((Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("sumo.ability"))) && 
/* 183 */       (e.getAction().name().contains("RIGHT_CLICK")) && 
/* 184 */       (e.getPlayer().getItemInHand().getType().equals(Material.REDSTONE))) {
/* 185 */       sairSumo(e.getPlayer());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void entrar(PlayerJoinEvent e)
/*     */   {
/* 193 */     for (Player p : hide) {
/* 194 */       p.hidePlayer(e.getPlayer());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void cmd(PlayerCommandPreprocessEvent e) {
/* 200 */     if (Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("sumo.ability"))) {
/* 201 */       e.getPlayer().sendMessage(Main.cfg_x1.getString("sumo.msg.no_cmd").replace("&", "§"));
/* 202 */       e.setCancelled(true);
/* 203 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void kick(PlayerQuitEvent e) {
/* 209 */     if (lutadores.containsKey(e.getPlayer().getName())) {
/* 210 */       Player matou = Bukkit.getServer().getPlayerExact((String)lutadores.get(e.getPlayer().getName()));
/* 211 */       Player perdedor = e.getPlayer();
/* 212 */       matou.sendMessage(Main.cfg_x1.getString("sumo.msg.disconect").replace("&", "§"));
/* 213 */       hide.remove(perdedor);
/* 214 */       hide.remove(matou);
/* 215 */       for (Player pp : Bukkit.getOnlinePlayers()) {
/* 216 */         matou.showPlayer(pp);
/* 217 */         perdedor.showPlayer(pp);
lutadores.remove(e.getPlayer().getName());
/*     */       }
/* 219 */       entrar1v1(matou);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void kick(PlayerKickEvent e) {
/* 225 */     if (lutadores.containsKey(e.getPlayer().getName())) {
/* 226 */       Player matou = Bukkit.getServer().getPlayerExact((String)lutadores.get(e.getPlayer().getName()));
/* 227 */       Player perdedor = e.getPlayer();
/* 228 */       matou.sendMessage(Main.cfg_x1.getString("sumo.msg.disconect").replace("&", "§"));
/* 229 */       hide.remove(perdedor);
/* 230 */       hide.remove(matou);
/* 231 */       for (Player pp : Bukkit.getOnlinePlayers()) {
/* 232 */         matou.showPlayer(pp);
/* 233 */         perdedor.showPlayer(pp);
lutadores.remove(e.getPlayer().getName());
/*     */       }
/* 235 */       entrar1v1(matou);
/*     */     }
/*     */   }
/*     */   
/*     */  

/*     */   
/*     */   
/*     */   @EventHandler
/*     */   public void InteractItem(PlayerInteractEntityEvent e)
/*     */   {
/* 287 */     if ((Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("sumo.ability"))) && 
/* 288 */       ((e.getRightClicked() instanceof Player)) && 
/* 289 */       (e.getPlayer().getItemInHand().getType() == Material.APPLE)) {
/* 290 */       final Player p = e.getPlayer();
/* 291 */       Player target = (Player)e.getRightClicked();
/* 292 */       if (convites.containsKey(target.getName())) {
/* 293 */         if (((String)convites.get(target.getName())).equalsIgnoreCase(p.getName())) {
/* 294 */           aceitar(target, p);
/* 295 */         } else if (!convites.containsKey(p.getName())) {
/* 296 */           p.sendMessage(Main.cfg_x1.getString("sumo.msg.invite").replace("$player$", target.getName()).replace("&", "§"));
/* 297 */           target.sendMessage(
/* 298 */             Main.cfg_x1.getString("sumo.msg.guest").replace("$player$", p.getName()).replace("&", "§"));
/* 299 */           convites.put(p.getName(), target.getName());
/* 300 */           Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 304 */               if (Sumo.convites.containsKey(p.getName())) {
/* 305 */                 Sumo.convites.remove(p.getName());
/*     */               }
/*     */             }
/* 308 */           }, 200L);
/*     */         } else {
/* 310 */           p.sendMessage(Main.cfg_x1.getString("sumo.msg.invite_cooldown").replace("&", "§"));
/*     */         }
/* 312 */       } else if (!convites.containsKey(p.getName())) {
/* 313 */         p.sendMessage(Main.cfg_x1.getString("sumo.msg.invite").replace("$player$", target.getName()).replace("&", "§"));
/* 314 */         target.sendMessage(Main.cfg_x1.getString("sumo.msg.guest").replace("$player$", p.getName()).replace("&", "§"));
/* 316 */         convites.put(p.getName(), target.getName());
/* 317 */         BukkitTask runTaskLater = Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 321 */             if (Sumo.convites.containsKey(p.getName())) {
/* 322 */               Sumo.convites.remove(p.getName());
/*     */             }
/*     */           }
/* 325 */         }, 200L);
/*     */       } else {
/* 327 */         p.sendMessage(Main.cfg_x1.getString("sumo.msg.invite_cooldown").replace("&", "§"));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore)
/*     */   {
/* 336 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
/* 337 */     ItemMeta meta = item.getItemMeta();
/* 338 */     meta.setDisplayName(displayName);
/* 339 */     meta.setLore(lore);
/* 340 */     item.setItemMeta(meta);
/* 341 */     return item;
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\sumo\sumo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */

