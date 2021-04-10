package me.Hessky.BalkanStarPlugin.events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class DiscordGUI implements Listener{
	

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		if(!event.getView().getTitle().contains("Discord"))
			return;
		if(event.getCurrentItem()== null)
			return;
		if(event.getCurrentItem().getItemMeta() == null)
			return;
		
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getClickedInventory().getType() == InventoryType.PLAYER)
			return;
		
		if(event.getSlot() == 4) {
			
			player.closeInventory();
			player.updateInventory();
			
			TextComponent discord = new TextComponent("Join our Discord! Click here.");
			discord.setBold(true);
			discord.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/G645H9r") );
			discord.setColor(ChatColor.BLUE);
			
			player.spigot().sendMessage(discord);
			
		}
	}
}
