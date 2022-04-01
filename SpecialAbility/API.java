package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.main.Main;





public class API
{
  
    public static String NomeServer;

    public static String fimcooldown;
	
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

		
	    public static void tirarArmadura(final Player p) {
	        p.getInventory().setHelmet(new ItemStack(Material.AIR));
	        p.getInventory().setChestplate(new ItemStack(Material.AIR));
	        p.getInventory().setLeggings(new ItemStack(Material.AIR));
	        p.getInventory().setBoots(new ItemStack(Material.AIR));
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
}
}
