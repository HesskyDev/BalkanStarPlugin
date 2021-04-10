package me.Hessky.BalkanStarPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Hessky.BalkanStarPlugin.Main;
import me.Hessky.BalkanStarPlugin.utils.SkullCreator;
import me.Hessky.BalkanStarPlugin.utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class Info implements CommandExecutor{
	
	private final Main plugin;
	
	public Info(Main plugin) {
		this.plugin = plugin;
	}
	
	public static Inventory infoInventory;
	@Deprecated
	public void infoInve() {
		Inventory infoinv = Bukkit.createInventory(null, 54, ChatColor.BLACK + "Info");
		//RANKS ITEM
		ItemStack ranks = new ItemStack(Material.PAPER);
		ItemMeta rankmeta = ranks.getItemMeta();
		
		rankmeta.setDisplayName(Utils.chat("&cRanks"));
		rankmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		rankmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ranks.setItemMeta(rankmeta);
		//SPAWN
		ItemStack spawn = new ItemStack(Material.COMPASS);
		ItemMeta spawnmeta = spawn.getItemMeta();
		
		spawnmeta.setDisplayName(Utils.chat("&7Spawn"));
		spawnmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		spawnmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		spawn.setItemMeta(spawnmeta);
		//DISCORD
		ItemStack disc = new ItemStack(SkullCreator.itemWithBase64(SkullCreator.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM1OWU1YzdiMDczOGI1NzlmM2I0NDRjMTNhNDdiZWQ0OTZiMzA4MzhiMmVlMmIxMjdjYzU5Y2Q3OThhZWU3NyJ9fX0=")).clone();
		ItemMeta discmeta = disc.getItemMeta();
		
		discmeta.setDisplayName(Utils.chat("&bDiscord"));
		discmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		discmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		disc.setItemMeta(discmeta);
		//AUCTION HOUSE
		ItemStack ah = new ItemStack(Material.HEART_OF_THE_SEA);
		ItemMeta ahhometa = ah.getItemMeta();
		
		ahhometa.setDisplayName(Utils.chat("&9Auction House"));
		ahhometa.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		ahhometa.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ah.setItemMeta(ahhometa);
		//ENDERCHEST
		ItemStack ec =  new ItemStack(SkullCreator.itemWithBase64(SkullCreator.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjYzE4OTYzM2M3ODljYjZkNWU3OGQxM2E1MDQzYjI2ZTdiNDBjZGI3Y2ZjNGUyM2FhMjI3OTU3NDk2N2I0In19fQ==")).clone();
		ItemMeta ecstmeta = ec.getItemMeta();
		
		ecstmeta.setDisplayName(Utils.chat("&5Ender Chest"));
		ecstmeta.addEnchant(Enchantment.DURABILITY, 1, true);
		ecstmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		ec.setItemMeta(ecstmeta);
		//RULES
		ItemStack rules = new ItemStack(SkullCreator.itemWithBase64(SkullCreator.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjYyNjUxODc5ZDg3MDQ5OWRhNTBlMzQwMzY4MDBkZGZmZDUyZjNlNGUxOTkzYzVmYzBmYzgyNWQwMzQ0NmQ4YiJ9fX0=")).clone();
		ItemMeta rulesmeta = rules.getItemMeta();
		
		rulesmeta.setDisplayName(Utils.chat("&6Rules"));
		rulesmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		rulesmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		rules.setItemMeta(rulesmeta);
		
		//RECIPELIST
		ItemStack recipes = new ItemStack(SkullCreator.itemWithBase64(SkullCreator.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmNkYzBmZWI3MDAxZTJjMTBmZDUwNjZlNTAxYjg3ZTNkNjQ3OTMwOTJiODVhNTBjODU2ZDk2MmY4YmU5MmM3OCJ9fX0=")).clone();
		ItemMeta recipemeta = recipes.getItemMeta();
		
		recipemeta.setDisplayName(Utils.chat("&eRecipes"));
		recipemeta.addEnchant(Enchantment.DAMAGE_ALL,1, true);
		recipemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		recipes.setItemMeta(recipemeta);
		//WILD
		ItemStack wild = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta wildmeta = wild.getItemMeta();
		
		wildmeta.setDisplayName(Utils.chat("&aWild"));
		wildmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		wildmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		wild.setItemMeta(wildmeta);
		//PVP
		ItemStack pvp = new ItemStack(Material.GOLDEN_SWORD);
		ItemMeta pvpmeta = pvp.getItemMeta();
		
		pvpmeta.setDisplayName(Utils.chat("&cPvP"));
		pvpmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		pvpmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		pvp.setItemMeta(pvpmeta);
		//SPAWNER SHOP
		ItemStack spas = new ItemStack(Material.SPAWNER);
		ItemMeta spasmeta = spas.getItemMeta();
		
		spasmeta.setDisplayName(Utils.chat("&dSpawner Shop"));
		spasmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		spasmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		spas.setItemMeta(spasmeta);
		
		
		//BACKGROUND
		for(int i = 0; i<54; i++) {
			infoinv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
		}
		infoinv.setItem(22, ranks);
		infoinv.setItem(4, spawn);
		infoinv.setItem(18, disc);
		infoinv.setItem(20, ah);
		infoinv.setItem(24, ec);
		infoinv.setItem(26, rules);
		infoinv.setItem(31, recipes);;
		infoinv.setItem(38, wild);
		infoinv.setItem(40, pvp);
		infoinv.setItem(42, spas);
		
		infoInventory = infoinv;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return true;
		}
		infoInve();
		Player p = (Player) sender;
		Location loc = p.getLocation();
		p.playSound(loc, Sound.BLOCK_DISPENSER_DISPENSE, 0.5F, 0.5F);
		p.openInventory(infoInventory);
		plugin.getName();
		return false;
	}
}
