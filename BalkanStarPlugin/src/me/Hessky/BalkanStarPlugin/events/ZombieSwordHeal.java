package me.Hessky.BalkanStarPlugin.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

import me.Hessky.BalkanStarPlugin.Main;
import me.Hessky.BalkanStarPlugin.utils.Constants;
import me.Hessky.BalkanStarPlugin.utils.Utils;

public class ZombieSwordHeal implements Listener{
	
	Map<String, Long> cooldown = new HashMap<String, Long>();
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getItem() == null) return;
			if(event.getItem().getItemMeta().getPersistentDataContainer().has(Constants.ZOMBIE_SWORD, PersistentDataType.STRING)) {
				Player p = event.getPlayer();
				double health  = p.getHealth();
				
				//COOLDOWN
				if(cooldown.containsKey(p.getName())) {
					if(cooldown.get(p.getName()) > System.currentTimeMillis()) {
						long timeleft = (cooldown.get(p.getName()) - System.currentTimeMillis()) / 1000;
						p.sendMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &4Coolodwn "+timeleft+" &4second(s)."));
						p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.5F, 0.5F);
						return;
					}
				}
				cooldown.put(p.getName(), System.currentTimeMillis()+ (Main.plugin3.getConfig().getInt("ZombieSword.cooldown") * 1000));
				
				p.setHealth(health+6);
				p.sendMessage(Utils.chat("&aZombie Sword healed you for 3 health!"));
			}
		}
		
	}
	
}
