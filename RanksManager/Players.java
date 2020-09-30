package me.amankumar.ranksmanager.players;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.amankumar.ranksmanager.RanksManager;
import me.amankumar.ranksmanager.files.RanksFileManager;

public class Players {

	RanksManager instance;
	RanksFileManager rfm;
	
	public Players(RanksManager instance) {
		this.instance = instance;
		rfm = instance.getRFM();
		playerFormat();
	}
	
	public void addToFile(Player player) {
		removeOtherInstance(player);
		rfm.getConfig().set("ranks.player", player.getName().toString());
		rfm.getConfig().set("ranks.player." + player.getName().toString(), 
				player.getUniqueId().toString());
		rfm.saveConfig();
	}
	
	public void playerFormat()  {
		rfm.getConfig().set("ranks.format.player", 
				ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Player"
				+ ChatColor.DARK_GRAY + "]"); 			
	}
	
	// we want to remove the other staff groups from player
	private void removeOtherInstance(Player player) {
		Set<String> staffranks = rfm.getConfig().getConfigurationSection("ranks.staff").getKeys(false);
		for(String s : staffranks) { 
			try {
				rfm.getConfig().set("ranks.staff." + s + "." + player.getName(), null);	
			} catch(Exception e) {
				// do nothing
			}
		}
		rfm.saveConfig();
	}
}
