package me.Hessky.BalkanStarPlugin.utils;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class Recipes {
	@Deprecated
	public static void Recipe() {
		
		ShapedRecipe enchstone = new ShapedRecipe(Constants.ENCHANTED_STONE, Items.EnchantedStone());
		
		enchstone.shape("SSS","SSS","SSS");
		
		enchstone.setIngredient('S', new RecipeChoice.ExactChoice(Items.StoneShard()));
		Bukkit.addRecipe(enchstone);
		
		ShapedRecipe minerpick = new ShapedRecipe(Constants.MINER_PICKAXE, Items.MinerPickaxe());
		
		minerpick.shape("EEE"," S "," S ");
		minerpick.setIngredient('E', new RecipeChoice.ExactChoice(Items.EnchantedStone()));
		minerpick.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(minerpick);
		
		//Feed box
		
		ShapedRecipe feedboks = new ShapedRecipe(Constants.FEED_BOX, Items.FeedBox());

		feedboks.shape("CSC","CNC","CSC");
		
		feedboks.setIngredient('C', Material.COOKED_BEEF);
		feedboks.setIngredient('S', Material.SHULKER_SHELL);
		feedboks.setIngredient('N', Material.NETHER_STAR);
		
		Bukkit.addRecipe(feedboks);
	}
	
}
