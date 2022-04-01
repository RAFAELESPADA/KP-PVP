/*     */ package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;

/*     */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.logging.Logger;
import java.util.stream.Collectors;

/*     */ import me.RafaelAulerDeMeloAraujo.BStatsSystem.Metrics;
import me.RafaelAulerDeMeloAraujo.Coins.CoinsCommand;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Commands;
import me.RafaelAulerDeMeloAraujo.Coins.PayCoins;
import me.RafaelAulerDeMeloAraujo.Coins.RemoveCoins;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.AirmanFly;
import me.RafaelAulerDeMeloAraujo.Listeners.ArrowMessage;
import me.RafaelAulerDeMeloAraujo.Listeners.CombatLog;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.CommandsSounds;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.ConfigUtils;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Fisherman;

/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.JoinSign;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.LeaveSign;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.NoDrops;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.NoExplosion;
import me.RafaelAulerDeMeloAraujo.Listeners.PlaceEvent;
import me.RafaelAulerDeMeloAraujo.Listeners.Protection;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Soup;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.SoupSign;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Switcher;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.ThrowTnt;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.WallClamber;
import me.RafaelAulerDeMeloAraujo.PluginHooks.PlaceHolderAPIHook;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreboardBuilder;

/*     */ 


/*     */ import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Anchor;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Basic;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Camel;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.ConfuserHability;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Critical;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.DesifireCMD;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Dublejump;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Fireman;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.FiremanCMD;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.GladCMD;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Kangaroo;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Monk;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.MonkCMD;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Naruto;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.NewKitMenu;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Ninja;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Phantom;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.PhantomCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Poseidon;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Poseidonkit;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Resouper;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.ResouperCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Ryu;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Snail;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Sonic;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Sponge;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Stomper;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.StomperKITCOMMAND;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Thor;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.ThorKITCOMMAND;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.TimeLord;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.TimelordCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Vampire;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Viper;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
/*     */ import me.RafaelAulerDeMeloAraujo.X1.SetX1;
/*     */ import me.RafaelAulerDeMeloAraujo.X1.X1;


/*     */ import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
/*     */
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
/*     */
/*     */ import org.bukkit.configuration.InvalidConfigurationException;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDeathEvent;

/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;

/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;





/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends JavaPlugin
/*     */   implements Listener
/*     */ {
/*  77 */   public static String pluginName = "KP-PVP";
/*     */   
/*     */   private static Hologram topPlayersHd;
/*     */   public static Main getInstance()
/*     */   {
/*  82 */     return instance;
/*     */   }
/*     */   
/*     */   public static Main getInstace()
/*     */   {
/*  87 */     return instance;
/*     */   }
private me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreboardBuilder scoreboardBuilder;
/*     */   private Server server = Bukkit.getServer();
/*  90 */   public static final String instance2 = null;
/*     */   public static Object instancs;
/*     */   public static Logger log;
/*  93 */   public static File customizationf = new File("plugins/KP-PVP", "settings.yml");
/*     */   public YamlConfiguration cf;
/*  93 */   public static File messagesf = new File("plugins/KP-PVP", "messages.yml");
            public static File kitsf = new File("plugins/KP-PVP", "kits.yml");
/*     */   public static Plugin plugin;
/*     */   public static Main instance;
/*     */   private static ConfigUtils cH;
/*  98 */   public static File file_x1 = new File("plugins/KP-PVP", "1v1.yml");
/*     */   
/*     */   public static Main getPlugin()
/*     */   {
/* 102 */     return instance;
/*     */   }
/*     */   

/*     */   public void onEnable()
/*     */   {

/* 107 */     getLogger().info("KP-PVP plugin is now enable [By zEnderX5_]");
/* 108 */     getLogger().info("Website: http://bit.ly/2kC345B");
/* 109 */     Metrics metrics = new Metrics(this);

metrics.addCustomChart(new Metrics.DrilldownPie("serverAddress", () -> {
	Map<String, Map<String, Integer>> map = new HashMap<>();
	Map<String, Integer> entry = new HashMap<>();
	
	if (getConfig().getBoolean("SendIPAddressData")) entry.put(server.getIp(), 1);
	else entry.put("Hidden", 1);
	
	map.put("Port " + server.getPort(), entry);
	
	return map;
}));

new BukkitRunnable() {
	
	@Override
	public void run() {
		for (Player p1 : Bukkit.getOnlinePlayers()) {
			if (Main.plugin.getConfig().getBoolean("bungeemode")) {
		ScoreboardBuilder.update(p1);
	}
	}}}.runTaskTimer(this, 0, 30 * 20L);



if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
	/* 151 */       Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aPlaceHolderAPI is found!");
	/* 151 */       Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aHooking into it!");
    new PlaceHolderAPIHook(this).register();
	/* 151 */       Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aPlaceHolderAPI has hooked sucefully!");
}
 

	

	

		
this.scoreboardBuilder = new ScoreboardBuilder(this);
				
/* 117 */     this.pm = Bukkit.getPluginManager();
/* 118 */     
/* 119 */    

/* 121 */     instance = this;
/* 122 */     plugin = this;
/*     */     
/* 124 */     cH = new ConfigUtils();
/*     */     
/* 126 */     File cf = new File(getDataFolder(), "config.yml");
/* 127 */     if (!cf.exists()) {
/* 128 */       saveResource("config.yml", false);
/*     */     }
/* 130 */     this.cf1 = new File(getDataFolder(), "config.yml");
/* 131 */     if (!file_x1.exists()) {
/* 132 */       saveResource("1v1.yml", false);
/*     */     }
/* 134 */     if (!customizationf.exists()) {
/* 135 */       saveResource("settings.yml", false);
/*     */     }
/* 134 */     if (!messagesf.exists()) {
/* 135 */       saveResource("messages.yml", false);
/*     */     }
/* 134 */     if (!kitsf.exists()) {
/* 135 */       saveResource("kits.yml", false);
/*     */     }
/*     */     try
/*     */     {
/* 139 */       cfg_x1.load(file_x1);
messages.load(messagesf);
kits.load(kitsf);

/* 140 */       customization.load(customizationf);
/*     */     }
/*     */     catch (IOException|InvalidConfigurationException e1)
/*     */     {
/* 144 */       System.out.println(e1.getMessage());
/*     */     }

loadTopPlayersHologram();
/* 146 */     if ((Bukkit.getVersion().contains("1.9") || (Bukkit.getVersion().contains("1.10") || (Bukkit.getVersion().contains("1.11") || (Bukkit.getVersion().contains("1.12"))))))
/*     */     {
/* 148 */       getConfig().options().copyDefaults(true);
/* 149 */       getConfig().options().copyHeader(true);
/* 150 */       saveConfig();
/* 151 */       Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aThe server is using 1.9+ MINECRAFT VERSION");
/* 152 */       Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aAltering config sounds to 1.9+ Sounds...");
getConfig().options().copyDefaults(true);
getConfig().options().copyHeader(true);
saveConfig();
getConfig().set("Sound.Kit", "ENTITY_ITEM_PICKUP");
getConfig().set("Sound.ShopMenu", "BLOCK_CHEST_OPEN");
getConfig().set("Sound.KitUse", "ENTITY_ENDERDRAGON_HURT");
getConfig().set("Sound.Soup", "ENTITY_GENERIC_EAT");
getConfig().set("Sound.Fisherman", "ENTITY_ENDERMEN_TELEPORT");
getConfig().set("Sound.Spiderman", "ENTITY_SLIME_JUMP");
getConfig().set("Sound.Respawn", "ENTITY_PLAYER_LEVELUP");
getConfig().set("Sound.Join", "ENTITY_PLAYER_LEVELUP");
getConfig().set("Sound.KitMenu", "BLOCK_WOODEN_DOOR_CLOSE");
getConfig().set("Sound.SpongeUse", "ENTITY_ENDERMEN_TELEPORT");
getConfig().set("Sound.BowlDrop", "ENTITY_ITEM_PICKUP");
getConfig().set("Sound.ErrorMessage", "ENTITY_ARROW_HIT_PLAYER");
getConfig().set("Sound.SucefullMessage", "ENTITY_EXPERIENCE_ORB_PICKUP");
getConfig().set("Sound.NoPermissionMessage", "ENTITY_WITHER_SHOOT");
getConfig().set("Sound.SwitcherShoot", "ENTITY_ENDERMEN_TELEPORT");
getConfig().set("Sound.Timelord", "ENTITY_WITHER_SPAWN");
getConfig().set("Sound.ItemDespawn", "BLOCK_LAVA_POP");
getConfig().set("Sound.Stomper", "ENTITY_FIREWORK_BLAST");
getConfig().set("Sound.NarutoAbility", "ENTITY_BLAZE_DEATH");
getConfig().set("Sound.CommandsSounds", "UI_BUTTON_CLICK");
getConfig().set("Sound.ClickTest", "UI_BUTTON_CLICK");
getConfig().set("Sound.1v1", "UI_BUTTON_CLICK");
getConfig().set("Sound.Respawning", "UI_BUTTON_CLICK");
getConfig().set("Sound.RespawnSucess", "ENTITY_EXPERIENCE_ORB_PICKUP");
getConfig().set("Sound.ShopMenu-Click", "ENTITY_PLAYER_LEVELUP");
getConfig().set("Sound.Airman-Fly", "ENTITY_ENDERMEN_SCREAM");
getConfig().set("Sound.DoubleJump-Ability", "ENTITY_FIREWORK_BLAST");
getConfig().set("Sound.StomperDamage", "BLOCK_ANVIL_LAND");
getConfig().set("Sound.AnchorHit", "BLOCK_ANVIL_LAND");
getConfig().set("Sound.RyuAbility", "ENTITY_GENERIC_EXPLODE");
/* 178 */       Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aDone! All Sounds have been modified to 1.9+ Sounds.");
/*     */     }
registerEvents();
registerCommands();
Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aThe plugin updater notification gets removed!");
Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §aAlways verify if the plugin have a new version here");
Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §chttps://www.spigotmc.org/resources/kp-pvp-the-ultimate-kitpvp-plugin.50969/");
Bukkit.getConsoleSender().sendMessage("§e[KP-PVP] §2Your version is: §e" + Main.getInstance().getDescription().getVersion());
/*     */   

  
}
/*     */ 
/*     */ 
/*     */   public ConfigUtils getConfigHandler()
/*     */   {
/* 186 */     return cH;
/*     */   }

/*     */   
/*     */   private void registerCommands()
/*     */   {
/* 191 */     getCommand("kitreload").setExecutor(new Reload(this));
/* 192 */     getCommand("givecoins").setExecutor(new Commands());
              getCommand("removecoins").setExecutor(new RemoveCoins());
              getCommand("coins").setExecutor(new CoinsCommand());
/* 193 */     getCommand("kitcredits").setExecutor(new KitCredits(this));
/* 194 */     getCommand("dev").setExecutor(new Dev(this));
/* 195 */     getCommand("ksc").setExecutor(new BSC());
              getCommand("kpeditmode").setExecutor(new NoBreakEvent()); 
/* 196 */     getCommand("kpstats").setExecutor(new Stats());
/* 197 */     getCommand("kphelp").setExecutor(new KITPVP());
getCommand("settopkills").setExecutor(new SetTopKills());
getCommand("updatetopkill").setExecutor(new UpdateTopKill());
/* 198 */     getCommand("adminmode").setExecutor(new AdminMode(this));
/* 201 */     getCommand("kpvp").setExecutor(new Kits(this));
/* 202 */     getCommand("freezer").setExecutor(new Kits(this));
/* 203 */     getCommand("basic").setExecutor(new Basic(this));
getCommand("kposeidon").setExecutor(new Poseidonkit(this));
getCommand("kcamel").setExecutor(new Camel(this));
/* 204 */     getCommand("airman").setExecutor(new Kits(this));
/* 205 */     getCommand("fisherman").setExecutor(new Kits(this));
/* 206 */     getCommand("archer").setExecutor(new Kits(this));
/* 207 */     getCommand("tank").setExecutor(new Kits(this));
/* 208 */     getCommand("pyro").setExecutor(new Kits(this));
getCommand("kviking").setExecutor(new Kits(this));
getCommand("kp").setExecutor(new Join(this));
/* 209 */     getCommand("kthor").setExecutor(new ThorKITCOMMAND(this));
getCommand("kvampire").setExecutor(new Vampire(this));
getCommand("kpsetdeathspawn").setExecutor(new kpsetdeathspawn());
/* 210 */     getCommand("switcher").setExecutor(new Kits(this));
/* 211 */     getCommand("viper").setExecutor(new Viper(this));
getCommand("kconfuser").setExecutor(new ConfuserHability(this));
/* 212 */     getCommand("snail").setExecutor(new Snail(this));
/* 213 */     getCommand("warper").setExecutor(new Kits(this));
getCommand("paycoins").setExecutor(new PayCoins());
/* 214 */     getCommand("jumper").setExecutor(new Kits(this));
/* 215 */     getCommand("wasp").setExecutor(new Kits(this));
/* 216 */     getCommand("cactus").setExecutor(new Kits(this));
/* 217 */     getCommand("bomber").setExecutor(new Kits(this));
/* 218 */     getCommand("spiderman").setExecutor(new Kits(this));
/* 219 */     getCommand("stats").setExecutor(new Stats());
/* 220 */     getCommand("kpstats").setExecutor(new KPStats());
/* 221 */     getCommand("kitmenu").setExecutor(new Menu(this));
/* 222 */     getCommand("kitpvp").setExecutor(new Join());
getCommand("kfireman").setExecutor(new FiremanCMD(this));
getCommand("kmonk").setExecutor(new MonkCMD(this));
/*     */     getCommand("kryu").setExecutor(new Ryu(this));/*     */ 
/* 225 */     getCommand("kpkits").setExecutor(new Menu(this));
              getCommand("kpkickall").setExecutor(new KPKICK());
/* 226 */     getCommand("kpshop").setExecutor(new Shop(this));
/* 227 */     getCommand("kploja").setExecutor(new Shop(this));
/* 228 */     getCommand("shopmenu").setExecutor(new Shop(this));
getCommand("setarena").setExecutor(new  me.RafaelAulerDeMeloAraujo.main.SetArena());
/* 229 */     getCommand("kpkitmenu").setExecutor(new NewKitMenu(this));
/* 230 */     getCommand("kitsc").setExecutor(new StaffChat(this));
/* 231 */     getCommand("kpkit").setExecutor(new Menu(this));
/* 232 */     getCommand("kpsetspawn").setExecutor(new kpsetspawn());
/* 233 */     getCommand("stomper").setExecutor(new StomperKITCOMMAND(this));
/* 234 */     getCommand("gladiator").setExecutor(new GladCMD(this));
/* 235 */     getCommand("deshfire").setExecutor(new DesifireCMD(this));
/* 236 */     getCommand("ninja").setExecutor(new Ninja(this));
/* 237 */   getCommand("kanchor").setExecutor(new Anchor(this));
/* 238 */     getCommand("kangaroo").setExecutor(new Kangaroo(this));
/* 239 */     getCommand("timelord").setExecutor(new TimelordCMD(this));
/* 240 */     getCommand("doublejump").setExecutor(new Dublejump(this));
getCommand("kresouper").setExecutor(new ResouperCMD(this));
/* 241 */     getCommand("kitclear").setExecutor(new Kits(this));
/* 242 */     getCommand("skit").setExecutor(new Skit());
              getCommand("kpkills").setExecutor(new Kills());
/* 243 */     getCommand("critical").setExecutor(new Critical(this));
/* 244 */     getCommand("kitpvp").setExecutor(new Join(this));
/* 245 */     getCommand("naruto").setExecutor(new Naruto(this));
getCommand("kphantom").setExecutor(new PhantomCMD(this));
getCommand("sonic").setExecutor(new Sonic());
this.pm.registerEvents(new ClickTest(), this);
/* 246 */     
/* 247 */     getCommand("set1v1").setExecutor(new SetX1());
/*     */   }
public static void handleTopPlayers(Location location) {
	List<Player> topPlayers = Join.player.stream().sorted((x, y) ->
			Integer.compare(AntiDeathDrop.GetKills(x), AntiDeathDrop.GetKills(y))
	).limit(16).collect(Collectors.toList());
	
	Hologram hologram = topPlayersHd != null ?
			topPlayersHd : (topPlayersHd = HologramsAPI.createHologram(Main.getInstance(), location));

	hologram.teleport(location);
	hologram.clearLines();
	
	try {
		hologram.appendTextLine("§e§lTop 15 Players §6§l(KILL)");
		
		for (int i = 0; i < 15; i++) {
			int position = i + 1;
			Player helixPlayer = (topPlayers.size() - 1) > i ? topPlayers.get(i) : null;
				hologram.appendTextLine(helixPlayer == null ? "§cNot Found." :
				"§6" + position + "º " + "§e" + helixPlayer.getName() + " §e- " +
				"§fKills: §6" + HelixDecimalFormat.format(AntiDeathDrop.GetKills(helixPlayer)));
				
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
public static void loadTopPlayersHologram() {
	new BukkitRunnable() {
		@Override
		public void run() {
		      World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("TOP.World"));
		  	/* 201 */           double x = Main.plugin.getConfig().getDouble("TOP.X");
		  	/* 202 */           double y = Main.plugin.getConfig().getDouble("TOP.Y");
		  	/* 203 */           double z = Main.plugin.getConfig().getDouble("TOP.Z");
		  	/* 204 */           Location lobby = new Location(w, x, y, z);
			
			Location location = lobby;
			handleTopPlayers(location);
		}
	}.runTaskTimer(Main.getInstance(), 10 * 20L, 2 * (60 * 20L));
}

/*     */   
/*     */   private void registerEvents()
/*     */   {
	          this.pm.registerEvents(new ArrowMessage(), this);
	          this.pm.registerEvents(new Respawn(), this);
/* 252 */     this.pm.registerEvents(new ThrowTnt(this), this);
/* 253 */     this.pm.registerEvents(new Dublejump(this), this);
              this.pm.registerEvents(new Phantom(), this);
              this.pm.registerEvents(new Camel(this), this);
              this.pm.registerEvents(new Poseidon(), this);
              this.pm.registerEvents(new Anchor(this), this);
              this.pm.registerEvents(new Fireman(), this);
              this.pm.registerEvents(new Monk(), this);
              this.pm.registerEvents(new ConfuserHability(this), this);
/* 256 */     this.pm.registerEvents(new NewKitMenu(this), this);
/* 257 */     this.pm.registerEvents(new Sponge(this), this);
/* 258 */     this.pm.registerEvents(new Naruto(this), this);
this.pm.registerEvents(new Compass(), this);
/* 259 */     this.pm.registerEvents(new Critical(this), this);
this.pm.registerEvents(new Resouper(), this);
this.pm.registerEvents(new Ryu(this), this);
/* 260 */     this.pm.registerEvents(new BlockCommands(this), this);
/* 261 */     this.pm.registerEvents(new Menu(this), this);
/* 262 */     this.pm.registerEvents(new NoBreakEvent(), this);
/* 263 */     this.pm.registerEvents(new Fisherman(this), this);
/* 264 */     this.pm.registerEvents(new Switcher(), this);
this.pm.registerEvents(new PlaceEvent(), this);
if (Main.getInstace().getConfig().getString("DisableCombatLog").equalsIgnoreCase("false")) {
	this.pm.registerEvents(new CombatLog(), this);	
}
              this.pm.registerEvents(new Vampire(this), this);
/* 265 */     this.pm.registerEvents(new Viper(this), this);
/* 266 */     this.pm.registerEvents(new SoupSign(), this);
/* 267 */     this.pm.registerEvents(new Deshfire(), this);
/* 268 */     this.pm.registerEvents(new Thor(this), this);
/* 269 */     this.pm.registerEvents(new Ninja(this), this);
/* 270 */     this.pm.registerEvents(new JoinSign(this), this);
/* 271 */     this.pm.registerEvents(new LeaveSign(this), this);
/* 272 */     this.pm.registerEvents(new Kangaroo(this), this);
/* 273 */     this.pm.registerEvents(new AdminMode(this), this);
this.pm.registerEvents(new Sonic(), this);
/* 274 */     this.pm.registerEvents(new TimeLord(this), this);
/* 275 */     this.pm.registerEvents(new Soup(this), this);
/* 276 */     this.pm.registerEvents(new NoDrops(this), this);
/* 277 */     this.pm.registerEvents(new NoHunger(), this);
/* 278 */     this.pm.registerEvents(new Gladiator(), this);
/* 279 */     this.pm.registerEvents(new Join(this), this);
/* 280 */     this.pm.registerEvents(new Shop(this), this);
/* 281 */     this.pm.registerEvents(new Stomper(this), this);
/* 282 */     this.pm.registerEvents(new Snail(this), this);
/* 283 */     this.pm.registerEvents(new X1(this), this);
/* 284 */     this.pm.registerEvents(new Streak(), this);
/* 285 */     this.pm.registerEvents(new NoExplosion(), this);
/* 286 */     this.pm.registerEvents(new AntiDeathDrop(this), this);
/* 287 */     this.pm.registerEvents(new WallClamber(this), this);
/* 288 */     this.pm.registerEvents(new SoupSign(), this);
this.pm.registerEvents(new Protection(), this);
/* 289 */     this.pm.registerEvents(new CommandsSounds(this), this);
/* 290 */     this.pm.registerEvents(new AirmanFly(this), this);
/* 291 */     this.pm.registerEvents(new NewKitMenu(this), this);
}
/*     */     
/* 293 *
/*     */   @EventHandler
/*     */   public void playerKill(EntityDeathEvent evt)
/*     */   {
/* 313 */     File f = new File("plugins/KP-PVP/Stats/stats.yml");
/* 314 */     YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
/* 315 */     if ((evt instanceof PlayerDeathEvent))
/*     */     {
/* 317 */       getLogger().info("Recognised player death");
/* 318 */       PlayerDeathEvent event = (PlayerDeathEvent)evt;
/* 319 */       Player dead = event.getEntity();
/* 320 */       Player killer = dead.getKiller();
/* 321 */       getLogger().info("Dead: " + dead.getDisplayName());
/* 322 */       if ((killer instanceof Player))
/*     */       {
/* 324 */         getLogger().info("Killer recognised as a player.");
/* 325 */         Player murderer = killer;
/* 326 */         getLogger().info("Killer: " + murderer.getName());
/*     */         
/* 328 */         int streak = yamlFile.getInt("players." + murderer.getName() + ".streak");
/*     */         
/* 330 */         int newStreak = streak + 1;
/* 331 */         yamlFile.set("players." + murderer.getName() + ".streak", Integer.valueOf(newStreak));
/*     */       }
/*     */       try
/*     */       {
/* 335 */         yamlFile.save(f);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 339 */         e.printStackTrace();
/*     */       }
/* 341 */       getLogger().info("Set and saved stats.");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Funcionou(Player p) {}
/*     */   
/*     */   public static void darEfeito(Player p, PotionEffectType tipo, int duracao, int level)
/*     */   {
/* 349 */     p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
/*     */   }
/*     */   
/*     */   public void save()
/*     */   {
/*     */     try
/*     */     {
/* 356 */       this.cf.save(this.cf1);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 360 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/* 364 */   public static FileConfiguration cfg_x1 = YamlConfiguration.loadConfiguration(file_x1);
public static FileConfiguration messages = YamlConfiguration.loadConfiguration(messagesf);
public static FileConfiguration kits = YamlConfiguration.loadConfiguration(kitsf);
/* 365 */   public static FileConfiguration customization = YamlConfiguration.loadConfiguration(customizationf);
/*     */   private File cf1;
/*     */   FileConfiguration config;
/*     */   private PluginManager pm;
/*     */   
/*     */   public boolean IsOnKitPvP(String name)
/*     */   {
/* 372 */     return Join.game.contains(name);
/*     */   }
public ScoreboardBuilder getScoreboardBuilder() {
	return scoreboardBuilder;
}
/*     */ 
public void onDisable()
{
  ConsoleCommandSender cmd = Bukkit.getConsoleSender();
  cmd.sendMessage(" ");
  cmd.sendMessage("    §7KP-PVP Version " + Main.getInstance().getDescription().getVersion() + " has been disabled");
  cmd.sendMessage("    §cAuthor: §EzEnderX5_ , Rafael Auler    ");
  cmd.sendMessage("    §cThank you for use the plugin §a=D    ");
  cmd.sendMessage(" ");
  /*     */ 
  /*     */ for(Player p: Bukkit.getOnlinePlayers()){
	  if (Join.game.contains(p.getName()) && !Main.plugin.getConfig().getBoolean("bungeemode")) {
  /* 279 */       Habilidade.removeAbility(p);
  /* 280 */       Deshfire.Armadura.remove(p);
  /* 281 */       Deshfire.Armadura2.remove(p);
  /* 282 */       Deshfire.cooldownm.remove(p);
  /* 283 */       Join.game.remove(p.getName());
  /* 284 */       Join.game.remove(p.getName());
  /* 285 */       Join.game.remove(p.getName());
  /* 286 */       Join.game.remove(p.getName());
  /* 287 */       Join.game.remove(p.getName());
  /* 288 */       Join.game.remove(p.getName());
  /* 289 */       Join.game.remove(p.getName());
  /* 290 */       Join.game.remove(p.getName());
  /* 291 */       Join.game.remove(p.getName());
  /* 292 */       Join.game.remove(p.getName());
  /* 293 */       Join.game.remove(p.getName());
  /* 294 */       Join.game.remove(p.getName());Join.game.remove(p.getName());
  /* 295 */       Join.game.remove(p.getName());
  /* 296 */       Join.game.remove(p.getName());
  /* 297 */       Join.game.remove(p.getName());

  /*     */ 
  /*     */ 
  /*     */ 
  /* 302 */       Cooldown.remove(p);
  /* 303 */       p.sendMessage(ChatColor.RED + "The plugin has been reloaded/disabled so you are forced to leave the game");
  /* 304 */       p.getInventory().clear();
  /* 305 */       p.teleport((Location)Join.saveworld.get(p.getName()));
  /* 306 */       p.getInventory().setContents((ItemStack[])Join.saveinv.get(p.getName()));
  /* 307 */       p.setGameMode((GameMode)Join.savegamemode.get(p.getName()));
  p.setLevel(Join.savelevel.get(p.getName()));

  /* 308 */       p.getInventory().setArmorContents((ItemStack[])Join.savearmor.get(p.getName()));

  /*     */   
  /* 311 */       p.updateInventory();
  API.tirarEfeitos(p);
  }
  }
}



public static String TAC(String s)
{
  return ChatColor.translateAlternateColorCodes('&', s);
}

{
	
}





}




/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
