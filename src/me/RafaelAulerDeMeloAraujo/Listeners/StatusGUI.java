package me.RafaelAulerDeMeloAraujo.Listeners;



import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Level;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import me.RafaelAulerDeMeloAraujo.main.Main;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatusGUI implements Listener {



    @EventHandler
    private void onPlayerInteract(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getType().equals(Material.SKULL_ITEM)) {
            if (event.getRightClicked().getType() == EntityType.ARMOR_STAND)
                event.setCancelled(true);
        }
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player && event.getInventory().getName().equals("§aKitPvP profile") && event.getCurrentItem() != null && event.getCurrentItem().hasItemMeta() && !event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Display status in chat")) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    private void onInv2entoryClick(InventoryClickEvent event) {
    	Player p = (Player) event.getWhoClicked();
    	if (event.getCurrentItem() == null) {
    		return;
    	}
    	else if (event.getWhoClicked() instanceof Player && event.getInventory().getName().equals("§aKitPvP profile") && event.getCurrentItem().getItemMeta().getDisplayName().equals("§6Display status in chat")) {
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
            p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
            event.setCancelled(true);
        }
    }

    public static void openGUI(Player player, Player target) {
        Inventory inv = Bukkit.createInventory(null, 54, "§aKitPvP profile");
        ItemStack glass = getCustomItemStack(Material.THIN_GLASS, " ", " ");
        for (int i = 0; i < 54; ++i) {
            if ((i <= 9 || i >= 17) && (i <= 27 || i >= 35)) {
                if (i <= 36 || i >= 44) {
                    inv.setItem(i, glass);
                }
            }
        }
        double kdr = AntiDeathDrop.GetDeaths(player) == 0 ? (double) AntiDeathDrop.GetKills(player) : (double) AntiDeathDrop.GetKills(player) / (double) AntiDeathDrop.GetDeaths(player);
        inv.setItem(11, glass);
        inv.setItem(12, glass);
        inv.setItem(14, glass);
        inv.setItem(15, glass);
        int ks = ((Integer)Streak.killstreak.get(player.getName())).intValue();
        for (int i = 17; i > 0; i--) {
            inv.addItem(editItemStack(new ItemStack(Material.STAINED_GLASS_PANE , 1,  (short)4), "§7(" + "§6§lLEVEL" + "§7) §b§l" + i, Arrays.asList("§a" + player.getName() + " You are currently in Level: §b" + Level.getLevel(player),  "§fYou Reached the Level §b" + i  + "§f? " + (Level.getLevel(player) >= i ? "§aYes" : "§cNo"))));
    }
        inv.setItem(4, editItemStack(getPlayerSkull(player.getName()), "§6Informations", Arrays.asList("§fNick: §a" + player.getName(), "§fUUID: §a" + player.getUniqueId(), "§fCoins: §a" + new DecimalFormat("###,###.##").format(Coins.getCoins(player.getName())), "§fFirst acess: §a" + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(player.getFirstPlayed()))));
        inv.setItem(10, getCustomItemStack(Material.DIAMOND_SWORD, "§6Status", Arrays.asList("§fKills: §a" + AntiDeathDrop.GetKills(player), "§fDeaths: §a" + AntiDeathDrop.GetDeaths(player), "§fKDR: §a" + String.format("%.2f",kdr),"§fKillstreak: §a" + ks)));
        inv.setItem(13, getCustomItemStack(Material.EYE_OF_ENDER, "§6Boosters", Arrays.asList("§fXP Boost: §a" + (player.hasPermission("kitpvp.doublexp") ? "Yes" : "No"), "§fCoins Boost: §a" + (player.hasPermission("kitpvp.doublecoins") ? "Yes" : "No"))));
        inv.setItem(16, getCustomItemStack(Material.EXP_BOTTLE, "§6Level", Arrays.asList("§fLevel: §7(" + "§6§lLEVEL" + "§7) §b" + Level.getLevel(player), "§fNext Level: §b" + (Level.getLevel(player) + 1), "§fXP Necessary to Next Level: §b" + Level.getXPToLevelUp(player) + "XP")));
        inv.setItem(22, getCustomItemStack(Material.DIAMOND_AXE, "§6Display status in chat", Arrays.asList("§eClick to display your status in chat")));
        target.openInventory(inv);
    }

    public static ItemStack editItemStack(ItemStack itemStack, String name, List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack getPlayerSkull(String name) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(name);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

public static ItemStack getCustomItemStack(Material material, String name, String lore) {
    ItemStack itemStack = new ItemStack(material);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(name);
    if (lore != null) {
        List<String> l = Collections.singletonList(lore);
        itemMeta.setLore(l);
    }
    itemStack.setItemMeta(itemMeta);
    return itemStack;
}

public static ItemStack getCustomItemStack(Material material, String name, List<String> lore) {
    ItemStack itemStack = new ItemStack(material);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(name);
    itemMeta.setLore(lore);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
}
}