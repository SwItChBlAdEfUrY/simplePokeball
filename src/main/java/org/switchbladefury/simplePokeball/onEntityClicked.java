package org.switchbladefury.simplePokeball;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class onEntityClicked implements Listener {
	@EventHandler
	public void onEntityClicked(PlayerInteractEntityEvent event) {
		if (event.getRightClicked() != null && event.getPlayer().getInventory().getItemInMainHand() != null) {
			// if player right clicked something, and they have an item in hand
			// get the player
			Player player = event.getPlayer();

			// get the item in thier hand and its meta
			ItemStack item = event.getPlayer().getInventory().getItemInMainHand(); // player.getInventory().getItem(slot);

			// get the entity they clicked
			Entity entity = event.getRightClicked();

			if (pokeball.isPokeball(item) && pokeball.containsEntity(item)) {
				// if its a pokeball and has an entity
				player.sendMessage("This Pokéball already contains an entity.");
				return;

			} else if (pokeball.isPokeball(item)) {
				// if it is pokeball and does not contain entity
				pokeball.setEntity(item, entity);
				player.sendMessage("Captured: " + entity.getName().toString());

				// remove entity from world
				entity.remove();
			}
		}
	}

}
