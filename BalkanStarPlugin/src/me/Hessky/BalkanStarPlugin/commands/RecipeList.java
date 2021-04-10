package me.Hessky.BalkanStarPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.Hessky.BalkanStarPlugin.Main;
import me.Hessky.BalkanStarPlugin.utils.Items;
import net.md_5.bungee.api.ChatColor;

public class RecipeList implements CommandExecutor{
	
	private final Main plugin;
	public RecipeList(Main plugin) {
		this.plugin = plugin;
	}
	
	public static Inventory recipeinventory;
	public void recipeinv() {
		Inventory recipeinv = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Recipes");
		
		for(int i = 0; i<54; i++) {
			recipeinv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		}
		recipeinv.setItem(10, Items.EnchantedStone());
		recipeinv.setItem(11, Items.MinerPickaxe());
		recipeinv.setItem(12, Items.FeedBox());
		
		recipeinventory = recipeinv;		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) return true;
		
		Player p = (Player) sender;	
		recipeinv();
		p.openInventory(recipeinventory);
		plugin.getName();
		return false;
	}
	
}
