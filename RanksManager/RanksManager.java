package me.amankumar.ranksmanager;

import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.amankumar.ranksmanager.files.RanksFileManager;

public class RanksManager extends JavaPlugin {
	
	public RanksFileManager rfm;
	private String[] rankTypes = {"owner", "manager", "admin", "mod", "helper", "player"};

	public void onEnable() {
		rfm = new RanksFileManager(this);
		this.getCommand("rankset").setExecutor(new RankSet(this));
	}
	
	public void onDisable() {
		
	}
	
	public RanksFileManager getRFM() { 
		return rfm;
	}
	
	public String getRank(Player player) { 
		String rank = "";
		Set<String> ranks = rfm.getConfig().getConfigurationSection("ranks").getKeys(true);
		for(String path : ranks) {
			
			if(path.contains(player.getName())) {
				for(int i = 0; i < rankTypes.length; i++) {
					
					if(path.contains(rankTypes[i])) {
						rank = rankTypes[i];
						return rank;
					}
				}
			}
		}
		return rank;
	}
	
}
