package me.Hessky.BalkanStarPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import me.Hessky.BalkanStarPlugin.utils.Constants;
import me.Hessky.BalkanStarPlugin.utils.Items;
import net.md_5.bungee.api.ChatColor;

public class EnchantedStoneRecipeGUI implements Listener{

	public static Inventory StoneShardInv;
	
	//Inventoy Recepti Za Enchanted Stone
	public static Inventory EnchStoneInv;
	public void EnchantedStone() {
		Inventory EnchStone = Bukkit.createInventory(null, 45, ChatColor.GRAY + "Enchanted Stone Recipe");
		//Background
		ItemStack background = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta backgroundmeta = background.getItemMeta();
		backgroundmeta.setDisplayName(".");
		background.setItemMeta(backgroundmeta);
		for(int i = 0; i<45; i++) {
			EnchStone.setItem(i, background);
		}	
		//EnchStone recept
		EnchStone.setItem(10, Items.EnchantedStone());
		EnchStone.setItem(11, Items.EnchantedStone());
		EnchStone.setItem(12, Items.EnchantedStone());
		EnchStone.setItem(19, null);
		EnchStone.setItem(20, new ItemStack(Material.STICK));
		EnchStone.setItem(21, null);
		EnchStone.setItem(23, Items.CraftingTable());
		EnchStone.setItem(25, Items.MinerPickaxe());
		EnchStone.setItem(28, null);
		EnchStone.setItem(29, new ItemStack(Material.STICK));
		EnchStone.setItem(30, null);
		EnchStoneInv = EnchStone;
	}
	
	//On right click
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		if(event.getItem() == null) return;
		if(event.getItem().getType() != Material.CLAY) return;
		if(!(event.getItem().getItemMeta().getPersistentDataContainer().has(Constants.ENCHANTED_STONE, PersistentDataType.STRING))) return;
		Player p = event.getPlayer();
		EnchantedStone();
		p.openInventory(EnchStoneInv);
	}
	
	//Enchanted Stone place event
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player p = (Player) event.getPlayer();
		if(p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(Constants.ENCHANTED_STONE, PersistentDataType.STRING)) {
			event.setCancelled(true);
		}
		
	}
	//Inventory Cancel
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(event.getView().getTitle().contains("Enchanted Stone Recipe")) {
			event.setCancelled(true);
		}
		if(event.getView().getTitle().contains("Feed Box Recipe")) {
			event.setCancelled(true);
		}
	}
	
}
