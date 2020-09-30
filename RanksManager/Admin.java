package me.amankumar.ranksmanager.staff;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.amankumar.ranksmanager.RanksManager;
import me.amankumar.ranksmanager.files.RanksFileManager;

public class Admin {
	
	RanksManager instance;
	RanksFileManager rfm;
	
	public Admin(RanksManager instance) {
		this.instance = instance;
		rfm = instance.getRFM();
		adminFormat();
	}
	
	public void addToFile(Player player) {
		removeOtherInstance(player);
		rfm.getConfig().set("ranks.staff.admin", player.getName().toString());
		rfm.getConfig().set("ranks.staff.admin." + player.getName().toString(), 
				player.getUniqueId().toString());
		rfm.saveConfig();
	}
	
	public void adminFormat()  {
		rfm.getConfig().set("ranks.staff.format.admin", 
				ChatColor.DARK_GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + "Admin"
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
