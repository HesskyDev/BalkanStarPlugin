package me.Hessky.BalkanStarPlugin.events;

import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.Hessky.BalkanStarPlugin.Main;
import me.Hessky.BalkanStarPlugin.utils.Items;
import me.Hessky.BalkanStarPlugin.utils.Utils;

public class ZombieSword implements Listener{
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent event) {
		
		if(event.getEntity() instanceof Zombie) {
			
			LivingEntity entity = event.getEntity();
			
			if((int)(Math.random()*10000000) + 0 <= Main.plugin3.getConfig().getInt("ZombieSword.drop")) {
				entity.getLocation().getWorld().dropItem(entity.getLocation(), Items.Zombiesword());
				entity.getKiller().sendMessage(Utils.chat("&5&lRARE DROP! &7You got a &2Zombie Sword&7!"));
				entity.getKiller().playSound(entity.getKiller().getLocation(), Sound.BLOCK_METAL_PLACE, 0.9F, 0.9F);
				return;
				}
		}
		
	}
	
}
