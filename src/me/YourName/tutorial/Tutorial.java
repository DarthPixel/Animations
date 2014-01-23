package me.YourName.tutorial;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin implements Listener {

	Inventory inv;
	
	int num = 1;
	
	public void onEnable() {		
		inv = Bukkit.createInventory(null, 9, "§0§nThe Magic Inventory");
		
		getServer().getScheduler().scheduleSyncRepeatingTask(this,
				new Runnable() {
					public void run() {
										
						if (num == 1) {
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§aA§fnimation", "")); 
							num++;
						}else if (num == 2){
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§fA§an§fimation", "§2H"));
							num++;
						}else if (num == 3){
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§fAn§ai§fmation", "§2HE"));
							num++;
						}else if (num == 4){
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§fAni§am§fation", "§2HEL"));
							num++;
						}else if (num == 5){
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§fAnim§aa§ftion", "§2HELL"));
							num++;
						}else if (num == 6){
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§fAnima§at§fion", "§2HELLO")); 
							num++;
						}else if (num == 7){
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§fAnimati§ao§fn", "§2HELLO!"));
							num++;
						}else if (num == 8){
							inv.setItem(0, createItem(Material.APPLE, 1, (short) 0, "§fAnimatio§an", "§2HELLO! :D"));
							num = 1;
						}
					}
				}, 0, 1 * 2);
		}
	
	public ItemStack createItem(Material material, int amount,
			short shrt, String displayname, String lore) {
		ItemStack item = new ItemStack(material, amount, (short) shrt);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add(lore);
		meta.setLore(Lore);

		item.setItemMeta(meta);
		return item;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] a) {
		final Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("test")) {
			player.openInventory(inv);
		}
		return false;
	}
}