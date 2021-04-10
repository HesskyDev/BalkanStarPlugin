package me.Hessky.BalkanStarPlugin.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

import me.Hessky.BalkanStarPlugin.utils.Constants;
import me.Hessky.BalkanStarPlugin.utils.Utils;

public class FeedBoxInteract implements Listener{
	Map<String, Long> cooldownFeed = new HashMap<String, Long>();
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		if(event.getItem() == null) return;
		if(event.getItem().getType() != Material.PLAYER_HEAD) return;
		if(!(event.getItem().getItemMeta().getPersistentDataContainer().has(Constants.FEED_BOX, PersistentDataType.STRING))) return;
		Player player = event.getPlayer();
		
		//COOLDOWN
		if(cooldownFeed.containsKey(player.getName())) {
			if(cooldownFeed.get(player.getName()) > System.currentTimeMillis()) {
				long timeleft = (cooldownFeed.get(player.getName()) - System.currentTimeMillis()) / 1000;
				player.sendMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &4Coolodwn "+timeleft+" &4second(s)."));
				return;
			}
		}
		cooldownFeed.put(player.getName(), System.currentTimeMillis()+ (3 * 1000));
		
		int food = player.getFoodLevel();
		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 0.5F, 0.5F);
		player.setFoodLevel(food + 8);
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = (Player) e.getPlayer();
		if(p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(Constants.FEED_BOX, PersistentDataType.STRING)) {
			e.setCancelled(true);
		}
	}
}
