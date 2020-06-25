package org.switchbladefury.simplePokeball;

import java.util.ArrayList;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import com.google.gson.Gson;

public class pokeball {
	public static boolean containsEntity(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		String json = meta.getPersistentDataContainer().getOrDefault(makeKey("entity"), PersistentDataType.STRING,
				null);
		if (json == null) {
			return false;
		}
		return true;
	}

	public static EntityType getEntity(ItemStack item) {
		Gson gson = new Gson();
		ItemMeta meta = item.getItemMeta();
		String json = meta.getPersistentDataContainer().getOrDefault(makeKey("entity"), PersistentDataType.STRING,
				null);
		if (json == null) {
			return null;
		}
		return gson.fromJson(json, EntityType.class);
	}

	public static void setEntity(ItemStack item, Entity ent) {
		Gson gson = new Gson();
		ItemMeta meta = item.getItemMeta();
		String json = gson.toJson(ent.getType());
		meta.getPersistentDataContainer().set(makeKey("entity"), PersistentDataType.STRING, json);

		// rename the ball ans stuffs
		meta.setDisplayName("Poké Ball [" + ent.getName().toString() + "]");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Currently holding:");
		lore.add(ent.getName().toString());
		meta.setLore(lore);

		// apply meta
		item.setItemMeta(meta);
	}

	// check if is a pokeball
	public static boolean isPokeball(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		Integer isPokeball = meta.getPersistentDataContainer().getOrDefault(makeKey("isPokeball"),
				PersistentDataType.INTEGER, 0);
		if (isPokeball > 0) {
			return true;
		}
		return false;
	}

	public static NamespacedKey makeKey(String key) {
		return new NamespacedKey(simplePokeball.getInstance(), key);

	}

	public static void createPokeball(ItemStack item) {

		ItemMeta meta = item.getItemMeta();
		meta.getPersistentDataContainer().set(makeKey("isPokeball"), PersistentDataType.INTEGER, 1);

		// make the item glow DONT WORK
		item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		// change name
		meta.setDisplayName("Poké Ball");

		// add instructions
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Right click on a mob to capture it.");
		lore.add("Right click again to release the mob");
		meta.setLore(lore);

		// set meta to item
		item.setItemMeta(meta);

	}

	public static void resetPokeball(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		meta.getPersistentDataContainer().set(makeKey("isPokeball"), PersistentDataType.INTEGER, 1);
		meta.getPersistentDataContainer().remove(makeKey("entity"));

		// make the item glow DONT WORK
		item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		// change name
		meta.setDisplayName("Poké Ball");

		// add instructions
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Right click on a mob to capture it.");
		lore.add("Right click again to release the mob");
		meta.setLore(lore);

		// set meta to item
		item.setItemMeta(meta);
	}
	
}
