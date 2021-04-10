package me.Hessky.BalkanStarPlugin.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import net.md_5.bungee.api.ChatColor;

public class Items {
	// STONE SHARD
	public static ItemStack StoneShard() {
		
		ItemStack stonesharde = new ItemStack(Material.CLAY_BALL);
		ItemMeta stonemeta = stonesharde.getItemMeta();
		stonemeta.setDisplayName(Utils.chat("&8&lStone Shard"));
		ArrayList<String> stonelore = new ArrayList<>();
		stonelore.add("");
		stonelore.add(Utils.chat("&6Right-click to view recipes."));
		stonemeta.setLore(stonelore);
		stonemeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		stonemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		stonemeta.getPersistentDataContainer().set(Constants.STONE_SHARD, PersistentDataType.STRING, "");
		stonesharde.setItemMeta(stonemeta);
		
		
		return stonesharde;
	}
	// ENCHANTED STONE
	public static ItemStack EnchantedStone() {
		ItemStack EnchStone = new ItemStack(Material.CLAY);
		ItemMeta enchstonemeta = EnchStone.getItemMeta();
		ArrayList<String> enchstonelore = new ArrayList<>();
		
		enchstonelore.add("");
		enchstonelore.add(Utils.chat("&6Right-Click to view recipes."));
		enchstonemeta.setLore(enchstonelore);
		
		enchstonemeta.setDisplayName(Utils.chat("&8Enchanted Stone"));
		enchstonemeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		enchstonemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		enchstonemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		enchstonemeta.getPersistentDataContainer().set(Constants.ENCHANTED_STONE, PersistentDataType.STRING, "");
		EnchStone.setItemMeta(enchstonemeta);
		
		return EnchStone;
	}
	// CRAFTING TABLE
	public static ItemStack CraftingTable() {
		ItemStack craftingt = new ItemStack(Material.CRAFTING_TABLE);
		ItemMeta craftingmeta = craftingt.getItemMeta();
		craftingmeta.setDisplayName(ChatColor.GREEN + "Crafting Table");
		ArrayList<String> craftinglore = new ArrayList<>();
		craftinglore.add(Utils.chat("&6This item can be crafted in a crafting table."));
		craftingmeta.setLore(craftinglore);
		craftingt.setItemMeta(craftingmeta);
		
		return craftingt;
	}
	//MINER PICKAXE
	public static ItemStack MinerPickaxe() {
		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta pickmeta = pickaxe.getItemMeta();
		ArrayList<String> picklore = new ArrayList<>();
		
		//LORE
		picklore.add("");
		picklore.add(Utils.chat("&aEfficiency VI"));
		picklore.add(Utils.chat("&7Break blocks faster with this enchant."));
		picklore.add("");
		picklore.add(Utils.chat("&aFortune V"));
		picklore.add(Utils.chat("&7Increased block drop chance of getting flint, apple and ores."));
		picklore.add("");
		picklore.add(Utils.chat("&aUnbreaking V"));
		picklore.add(Utils.chat("&7Item will lose durability slower."));
		picklore.add("");
		picklore.add(Utils.chat("&aMending I"));
		picklore.add(Utils.chat("&7While holding the item, it can repair itself with xp."));
		picklore.add("");
		picklore.add(Utils.chat("&cCurse Of Vanishing"));
		picklore.add(Utils.chat("&7When you die the item will disappear."));
		pickmeta.setLore(picklore);
		
		//ENCHANTS
		pickmeta.addEnchant(Enchantment.DIG_SPEED, 6, true);
		pickmeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
		pickmeta.addEnchant(Enchantment.DURABILITY, 5, true);
		pickmeta.addEnchant(Enchantment.MENDING, 1, true);
		pickmeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		pickmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		pickmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		pickmeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Miner Pickaxe");
		pickmeta.getPersistentDataContainer().set(Constants.MINER_PICKAXE, PersistentDataType.STRING, "");
		
		pickaxe.setItemMeta(pickmeta);
		
		return pickaxe;
	}
	// CUSTOM ITEM (TOTALLY NOT FROM HYPIXEL.NET)
	public static ItemStack Zombiesword() {
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<>();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		meta.setDisplayName(Utils.chat("&2&lZombie Sword"));
		
		lore.add(Utils.chat("&7Rare drop from Zombies. Can be used to heal yourself"));
		lore.add(Utils.chat("&7for 3 hearts. 10 Second Cooldown."));
		lore.add("");
		lore.add(Utils.chat("&6Item Ability: Instant Heal &e&lRIGHT-CLICK"));
		lore.add(Utils.chat("&7Heal yourself for &c3 health."));
		lore.add(Utils.chat(""));
		lore.add(Utils.chat("&aSharpness VII"));
		lore.add(Utils.chat("&7You will do more damage to mobs."));
		lore.add("");
		lore.add(Utils.chat("&aLotting IV"));
		lore.add(Utils.chat("&7Get more drops from mobs."));
		lore.add("");
		lore.add(Utils.chat("&aUnbreaking V"));
		lore.add(Utils.chat("&7Item will lose durability slower."));
		lore.add("");
		lore.add(Utils.chat("&aMending"));
		lore.add(Utils.chat("&7While holding the item, it can repair itself with xp."));
		lore.add("");
		lore.add(Utils.chat("&cCurse Of Vanishing"));
		lore.add(Utils.chat("&7When you die the item will disappear."));
		lore.add("");
		lore.add(Utils.chat("&5&lEPIC SWORD"));
		
		meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);
		meta.addEnchant(Enchantment.DURABILITY, 5, true);
		meta.addEnchant(Enchantment.MENDING, 1, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
		
		meta.getPersistentDataContainer().set(Constants.ZOMBIE_SWORD, PersistentDataType.STRING, "");
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		return item;
	}
	//FEED BOX
	@SuppressWarnings("deprecation")
	public static ItemStack FeedBox() {
		ItemStack feedbox =  new ItemStack(SkullCreator.itemWithBase64(SkullCreator.createSkull(), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjY3ZjkxYTAyN2I2ZGMwNjQ5ZTc4YTE2YWQ2ZWRiMzVjNTg0ZWVlYzE5M2QwNzRiMmU5NzcwOWFhOWU3ZmNkNiJ9fX0=")).clone();
		SkullMeta skullMeta = (SkullMeta) feedbox.getItemMeta();
		skullMeta.setDisplayName(Utils.chat("&6&lFeed Box"));
		ArrayList<String> skullLore= new ArrayList<>();
		skullLore.add("");
		skullLore.add(Utils.chat("&8Infinite supply of steak."));
		skullLore.add(Utils.chat("&6Right-Click to eat, 3 second cooldown."));
		
		skullMeta.setLore(skullLore);
		skullMeta.getPersistentDataContainer().set(Constants.FEED_BOX, PersistentDataType.STRING, "");
		feedbox.setItemMeta(skullMeta);
		
		return feedbox;
	}
}
