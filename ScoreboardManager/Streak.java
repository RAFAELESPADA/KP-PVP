/*     */ package me.RafaelAulerDeMeloAraujo.ScoreboardManager;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
import net.md_5.bungee.api.chat.BaseComponent;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Sound;
import org.bukkit.World;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Streak
/*     */   implements Listener
/*     */ {
/*     */   private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public Streak()
/*     */   {
/*  31 */     this.main = this.main;
/*  32 */     plugin = this.main;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  40 */   public static Map<String, Integer> killstreak = new HashMap();
/*     */   
/*     */   public void onEnable() {}
/*     */   
/*     */   @EventHandler
/*  45 */   public void playerdeath(PlayerDeathEvent ev) { Player p = ev.getEntity();
/*  46 */     if ((p.getKiller() instanceof Player))
/*     */     {
/*     */ 
/*  49 */       Player killer = p.getKiller();
/*  50 */       if (Join.game.contains(killer.getName()))
/*     */       {
/*  52 */       p.sendMessage(API.NomeServer + "" + (Main.messages.getString("StreakDestroyed").replace("&", "§").replace("%player%", killer.getName()))); }
/*  53 */       addtokillstreak(killer);
/*  54 */       killstreak.put(p.getName(), Integer.valueOf(0));
/*     */     }
/*     */   }
/*     
*/  

/*     */ 
/*     */   public void addtokillstreak(Player killer)
/*     */   {
/*  61 */     String name = killer.getName();
/*  62 */     if (killstreak.containsKey(name) && Join.game.contains(name))
/*     */     {
/*  64 */       int kills = ((Integer)killstreak.get(name)).intValue();
/*  65 */       kills++;
/*  66 */       killstreak.put(name, Integer.valueOf(kills));
/*     */       
/*  68 */       killer.sendMessage(API.NomeServer + "" + ChatColor.GREEN + "You are on " + ChatColor.RED + Integer.toString(kills) + ChatColor.GREEN + " Killstreak.");
/*  69 */       if (kills % 3 == 0) {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", String.valueOf(kills)).replace("%player%", name) , killer.getWorld());
/*  73 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You have been awarded " + Main.customization.getDouble("KS-3") + " Coins!");
/*  74 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-3"));
/*     */       }
/*  76 */      
/*     */     }
/*     */   }
/*     */ 

  public static void broadcast(String text, World w){
    for(Player p: w.getPlayers()){
        p.sendMessage(text);
    }
  }}
/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\ScoreboardManager\Streak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
