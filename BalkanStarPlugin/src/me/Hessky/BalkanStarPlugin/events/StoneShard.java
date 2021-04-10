package me.Hessky.BalkanStarPlugin.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.Hessky.BalkanStarPlugin.utils.Items;

public class StoneShard implements Listener{

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Material block = event.getBlock().getType();
		//Stone block 
		if(block == Material.STONE) {
				
			int randomnum = (int)(Math.random() * 5000) + 0;
			if(randomnum <= 1) {
				event.getBlock().getLocation().getWorld().dropItem(event.getBlock().getLocation(), Items.StoneShard());
			}
		}
	}
	
}
