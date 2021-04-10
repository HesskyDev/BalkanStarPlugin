package me.Hessky.BalkanStarPlugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Hessky.BalkanStarPlugin.Main;
import me.Hessky.BalkanStarPlugin.utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class Ranks implements CommandExecutor{
	
	private final Main plugin;
	public Ranks(Main plugin) {
		this.plugin = plugin;
	}
	
	public static Inventory ranksInventory;
	
	public void ranksInv() {
		
		Inventory ranksInv = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "Ranks");
		
		ItemStack Roamer = new ItemStack(Material.WHITE_SHULKER_BOX);
		ItemStack Ranger = new ItemStack(Material.LIGHT_GRAY_SHULKER_BOX);
		ItemStack Adventurer = new ItemStack(Material.GRAY_SHULKER_BOX);
		ItemStack Explorer = new ItemStack(Material.CYAN_SHULKER_BOX);
		ItemStack Warrior = new ItemStack(Material.YELLOW_SHULKER_BOX);
		ItemStack Knight = new ItemStack(Material.ORANGE_SHULKER_BOX);
		ItemStack King = new ItemStack(Material.RED_SHULKER_BOX);
		ItemStack Lord = new ItemStack(Material.PURPLE_SHULKER_BOX);
		//METAS
		ItemMeta Roamerm = Roamer.getItemMeta();
		ItemMeta Rangerm = Ranger.getItemMeta();
		ItemMeta Adventurerm = Adventurer.getItemMeta();
		ItemMeta Explorerm = Explorer.getItemMeta();
		ItemMeta Warriorm = Warrior.getItemMeta();
		ItemMeta Knightm = Knight.getItemMeta();
		ItemMeta Kingm = King.getItemMeta();
		ItemMeta Lordm = Lord.getItemMeta();
		//DISPLAY NAMES
		Roamerm.setDisplayName(Utils.chat("&f&lRoamer Rank"));
		Rangerm.setDisplayName(Utils.chat("&7&lRanger Rank"));
		Adventurerm.setDisplayName(Utils.chat("&8&lAdventurer Rank"));
		Explorerm.setDisplayName(Utils.chat("&3&lExplorer Rank"));
		Warriorm.setDisplayName(Utils.chat("&e&lWarrior Rank"));
		Knightm.setDisplayName(Utils.chat("&6&lKnight Rank"));
		Kingm.setDisplayName(Utils.chat("&4&lKing Rank"));
		Lordm.setDisplayName(Utils.chat("&5&lLord Rank"));
		//Lore
		ArrayList<String> Roamerl = new ArrayList<>();
		ArrayList<String> Rangerl = new ArrayList<>();
		ArrayList<String> Adventurerl = new ArrayList<>();
		ArrayList<String> Explorerl = new ArrayList<>();
		ArrayList<String> Warriorl = new ArrayList<>();
		ArrayList<String> Knigtl = new ArrayList<>();
		ArrayList<String> Kingl = new ArrayList<>();
		ArrayList<String> Lordl = new ArrayList<>();
		
		Roamerl.add((""));
		Rangerl.add((""));
		Adventurerl.add((""));
		Explorerl.add((""));
		Warriorl.add((""));
		Knigtl.add((""));
		Kingl.add((""));
		Lordl.add((""));
		
		Roamerl.add(Utils.chat("&f0$"));
		Rangerl.add(Utils.chat("&710 000$"));
		Adventurerl.add(Utils.chat("&850 000$"));
		Explorerl.add(Utils.chat("&370 000$"));
		Warriorl.add(Utils.chat("&e100 000$"));
		Knigtl.add(Utils.chat("&6150 000$"));
		Kingl.add(Utils.chat("&4500 000$"));
		Lordl.add(Utils.chat("&5Purchase the rank for &e10€"));
		
		Roamerl.add((""));
		Rangerl.add((""));
		Adventurerl.add((""));
		Explorerl.add((""));
		Warriorl.add((""));
		Knigtl.add((""));
		Kingl.add((""));
		Lordl.add((""));
		
		//PERMISSIONS
		Roamerl.add(Utils.chat("&f/Kit Starter"));
		Roamerl.add(Utils.chat("&f/Mf create [Faction Name]"));
		Roamerl.add(Utils.chat("&f/Tpa"));
		Roamerl.add(Utils.chat("&f/Warps"));
		Roamerl.add(Utils.chat("&f/Pay"));
		Roamerl.add(Utils.chat("&f/Ping"));
		Roamerl.add(Utils.chat("&fMax Homes - 1"));
		Roamerl.add(Utils.chat("&fMax Jobs - 1"));
		Roamerl.add(Utils.chat("&fJobs Money Boost +1%"));
		Roamerl.add(Utils.chat("&fJobs XP Boost +1%"));
			//RANGER
		Rangerl.add(Utils.chat("&7Roamer Commands"));
		Rangerl.add(Utils.chat("&7/Kit Ranger"));
		Rangerl.add(Utils.chat("&7/Back"));
		Rangerl.add(Utils.chat("&7Max Jobs - 2"));
		Rangerl.add(Utils.chat("&7Jobs Money Boost +5%"));
		Rangerl.add(Utils.chat("&7Jobs XP Boost +5%"));
			//ADVENTURER
		Adventurerl.add(Utils.chat("&8Roamer Commands"));
		Adventurerl.add(Utils.chat("&8Ranger Commands"));
		Adventurerl.add(Utils.chat("&8/Kit Adventurer"));
		Adventurerl.add(Utils.chat("&8Max Jobs - 2"));
		Adventurerl.add(Utils.chat("&8Jobs Money Boost +10%"));
		Adventurerl.add(Utils.chat("&8Jobs XP Boost +10%"));
			//EXPLORER
		Explorerl.add(Utils.chat("&3Roamer Commands"));
		Explorerl.add(Utils.chat("&3Ranger Commands"));
		Explorerl.add(Utils.chat("&3Adventurer Commands"));
		Explorerl.add(Utils.chat("&3/Kit Explorer"));
		Explorerl.add(Utils.chat("&3Max Jobs - 3"));
		Explorerl.add(Utils.chat("&3Jobs Money Boost +15%"));
		Explorerl.add(Utils.chat("&3Jobs XP Boost +15% "));
		Explorerl.add(Utils.chat("&3mcMMO XP Boost +25%"));
			//WARRIOR
		Warriorl.add(Utils.chat("&eRoamer Commands"));
		Warriorl.add(Utils.chat("&eRanger Commands"));
		Warriorl.add(Utils.chat("&eAdventurer Commands"));
		Warriorl.add(Utils.chat("&eExplorer Commands"));
		Warriorl.add(Utils.chat("&e/Kit Warrior"));
		Warriorl.add(Utils.chat("&eMax Jobs - 3"));
		Warriorl.add(Utils.chat("&eJobs Money Boost +20%"));
		Warriorl.add(Utils.chat("&eJobs XP Boost +20%"));
		Warriorl.add(Utils.chat("&emcMMO XP Boost +50%"));
			//KNIGHT
		Knigtl.add(Utils.chat("&6Roamer Commands"));
		Knigtl.add(Utils.chat("&6Ranger Commands"));
		Knigtl.add(Utils.chat("&6Adventurer Commands"));
		Knigtl.add(Utils.chat("&6Explorer Commands"));
		Knigtl.add(Utils.chat("&6Warrior Commands"));
		Knigtl.add(Utils.chat("&6/Kit Knight"));
		Knigtl.add(Utils.chat("&6/Enderchest & /ec"));
		Knigtl.add(Utils.chat("&6Max Jobs - 4"));
		Knigtl.add(Utils.chat("&6Jobs Money Boost +25%"));
		Knigtl.add(Utils.chat("&6Jobs XP Boost +25%"));
		Knigtl.add(Utils.chat("&6mcMMO XP Boost +200%"));
			//KING
		Kingl.add(Utils.chat("&4Roamer Commands"));
		Kingl.add(Utils.chat("&4Ranger Commands"));
		Kingl.add(Utils.chat("&4Adventurer Commands"));
		Kingl.add(Utils.chat("&4Explorer Commands"));
		Kingl.add(Utils.chat("&4Warrior Commands"));
		Kingl.add(Utils.chat("&4Knight Commands"));
		Kingl.add(Utils.chat("&4/Kit King"));
		Kingl.add(Utils.chat("&4/Near"));
		Kingl.add(Utils.chat("&4/Craft"));
		Kingl.add(Utils.chat("&4Max Homes - 5"));
			//LORD
		Lordl.add(Utils.chat("&5Commands Of All Ranks"));
		Lordl.add(Utils.chat("&5/Kit Lord [The Best Kit]"));
		Lordl.add(Utils.chat("&5/Day"));
		Lordl.add(Utils.chat("&5/Night"));
		Lordl.add(Utils.chat("&5/Sun"));
		Lordl.add(Utils.chat("&5/Storm"));
		Lordl.add(Utils.chat("&5An Private 5x5 Island To Keep Your Stuff Safe"));
		Lordl.add(Utils.chat("&5OP Boots [Jump Boost Effect When Wearing + OP Enchants]"));
		
		//SET LORE
		Roamerm.setLore(Roamerl);
		Rangerm.setLore(Rangerl);
		Adventurerm.setLore(Adventurerl);
		Explorerm.setLore(Explorerl);
		Warriorm.setLore(Warriorl);
		Knightm.setLore(Knigtl);
		Kingm.setLore(Kingl);
		Lordm.setLore(Lordl);
		//SET ITEM METAS
		Roamer.setItemMeta(Roamerm);
		Ranger.setItemMeta(Rangerm);
		Adventurer.setItemMeta(Adventurerm);
		Explorer.setItemMeta(Explorerm);
		Warrior.setItemMeta(Warriorm);
		Knight.setItemMeta(Knightm);
		King.setItemMeta(Kingm);
		Lord.setItemMeta(Lordm);
		//INVENTORY
		for(int i = 0; i<27; i++) {
			
				ranksInv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
			
		}
		ranksInv.setItem(9, Roamer);
		ranksInv.setItem(10, Ranger);
		ranksInv.setItem(11, Adventurer);
		ranksInv.setItem(12, Explorer);
		ranksInv.setItem(14, Warrior);
		ranksInv.setItem(15, Knight);
		ranksInv.setItem(16, King);
		ranksInv.setItem(17, Lord);
		
		ranksInventory = ranksInv;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return true;
		}
		
		Player p = (Player) sender;	
		ranksInv();
		p.openInventory(ranksInventory);
		plugin.getName();
		return false;
	}
	
}
