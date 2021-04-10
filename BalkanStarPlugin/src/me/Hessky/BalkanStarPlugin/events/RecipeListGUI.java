package me.Hessky.BalkanStarPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Hessky.BalkanStarPlugin.utils.Items;
import net.md_5.bungee.api.ChatColor;

public class RecipeListGUI implements Listener{
	

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(event.getView().getTitle().contains("Recipes")) {
			
			event.setCancelled(true);		
			Player p = (Player) event.getWhoClicked();
			p.getName();
			
			if(event.getSlot() == 10) {
				StoneShard();
				p.openInventory(StoneShardInv);
			}
			if(event.getSlot() == 11) {
				EnchantedStone();
				p.openInventory(EnchStoneInv);
			}
			if(event.getSlot() == 12) {
				FeedBox();
				p.openInventory(FeedBoxInv);
			}
		}
	}
	
	//INVENTORIES
	
	//ENCHANTED STONE
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
		//Invenotry za Feed Box
		public static Inventory FeedBoxInv;
		public void FeedBox() {
			Inventory feedbox = Bukkit.createInventory(null, 45, ChatColor.GRAY + "Feed Box Recipe");
			//Background
			ItemStack background = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
			ItemMeta backgroundmeta = background.getItemMeta();
			backgroundmeta.setDisplayName(".");
			background.setItemMeta(backgroundmeta);
			for(int i = 0; i<45; i++) {
				feedbox.setItem(i, background);
			}
			
			//recept
			feedbox.setItem(10, new ItemStack(Material.COOKED_BEEF));
			feedbox.setItem(11, new ItemStack(Material.SHULKER_SHELL));
			feedbox.setItem(12, new ItemStack(Material.COOKED_BEEF));
			feedbox.setItem(19, new ItemStack(Material.COOKED_BEEF));
			feedbox.setItem(20, new ItemStack(Material.NETHER_STAR));
			feedbox.setItem(21, new ItemStack(Material.COOKED_BEEF));
			feedbox.setItem(28, new ItemStack(Material.COOKED_BEEF));
			feedbox.setItem(29, new ItemStack(Material.SHULKER_SHELL));
			feedbox.setItem(30, new ItemStack(Material.COOKED_BEEF));
			feedbox.setItem(23, Items.CraftingTable());
			feedbox.setItem(25, Items.FeedBox());
			FeedBoxInv = feedbox;
		}
	
}
