package me.Hessky.BalkanStarPlugin;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.Hessky.BalkanStarPlugin.commands.Discord;
import me.Hessky.BalkanStarPlugin.commands.Info;
import me.Hessky.BalkanStarPlugin.commands.Ranks;
import me.Hessky.BalkanStarPlugin.commands.RecipeList;
import me.Hessky.BalkanStarPlugin.events.DiscordGUI;
import me.Hessky.BalkanStarPlugin.events.EnchantedStoneRecipeGUI;
import me.Hessky.BalkanStarPlugin.events.FeedBoxInteract;
import me.Hessky.BalkanStarPlugin.events.InfoGUI;
import me.Hessky.BalkanStarPlugin.events.RanksGUI;
import me.Hessky.BalkanStarPlugin.events.RecipeListGUI;
import me.Hessky.BalkanStarPlugin.events.StoneShard;
import me.Hessky.BalkanStarPlugin.events.StoneShardRecipeGUI;
import me.Hessky.BalkanStarPlugin.events.ZombieSword;
import me.Hessky.BalkanStarPlugin.events.ZombieSwordHeal;
import me.Hessky.BalkanStarPlugin.utils.Recipes;
import me.Hessky.BalkanStarPlugin.utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	
	public static Inventory kits;
	public static Main plugin3;
	private static Main instance;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		instance = this;
		plugin3 = this;
		Recipes.Recipe();
		saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new DiscordGUI(), this);
		this.getServer().getPluginManager().registerEvents(new EnchantedStoneRecipeGUI(), this);
		this.getServer().getPluginManager().registerEvents(new RanksGUI(), this);
		this.getServer().getPluginManager().registerEvents(new InfoGUI(), this);
		this.getServer().getPluginManager().registerEvents(new StoneShard(), this);
		this.getServer().getPluginManager().registerEvents(new StoneShardRecipeGUI(), this);
		this.getServer().getPluginManager().registerEvents(new FeedBoxInteract(), this);
		this.getServer().getPluginManager().registerEvents(new ZombieSword(), this);
		this.getServer().getPluginManager().registerEvents(new ZombieSwordHeal(), this);
		this.getServer().getPluginManager().registerEvents(new RecipeListGUI(), this);
		getCommand("Discord").setExecutor(new Discord(this));
		getCommand("Ranks").setExecutor(new Ranks(this));
		getCommand("Info").setExecutor(new Info(this));
		getCommand("Recipes").setExecutor(new RecipeList(this));
		createInventory();
		getServer().getConsoleSender().sendMessage("\n\nBalkanStarPlugin Enabled\n\n");
	}
	
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("\n\nBalkanStarPlugin Disabled\n\n");
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	//Lord kit inventory
	private void createInventory() {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Lord Kit");
		
		ItemStack lordItem = new ItemStack(Material.BEACON);
		ItemMeta lordMeta = lordItem.getItemMeta();
		lordMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Lord Kit");
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.LIGHT_PURPLE + "Click the item to get the kit");
		lordMeta.setLore(lore);
		lordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		lordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		lordItem.setItemMeta(lordMeta);
		
		
		//OPBOOTS
		ItemStack opBoots = new ItemStack(Material.LEATHER_BOOTS);
		ItemMeta opBootsMeta = opBoots.getItemMeta();
		opBootsMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Rabbit Boots");
		ArrayList<String> opLore = new ArrayList<>();
		opLore.add(ChatColor.DARK_GREEN + "You will have jump boost 2 effect!");
		opBootsMeta.setLore(opLore);
		opBootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
		opBootsMeta.addEnchant(Enchantment.DURABILITY, 10, true);
		opBootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
		opBootsMeta.addEnchant(Enchantment.MENDING, 2, true);
		opBoots.setItemMeta(opBootsMeta);
		
		//Background (glass)
		for(int i = 0; i<9; i++){
			if(i!= 3 || i != 5) {
				inv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
			}
		}
		inv.setItem(5, opBoots);
		inv.setItem(3,  lordItem);
		kits = inv;
		
	}
	
	Map<String, Long> cooldowns = new HashMap<String, Long>();
	Map<String, Long> cooldownsBoots = new HashMap<String, Long>();
	
	
	private ItemStack[] getLordKit() {

	
	ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
	ItemMeta helmeta = helmet.getItemMeta();
	helmeta.setDisplayName(ChatColor.DARK_PURPLE + "Lord Helmet");
	helmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	helmeta.addEnchant(Enchantment.DURABILITY, 3, true);
	helmeta.addEnchant(Enchantment.MENDING, 1, true);
	helmet.setItemMeta(helmeta);
	
	ItemStack chesp = new ItemStack(Material.DIAMOND_CHESTPLATE);
	ItemMeta chesmeta = chesp.getItemMeta();
	chesmeta.setDisplayName(ChatColor.DARK_PURPLE + "Lord Chestplate");
	chesmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	chesmeta.addEnchant(Enchantment.DURABILITY, 3, true);
	chesmeta.addEnchant(Enchantment.MENDING, 1, true);
	chesp.setItemMeta(chesmeta);
	
	ItemStack l = new ItemStack(Material.DIAMOND_LEGGINGS);
	ItemMeta lmeta = l.getItemMeta();
	lmeta.setDisplayName(ChatColor.DARK_PURPLE + "Lord Leggings");
	lmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	lmeta.addEnchant(Enchantment.DURABILITY, 3, true);
	lmeta.addEnchant(Enchantment.MENDING, 1, true);
	l.setItemMeta(lmeta);
	
	ItemStack b = new ItemStack(Material.DIAMOND_BOOTS);
	ItemMeta bmeta = b.getItemMeta();
	bmeta.setDisplayName(ChatColor.DARK_PURPLE + "Lord Boots");
	bmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
	bmeta.addEnchant(Enchantment.DURABILITY, 3, true);
	bmeta.addEnchant(Enchantment.MENDING, 1, true);
	b.setItemMeta(bmeta);
	
	ItemStack sw = new ItemStack(Material.DIAMOND_SWORD);
	ItemMeta swm = sw.getItemMeta();
	swm.setDisplayName(ChatColor.DARK_PURPLE + "Lord Sword");
	swm.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
	swm.addEnchant(Enchantment.DURABILITY, 3, true);
	swm.addEnchant(Enchantment.MENDING, 1, true);
	sw.setItemMeta(swm);
	
	ItemStack p = new ItemStack(Material.DIAMOND_PICKAXE);
	ItemMeta pm = p.getItemMeta();
	pm.setDisplayName(ChatColor.DARK_PURPLE + "Lord Pickaxe");
	pm.addEnchant(Enchantment.DIG_SPEED, 5, true);
	pm.addEnchant(Enchantment.DURABILITY, 3, true);
	pm.addEnchant(Enchantment.MENDING, 1, true);
	p.setItemMeta(pm);
		
	ItemStack[] items = {helmet, chesp, l, b, sw, p,
						new ItemStack(Material.COOKED_BEEF, 64),
						new ItemStack(Material.GOLDEN_APPLE, 64),
						new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 32)};
	return items;
}
	
	private ItemStack opBoots() {

			ItemStack opBoots = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta opBootsMeta = opBoots.getItemMeta();
			opBootsMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Rabbit Boots");
			ArrayList<String> opLore = new ArrayList<>();
			opLore.add("");
			opLore.add(ChatColor.DARK_GREEN + "You will have jump boost 2 effect!");
			opBootsMeta.setLore(opLore);
			opBootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
			opBootsMeta.addEnchant(Enchantment.DURABILITY, 10, true);
			opBootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 5, true);
			opBootsMeta.addEnchant(Enchantment.MENDING, 2, true);
			opBoots.setItemMeta(opBootsMeta);
			return opBoots;
		}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("kit")) {
			
			if(!(sender instanceof Player)) {
				sender.sendMessage("Only players can access this");
				return true;
			}
			
			Player player = (Player) sender;
			if(args.length > 0 && args[0].equalsIgnoreCase("lord")) {
				player.openInventory(kits);
				return true;		
			}
			
			
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		if(!event.getView().getTitle().contains("Lord Kit"))
			return;
		if(event.getCurrentItem()== null)
			return;
		if(event.getCurrentItem().getItemMeta() == null)
			return;
		
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getClickedInventory().getType() == InventoryType.PLAYER)
			return;
		//LORD KIT
		if(event.getSlot() == 3) {
			if(!player.hasPermission("balkanstarplugin.lordkit")) {
				player.sendMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &4No permission!"));
				return;
			}
			player.closeInventory();
			player.updateInventory();
		//COOLDOWN
			if(cooldowns.containsKey(player.getName())) {
				if(player.hasPermission("balkanstarplugin.lordkit.nocooldown")) {
					player.getInventory().addItem(getLordKit());
					Bukkit.broadcastMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &a"+ player.getName() +" &aclaimed the &5Lord &aKit!"));
					return;
				}
				if(cooldowns.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;
					player.sendMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &4You need to wait another "+timeleft+" &4seconds."));
					return;
				}
			}
			cooldowns.put(player.getName(), System.currentTimeMillis()+ (getConfig().getInt("cooldown") * 1000));
			player.getInventory().addItem(getLordKit());
			Bukkit.broadcastMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &a"+ player.getName() +" &aclaimed the &5Lord &aKit!"));
			return;	
		}
		
		//Op boots
		if(event.getSlot() == 5) {
			if(!player.hasPermission("balkanstarplugin.lordkit")) {
				player.sendMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &4No permission!"));
				return;
			}
			player.closeInventory();
			player.updateInventory();
		//COOLDOWN
			if(cooldowns.containsKey(player.getName())) {
				if(player.hasPermission("balkanstarplugin.lordkit.nocooldown")) {
					player.getInventory().addItem(opBoots());
					Bukkit.broadcastMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &a"+ player.getName() +" &aclaimed the &5Rabbit Boots"));
					return;
				}
				if(cooldownsBoots.get(player.getName()) > System.currentTimeMillis()) {
					long timeleft = (cooldownsBoots.get(player.getName()) - System.currentTimeMillis()) / 1000;
					player.sendMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &4You need to wait another "+timeleft+" &4seconds."));
					return;
				}
			}
			
			cooldownsBoots.put(player.getName(), System.currentTimeMillis()+ (getConfig().getInt("bootscooldown")*1000));
			
			player.getInventory().addItem(opBoots());
			Bukkit.broadcastMessage(Utils.chat("&8&l[&e&lBalkanStar&8&l] &a"+ player.getName() +" &aclaimed the &5Rabbit Boots"));
			return;
			
		}
	}
}
