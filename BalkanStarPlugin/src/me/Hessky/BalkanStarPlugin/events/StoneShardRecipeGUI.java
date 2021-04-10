package me.Hessky.BalkanStarPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import me.Hessky.BalkanStarPlugin.utils.Constants;
import me.Hessky.BalkanStarPlugin.utils.Items;
import net.md_5.bungee.api.ChatColor;

public class StoneShardRecipeGUI implements Listener{
	
	//Stone Shard Recipe
	public static Inventory StoneShardInv;
	public void StoneShard() {
		Inventory StoneShard = Bukkit.createInventory(null, 45, ChatColor.GRAY + "Stone Shard Recipe");
		//Background
		ItemStack background = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta backgroundmeta = background.getItemMeta();
		backgroundmeta.setDisplayName(".");
		background.setItemMeta(backgroundmeta);
		for(int i = 0; i<45; i++) {
			StoneShard.setItem(i, background);
		}	
		//StoneShard recept
		StoneShard.setItem(10, Items.StoneShard());
		StoneShard.setItem(11, Items.StoneShard());
		StoneShard.setItem(12, Items.StoneShard());
		StoneShard.setItem(19, Items.StoneShard());
		StoneShard.setItem(20, Items.StoneShard());
		StoneShard.setItem(21, Items.StoneShard());
		StoneShard.setItem(23, Items.CraftingTable());
		StoneShard.setItem(25, Items.EnchantedStone());
		StoneShard.setItem(28, Items.StoneShard());
		StoneShard.setItem(29, Items.StoneShard());
		StoneShard.setItem(30, Items.StoneShard());
		StoneShardInv = StoneShard;
	}
	
	
	//On right click
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		if(event.getItem() == null) return;
		if(event.getItem().getType() != Material.CLAY_BALL) return;
		if(!(event.getItem().getItemMeta().getPersistentDataContainer().has(Constants.STONE_SHARD, PersistentDataType.STRING))) return;
		Player p = event.getPlayer();
		StoneShard();
		p.openInventory(StoneShardInv);
	}
	//Inventory Cancel
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(event.getView().getTitle().contains("Stone Shard Recipe")) {
			event.setCancelled(true);
		}
	}
	
	
}
