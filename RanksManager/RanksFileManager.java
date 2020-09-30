package me.amankumar.ranksmanager.files;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.amankumar.ranksmanager.RanksManager;

public class RanksFileManager {

	private RanksManager plugin;
	private FileConfiguration data = null;
	private File configFile = null;
	
	public RanksFileManager(RanksManager plugin) {
		this.plugin = plugin;
		saveDefaultConfig();
	}
	
	public void loadConfig() {
		if(configFile == null)
			configFile = new File(plugin.getDataFolder(), "ranks.yml");
		
		data = YamlConfiguration.loadConfiguration(configFile);
		InputStream defaultStream = plugin.getResource("ranks.yml");
		
		if(defaultStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration
					(new InputStreamReader(defaultStream));
			data.setDefaults(defaultConfig);
		}
	}
	
	public FileConfiguration getConfig() {
		if(data == null)
			loadConfig();
		return data;
	}
	
	public void saveConfig() {
		if(data == null || configFile == null)
			return;
		try {
			getConfig().save(configFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveDefaultConfig() { 
		if(configFile == null) {
			configFile = new File(plugin.getDataFolder(), "ranks.yml");
		}
		if(!configFile.exists()) {
			plugin.saveResource("ranks.yml", false);
		}
	}
}
