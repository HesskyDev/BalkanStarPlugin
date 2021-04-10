package me.Hessky.BalkanStarPlugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.Hessky.BalkanStarPlugin.utils.Utils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class RanksGUI implements Listener{

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if(!event.getView().getTitle().contains("Ranks"))
			return;
		if(event.getCurrentItem() == null)
			return;
		if(event.getCurrentItem().getItemMeta() == null)
			return;
		Player p = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getClickedInventory().getType() == InventoryType.PLAYER)
			return;
		
		//Lord rank click
		if(event.getSlot() == 17) {
			p.closeInventory();
			p.updateInventory();
			
			TextComponent paypal = new TextComponent(Utils.chat("&c&lClick here to purchase the rank."));
			paypal.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.paypal.com/paypalme/ivanhacek"));
			p.spigot().sendMessage(paypal);
		}
		
	}
}
