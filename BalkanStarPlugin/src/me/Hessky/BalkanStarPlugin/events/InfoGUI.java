package me.Hessky.BalkanStarPlugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InfoGUI implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(!event.getView().getTitle().contains("Info"))
			return;
		if(event.getCurrentItem() == null)
			return;
		Player p = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getClickedInventory().getType() == InventoryType.PLAYER)
			return;
		//Spawn
		if(event.getSlot() == 4) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("spawn");
		}
		//Ranks
		if(event.getSlot() == 22) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("ranks");
		}
		if(event.getSlot() == 18) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("discord");
		}
		if(event.getSlot() == 20) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("ah");
		}
		if(event.getSlot() == 24) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("ec");
		}
		if(event.getSlot() == 26) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("rules");
		}
		if(event.getSlot() == 31) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("recipes");
		}
		if(event.getSlot() == 38) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("warp wild");	
		}
		if(event.getSlot() == 40) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("warp pvp");	
		}
		if(event.getSlot() == 42) {
			p.closeInventory();
			p.updateInventory();
			p.performCommand("warp spawnershop");	
		}
		
		
	}
	
}
