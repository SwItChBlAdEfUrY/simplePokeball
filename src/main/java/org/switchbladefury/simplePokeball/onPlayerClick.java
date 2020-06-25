package org.switchbladefury.simplePokeball;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class onPlayerClick implements Listener {

	ArrayList<UUID> waiting = new ArrayList<UUID>();

	@EventHandler
	public void onPlayerClick(PlayerInteractEvent event) {
		// ObjectMapper objectMapper = new ObjectMapper();
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		BlockFace blockFace = event.getBlockFace();

		if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
			if (item != null && item.getType().equals(Material.HEART_OF_THE_SEA)) {
				// if player right clicks a heart of the sea

				if (pokeball.isPokeball(item)) {
			// if it is already a pokeball

					if (pokeball.containsEntity(item)) {
						// spawn entity
						Location loc = event.getClickedBlock().getRelative(blockFace).getLocation();
						double x = loc.getBlockX() + 0.5;
						double y = loc.getBlockY();
						double z = loc.getBlockZ() + 0.5;
						Location spawnLocation = new Location(event.getClickedBlock().getWorld(), x, y, z);

						EntityType entity = pokeball.getEntity(item);
						Entity spawned = player.getWorld().spawnEntity(spawnLocation, entity);

						pokeball.resetPokeball(item);

					} else {
						player.sendMessage("Right click on a mob to capture it");
					}

				} 
				else {
			//if its not a pokeball already
					if (player.isSneaking() && waiting.contains(player.getUniqueId())) {
						// Create the pokeball
						pokeball.createPokeball(item);

						player.sendMessage("Created a Poké Ball.");
						waiting.remove(player.getUniqueId());
					} else {
						if (waiting.contains(player.getUniqueId())) {

						} else {
							player.sendMessage("You're about to create a Poké Ball.");
							player.sendMessage("Shift right click again to create a Poké Ball");
							waiting.add(player.getUniqueId());
						}

					}

				}

			}
		}

	}

}
