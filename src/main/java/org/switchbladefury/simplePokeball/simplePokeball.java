package org.switchbladefury.simplePokeball;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class simplePokeball extends JavaPlugin{
	
	private static simplePokeball instance;
	
	@Override
    public void onEnable() {
		getLogger().info("onEnable has been invoked!");
		instance = this;
		getServer().getPluginManager().registerEvents(new onPlayerClick(), this);
		getServer().getPluginManager().registerEvents(new onEntityClicked(), this);
    }
    
    @Override
    public void onDisable() {
    	//getLogger().info("onDisable has been invoked!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("givepokeball") && (sender instanceof Player)) { 
//    		  Player player = (Player) sender;
//    		  
//    		  
//    		  
//    		  
//    		  return true;
    	}
    	return false;
    }

	public static simplePokeball getInstance() {
		return instance;
	}

}
