package me.Hessky.BalkanStarPlugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Hessky.BalkanStarPlugin.Main;
import me.Hessky.BalkanStarPlugin.utils.SkullCreator;
import me.Hessky.BalkanStarPlugin.utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class Discord implements CommandExecutor{

private final Main plugin;
    
    public Discord(Main plugin) {
        this.plugin = plugin;

    }
    
    public static Inventory discordInventory;
    @Deprecated
    public void discordinve() {
    	//Inventory GUI
    			Inventory discordinv = Bukkit.createInventory(null, 9, ChatColor.BLUE+"Discord");
    			ItemStack lordItem = new ItemStack(SkullCreator.itemWithBase64(SkullCreator.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM1OWU1YzdiMDczOGI1NzlmM2I0NDRjMTNhNDdiZWQ0OTZiMzA4MzhiMmVlMmIxMjdjYzU5Y2Q3OThhZWU3NyJ9fX0=")).clone();
    			ItemMeta lordMeta = lordItem.getItemMeta();
    			lordMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Discord");
    			ArrayList<String> lore = new ArrayList<>();
    			lore.add(Utils.chat("&bClick the item to get the link!"));
    			lordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
    			lordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    			lordMeta.setLore(lore);
    			lordItem.setItemMeta(lordMeta);
    			discordinv.setItem(4,  lordItem);
    			//Glass
    			for(int i = 0; i<9; i++){ 
    				if(i!=4){ 
    					discordinv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
    				}
    			}
    			discordInventory = discordinv;
    }
    
	@Override
	public boolean onCommand( CommandSender sender,  Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) { 
			return true;
		}

		Player p = (Player) sender;
		discordinve();
		p.openInventory(discordInventory);
		plugin.getName();
		return false;
	}
	
	
	
}
