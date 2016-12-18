package co.plasmanetwork.registers;

import co.plasmanetwork.OPPrison;
import com.sk89q.minecraft.util.commands.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static javafx.scene.input.KeyCode.I;
import static org.bukkit.Bukkit.getServer;

/**
 * Created by Corey on 12/12/2016.
 */
public class CustomRecipesRegister {
    OPPrison plugin;

    public CustomRecipesRegister(OPPrison plugin) {
        this.plugin = plugin;
    }

    public CustomRecipesRegister() {

    }

    public static CustomRecipesRegister instance = new CustomRecipesRegister();

    public static CustomRecipesRegister getInstance() {
        return instance;
    }


//    public void setCustomRecipes() {
//        ItemStack rubyBlock = new ItemStack(Material.REDSTONE_BLOCK, 1);
//        ItemMeta rubyBlockMeta = rubyBlock.getItemMeta();
//        rubyBlockMeta.setDisplayName(ChatColor.RED + "Ruby Block");
//        rubyBlockMeta.setUnbreakable(true);
//        rubyBlockMeta.setLore(Arrays.asList(ChatColor.GREEN + "OPPrison currency in block form!", ChatColor.RED + "You can use me at the shop!", ChatColor.AQUA + "Designed for those expensive items."));
//        rubyBlock.setItemMeta(rubyBlockMeta);
//
//        ItemStack ruby = new ItemStack(Material.REDSTONE, 1);
//        ItemMeta rubyMeta = ruby.getItemMeta();
//        rubyMeta.setDisplayName(ChatColor.RED + "Ruby");
//        rubyMeta.setUnbreakable(true);
//        rubyMeta.setLore(Arrays.asList(ChatColor.GREEN + "OPPrison currency!", ChatColor.RED + "You can use me at the shop!"));
//        ruby.setItemMeta(rubyMeta);
//        ShapedRecipe rubyBlcokRecipe = new ShapedRecipe(rubyBlock);
//
//        rubyBlcokRecipe.shape("*%*", "%B%", "*%*");
//
//        rubyBlcokRecipe.set('*', ruby, 1);
//        rubyBlcokRecipe.setIngredient('%', ruby);
//        rubyBlcokRecipe.setIngredient('B', ruby);
//
//        getServer().addRecipe(expBottle);
//    }

}
